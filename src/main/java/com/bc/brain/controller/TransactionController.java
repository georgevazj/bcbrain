package com.bc.brain.controller;

import com.bc.brain.model.transactions.*;
import com.bc.brain.repository.BlockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by jorge on 7/12/16.
 */

@Controller
public class TransactionController {

    private String blockId = "";
    private Block block = new Block();
    private boolean blockEnabled = false;

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private BlockRepository blockRepository;


    @MessageMapping("/transaction")
    @SendTo("/topic/transactions")
    private Transaction transaction(TransactionMessage message) throws Exception{
        if (this.blockId.isEmpty()){
            SecureRandom random = new SecureRandom();
            this.blockId = new BigInteger(130, random).toString(32);
            block.setId(this.blockId);
        }
        Transaction transaction = new Transaction();
        transaction.setBlockId(this.blockId);
        transaction.setConcept(message.getConcept());
        transaction.setValue(message.getValue());
        block.getTransactions().add(transaction);
        return transaction;
    }

    @MessageMapping("/interval")
    @SendTo("/topic/transactions")
    private Interval interval(IntervalMessage message) throws Exception{
        this.blockEnabled = true;
        return new Interval(message.getConcept() + ": " + message.getInterval());
    }
}

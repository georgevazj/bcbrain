package com.bc.brain.controller;

import com.bc.brain.model.transactions.*;
import com.bc.brain.repository.BlockRepository;
import com.bc.brain.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

/**
 * Created by jorge on 7/12/16.
 */

@Controller
public class TransactionController {

    private boolean blockEnabled = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private BlockService blockService;

    private List<Transaction> transactions;


    @MessageMapping("/transaction")
    @SendTo("/topic/transactions")
    private Transaction transaction(TransactionMessage message) throws Exception{
        Block lastBlock  = blockService.getLast();
        Transaction transaction = new Transaction();
        transaction.setBlockId(lastBlock.getId());
        transaction.setConcept(message.getConcept());
        transaction.setValue(message.getValue());
        this.transactions.add(transaction);
        return transaction;
    }

    @MessageMapping("/interval")
    @SendTo("/topic/transactions")
    private Interval interval(IntervalMessage message) throws Exception{
        this.blockEnabled = true;
        return new Interval(message.getConcept() + ": " + message.getInterval());
    }

    @MessageMapping("/close")
    @SendTo("/topic/transactions")
    private Block closeBlock(TransactionMessage message) throws Exception {
        Block block = blockService.getLast();
        LOGGER.info("Closing block " + block.toString());
        block.setTransactions(this.transactions);
        blockService.insert(block);
        this.transactions = null;
        return block;
    }
}

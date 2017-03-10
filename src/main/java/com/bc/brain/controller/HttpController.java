package com.bc.brain.controller;

import com.bc.brain.model.transactions.Block;
import com.bc.brain.repository.BlockRepository;
import com.bc.brain.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jorge on 07/03/2017.
 */

@RestController
public class HttpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpController.class);

    @Autowired
    BlockService blockService;
    @Autowired
    BlockRepository blockRepository;

    @RequestMapping(value = "/block/new", method = RequestMethod.GET)
    public Block initBlock(){
        LOGGER.info("Creating new block...");
        Block block = blockService.create();
        LOGGER.info(block.toString() + " created.");
        return block;
    }

}

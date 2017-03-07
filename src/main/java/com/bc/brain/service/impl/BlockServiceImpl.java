package com.bc.brain.service.impl;

import com.bc.brain.model.transactions.Block;
import com.bc.brain.repository.BlockRepository;
import com.bc.brain.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jorge on 07/03/2017.
 */

@Service
public class BlockServiceImpl implements BlockService {

    private static final Logger LOG = LoggerFactory.getLogger(BlockServiceImpl.class);

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public void insert(Block block) {
        LOG.info("Saving block " + block);
        blockRepository.save(block);
    }
}

package com.bc.brain.service.impl;

import com.bc.brain.model.transactions.Block;
import com.bc.brain.repository.BlockRepository;
import com.bc.brain.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorge on 07/03/2017.
 */

@Service
public class BlockServiceImpl implements BlockService {

    private static final Logger LOG = LoggerFactory.getLogger(BlockServiceImpl.class);

    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Block create() {
        LOG.info("Creating new block...");
        return blockRepository.save(new Block());
    }

    @Override
    public Block insert(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public Block getLast() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        List<Block> blocks = mongoTemplate.find(query, Block.class);
        Block block = blocks.get(0);
        return block;
    }
}

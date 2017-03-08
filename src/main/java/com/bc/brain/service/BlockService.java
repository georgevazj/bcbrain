package com.bc.brain.service;

import com.bc.brain.model.transactions.Block;

/**
 * Created by jorge on 07/03/2017.
 */
public interface BlockService {

    public Block create();
    public Block insert(Block block);

}

package com.bc.brain.repository;

import com.bc.brain.model.transactions.Block;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jorge on 06/03/2017.
 */

public interface BlockRepository extends MongoRepository<Block, String> {


}

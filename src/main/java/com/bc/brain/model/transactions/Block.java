package com.bc.brain.model.transactions;

/**
 * Created by jorge on 7/12/16.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 13/10/2016.
 */
public class Block {

    private String id;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public Block() {
    }

    public Block(String id, List<Transaction> transactions) {
        this.id = id;
        this.transactions = transactions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

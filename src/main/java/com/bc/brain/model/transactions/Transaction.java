package com.bc.brain.model.transactions;

/**
 * Created by jorge on 7/12/16.
 */
public class Transaction {
    
    private String blockId;
    private String concept;
    private int value;

    public Transaction() {
    }

    public Transaction(String blockId, String concept, int value) {
        this.blockId = blockId;
        this.concept = concept;
        this.value = value;
    }

    public String getBlockId() {
        return blockId;
    }

    public String getConcept() {
        return concept;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "blockId='" + blockId + '\'' +
                ", concept='" + concept + '\'' +
                ", value=" + value +
                '}';
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

package com.bc.brain.model.transactions;

/**
 * Created by jorge on 7/12/16.
 */
public class TransactionMessage {

    private String concept;
    private int value;

    public TransactionMessage() {
    }

    public TransactionMessage(String concept, int value) {
        this.concept = concept;
        this.value = value;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

package com.bc.brain.model.transactions;

/**
 * Created by jorge on 7/12/16.
 */
public class IntervalMessage {

    private int interval;
    private String concept;

    public IntervalMessage() {
    }

    public IntervalMessage(int interval, String concept) {
        this.interval = interval;
        this.concept = concept;
    }

    public int getInterval() {
        return interval;
    }


    public String getConcept() {
        return concept;
    }


    @Override
    public String toString() {
        return "IntervalMessage{" +
                "interval=" + interval +
                ", concept='" + concept + '\'' +
                '}';
    }
}

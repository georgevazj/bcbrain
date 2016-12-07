package com.bc.brain.model.transactions;

/**
 * Created by jorge on 7/12/16.
 */
public class Interval {

    private String content;

    public Interval(String content) {
        this.content = content;
    }

    public Interval() {
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "content='" + content + '\'' +
                '}';
    }
}

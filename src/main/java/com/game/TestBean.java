/*
 * User: avishay
 * Date: 11/07/11 

 */
package com.game;

/**
 *
 */
public class TestBean implements TestBeanMBean {

    private boolean continuee;

    @Override
    public boolean getContinue() {
        return continuee;
    }

    @Override
    public void setContinue(boolean continuee) {
        this.continuee = continuee;
    }

    @Override
    public String answerToQuestion() {
        return "MBean is great!!";
    }

}
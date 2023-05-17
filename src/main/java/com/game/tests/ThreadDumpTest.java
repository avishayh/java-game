/*
 * User: avishay
 * Date: 27/06/11 
 */
package com.game.tests;

/**
 *
 */
public class ThreadDumpTest extends GameTest {


    private static final String PROPERTY_NAME = "passThreadDump";

    @Override
    public void startTest() {
        title("Thread Dump Test");
        msg("To answer this test, you need to create a thread dump and read it.");


        final String value = System.getProperty(PROPERTY_NAME);
        if ("true".equals(value)) {
            msg(String.format("Found property [-D%s=true]", PROPERTY_NAME));
            passed(10, "ThreadDump test passed successfully");
            return;
        }
        test();
    }

    private void you() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                gameOver();
            }
        }
    }
    private void are() {you();}
    private void looking() {are();}
    private void at() {looking();}
    private void a() {at();}
    private void thread() {a();}
    private void dump() {thread();}
    private void add() {dump();}
    private void system() {add();}
    private void property() {system();}
    private void passThreadDump_equals_true() {property();}
    private void to() {passThreadDump_equals_true();}
    private void pass() {to();}
    private void test() {pass();}

}
/*
 * User: avishay
 * Date: 11/07/11 
*/
package com.game.tests;

import com.game.TestBean;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 *
 */
public class JMXBeanTest extends GameTest {

    private TestBean testBean = new TestBean();

    @Override
    public void startTest() {
        title("MBean Test");
        msg("1. Check the MBean 'com.game.TestBean' attributes in the MBean Server");
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            platformMBeanServer.registerMBean(testBean, new ObjectName("com.game:type=TestBean"));
        } catch (Exception e) {
            gameOver();
        }

        while (!testBean.getContinue()) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
            }
        }
        passed(5, "MBean test phase 1 completed");
        msg("");
        msg("2. What is the answer to this question?");
        getAnswerUntil(testBean.answerToQuestion());
        passed(5, "Very good, MBean test phase 2 completed");

    }

}
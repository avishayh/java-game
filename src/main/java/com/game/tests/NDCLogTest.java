/*
 * User: avishay
 * Date: 27/06/11 
*/
package com.game.tests;

import org.apache.log4j.NDC;

public class NDCLogTest extends GameTest {

    private static final String ANSWER = "NDC you know me!";

    @Override
    public void startTest() {
        title("Log4j NDC test");
        NDC.push("Answer is : " + ANSWER);
        msg("I need an answer , configure log to show NDC and find the answer!");
        getAnswerUntil(ANSWER);
        NDC.pop();
        passed(5, "NDC Log test passed. If you see this message it means you added to the log4j the %x pattern");

    }
}
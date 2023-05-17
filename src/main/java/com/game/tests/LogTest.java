/*
 * User: avishay
 * Date: 27/06/11 
*/
package com.game.tests;

import com.game.Logg;

public class LogTest extends GameTest {

    @Override
    public void startTest() {
        Logg.msg("Log4j configuration file found");
        Logg.msg("To see the messages you must enable DEBUG level for com.game category");

        title("Log Test");
        passed(2, "Log test passed. If you see this message it means you configured the log4j properly");

    }
}
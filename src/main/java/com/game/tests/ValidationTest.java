/*
 * User: avishay
 * Date: 03/07/11 
 */
package com.game.tests;

import com.game.Logg;
import com.game.tests.GameTest;

/**
 *
 */
public class ValidationTest extends GameTest {

    @Override
    public void startTest() {
        try {
            Class.forName("org.apache.log4j.Logger");
        } catch (ClassNotFoundException e) {
            out("You must add log4j to your classpath !");
            gameOver();
        }
        out("log4j.jar added successfully");
        try {
            Class.forName("com.intellij.rt.debugger.BatchEvaluatorServer");
        } catch (ClassNotFoundException e) {
            return;
        }
        Logg.msg("You should not use intellij to run this game, only command line, don't cheat !");
        gameOver();
    }
}
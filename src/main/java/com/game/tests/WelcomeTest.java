/*
 * User: avishay
 * Date: 27/06/11 
 */
package com.game.tests;

/**
 *
 */
public class WelcomeTest extends GameTest {

    @Override
    public void startTest() {
        out("Welcome to the Java game");
        out("----------------------");
        out("The purpose of this game is to learn basic and advanced java configurations and tools,");
        out("which can help a developer improve his development skills.");
        out("");
        out("How does the games works ?");
        out("");
        out("You will be given a serious of tests which you need to pass in-order to complete the game.");
        out("Each test passed will earn you points which will be added to a final score");
        out("You cannot continue with the game unless you pass a given test");
        out("");
        out("In order to finish the game, You will need basic knowledge of system configurations.");
        out("You may use specific java tools like VisualVM, JConsole etc...");
        out("");
        out("What is not allowed ?");
        out("");
        out("Do not try to cheat by decompiling the game code and read the answers (if you do that, you will not learn anything ... accept knowing how to decompile (-:)");
        out("Do not use Intellij or Eclipse , the purpose of this game is to learn java - \" The Hard Way\"");
        out("");
        out("So.... If you are ready to start the game, type something to continue");

        String answer = getAnswer();
        while (answer==null || !answer.equals("something")) {
            if (answer == null) {
                gameOver();
            }
            out("type something to continue");
            answer = getAnswer();
        }
        out("very Good ! start the game now");


    }
}
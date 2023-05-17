/*
 * User: avishay
 * Date: 27/06/11 
 */
package com.game.tests;

import com.game.Game;
import com.game.GameFactory;
import com.game.Logg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public abstract class GameTest {

    private static BufferedReader deafultReader = new BufferedReader(new InputStreamReader(System.in));

    private Game game;

    public final void start(Game game) {
        this.game = game;
        if (game.isTestPassed(getClass())) {
            out(getClass().getSimpleName() + " passed!");
        } else {
            startTest();
            game.passTest(getClass());
            GameFactory.save(game);
        }
    }

    protected abstract void startTest();

    protected void msg(String msg) {
        Logg.debug(msg);
    }

    protected void out(String msg) {
        Logg.out(msg);
    }

    protected void title(String msg) {
        final StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < msg.length(); i++) {
            sb.append("_");
        }
        msg(sb.toString());
        msg(msg);
        msg(sb.toString());
    }

    protected void passed(int points, String msg) {
        msg(msg);
        game.addPoints(points);
    }

    protected void gameOver() {
        out("Game Over !!! you need to run the game again");
        System.exit(1);
    }

    protected void getAnswerUntil(String... requestedAnswers) {
        String answer = getAnswer();
        while (!isThere(answer, requestedAnswers)) {
            msg("This is not the answer!");
            answer = getAnswer();
        }
    }

    private boolean isThere(String answer, String...  requestedAnswers){
        for (final String requestedAnswer : requestedAnswers) {
            if (requestedAnswer.toLowerCase().equals(answer.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static String getAnswer() {
        String input = null;
        try {
            input = deafultReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                deafultReader.close();
            } catch (IOException e1) {
            }
        }
        return input;

    }
}
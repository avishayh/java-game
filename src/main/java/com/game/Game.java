package com.game;

import com.game.tests.GameTest;

import java.util.HashSet;
import java.util.Set;

/**

 */
public class Game {

    Set<String> passedTests = new HashSet<String>();
    int earnedPoints;
    String id;

    public void passTest(Class<? extends GameTest> test) {
        passedTests.add(test.getName());
    }

    public boolean isTestPassed(Class<? extends GameTest> test) {
        return passedTests.contains(test.getName());
    }

    public void addPoints(int points) {
        earnedPoints += points;
        Logg.debug(String.format("Points earned [%d] , total score [%d]", points, earnedPoints));
    }

    public int getPoints() {
        return earnedPoints;
    }

    @Override
    public String toString() {
        return "id='" + id +
                "\ntests=" + passedTests +
                "\npoints=" + earnedPoints;
    }

}

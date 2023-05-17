/*
 * User: avishay
 * Date: 27/06/11
 */
package com.game.tests;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class JavaVersionTest extends GameTest {

    private Set<String> allowedJavaVersions = new HashSet();

    {
        allowedJavaVersions.add("6");
        allowedJavaVersions.add("7");
    }


    @Override
    public void startTest() {
        title("Java Version Test");
        final String version = System.getProperty("java.version");
        msg("you are using java version " + version);
        if (version.contains("_")) {
            final String[] split = version.split("_");
            final String majorVersion = split[0];
            final String minorVersion = split[1];
            String javaVersion = null;
            int points = 0;
            try {
                javaVersion = majorVersion.split("\\.")[1];
                points = Integer.parseInt(minorVersion) + (Integer.parseInt(javaVersion) * 100);
            } catch (NumberFormatException e) {
                msg("sorry cannot continue ! error parse java version");
                gameOver();
            }

            if (!allowedJavaVersions.contains(javaVersion)) {
                msg("wow !!??? you are using an old java version [" + javaVersion + "] , I am sorry but you need to upgrade to java 6 at least!!!");
                gameOver();
            }
            passed(points, String.format("you are using Java [" + javaVersion + "] version, which is very good ! the number of points you earn is %d. You can earn more points if you will use the latest version of java", points));
        } else {
            msg("sorry cannot continue ! cannot parse java version");
            gameOver();
        }

    }
}
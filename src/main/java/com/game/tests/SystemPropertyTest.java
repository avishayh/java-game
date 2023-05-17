package com.game.tests;

/**

 */
public class SystemPropertyTest extends GameTest {

    private static final String PROPERTY_NAME = "passPropertyTest";
    private static final String SYS_KEY = "javaGame";
    private static final String SYS_VALUE = "isthebest";

    @Override
    public void startTest() {
         title("System Property Test");
        System.setProperty(SYS_KEY, SYS_VALUE);
        final String value = System.getProperty(PROPERTY_NAME);
        if ("true".equals(value)) {
            msg(String.format("Good, Found property [-D%s=true]", PROPERTY_NAME));

            msg("2. What is the value of the System Property : " + SYS_KEY);
            getAnswerUntil(SYS_VALUE);
            passed(5, "System Property tests passed successfully");
            return;
        }
        msg(String.format("1. In-order to pass this test,run program with a system property name [%s] equals true", PROPERTY_NAME));
        gameOver();
    }
}

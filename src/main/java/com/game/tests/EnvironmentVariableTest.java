package com.game.tests;

public class EnvironmentVariableTest extends GameTest {

    private static final String ENV_VAR_TO_PASS ="JAVA_GAME_PASS";

    @Override
    public void startTest() {
        title("Environment Variable Test");
        msg("");
        final String check = System.getenv(ENV_VAR_TO_PASS);
        if ("true".equals(check)) {
            msg("Found Environment variable " + ENV_VAR_TO_PASS + " with 'true' value");
            passed(2, "Environment Variable test passed successfully");
            return;
        }
        msg(String.format("In-order to pass this test, please specify an environment variable name [%s] with value [true]", ENV_VAR_TO_PASS));
        gameOver();
    }

}

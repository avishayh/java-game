/*
 * User: avishay
 * Date: 13/07/11 
 */

import com.game.Game;
import com.game.GameFactory;
import com.game.Logg;
import com.game.tests.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Answer :
 set JAVA_GAME_PASS=true
 java -Xmx128m -cp .;log4j-1.2.13.jar;game-1.0.jar -DpassPropertyTest=true -DpassThreadDump=true Start gameRocks
 something
 240
 */
public class Start {

    public static void main(String[] args) {
        List<GameTest> tests = new ArrayList<GameTest>();
        tests.add(new WelcomeTest());
        tests.add(new ValidationTest());
        tests.add(new LogTest());
        tests.add(new JavaVersionTest());
        tests.add(new EnvironmentVariableTest());
        tests.add(new ProgramArgumentTest(args.length > 0 ? args[0] : null));
        tests.add(new SystemPropertyTest());
        tests.add(new MemoryTest1());
        tests.add(new MemoryTest2());
        tests.add(new JMXBeanTest());
        tests.add(new ThreadDumpTest());
        tests.add(new NDCLogTest());
        tests.add(new SocketTest());

        Game game = new GameFactory().load();
        for (final GameTest test : tests) {
            test.start(game);
            space();
        }
        Logg.debug("Game ended - Well done you won " + game.getPoints());
    }

    private static void space() {
        Logg.out("\n\npress Enter to next test");
        GameTest.getAnswer();
    }
}
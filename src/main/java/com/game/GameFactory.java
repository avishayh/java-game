/*
 * User: avishay
 * Date: 13/07/11 

 */
package com.game;

import java.io.*;

/**
 *
 */
public class GameFactory {

    private static final String DIRECTORY = System.getProperty("java.io.tmpdir");
    private static final String FILE_NAME = "javaGame.txt";

    private static final long SESSION_TIMEOUT = 1000 * 60 * 20; //20 minutes

    public static Game load() {
        Game game = null;
        File file = getFile();
        if (file.exists()) {
            game = readFromFile(file);
            if (game != null) {
                long gameDate = Long.valueOf(game.id);
                long now = System.currentTimeMillis();
                long passedTime = now - gameDate;
                if (passedTime > SESSION_TIMEOUT) {
                    game = null;
                }
            }
        }
        if (game == null) {
            game = createNewGame();
        }
        return game;
    }

    public static void save(Game game) {
        File file = getFile();
        if (file.exists()) {
            file.delete();
        }
        writeToFile(game, file);
    }

    private static void writeToFile(Game game, File file) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
            out.println(game.id);
            out.println(game.earnedPoints);
            out.println(game.passedTests.toString());
            out.flush();
        } catch (IOException e) {
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    private static Game readFromFile(File file) {
        FileReader reader = null;
        try {
            Game game = new Game();
            reader = new FileReader(file);
            BufferedReader re = new BufferedReader(reader);
            game.id = re.readLine();
            game.earnedPoints = Integer.valueOf(re.readLine());
            String tests = re.readLine();
            String[] testss = tests.replace("[", "").replace("]", "").split(",");
            for (final String test : testss) {
                Class<?> type = Class.forName(test.trim());
                game.passedTests.add(test.trim());
            }
            return game;
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }

    private static Game createNewGame() {
        File file = getFile();
        if (file.exists()) {
            file.delete();
        }
        Game game = new Game();
        game.id = String.valueOf(System.currentTimeMillis());
        return game;
    }

    private static File getFile() {
        return new File(DIRECTORY + FILE_NAME);
    }
}
/*
 * User: avishay
 * Date: 27/07/11 
 */
package com.game.tests;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class SocketTest extends GameTest {

    private static final String HEB_ENCODING = "ISO8859-8";
    private static final String INPUT = "hello";
    private static final String[] ANSWER = {"hagiga basnuker","hagiga b'snooker","hagiga basnooker","hagiga b'asnuker"};
    private static final String QUESTION2 = "מאיזה סרט לקוח המשפט הבא: הצ'קים שלנו אף פעם לא חוזרים - יש לרשום תשובה באנגלית -תרגום חופשי";
    private static final int PORT = 6336;


    @Override
    protected void startTest() {
        title("Socket Test");
        msg("Program is listening to TCP port  " + PORT + " and waiting for input : " + INPUT);
        msg("You are allowed to use an IDE to create an answer, but do not add the game jar");
        ServerSocketFactory serverSocketFactory = ServerSocketFactory.getDefault();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                InputStream inputStream = clientSocket.getInputStream();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String line = reader.readLine();
                msg("received input via socket: " + line);
                if (INPUT.equals(line)) {
                    OutputStream outputStream = clientSocket.getOutputStream();
                    final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, HEB_ENCODING));
                    try {
                        msg("Sending back to socket the answer");
                        printWriter.write(QUESTION2);
                        printWriter.flush();
                    } finally {
                        printWriter.close();
                    }
                    break;
                } else {
                    msg("this is not what I expected");
                }
            }
        } catch (IOException e) {
            msg("problem with socket : " + e.getMessage());
            gameOver();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException ignored) {
            }
        }
        msg("What is the answer ?");
        getAnswerUntil(ANSWER);
        passed(10, "Socket Test passed");
    }
}
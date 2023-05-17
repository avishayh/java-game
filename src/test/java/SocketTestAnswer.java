/*
 * User: avishay
 * Date: 27/07/11 
 */

import javax.net.SocketFactory;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 */
public class SocketTestAnswer {

    /**
     * Execution entry method.
     *
     * @param args The runtime arguments for the this executable.
     * @throws Exception An exception which may be thrown and cannot be caught anywhere.
     */
    public static void main(final String[] args) throws Exception {

        SocketFactory socketFactory = SocketFactory.getDefault();
        Socket socket = socketFactory.createSocket();
        socket.connect(new InetSocketAddress("localhost", 6336));
        final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.println("hello");
        printWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "ISO8859-8"));
        String line = bufferedReader.readLine();
        System.out.println(line);
        bufferedReader.close();
        printWriter.close();
        socket.close();

    }
}
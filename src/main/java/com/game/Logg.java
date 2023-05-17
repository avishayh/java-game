package com.game;

import org.apache.log4j.Logger;

/**

 */
public class Logg {

    public static void out(String msg) {
        System.out.println(capitalize(msg));
    }

    public static void debug(String msg) {
        final Logger logger = Logger.getLogger(Logg.class);
        logger.debug(capitalize(msg));
    }

    public static void msg(String msg) {
        final Logger logger = Logger.getLogger(Logg.class);
        logger.error(capitalize(msg));
    }

    public static void audit(String msg) {
        final Logger logger = Logger.getLogger(Logg.class);
        logger.error(capitalize(msg));
    }

    private static String capitalize(String msg) {
        if (msg.length() > 1) {
            return Character.toUpperCase(msg.charAt(0)) + msg.substring(1);
        } else {
            return msg;
        }
    }

}

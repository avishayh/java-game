package com.game.tests;

import com.game.XXX;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class MemoryTest1 extends GameTest {

    private static final int A_NUMBER = (123 * 2 ^ 2) - 4;

    @Override
    public void startTest() {
        title("Memory Test");
        msg("To pass this test you need to find out how much instances of class com.game.XXX exist in the java heap.");
        msg("");
        List<XXX> arr=new ArrayList<XXX>();
        int i=0;
        for (int j = 0; j <A_NUMBER; j++) {
            arr.add(new XXX());
        }
        msg("Type how much instances of class com.game.XXX exist now?");
        getAnswerUntil(String.valueOf(A_NUMBER));
        msg("Correct the answer is : " + A_NUMBER);
        passed(5, "Congrats, Memory test passed");
    }
}



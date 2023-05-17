/*
 * User: avishay
 * Date: 28/06/11 
 */
package com.game.tests;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MemoryTest2 extends GameTest {

    private static final long A_NUMBER_WHICH_MORE_MEM_WILL_FIX = 1999999;

    @Override
    public void startTest() {
        title("Memory Test #2");
        msg("please wait ...");
        final List<List> arr = new ArrayList<List>();
        int j = 0;
        for (; j < A_NUMBER_WHICH_MORE_MEM_WILL_FIX; j++) {
            final Object o = Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{List.class}, new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return null;
                }
            });
            arr.add((List) o);
        }
        msg("Very good, adding more memory to the heap worked.");
        passed(3, "Out Of Memory test passed");
    }
}
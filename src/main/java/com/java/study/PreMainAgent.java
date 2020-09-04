package com.java.study;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 *
 * @author xuyuansheng
 */
public class PreMainAgent {

    public static void premain(String param, Instrumentation inst) {
        System.out.println("premain");

    }

}

package com.java.study;

/**
 * @author Mr.Xu
 * @date 2020/9/4 9:20
 */
public class TestAgent {

    public static void main(String[] args) {
        new TestAgent().test("sttt",999);
    }

    public Object test(String str, Integer integer) {
        System.out.println("TestAgent = ");
        return str + "<======>" + integer;
    }
}

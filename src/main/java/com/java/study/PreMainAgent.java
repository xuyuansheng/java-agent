package com.java.study;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 *
 * @author xuyuansheng
 */
public class PreMainAgent {

    public static void premain(String param, Instrumentation inst) {
        AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader, javaModule)
                -> builder.method(ElementMatchers.any()).intercept(MethodDelegation.to(CustomInterceptor.class));

        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith(""))
                .transform(transformer).installOn(inst);
    }

}

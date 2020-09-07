package com.java.study;

import net.bytebuddy.implementation.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author Mr.Xu
 * @date 2020/9/4 11:31
 */
public class CustomInterceptor {


    static OutputStream outputStream = null;

    static {
        try {
            outputStream = Files.newOutputStream(Paths.get("D:\\logs.txt"));
        } catch (IOException e) {
        }
    }

    @RuntimeType
    public static Object interceptor(@AllArguments Object[] args,
                                     @SuperMethod Method method,
                                     @Origin Class<?> clazz,
                                     @SuperCall Callable callable) throws Exception {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------------------------------------------------------------------------------------------\n");

        stringBuffer.append(clazz.getName()).append("\n");
        stringBuffer.append(method.toGenericString()).append("\n");
        stringBuffer.append("============================================parameterStart======================================\n");
        for (int i = 0; i < args.length; i++) {
            if (args[i].getClass().isArray()) {
                stringBuffer.append("Array:").append(Arrays.toString((Object[]) args[i])).append("\n");
            } else {
                stringBuffer.append("Object:").append(args[i]).append("\n");
            }
        }
        stringBuffer.append("======================================parameterEnd============================================\n");

        Object call = callable.call();
        if (call != null && call.getClass().isArray()) {
            stringBuffer.append("Array:").append(Arrays.toString((Object[]) call)).append("\n");
        } else {
            stringBuffer.append("Object:").append(call).append("\n");
        }

        stringBuffer.append("======================================returnEnd============================================\n");

        outputStream.write(stringBuffer.toString().getBytes());
        outputStream.flush();
        return call;
    }


}

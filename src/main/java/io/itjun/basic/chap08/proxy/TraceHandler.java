package io.itjun.basic.chap08.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * A invocation handler the prints out the method name and parameters, the
 * invokes the original method
 * <p>
 * Created by itjun on 2016/6/28 0026.
 */
class TraceHandler implements InvocationHandler {

    private Object object;

    /**
     * Constructs a TraceHandler
     *
     * @param object the implicit parameter of the method call
     */
    public TraceHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(object);
        System.out.print("." + method.getName() + "(");

        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }

        System.out.println(")");
        return method.invoke(object, args);
    }

}

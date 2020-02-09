package ua.kpi.proxy;

import lombok.AllArgsConstructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@AllArgsConstructor
public class NoSetterProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().startsWith("set")) {
            throw new UnsupportedOperationException("no setters allowed!");
        }

        return method.invoke(target, args);
    }
}

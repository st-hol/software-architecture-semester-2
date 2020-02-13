package ua.kpi;

import lombok.extern.log4j.Log4j2;
import ua.kpi.entity.NumberInterface;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.proxy.NoSetterProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Log4j2
public class ProxyTaskMain {
    public static void main(String[] args) {
        InvocationHandler noSetterProxyHandler = new NoSetterProxy(new ComplexNumber());
        Class[] classes = new Class[]{NumberInterface.class};
        Object proxy = Proxy.newProxyInstance(NumberInterface.class.getClassLoader(), classes, noSetterProxyHandler);

        try {
            ((NumberInterface) proxy).get();
            log.info("1) get method proceeded successfully");
            ((NumberInterface) proxy).set(); // here exception occurs
            log.debug("-2) (will not be printed)");
        } catch (UnsupportedOperationException e) {
            log.error("caught: " + e.getMessage());
            log.error("3) set method caused exception");
        }
    }
}

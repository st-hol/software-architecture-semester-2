package ua.kpi.proxy;

import ua.kpi.entity.NumberInterface;
import ua.kpi.entity.impl.ComplexNumber;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        InvocationHandler noSetterProxyHandler = new NoSetterProxy(new ComplexNumber());
        Class[] classes = new Class[]{ NumberInterface.class };
        Object proxy = Proxy.newProxyInstance(NumberInterface.class.getClassLoader(), classes, noSetterProxyHandler);

        try {
            ((NumberInterface) proxy).get();
            System.out.println("1) get method proceeded successfully");
            ((NumberInterface) proxy).set();
            System.out.println("2) (will not be printed)");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
            System.out.println("catched:" + e.getMessage());
            System.out.println("3) set method caused exception");
        }
    }
}

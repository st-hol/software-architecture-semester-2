package ua.kpi.proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.entity.NumberInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

class NoSetterProxyTest {

    private static final String EXCEPTION_MESSAGE = "no setters allowed!";

    private Object proxyUnderTest;

    @BeforeEach
    void setUp() {
        Class[] classes = new Class[]{NumberInterface.class};
        InvocationHandler noSetterProxyHandler = new NoSetterProxy(new ComplexNumber());
        proxyUnderTest = Proxy.newProxyInstance(NumberInterface.class.getClassLoader(), classes, noSetterProxyHandler);
    }

    @Test
    void whenSetInvoked_thenThrowException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            NumberInterface proxiedComplexNumber = (NumberInterface) proxyUnderTest;
            proxiedComplexNumber.set();
        }, EXCEPTION_MESSAGE);
    }

    @Test
    void whenGetInvoked_thenProceed() {
        Assertions.assertDoesNotThrow(() -> {
            NumberInterface proxiedComplexNumber = (NumberInterface) proxyUnderTest;
            proxiedComplexNumber.get();
        });
    }
}
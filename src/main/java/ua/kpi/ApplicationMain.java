package ua.kpi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import lombok.extern.log4j.Log4j2;
import ua.kpi.controller.ApplicationController;
import ua.kpi.entity.NumberInterface;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.proxy.NoSetterProxy;

@Log4j2
public class ApplicationMain {
    public static void main(String[] args) {
        ApplicationController.getInstance().processActionControl();
    }
}

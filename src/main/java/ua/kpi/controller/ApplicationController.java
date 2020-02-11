package ua.kpi.controller;

import ua.kpi.ui.util.ApplicationView;
import ua.kpi.ui.util.InputProvider;


public class ApplicationController {

    private static ApplicationController instance;
    private ApplicationView applicationView;
    private InputProvider inputProvider;

    private ApplicationController() {
        this.applicationView = ApplicationView.getInstance();
        this.inputProvider = InputProvider.getInstance();
    }

    public static ApplicationController getInstance() {
        if (instance == null) {
            synchronized (ApplicationController.class) {
                if (instance == null) {
                    instance = new ApplicationController();
                }
            }
        }
        return instance;
    }

    public void printLine(String str) {
        applicationView.printLine(str);
    }

    public int readOrQuit() {
        return inputProvider.readOrQuit();
    }

}

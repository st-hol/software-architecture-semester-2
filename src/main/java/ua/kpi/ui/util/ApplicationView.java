package ua.kpi.ui.util;

import java.util.List;



public class ApplicationView {

    private static ApplicationView instance;

    private ApplicationView() {
    }

    public static ApplicationView getInstance() {
        if (instance == null) {
            synchronized (ApplicationView.class) {
                if (instance == null) {
                    instance = new ApplicationView();
                }
            }
        }
        return instance;
    }

    public void printLine(String s) {
        System.out.println(s);
    }


}

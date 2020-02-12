package ua.kpi.facade;

import ua.kpi.service.CalculationService;
import ua.kpi.service.impl.CalculationServiceImpl;
import ua.kpi.ui.util.ApplicationView;
import ua.kpi.ui.util.InputProvider;

public class CalculationFacade {

    private ApplicationView applicationView;
    private InputProvider inputProvider;
    private CalculationService calculationService;

    private static CalculationFacade instance;

    private CalculationFacade() {
        this.applicationView = ApplicationView.getInstance();
        this.inputProvider = InputProvider.getInstance();
        this.calculationService = CalculationServiceImpl.getInstance();
    }

    public static CalculationFacade getInstance() {
        if (instance == null) {
            synchronized (CalculationFacade.class) {
                if (instance == null) {
                    instance = new CalculationFacade();
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

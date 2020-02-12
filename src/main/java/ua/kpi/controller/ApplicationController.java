package ua.kpi.controller;

import ua.kpi.facade.CalculationFacade;


public class ApplicationController {

    private static ApplicationController instance;
    private CalculationFacade calculationFacade;

    private ApplicationController() {
        calculationFacade = CalculationFacade.getInstance();
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

    public void processActionControl(){

    }

    public void processAbsOperation(){

    }

    public void processAddOperation(){

    }

    public void processMultiplyOperation(){

    }

}

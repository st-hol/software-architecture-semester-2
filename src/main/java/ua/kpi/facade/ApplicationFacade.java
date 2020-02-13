package ua.kpi.facade;

import static ua.kpi.ui.TextConstants.ASK_OPTION;
import static ua.kpi.ui.TextConstants.RESULT;
import static ua.kpi.ui.TextConstants.SHOW_OPTION;
import static ua.kpi.ui.TextConstants.WELCOME;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import ua.kpi.command.Command;
import ua.kpi.command.operations.ExitCommand;
import ua.kpi.factory.OperationRequestFactory;
import ua.kpi.factory.OperationRequestFactoryImpl;
import ua.kpi.service.ApplicationService;
import ua.kpi.service.CalculationService;
import ua.kpi.service.impl.ApplicationServiceImpl;
import ua.kpi.service.impl.CalculationServiceImpl;
import ua.kpi.flyweight.OperationRequest;
import ua.kpi.type.ActionCode;
import ua.kpi.ui.util.ApplicationView;
import ua.kpi.ui.util.InputProvider;

public class ApplicationFacade {

    private ApplicationView applicationView;
    private InputProvider inputProvider;
    private CalculationService calculationService;
    private ApplicationService applicationService;
    private OperationRequestFactory operationRequestFactory;

    private static ApplicationFacade instance;

    private ApplicationFacade() {
        this.applicationView = ApplicationView.getInstance();
        this.inputProvider = InputProvider.getInstance();
        this.calculationService = CalculationServiceImpl.getInstance();
        this.applicationService = ApplicationServiceImpl.getInstance();
        this.operationRequestFactory = new OperationRequestFactoryImpl();
    }

    public static ApplicationFacade getInstance() {
        if (instance == null) {
            synchronized (ApplicationFacade.class) {
                if (instance == null) {
                    instance = new ApplicationFacade();
                }
            }
        }
        return instance;
    }

    public void process(Map<ActionCode, Command> commands) {
        printLine(WELCOME);
        while (true) {
            printLine(ASK_OPTION + "\n" + SHOW_OPTION + "\n");
            ActionCode actionCode = inputProvider.readStringForEnum(ActionCode.class);

            Command command = commands.getOrDefault(actionCode, new ExitCommand());
            if (command.getClass() == ExitCommand.class) {
                break;
            }
            //readParams
            List<BigDecimal> params ;
            OperationRequest request = operationRequestFactory.assembleRequest(params);
            BigDecimal result = command.execute(request);

            printLine(RESULT + result.toString());
        }
    }

    private void printLine(String str) {
        applicationView.printLine(str);
    }

}

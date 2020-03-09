package ua.kpi.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.command.Command;
import ua.kpi.command.operations.ExitCommand;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.factory.OperationRequestFactory;
import ua.kpi.flyweight.OperationRequest;
import ua.kpi.service.ApplicationService;
import ua.kpi.service.CalculationService;
import ua.kpi.type.ActionCode;
import ua.kpi.ui.util.ApplicationView;
import ua.kpi.ui.util.InputProvider;

import java.util.List;
import java.util.Map;

import static ua.kpi.ui.TextConstants.*;


@Component
public class ApplicationFacade {

    private ApplicationView applicationView;
    private InputProvider inputProvider;
    private CalculationService calculationService;
    private ApplicationService applicationService;
    private OperationRequestFactory operationRequestFactory;

    @Autowired
    public ApplicationFacade(ApplicationView applicationView, InputProvider inputProvider,
                             CalculationService calculationService, ApplicationService applicationService,
                             OperationRequestFactory operationRequestFactory) {
        this.applicationView = applicationView;
        this.inputProvider = inputProvider;
        this.calculationService = calculationService;
        this.applicationService = applicationService;
        this.operationRequestFactory = operationRequestFactory;
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
            List<ComplexNumber> params = inputProvider.readParams(actionCode.getNoOfOperands());
            OperationRequest request = operationRequestFactory.assembleRequest(params);
            ComplexNumber result = command.execute(request);

            printLine(RESULT + result.toString());
        }
    }

    private void printLine(String str) {
        applicationView.printLine(str);
    }

}

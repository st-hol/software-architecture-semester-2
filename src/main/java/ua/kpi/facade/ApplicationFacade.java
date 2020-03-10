package ua.kpi.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.kpi.factory.OperationRequestFactory;
import ua.kpi.service.ApplicationService;
import ua.kpi.service.CalculationService;


@Component
public class ApplicationFacade {

    private CalculationService calculationService;
    private ApplicationService applicationService;
    private OperationRequestFactory operationRequestFactory;

    @Autowired
    public ApplicationFacade(CalculationService calculationService, ApplicationService applicationService,
                             OperationRequestFactory operationRequestFactory) {
        this.calculationService = calculationService;
        this.applicationService = applicationService;
        this.operationRequestFactory = operationRequestFactory;
    }
}

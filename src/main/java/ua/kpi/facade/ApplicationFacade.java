package ua.kpi.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.kpi.service.CalculationService;
import ua.kpi.service.impl.CalculationRequestService;
import ua.kpi.service.impl.CalculationResultService;
import ua.kpi.service.impl.ComplexNumberService;


@Component
public class ApplicationFacade {

    private CalculationService calculationService;
    private ComplexNumberService complexNumberService;
    private CalculationResultService calculationResultService;
    private CalculationRequestService calculationRequestService;

    @Autowired
    public ApplicationFacade(CalculationService calculationService, ComplexNumberService complexNumberService,
                             CalculationResultService calculationResultService,
                             CalculationRequestService calculationRequestService) {
        this.calculationService = calculationService;
        this.complexNumberService = complexNumberService;
        this.calculationResultService = calculationResultService;
        this.calculationRequestService = calculationRequestService;
    }
}

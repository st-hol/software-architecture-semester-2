package ua.kpi.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.kpi.service.ApplicationService;
import ua.kpi.service.CalculationService;


@Component
public class ApplicationFacade {

    private CalculationService calculationService;
    private ApplicationService applicationService;

    @Autowired
    public ApplicationFacade(CalculationService calculationService, ApplicationService applicationService) {
        this.calculationService = calculationService;
        this.applicationService = applicationService;
    }
}

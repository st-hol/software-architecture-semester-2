package ua.kpi.command;

import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.flyweight.OperationRequest;
import ua.kpi.service.CalculationService;
import ua.kpi.service.impl.CalculationServiceImpl;


public abstract class Command {
    protected CalculationService calculationService = CalculationServiceImpl.getInstance();

    public abstract ComplexNumber execute(OperationRequest req);
}

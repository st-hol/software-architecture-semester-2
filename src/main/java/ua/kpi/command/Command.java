package ua.kpi.command;

import ua.kpi.domain.CalculationRequest;
import ua.kpi.entity.impl.ComplexNumber;

public interface Command {
    ComplexNumber execute(CalculationRequest calculationRequest);
}

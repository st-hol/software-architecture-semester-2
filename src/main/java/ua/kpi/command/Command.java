package ua.kpi.command;

import ua.kpi.domain.CalculationRequest;
import ua.kpi.domain.ComplexNumber;

public interface Command {
    ComplexNumber execute(CalculationRequest calculationRequest);
}

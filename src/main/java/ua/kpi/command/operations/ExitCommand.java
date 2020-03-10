package ua.kpi.command.operations;

import org.springframework.stereotype.Component;

import ua.kpi.command.Command;
import ua.kpi.domain.CalculationRequest;
import ua.kpi.domain.ComplexNumber;

@Component
public class ExitCommand implements Command {
    @Override
    public ComplexNumber execute(CalculationRequest calculationRequest) {
        return null;
    }
}

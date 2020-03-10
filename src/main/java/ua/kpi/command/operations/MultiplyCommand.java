package ua.kpi.command.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.kpi.command.Command;
import ua.kpi.domain.CalculationRequest;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.service.CalculationService;

@Component
public class MultiplyCommand implements Command {

    @Autowired
    private CalculationService calculationService;

    @Override
    public ComplexNumber execute(CalculationRequest calculationRequest) {
        ComplexNumber firstOperand = null;
        ComplexNumber secondOperand = null;
        return calculationService.multiply(firstOperand, secondOperand);
    }
}

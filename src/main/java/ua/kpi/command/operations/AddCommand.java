package ua.kpi.command.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.kpi.command.Command;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.payload.OperationRequest;
import ua.kpi.service.CalculationService;

@Component
public class AddCommand implements Command {

    @Autowired
    private CalculationService calculationService;

    @Override
    public ComplexNumber execute(OperationRequest req) {
        ComplexNumber firstOperand = req.getArgs().get(0);
        ComplexNumber secondOperand = req.getArgs().get(1);
        return calculationService.add(firstOperand, secondOperand);
    }
}

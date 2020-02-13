package ua.kpi.command.operations;

import ua.kpi.command.Command;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.flyweight.OperationRequest;

public class AddCommand extends Command {
    @Override
    public ComplexNumber execute(OperationRequest req) {
        ComplexNumber firstOperand = req.getArgs().get(0);
        ComplexNumber secondOperand = req.getArgs().get(1);
        return calculationService.add(firstOperand, secondOperand);
    }
}

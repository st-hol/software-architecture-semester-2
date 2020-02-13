package ua.kpi.command.operations;

import ua.kpi.command.Command;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.flyweight.OperationRequest;

public class AbsCommand extends Command {

    @Override
    public ComplexNumber execute(OperationRequest req) {
        ComplexNumber operand = req.getArgs().get(0);
//        calculationService.abs(new NumberBuilder().)
        return null;
    }
}

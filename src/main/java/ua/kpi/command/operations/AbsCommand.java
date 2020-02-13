package ua.kpi.command.operations;

import lombok.extern.log4j.Log4j2;
import ua.kpi.command.Command;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.exception.CalculationException;
import ua.kpi.flyweight.OperationRequest;

@Log4j2
public class AbsCommand extends Command {

    @Override
    public ComplexNumber execute(OperationRequest req) {
        ComplexNumber operand = req.getArgs().get(0);
        ComplexNumber result = new ComplexNumber();
        try {
            result = calculationService.abs(operand);
        } catch (CalculationException ex) {
            log.error("ComplexNumber CalculationException");
        }
        return result;
    }
}

package ua.kpi.command.operations;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.command.Command;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.exception.CalculationException;
import ua.kpi.flyweight.OperationRequest;
import ua.kpi.service.CalculationService;

@Log4j2
@Component
public class AbsCommand implements Command {

    @Autowired
    private CalculationService calculationService;

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

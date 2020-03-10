package ua.kpi.command.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import ua.kpi.command.Command;
import ua.kpi.domain.CalculationRequest;
import ua.kpi.domain.ComplexNumber;
import ua.kpi.exception.CalculationException;
import ua.kpi.service.CalculationService;

@Log4j2
@Component
public class AbsCommand implements Command {

    @Autowired
    private CalculationService calculationService;

    @Override
    public ComplexNumber execute(CalculationRequest calculationRequest) {
        ComplexNumber operand = null;
        ComplexNumber result = new ComplexNumber();
        try {
            result = calculationService.abs(operand);
        } catch (CalculationException ex) {
            log.error("ComplexNumber CalculationException");
        }
        return result;
    }
}

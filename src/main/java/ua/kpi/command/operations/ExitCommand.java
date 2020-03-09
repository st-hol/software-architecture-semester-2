package ua.kpi.command.operations;

import org.springframework.stereotype.Component;
import ua.kpi.command.Command;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.flyweight.OperationRequest;

@Component
public class ExitCommand implements Command {
    @Override
    public ComplexNumber execute(OperationRequest req) {
        return null;
    }
}

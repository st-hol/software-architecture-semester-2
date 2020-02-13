package ua.kpi.command.operations;

import java.math.BigDecimal;

import ua.kpi.command.Command;
import ua.kpi.flyweight.OperationRequest;
import ua.kpi.type.ActionCode;

public class AddCommand implements Command {
    @Override
    public BigDecimal execute(OperationRequest req) {
        return null;
    }
}

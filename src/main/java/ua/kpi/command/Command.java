package ua.kpi.command;

import java.math.BigDecimal;

import ua.kpi.flyweight.OperationRequest;


public interface Command {
    BigDecimal execute(OperationRequest req);
}

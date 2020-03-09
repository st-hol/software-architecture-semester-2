package ua.kpi.command;

import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.flyweight.OperationRequest;


public interface Command {
    ComplexNumber execute(OperationRequest req);
}

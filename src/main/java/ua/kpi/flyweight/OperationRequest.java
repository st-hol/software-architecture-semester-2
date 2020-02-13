package ua.kpi.flyweight;

import java.util.List;

import ua.kpi.entity.impl.ComplexNumber;

public interface OperationRequest {

    List<ComplexNumber> getArgs();

}

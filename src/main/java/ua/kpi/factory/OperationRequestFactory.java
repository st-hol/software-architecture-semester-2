package ua.kpi.factory;

import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.flyweight.OperationRequest;

import java.util.List;

public abstract class OperationRequestFactory {

    abstract OperationRequest makeRequest(List<ComplexNumber> params);

    public OperationRequest assembleRequest(List<ComplexNumber> params) {
        return makeRequest(params);
    }

}
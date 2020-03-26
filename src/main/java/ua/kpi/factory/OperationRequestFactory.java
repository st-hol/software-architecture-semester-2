package ua.kpi.factory;

import java.util.List;

import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.payload.OperationRequest;

public abstract class OperationRequestFactory {

    abstract OperationRequest makeRequest(List<ComplexNumber> params);

    public OperationRequest assembleRequest(List<ComplexNumber> params) {
        return makeRequest(params);
    }

}
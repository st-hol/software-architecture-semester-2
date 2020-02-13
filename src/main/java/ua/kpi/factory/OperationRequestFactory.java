package ua.kpi.factory;

import java.math.BigDecimal;
import java.util.List;

import ua.kpi.flyweight.OperationRequest;

public abstract class OperationRequestFactory {

    abstract OperationRequest makeRequest(List<BigDecimal> params);

    public OperationRequest assembleRequest(List<BigDecimal> params) {
        return makeRequest(params);
    }

}
package ua.kpi.factory;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.exception.UnrecognizedRequestException;
import ua.kpi.flyweight.OperationRequest;
import ua.kpi.flyweight.SingleOperandRequest;
import ua.kpi.flyweight.TwoOperandRequest;

import java.util.List;

@Log4j2
@Component
public class OperationRequestFactoryImpl extends OperationRequestFactory {
    private static final String NOT_EXIST_MESSAGE = "There are no request for your args";

    public OperationRequest makeRequest(List<ComplexNumber> params) {
        OperationRequest request = makeFromParams(params);
        log.info("Factory: Preparing " + request.toString());
        return request;
    }

    private OperationRequest makeFromParams(List<ComplexNumber> params) {
        int nArgs = params.size();
        switch (nArgs) {
            case 1:
                return new SingleOperandRequest(params.get(0));
            case 2:
                return new TwoOperandRequest(params.get(0), params.get(1));
            case 0:
            default:
                throw new UnrecognizedRequestException(NOT_EXIST_MESSAGE);
        }
    }
}

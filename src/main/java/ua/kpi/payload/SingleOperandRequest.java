package ua.kpi.payload;

import java.util.Collections;
import java.util.List;

import lombok.Data;
import ua.kpi.entity.impl.ComplexNumber;

@Data
public class SingleOperandRequest implements OperationRequest {
    private ComplexNumber operand;

    public SingleOperandRequest(ComplexNumber operand) {
        this.operand = operand;
    }

    @Override
    public List<ComplexNumber> getArgs() {
        return Collections.singletonList(operand);
    }
}

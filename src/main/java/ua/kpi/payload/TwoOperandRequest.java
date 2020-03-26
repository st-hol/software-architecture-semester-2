package ua.kpi.payload;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import ua.kpi.entity.impl.ComplexNumber;

@Data
public class TwoOperandRequest implements OperationRequest {
    private ComplexNumber firstOperand;
    private ComplexNumber secondOperand;

    public TwoOperandRequest(ComplexNumber firstOperand, ComplexNumber secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public List<ComplexNumber> getArgs() {
        return Arrays.asList(firstOperand, secondOperand);
    }
}

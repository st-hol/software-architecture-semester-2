package ua.kpi.flyweight;

import java.math.BigDecimal;

import lombok.Data;
import ua.kpi.type.ActionCode;

@Data
public class TwoOperandRequest implements OperationRequest {
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public TwoOperandRequest(BigDecimal firstOperand, BigDecimal secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

}

package ua.kpi.flyweight;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SingleOperandRequest implements OperationRequest {
    private BigDecimal operand;

    public SingleOperandRequest(BigDecimal operand) {
        this.operand = operand;
    }
}

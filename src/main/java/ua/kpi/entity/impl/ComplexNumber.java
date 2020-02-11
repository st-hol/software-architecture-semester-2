package ua.kpi.entity.impl;

import lombok.Data;
import ua.kpi.entity.NumberInterface;

import java.math.BigDecimal;

@Data
public class ComplexNumber implements NumberInterface {

    protected BigDecimal r;
    protected BigDecimal i;

    public ComplexNumber() {
        System.out.println("Base class constr. invocation");
    }

    public ComplexNumber(BigDecimal r) {
        this.r = r;
        this.i = BigDecimal.valueOf(0.0);
    }

    public ComplexNumber(BigDecimal r, BigDecimal i) {
        this.r = r;
        this.i = i;
    }

}

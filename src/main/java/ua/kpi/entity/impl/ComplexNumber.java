package ua.kpi.entity.impl;

import lombok.*;
import ua.kpi.entity.NumberInterface;

import java.math.BigDecimal;

public class ComplexNumber implements NumberInterface {

    protected BigDecimal aCoefficient;
    protected BigDecimal bCoefficient;

    public ComplexNumber(BigDecimal aCoefficient, BigDecimal bCoefficient) {
        this.aCoefficient = aCoefficient;
        this.bCoefficient = bCoefficient;
    }

    public ComplexNumber() {
        System.out.println("Base class constr. invocation");
    }

}

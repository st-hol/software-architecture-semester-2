package ua.kpi.entity.impl;


import java.math.BigDecimal;


public class ComplexNumberWithExp extends ComplexNumber {

    private BigDecimal fi = BigDecimal.ZERO;

    public ComplexNumberWithExp(BigDecimal aCoefficient, BigDecimal bCoefficient, BigDecimal fi) {
        super(aCoefficient, bCoefficient);
        this.fi = fi;
    }

    public ComplexNumberWithExp() {
        System.out.println("Child class constr. invocation");
    }

    @Deprecated
    public String calcExponentialForm() {
        return String.format("cos (%s) + i sin (%s) = e^i*(%s)", fi, fi, fi);
    }

    @Override
    public String toString() {
        return "ComplexNumberWithExp{" +
                "fi=" + fi +
                ", aCoefficient=" + r +
                ", bCoefficient=" + i +
                '}';
    }
}

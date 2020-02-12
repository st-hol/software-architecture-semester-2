
package ua.kpi.builder;


import java.math.BigDecimal;

import ua.kpi.entity.impl.ComplexNumber;


public class NumberBuilder {

    private BigDecimal r;
    private BigDecimal i;

    private NumberListBuilder numberListBuilder;

    public NumberBuilder(NumberListBuilder numberListBuilder) {
        this.numberListBuilder = numberListBuilder;
    }

    public NumberBuilder setR(BigDecimal r) {
        this.r = r;
        return this;
    }

    public NumberBuilder setI(BigDecimal i) {
        this.i = i;
        return this;
    }

    public NumberBuilder setNumberListBuilder(NumberListBuilder numberListBuilder) {
        this.numberListBuilder = numberListBuilder;
        return this;
    }

    private ComplexNumber build() {
        ComplexNumber number = new ComplexNumber();
        number.setR(r);
        number.setI(i);
        return number;
    }

    public NumberListBuilder addNumberToList() {
        ComplexNumber number = build();
        this.numberListBuilder.addNumber(number);
        return this.numberListBuilder;
    }

}

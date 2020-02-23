package ua.kpi.service.impl;

import org.junit.jupiter.api.Test;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.exception.CalculationException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CalculationServiceImplTest {

    private CalculationServiceImpl calculationService = CalculationServiceImpl.getInstance();

    @Test
    void calculateExpForm() {
        assertEquals("1+10i",
                calculationService.calculateExpForm(
                        new ComplexNumber(BigDecimal.ONE, BigDecimal.TEN)));
    }

    @Test
    void abs() throws CalculationException {
        ComplexNumber complexNumber = calculationService.abs(new ComplexNumber(BigDecimal.ONE, BigDecimal.TEN));
        assertNotNull(complexNumber);
    }

    @Test
    void add() {
        ComplexNumber complexNumber = calculationService.add(new ComplexNumber(BigDecimal.ONE, BigDecimal.TEN),
                new ComplexNumber(BigDecimal.ONE, BigDecimal.TEN));
        assertNotNull(complexNumber);
    }

    @Test
    void multiply() {
        ComplexNumber complexNumber = calculationService.multiply(new ComplexNumber(BigDecimal.ONE, BigDecimal.TEN),
                new ComplexNumber(BigDecimal.ONE, BigDecimal.TEN));
        assertNotNull(complexNumber);
    }
}
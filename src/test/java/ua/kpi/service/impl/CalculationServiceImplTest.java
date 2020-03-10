package ua.kpi.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import ua.kpi.domain.ComplexNumber;
import ua.kpi.exception.CalculationException;

class CalculationServiceImplTest {

    @InjectMocks
    private CalculationServiceImpl calculationService;

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
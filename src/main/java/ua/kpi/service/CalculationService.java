package ua.kpi.service;

import java.math.BigDecimal;

import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.exception.CalculationException;

public interface CalculationService {
    String calculateExpForm(ComplexNumber original);
    BigDecimal abs(ComplexNumber original) throws CalculationException;
    ComplexNumber add(ComplexNumber original, ComplexNumber other);
    ComplexNumber multiply(ComplexNumber original, ComplexNumber other);
}

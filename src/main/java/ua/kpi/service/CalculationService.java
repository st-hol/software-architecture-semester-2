package ua.kpi.service;


import ua.kpi.domain.ComplexNumber;
import ua.kpi.exception.CalculationException;

public interface CalculationService {
    String calculateExpForm(ComplexNumber original);

    ComplexNumber abs(ComplexNumber original) throws CalculationException;
    ComplexNumber add(ComplexNumber original, ComplexNumber other);
    ComplexNumber multiply(ComplexNumber original, ComplexNumber other);
}

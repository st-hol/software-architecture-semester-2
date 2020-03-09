package ua.kpi.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.exception.CalculationException;
import ua.kpi.service.CalculationService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculationServiceImpl implements CalculationService {

    private static final int SCALE_FOR_RESULT = 3;
    private static final int SCALE_FOR_SQRT = 10001;
    private static final String NEGATIVE_VALUE_FOR_SQRT = "NEGATIVE_VALUE_FOR_SQRT";

    @Override
    public String calculateExpForm(ComplexNumber original) {
        return original.getR() + "+" + original.getI() + "i";
    }

    @Override
    public ComplexNumber abs(ComplexNumber original) throws CalculationException {
        BigDecimal x = sqrt(pow(original.getR(), 2).add(pow(original.getI(), 2)));
        BigDecimal y = sqrt(pow(original.getR(), 2).add(pow(original.getI(), 2)));
        return new ComplexNumber(x, y);
    }

    @Override
    public ComplexNumber add(ComplexNumber original, ComplexNumber other) {
        BigDecimal x = original.getR().add(other.getR()).setScale(SCALE_FOR_RESULT, RoundingMode.HALF_UP);
        BigDecimal y = original.getI().add(other.getI()).setScale(SCALE_FOR_RESULT, RoundingMode.HALF_UP);
        return new ComplexNumber(x, y);
    }

    @Override
    public ComplexNumber multiply(ComplexNumber original, ComplexNumber other) {
        BigDecimal x = (original.getR().multiply(other.getR())).subtract(original.getI().multiply(other.getI()))
                .setScale(SCALE_FOR_RESULT, RoundingMode.HALF_UP);
        BigDecimal y = (original.getR().multiply(other.getI())).add((original.getI().multiply(other.getR())))
                .setScale(SCALE_FOR_RESULT, RoundingMode.HALF_UP);
        return new ComplexNumber(x, y);
    }


    /**
     * it’s from Stackoverflow :)
     *
     * @param number
     * @return square root
     * @throws CalculationException
     */
    private BigDecimal sqrt(BigDecimal number) throws CalculationException {

        BigDecimal first = BigDecimal.ZERO;
        BigDecimal second;
        try {
            second = BigDecimal.valueOf(Math.sqrt(number.doubleValue()));
        } catch (NumberFormatException e) {
            throw new CalculationException(NEGATIVE_VALUE_FOR_SQRT);
        }
        while (!first.equals(second)) {
            first = second;
            second = number.divide(first, SCALE_FOR_SQRT, RoundingMode.HALF_UP);
            second = second.add(first);
            second = second.divide(BigDecimal.valueOf(2), SCALE_FOR_SQRT, RoundingMode.HALF_UP);
        }
        return second;
    }

    private BigDecimal pow(BigDecimal base, int exponent) {

        BigDecimal ans = BigDecimal.valueOf(1.0);
        BigDecimal k = BigDecimal.valueOf(1.0);
        if (exponent != 0) {
            int absExponent = exponent > 0 ? exponent : (-1) * exponent;
            for (int i = 1; i <= absExponent; i++) {
                ans = ans.multiply(base);
            }

            if (exponent < 0) {
                // For negative exponent, must invert
                ans = k.divide(ans);
            }
        } else {
            // exponent is 0
            ans = k;
        }

        return ans;
    }


}

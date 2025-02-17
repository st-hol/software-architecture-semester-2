package ua.kpi.ui.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import lombok.extern.log4j.Log4j2;
import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.type.TypeEnum;

@Log4j2
public class InputProvider {

    private static InputProvider instance;
    private Scanner scanner;

    private InputProvider() {
        scanner = new Scanner(System.in);
    }

    public static InputProvider getInstance() {
        if (instance == null) {
            synchronized (InputProvider.class) {
                if (instance == null) {
                    instance = new InputProvider();
                }
            }
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <E extends TypeEnum> E readStringForEnum(Class clazz) {
        while (true) {
            String inputString = scanner.nextLine().toUpperCase();
            Optional foundValue = TypeEnum.findOptionalEnumValue(clazz, inputString);
            if (foundValue.isPresent()) {
                return (E) foundValue.get();
            } else {
                log.debug("You entered invalid value! Try again:");
            }
        }
    }

    public String readWithScanner() {
        return scanner.next();
    }

    public BigDecimal readBigDecimal() {
        while (!scanner.hasNextBigDecimal()) {
            scanner.next();
            log.error("Wrong format for number: please try again: ");
        }
        return scanner.nextBigDecimal();
    }

    public List<ComplexNumber> readParams(int noOfOperands) {
        List<ComplexNumber> params = new ArrayList<>();
        while (params.size() < noOfOperands) {
            log.debug("Enter param №" + params.size() + ": ");
            params.add(readComplexNumber());
        }
        return params;
    }

    private ComplexNumber readComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber();
        log.info("Input r: ");
        BigDecimal r = readBigDecimal();
        log.info("Input i: ");
        BigDecimal i = readBigDecimal();
        complexNumber.setI(i);
        complexNumber.setR(r);
        return complexNumber;
    }

    public int readOrQuit() {
        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            log.error("User input failed. Value '0' was set", e);
            return 0;
        }
    }
}

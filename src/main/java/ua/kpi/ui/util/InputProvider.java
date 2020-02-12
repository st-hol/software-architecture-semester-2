package ua.kpi.ui.util;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import lombok.extern.log4j.Log4j2;
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

    public int readOrQuit() {
        try {
            return scanner.nextInt();
        } catch (NumberFormatException e) {
            log.error("User input failed. Value '0' was set", e);
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    public <E extends TypeEnum> E readStringForEnum(Class clazz) {
        while (true) {
            String inputString = scanner.nextLine().toUpperCase();
            Optional foundValue = TypeEnum.findOptionalEnumValue(clazz, inputString);
            if (foundValue.isPresent()) {
                return (E) foundValue.get();
            } else {
                log.error("You entered invalid value! Try again:");
            }
        }
    }
}

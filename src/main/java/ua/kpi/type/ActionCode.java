package ua.kpi.type;

import java.util.stream.Stream;

public enum ActionCode implements StringTypeEnum {

    ABS("ABS", 1),
    ADD("ADD", 2),
    MUL("MUL", 2),
    EXIT("EXIT", 0);

    private final String value;
    private final int noOfOperands;

    ActionCode(String value, int noOfOperands) {
        this.value = value;
        this.noOfOperands = noOfOperands;
    }

    public static ActionCode fromValue(String value) {
        return Stream.of(values()).filter(v -> v.getValue().equals(value)).findFirst().orElse(null);
    }

    @Override
    public String getValue() {
        return value;
    }

    public int getNoOfOperands() {
        return noOfOperands;
    }

    @Override
    public boolean equalsTo(String value) {
        return false;
    }


}

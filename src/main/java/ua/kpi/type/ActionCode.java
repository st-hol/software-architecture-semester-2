package ua.kpi.type;

import java.util.stream.Stream;

public enum ActionCode implements StringTypeEnum {

    ABS("ABS"),
    ADD("ADD"),
    MUL("MUL"),
    EXIT("EXIT");

    private final String value;

    ActionCode(String value) {
        this.value = value;
    }

    /**
     * default - EN
     *
     * @param value
     * @return
     */
    public static ActionCode fromValue(String value) {
        return Stream.of(values()).filter(v -> v.getValue().equals(value)).findFirst().orElse(null);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equalsTo(String value) {
        return false;
    }


}

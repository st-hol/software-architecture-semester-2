package ua.kpi.entity;

public interface NumberInterface {
    default String get(){
        return "get";
    };

    default String set(){
        return "set";
    }
}


package ua.kpi.builder;

import java.util.ArrayList;
import java.util.List;

import ua.kpi.entity.NumberInterface;
import ua.kpi.entity.impl.ComplexNumber;


public class NumberListBuilder {

    private ArrayList<ComplexNumber> listOfNumbers;

    public NumberListBuilder addList() {
        this.listOfNumbers = new ArrayList<>();
        return this;
    }

    public NumberListBuilder addNumber(ComplexNumber number) {
        listOfNumbers.add(number);
        return this;
    }

    public NumberBuilder addNumber() {
        return new NumberBuilder(this);
    }

    public List<ComplexNumber> buildList() {
        return listOfNumbers;
    }

}

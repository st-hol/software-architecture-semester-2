package ua.kpi.entity.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInvocationTest {

    private ByteArrayOutputStream bo = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        //Redirect System.out to buffer
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void shouldPrintConstructorInvocations() throws IOException {
        new ComplexNumberWithExp();
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertTrue(allWrittenLines.contains("Base class constr. invocation"));
        assertTrue(allWrittenLines.contains("Child class constr. invocation"));
    }

    @Test
    public void shouldPrintToString() throws IOException {
        String result = new ComplexNumberWithExp(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN)
                .toString();
        System.out.println(result);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertTrue(allWrittenLines.contains("0"));
        assertTrue(allWrittenLines.contains("1"));
        assertTrue(allWrittenLines.contains("10"));
    }
}
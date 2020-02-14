package ua.kpi.command.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.flyweight.TwoOperandRequest;
import ua.kpi.service.impl.CalculationServiceImpl;

class AddCommandTest {

    @InjectMocks
    private AddCommand underTest;
    @Mock
    private CalculationServiceImpl calculationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnAsExpected() {
        ComplexNumber expected = new ComplexNumber();
        when(calculationService.add(any(ComplexNumber.class), any(ComplexNumber.class)))
                .thenReturn(expected);
        ComplexNumber actual = underTest.execute(new TwoOperandRequest(new ComplexNumber(), new ComplexNumber()));
        assertEquals(expected, actual);
    }
}
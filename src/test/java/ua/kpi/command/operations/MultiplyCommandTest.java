package ua.kpi.command.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ua.kpi.entity.impl.ComplexNumber;
import ua.kpi.payload.TwoOperandRequest;
import ua.kpi.service.impl.CalculationServiceImpl;

class MultiplyCommandTest {

    @InjectMocks
    private MultiplyCommand underTest;
    @Mock
    private CalculationServiceImpl calculationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnAsExpected() {
        ComplexNumber expected = new ComplexNumber();
        when(calculationService.multiply(any(ComplexNumber.class), any(ComplexNumber.class)))
                .thenReturn(expected);
        ComplexNumber actual = underTest.execute(new TwoOperandRequest(new ComplexNumber(), new ComplexNumber()));
        verify(calculationService).multiply(any(ComplexNumber.class), any(ComplexNumber.class));
        assertEquals(expected, actual);
    }
}
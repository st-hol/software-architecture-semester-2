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
import ua.kpi.exception.CalculationException;
import ua.kpi.payload.SingleOperandRequest;
import ua.kpi.service.impl.CalculationServiceImpl;


class AbsCommandTest {

    @InjectMocks
    private AbsCommand underTest;
    @Mock
    private CalculationServiceImpl calculationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldReturnAsExpected() throws CalculationException {
        ComplexNumber expected = new ComplexNumber();
        when(calculationService.abs(any(ComplexNumber.class)))
                .thenReturn(expected);
        ComplexNumber actual = underTest.execute(new SingleOperandRequest(new ComplexNumber()));
        verify(calculationService).abs(any(ComplexNumber.class));
        assertEquals(expected, actual);
    }

}
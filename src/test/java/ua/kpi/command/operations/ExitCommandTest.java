package ua.kpi.command.operations;

import static org.junit.jupiter.api.Assertions.assertNull;
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

class ExitCommandTest {

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
        when(calculationService.add(any(ComplexNumber.class), any(ComplexNumber.class)))
                .thenReturn(null);
        ComplexNumber actual = underTest.execute(new TwoOperandRequest(new ComplexNumber(), new ComplexNumber()));
        assertNull(actual);
    }
}
package ua.kpi.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TwoOperandsDto {
    private BigDecimal r1;
    private BigDecimal r2;
    private BigDecimal i1;
    private BigDecimal i2;
    private String actionTaken;
}

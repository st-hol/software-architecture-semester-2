package ua.kpi.domain;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ComplexNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal r;

    private BigDecimal i;

    @ManyToOne
    private CalculationRequest calculationRequest;

    @OneToOne(mappedBy = "complexNumber")
    private CalculationResult calculationResult;

    public ComplexNumber(BigDecimal r, BigDecimal i) {
        this.r = r;
        this.i = i;
    }
}

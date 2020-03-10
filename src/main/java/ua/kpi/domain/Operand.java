package ua.kpi.domain;


import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Operand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal r;

    private BigDecimal i;

    @ManyToOne
    private CalculationRequest calculationRequest;

    @OneToOne(cascade = CascadeType.ALL)
    private CalculationResult calculationResult;

}

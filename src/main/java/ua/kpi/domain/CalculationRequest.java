package ua.kpi.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import ua.kpi.type.ActionCode;

@Entity
@Setter
@Getter
public class CalculationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private ActionCode actionCode;

    @OneToMany(mappedBy = "calculationRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComplexNumber> complexNumbers;

    @OneToOne(mappedBy = "complexNumber")
    private CalculationResult calculationResult;
}

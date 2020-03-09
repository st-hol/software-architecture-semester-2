package ua.kpi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Setter
@Getter
public class CalculationResult {

    @OneToOne(mappedBy = "calculationResult")
    protected UserActionHistory userActionHistory;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String value;
}

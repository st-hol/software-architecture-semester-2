package ua.kpi.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "history")
public class UserActionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "userActionHistory")
    private CalculationResult calculationResult;

    @OneToMany(mappedBy = "userActionHistory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Operand> operands;
}

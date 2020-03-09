package ua.kpi.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Operand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String complexNumberValue;

    @ManyToOne
    private UserActionHistory userActionHistory;

}

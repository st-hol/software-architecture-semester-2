package ua.kpi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.kpi.domain.ComplexNumber;

@Repository
public interface OperandRepository extends CrudRepository<ComplexNumber, Long> {

}

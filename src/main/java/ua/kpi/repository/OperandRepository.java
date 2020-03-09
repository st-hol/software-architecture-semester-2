package ua.kpi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.domain.Operand;

@Repository
public interface OperandRepository extends CrudRepository<Operand, Long> {

}

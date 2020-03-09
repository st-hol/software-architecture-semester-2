package ua.kpi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.domain.CalculationResult;

@Repository
public interface CalculationResultRepository extends CrudRepository<CalculationResult, Long> {

}

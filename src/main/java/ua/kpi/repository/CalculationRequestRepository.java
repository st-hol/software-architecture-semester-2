package ua.kpi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.kpi.domain.CalculationRequest;

@Repository
public interface CalculationRequestRepository extends CrudRepository<CalculationRequest, Long> {

}

package ua.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import ua.kpi.domain.CalculationRequest;
import ua.kpi.repository.CalculationRequestRepository;

@Service
public class CalculationRequestService {

    @Autowired
    private CalculationRequestRepository repository;

    public List<CalculationRequest> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public CalculationRequest findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CalculationRequest save(CalculationRequest calculationRequest) {
        return repository.save(calculationRequest);
    }

}

package ua.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import ua.kpi.domain.CalculationResult;
import ua.kpi.repository.CalculationResultRepository;

@Service
public class CalculationResultService {

    @Autowired
    private CalculationResultRepository repository;

    public List<CalculationResult> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public CalculationResult findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CalculationResult save(CalculationResult calculationResult) {
        return repository.save(calculationResult);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

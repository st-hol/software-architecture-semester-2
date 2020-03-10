package ua.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import ua.kpi.domain.ComplexNumber;
import ua.kpi.repository.ComplexNumberRepository;

@Service
public class ComplexNumberService {
    @Autowired
    private ComplexNumberRepository repository;

    public List<ComplexNumber> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public ComplexNumber findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ComplexNumber save(ComplexNumber complexNumber) {
        return repository.save(complexNumber);
    }

}

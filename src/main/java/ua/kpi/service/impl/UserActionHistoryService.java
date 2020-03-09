package ua.kpi.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.domain.UserActionHistory;
import ua.kpi.repository.UserActionHistoryRepository;

import java.util.List;

@Service
public class UserActionHistoryService {

    @Autowired
    private UserActionHistoryRepository repository;

    public List<UserActionHistory> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public UserActionHistory findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserActionHistory save(UserActionHistory userActionHistory) {
        return repository.save(userActionHistory);
    }

}

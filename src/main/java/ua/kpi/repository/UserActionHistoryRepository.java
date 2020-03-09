package ua.kpi.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.domain.UserActionHistory;

@Repository
public interface UserActionHistoryRepository extends CrudRepository<UserActionHistory, Long> {

}

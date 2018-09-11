package com.blackswan.codetest.repo;

import com.blackswan.codetest.domain.Task;
import com.blackswan.codetest.domain.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


/**
 * @author Mark Andrews
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("select t from Task t where t.id = :taskid and t.user = :user")
    Optional<Task> findUserTask(@Param("taskid")Long taskId, @Param("user")User user);
}

package com.todoapp.repository;

import com.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    @Modifying
    @Query(nativeQuery=true, value="DELETE FROM TODO WHERE TODOID = ?1")
    public void deleteByTodoId(Long todoId);
}

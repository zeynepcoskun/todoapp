package com.todoapp.repository;

import com.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;

/**
 * 
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select user from User user where user.id not in (Select t.id from Todo t)")
    List<User> getUsersNoTodo();
    
    @Modifying
    @Query(nativeQuery=true, value="DELETE FROM USER WHERE ID = ?1")
    public void deleteById(Long id);
}

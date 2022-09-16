package com.indir.heroku.app.domain.repository;

import com.indir.heroku.app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "Select * from users", nativeQuery = true)
    List<User> findAllUsers();
}

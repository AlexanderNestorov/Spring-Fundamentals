package com.example.examprep15_10.repository.user;

import com.example.examprep15_10.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM User u ORDER BY size(u.orders) DESC")
    List<User> findAllByOrderByOrdersDescending();

}

package com.nuketree3.example.springhw2.repositories;

import com.nuketree3.example.springhw2.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT name FROM role WHERE id = :id", nativeQuery = true)
    String getUserRole(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO role (id, name) VALUES (:id, :role) ", nativeQuery = true)
    void setRole(@Param("id") long id, @Param("role") String role);
}

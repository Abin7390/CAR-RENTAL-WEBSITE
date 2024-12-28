package com.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carRental.entity.login;

@Repository
public interface loginRepository extends JpaRepository<login, Long> {
    login findByUsernameAndPassword(String username, String password);
}

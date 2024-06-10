package com.test.testdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.testdocker.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

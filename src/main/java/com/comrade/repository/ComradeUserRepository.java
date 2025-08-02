package com.comrade.repository;

import com.comrade.entity.ComradeUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComradeUserRepository extends JpaRepository<ComradeUserEntity,Long> {
    Optional<ComradeUserEntity> findByUsername(String username);
}

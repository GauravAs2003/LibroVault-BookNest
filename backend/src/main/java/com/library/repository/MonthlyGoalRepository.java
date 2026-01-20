package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.MonthlyGoal;

public interface MonthlyGoalRepository extends JpaRepository<MonthlyGoal, Long> {

	Optional<MonthlyGoal> findByUserId(Long userId);
}

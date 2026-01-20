package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.MonthlyGoal;
import com.library.repository.MonthlyGoalRepository;

@Service
public class MonthlyGoalService {

	@Autowired
	private MonthlyGoalRepository goalRepository;

	// get goal
	public MonthlyGoal getGoal(Long userId) {
		return goalRepository.findByUserId(userId).orElse(new MonthlyGoal(userId, 5)); // default goal
	}

	// save/update goal
	public MonthlyGoal saveGoal(Long userId, int goalBooks) {

		MonthlyGoal goal = goalRepository.findByUserId(userId).orElse(new MonthlyGoal(userId, goalBooks));

		goal.setGoalBooks(goalBooks);
		return goalRepository.save(goal);
	}
}

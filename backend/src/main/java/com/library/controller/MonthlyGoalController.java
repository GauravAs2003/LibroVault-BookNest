
package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.MonthlyGoal;
import com.library.service.MonthlyGoalService;

@RestController
@RequestMapping("/api/goal")
@CrossOrigin(origins = "http://localhost:3000")
public class MonthlyGoalController {

	@Autowired
	private MonthlyGoalService goalService;

	@GetMapping
	public MonthlyGoal getGoal(@RequestHeader("X-USER-ID") Long userId) {
		return goalService.getGoal(userId);
	}

	@PostMapping
	public MonthlyGoal saveGoal(@RequestHeader("X-USER-ID") Long userId, @RequestParam int goalBooks) {
		return goalService.saveGoal(userId, goalBooks);
	}
}

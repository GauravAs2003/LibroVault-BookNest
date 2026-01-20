package com.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "monthly_goals")
public class MonthlyGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	private int goalBooks; // e.g. 5

	// constructors
	public MonthlyGoal() {
	}

	public MonthlyGoal(Long userId, int goalBooks) {
		this.userId = userId;
		this.goalBooks = goalBooks;
	}

	// getters & setters
	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getGoalBooks() {
		return goalBooks;
	}

	public void setGoalBooks(int goalBooks) {
		this.goalBooks = goalBooks;
	}
}

package com.example.gunesscheduler.Entity;

public enum Day {
	Mon(0),
	Tue(1),
	Wed(2),
	Thu(3),
	Fri(4),
	Sat(5),
	Sun(6);

	private int value;

	private Day(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name();
	}
}

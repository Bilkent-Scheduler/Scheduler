package com.example.gunesscheduler.Entity;

public class Date {

	public Day day;
	public int start_time;
	public int end_time;
	public String place;

	public Date() {
	}

	public Date(Day day, int start_time, int end_time, String place) {
		this.day = day;
		this.start_time = start_time;  //hour format: 10.30 -> 600+30=630 , 8.30 -> 480+30=510 (minutes since midnight)
		this.end_time = end_time;
		this.place = place;
	}

	@Override
	public String toString() {
		return "Date{" +
				"day=" + day +
				", start_time=" + start_time +
				", end_time=" + end_time +
				", place='" + place + '\'' +
				'}';
	}

	//	public Day day;
//	public String hour;

	//public int startHour;
	//public int endHour;
}

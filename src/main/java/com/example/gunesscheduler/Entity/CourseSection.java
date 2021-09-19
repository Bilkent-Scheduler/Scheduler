package com.example.gunesscheduler.Entity;

import java.util.ArrayList;

public class CourseSection {
	public int no;
	public String instructor;
	public ArrayList<Date> hours;
	
	public CourseSection() {
		no = 0;
		instructor = "";
		hours = new ArrayList<Date>();
	}

	@Override
	public String toString() {
		return "CourseSection{" +
				"no=" + no +
				", instructor='" + instructor + '\'' +
				", hours=" + hours +
				'}';
	}

	//	public void print() {
//		System.out.print("Section " + no + " By " + instructor);
//		for(int i = 0; i < hours.size(); i++)
//			System.out.print(" " + hours.get(i).day + hours.get(i).startHour + "-" + hours.get(i).endHour + "\n");
//	}
}
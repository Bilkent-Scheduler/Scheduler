package com.example.gunesscheduler.Entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Course{
	public int no;
	public ArrayList<CourseSection> sections;
	public String name;
	public String depCode;
	
	public Course() {
		sections = new ArrayList<CourseSection>();
	}

	public Course(int no, ArrayList<CourseSection> sections, String name) {
		this.no = no;
		this.sections = sections;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course{" +
				"no=" + no +
				", sections=" + sections +
				", name='" + name + '\'' +
				'}';
	}
}

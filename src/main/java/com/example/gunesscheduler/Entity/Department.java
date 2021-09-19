package com.example.gunesscheduler.Entity;

import java.util.ArrayList;

public class Department {
    public String code;
    public ArrayList<Course> courses;
    public String dept_name;
    public String faculty_name;

    public Department(){
        code = "";
        dept_name = "";
        faculty_name = "";
        courses = new ArrayList<Course>();
    }

    public Department(String code, ArrayList<Course> courses, String dept_name, String faculty_name) {
        this.code = code;
        this.courses = courses;
        this.dept_name = dept_name;
        this.faculty_name = faculty_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "code='" + code + '\'' +
                ", courses=" + courses +
                ", dept_name='" + dept_name + '\'' +
                ", faculty_name='" + faculty_name + '\'' +
                '}';
    }


    public Course findByNo(String courseNo) {
        for(Course c: courses){
            if(c.no == Integer.parseInt(courseNo)){
                return c;
            }
        }
        return null;
    }

    public void assignDepCodeToCourses(){
        for(Course c : courses)
            c.depCode = code;
    }
}

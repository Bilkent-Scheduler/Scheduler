package com.example.gunesscheduler.Entity;

import java.util.ArrayList;

public class DepartmentList {
    public ArrayList<Department> depts;
    public String pull_time;

    public Department get(int index){
        return depts.get(index);
    }

    public Department findByCode(String code){
        for(Department dep: depts){
            if(dep.code.equals(code))
                return dep;
        }
        return null;
    }

    public void assingDepCodeToCourses(){
        for(Department dep : depts)
            dep.assignDepCodeToCourses();
    }
}

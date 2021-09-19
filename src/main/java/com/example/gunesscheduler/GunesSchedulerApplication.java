package com.example.gunesscheduler;

import com.example.gunesscheduler.Entity.Course;
import com.example.gunesscheduler.Entity.Department;
import com.example.gunesscheduler.Entity.DepartmentList;
import com.example.gunesscheduler.Entity.ScheduleFinder;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class GunesSchedulerApplication {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DepartmentList depList = objectMapper.readValue(new File("/Users/gunesustunalp/IdeaProjects/Gunes-Scheduler/src/main/resources/ScheduleData/data.json"), DepartmentList.class);
        depList.assingDepCodeToCourses();

        ArrayList<Course> wantedCourses = new ArrayList<Course>();

        Scanner in = new Scanner(System.in);

        System.out.println("Enter department then no");
        do{
            String depCode = in.next();
            if(depCode.equals(("END")))
                break;
            String courseNo = in.next();


            Course wanted = depList.findByCode(depCode).findByNo(courseNo);
            wantedCourses.add(wanted);
        }while(true);

        ScheduleFinder finder = new ScheduleFinder(wantedCourses);
        finder.createPossibleSchedulesArr();
        finder.print();


//        TxtReader reader = new TxtReader();
//        ScheduleFinder finder = new ScheduleFinder();
//        finder.createPossibleSchedulesArr();
//        finder.print();
        //SpringApplication.run(GunesSchedulerApplication.class, args);
    }

}

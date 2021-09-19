package com.example.gunesscheduler.Entity;

import java.util.ArrayList;

public class ScheduleFinder {
	ArrayList<String> possibleSchedules = new ArrayList<>();

	ArrayList<Course> wantedCourses;

	public ScheduleFinder(ArrayList<Course> wantedCourses) {
		this.wantedCourses = wantedCourses;
	}

	public void createPossibleSchedulesArr() {
		for(int i = 0; i < wantedCourses.get(0).sections.size(); i++) { //for all sections of the first class
			int[][] time = new int[7][1440]; //for every day, every minute
			
			for(int j = 0; j < wantedCourses.get(0).sections.get(i).hours.size(); j++) { //to mark times of the first class as occupied
				int day = wantedCourses.get(0).sections.get(i).hours.get(j).day.getValue();
				
				for(int k = wantedCourses.get(0).sections.get(i).hours.get(j).start_time;
					k < wantedCourses.get(0).sections.get(i).hours.get(j).end_time; k++) {
					time[day][k] = 1;
				}
			}
			
			findPossibilitiesRec( 1, wantedCourses.get(0).depCode + " " + wantedCourses.get(0).no + "-" + wantedCourses.get(0).sections.get(i).no + " ", time);
			}
		System.out.println("Finished");
		}
	
	private void findPossibilitiesRec( int classIndex, String currentPossibility, int[][] time) {
		if( classIndex == wantedCourses.size()) {
			possibleSchedules.add(currentPossibility);
			return;
		}
		
		for(int i = 0; i < wantedCourses.get(classIndex).sections.size(); i++) { //for all sections of the this class
			//System.out.println("Checking " + wantedCourses.get(classIndex).no + "-" + wantedCourses.get(classIndex).sections.get(i).no);
			int[][] newPossibleTime = new int[7][1440];
			for( int a = 0; a < 7; a++) {
				for( int b = 0; b < 1440; b++)
					newPossibleTime[a][b] = time[a][b];
			}
			
			boolean valid = true; //true if this section is possible for the current schedule
			
			for(int j = 0; j < wantedCourses.get(classIndex).sections.get(i).hours.size(); j++) { //to mark times of the this class as occupied
				int day = wantedCourses.get(classIndex).sections.get(i).hours.get(j).day.getValue();
				
				for(int k = wantedCourses.get(classIndex).sections.get(i).hours.get(j).start_time;
					k < wantedCourses.get(classIndex).sections.get(i).hours.get(j).end_time; k++) {
					
					if(time[day][k] != 0) { //checks if the time is already occupied
						valid = false;
						//System.out.println("Rejected! " + wantedCourses.get(classIndex).name + "-" +wantedCourses.get(classIndex).sections.get(i).sectionNo);
					}
					newPossibleTime[day][k] = classIndex + 1;
				}
			}
			
			String newStr = currentPossibility + wantedCourses.get(classIndex).depCode + " " + wantedCourses.get(classIndex).no + "-" + wantedCourses.get(classIndex).sections.get(i).no + " ";
			
			if(valid)
				findPossibilitiesRec( classIndex + 1, newStr , newPossibleTime);
			//else
				//System.out.println("Not Valid!");
			
			}			
		}
		
		public void print() {
			for( String str : possibleSchedules)
				System.out.println("Possible schedule: " + str);
		}
	}

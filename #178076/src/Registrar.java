import java.util.ArrayList;

public class Registrar {
	private ArrayList<CourseSchedule> schedules = new ArrayList<>();
	
	
	public ArrayList<CourseSchedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(ArrayList<CourseSchedule> schedules) {
		this.schedules = schedules;
	}

	public void register(CourseSchedule schedule) {
		schedules.add(schedule);
	}

	public void deRegister(String scheduleName) {
		
		int counter = 0;
		boolean find = false;
		
		do {
			if (schedules.get(counter).getCourseScheduleName().equals(scheduleName)) {
				schedules.remove(counter);
				find = true;
			}
			counter++;
		}while (!find || counter > schedules.size());
	}

	public void display() {
		System.out.println("########## REGISTRATION SUMMARY ##########");
		for (int i = 0; i < schedules.size(); i++) {
			schedules.get(i).display();
		}
	}

}

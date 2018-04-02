public class Test {
  public static void main(String[] args) {
    // Build Annie's schedule
    CourseSchedule annieSchedule = new CourseSchedule("Annie Atom");
    
    annieSchedule.add(new Course("CS 100", "Prof, Smith"));
    annieSchedule.add(new Course("ANTHRO 10", "Prof. Jones"));
    annieSchedule.add(new Course("MATH 125", "Prof. Aardvark"));
    
    annieSchedule.display();

    // Build Myra's schedule
    CourseSchedule myraSchedule = new CourseSchedule("Myra Moore");
    myraSchedule.add(new Course("CS 233", "Prof, Jensen"));
    myraSchedule.add(new Course("CS 234", "Prof. Thomas"));    
    
    myraSchedule.display();
    
    // Build Zach's schedule
    CourseSchedule zachSchedule = new CourseSchedule("Zach Zween");
    
    zachSchedule.add(new Course("PSYCH 140", "Prof, Arnold"));
    zachSchedule.add(new Course("ANTHRO 10", "Prof. Jones"));
    zachSchedule.add(new Course("FRENCH 1", "Prof. Renior"));
    
    zachSchedule.display();
    
    // Register all of them
    Registrar r = new Registrar();
    
    r.register(annieSchedule);
    r.register(myraSchedule);
    r.register(zachSchedule);

    // EXTRA CREDIT (1 pt)
    r.deRegister("Myra Moore");
    
    r.display();    
  }
}

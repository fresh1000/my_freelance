package DecoratorEmployee;

public class Recruiter extends ResponsibilityDecorator {


	public Recruiter(Employee employee) {
		super(employee);
	}
	//return employee
	public String getDescription() {
		return employee.getDescription() + "Recruiter";
	}
}

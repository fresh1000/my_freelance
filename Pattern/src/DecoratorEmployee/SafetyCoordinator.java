package DecoratorEmployee;

public class SafetyCoordinator extends ResponsibilityDecorator {
	

	public SafetyCoordinator(Employee employee) {
		super(employee);
	}
	//return employee
	public String getDescription() {
		return employee.getDescription() + "SafetyCoordinator";
	}
	
}

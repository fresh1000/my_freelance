package DecoratorEmployee;

public class Manager extends ResponsibilityDecorator{

	public Manager(Employee employee) {
		super(employee);
	}
	//return employee
	public String getDescription() {
		return employee.getDescription() + "Manager";
	}

}

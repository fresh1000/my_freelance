package DecoratorEmployee;

public class DepartmentHead extends ResponsibilityDecorator{

	public DepartmentHead(Employee employee) {
		super(employee);
	}
	//return employee
	public String getDescription() {
		return employee.getDescription() + "DepartmentHead";
	}
}

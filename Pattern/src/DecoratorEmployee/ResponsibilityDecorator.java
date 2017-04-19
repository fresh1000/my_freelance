package DecoratorEmployee;

public abstract class ResponsibilityDecorator extends Employee{
	Employee employee;//object type Employee
	
	//get employee in constructor
	public ResponsibilityDecorator(Employee employee) {
		this.employee = employee;
	}
	public abstract String getDescription();
	
}

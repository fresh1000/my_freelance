package DecoratorEmployee;

public class ProductionDesigner extends ResponsibilityDecorator{

	public ProductionDesigner(Employee employee) {
		super(employee);
	}
	//return employee
	public String getDescription() {
		return employee.getDescription() + "ProductionDesigner";
	}

}

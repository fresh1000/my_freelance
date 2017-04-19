package DecoratorEmployee;

public class CommunityLiason extends ResponsibilityDecorator{
	public CommunityLiason(Employee employee) {
		super(employee);
	}
	//return employee
	public String getDescription() {
		return employee.getDescription() + "CommunityLiason";
	}
}

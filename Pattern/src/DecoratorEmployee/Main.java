package DecoratorEmployee;

public class Main {

	public static void main(String[] args) {
		
		Employee employee1 = new DepartmentHead((new SalariedEmployee()));//create DepartmentHead employee
		Employee employee2 = new Manager(new SalariedEmployee());//create Manager employee
		Employee employee3 = new ProductionDesigner((new SalariedEmployee()));//create ProductionDesigner employee
		System.out.println(employee1.lastName +": " + employee1.getDescription() + " ," + employee2.getDescription() +" ,"+ employee3.getDescription());

	}

}

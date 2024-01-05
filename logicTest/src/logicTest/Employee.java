package logicTest;
import java.util.List;

public class Employee {
	String name;
	List<TimePunch> timePunches;
	
	
	//Nest timePunches inside of the employee
	
	public Employee(String name, List<TimePunch> timePunches) {
		this.name = name;
		this.timePunches = timePunches;
	}

}

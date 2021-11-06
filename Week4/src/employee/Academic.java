package employee;

public class Academic {
	private int id;
	final int baseMonthlySalary = 500;
	
	Academic(int id){
		this.id = id;
	}
	int CalculateMonthlySalary() {
		return baseMonthlySalary;
	}
	
	int getEmployeeID() {
		return this.id;
	}
}

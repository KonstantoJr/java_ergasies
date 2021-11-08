package employee;

public class Academic extends Employee{
	private int id;
	final int baseMonthlySalary = 500;
	
	Academic(int id){
		this.id = id;
	}
	int CalculateMonthlySalary() {
		return baseMonthlySalary;
	}
	
	public int getEmployeeID() {
		return this.id;
	}
	public void printInfo() {
		
	}
}

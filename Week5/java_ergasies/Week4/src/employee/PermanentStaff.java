package employee;
import enumerations.Bathmida;
import randomize.Randomize;

public class PermanentStaff extends Academic{
	Bathmida rank;
	private int monthlySlary;
	public PermanentStaff(int id){
		super(id);
		this.rank = Randomize.Bathmida();
	}
	@Override
	public int CalculateMonthlySalary() {
		int onTopSalary = 0;
		if (this.rank == Bathmida.Lecturer) onTopSalary = 1000;
		if (this.rank == Bathmida.Assistant) onTopSalary = 1200;
		if (this.rank == Bathmida.Associate) onTopSalary = 1400;
		if (this.rank == Bathmida.Professor) onTopSalary = 1500;
		this.monthlySlary = baseMonthlySalary + onTopSalary;
		return this.monthlySlary;
	} 
	public Bathmida getBatmida() {
		return this.rank;
	}
	public void printInfo() {
		System.out.println("");
		System.out.println("EmployeeID:"+super.getEmployeeID()+" is permanent. ");
		System.out.println("Academic rank:"+this.rank);
		System.out.println("Monthly based employye salary: "+this.monthlySlary);
	}
}

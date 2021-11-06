package employee;
import enumerations.WorkingExperience;
import randomize.Randomize;

public class HourlyStaff extends Academic{
	WorkingExperience experience;
	int workedhours;
	int monthlySlary;
	
	public HourlyStaff(int  id){
		super(id);
		this.experience = Randomize.WorkingExperience();
	}
	@Override
	public int CalculateMonthlySalary() {
		int hourlypay = 0;
		if (this.experience == WorkingExperience.uptoFiveYears) hourlypay =10;
		if (this.experience == WorkingExperience.FiveToTenYears) hourlypay =20;
		if (this.experience == WorkingExperience.morethanTenYears) hourlypay =30; 
		this.monthlySlary = baseMonthlySalary + this.workedhours * hourlypay;
		return this.monthlySlary;
	}
	public void printInfo() {
		System.out.println("");
		System.out.println("EmployeeID:"+super.getEmployeeID()+" is permanent. ");
		System.out.println("Work Experience: "+this.experience);
		System.out.println("Hourly based employye salary: "+this.monthlySlary);
	}
}

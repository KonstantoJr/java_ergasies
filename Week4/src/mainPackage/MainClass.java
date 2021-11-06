package mainPackage;
import employee.*;
import enumerations.*;
import randomize.Randomize;
public class MainClass {
	public static void main(String [] args) {
		System.out.println("Projet Week 4");
		createRandomizedEmployees(100);
		
	}
	
	public static void createRandomizedEmployees(int k) {
		System.out.println("Creating "+ k + " Randomized Employess");
		for (int i = 1 ; i<=k ; i++) {
			StaffType staff = Randomize.Staff();
			if (staff == StaffType.Permanent){
				PermanentStaff pstaff = new PermanentStaff(i);
				pstaff.CalculateMonthlySalary();
				pstaff.printInfo();	
			}
			if (staff == StaffType.HourlyBased){
				HourlyStaff pstaff = new HourlyStaff(i);
				pstaff.CalculateMonthlySalary();
				pstaff.printInfo();	
			}
		}
	}
}

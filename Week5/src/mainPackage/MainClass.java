package mainPackage;
import employee.*;
import enumerations.*;
import randomize.Randomize;
public class MainClass {
	public static void main(String [] args) {
		System.out.println("Projet Week 5");
		int nOf = 100000;
		createRandomizedEmployees(nOf);
		int searchemployeeID =  50000;
		System.out.println("\n Search with Linked List for Employee with id "+ searchemployeeID);
		Employee x = Employee.search_with_LinkedList(searchemployeeID);
		if (x!=null) x.printInfo();
		
		System.out.println("\n Search with Hash Map for Employee with id "+ searchemployeeID);
		x = Employee.search_with_HashMap(searchemployeeID);
		if (x!=null) x.printInfo();
	}
	
	public static void createRandomizedEmployees(int k) {
		System.out.println("Creating "+ k + " Randomized Employess");
		for (int i = 1 ; i<=k ; i++) {
			StaffType staff = Randomize.Staff();
			if (staff == StaffType.Permanent){
				PermanentStaff pstaff = new PermanentStaff(i);
				pstaff.CalculateMonthlySalary();
				Employee.addEmployeeNode((Employee) pstaff);
			}
			if (staff == StaffType.HourlyBased){
				HourlyStaff pstaff = new HourlyStaff(i);
				pstaff.CalculateMonthlySalary();
				Employee.addEmployeeNode((Employee) pstaff);
			}
		}
		System.out.println("Finished Randomized Employees");
	}
}

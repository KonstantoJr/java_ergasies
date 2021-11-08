package employee;
import java.util.HashMap;
import java.util.LinkedList;

abstract public class Employee {
	static private LinkedList<Employee> linkedlist = new LinkedList<Employee>();
	static private HashMap<Integer , Employee> hashmaplist = new HashMap<Integer , Employee>();
	
	abstract public void printInfo();
	abstract public int getEmployeeID();
	public static void addEmployeeNode (Employee x) {
		linkedlist.add(x);
		hashmaplist.put(x.getEmployeeID(),x);
	}
	
	public static Employee search_with_HashMap(int id) {
		long startTime , endTime;
		Employee tmp = null;
		startTime = System.nanoTime();
		tmp = hashmaplist.getOrDefault(id, null);
		endTime = System.nanoTime();
		if (tmp!=null) {
			System.out.println("Time to find Employee with id: "+id+", using HashMap was: "
		+(endTime-startTime)/Math.pow(10,9)+" Seconds.");	
		}
		else {
			System.out.println("Employee with id: "+ id + " does not exist in HashMap\n"+
		"Time to complete search was: "+ (endTime - startTime)/Math.pow(10, 9)+" Seconds");
		}
		return tmp;
	}
	public static Employee search_with_LinkedList(int id) {
		long startTime, endTime;
		Employee tmp = null;
		startTime = System.nanoTime();
		for(int i = 0 ; i<linkedlist.size() ; i++) {
			if (linkedlist.get(i).getEmployeeID() == id) {
				tmp = linkedlist.get(i);
				endTime = System.nanoTime();
				System.out.println("Time to find Employee with id: "+id+", using LinkedList was: "
				+(endTime-startTime)/Math.pow(10,9)+" Seconds.");
				break;
			}
		}
		if (tmp == null) {
			endTime = System.nanoTime();
			System.out.println("Employee with id: "+ id + " does not exist in LinkedList\n"+
					"Time to complete search was: "+ (endTime-startTime)/Math.pow(10,9)+" Seconds.");
		}
		return tmp;
	}
	
}

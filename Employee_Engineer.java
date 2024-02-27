class Employee{
	public void display(){
		System.out.println("Name of class is Employee!");
	}
	public void calcSalary(){
		System.out.println("The Salary of Employee is 10,000!");        
	}
}

class Engineer extends Employee{
	public void display(){
		super.display();
		System.out.println("Name of class is Engineer!");
	}
	public void calcSalary(){
		super.calcSalary();
		System.out.println("The Salary of Employee is 20,000!");        
	}
}

class Employee_Engineer{
	public static void main(String args[]){
		Engineer obj = new Engineer();
		obj.display();
		obj.calcSalary();
	}
}
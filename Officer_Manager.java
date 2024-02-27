class Employee{
	int age, salary;
	String name, address, phone_no;;
	public void print_salary(){
		System.out.println("The Salary for Employee: "+name+" = "+salary);
	}
}

class Officer extends Employee{
	String Specialization;
}

class Manager extends Employee{
	String Department;
}

class Officer_Manager{
	public static void main(String args[]){
		Officer obj_off = new Officer();
		Manager obj_man = new Manager();
        
		obj_off.name = "John";
		obj_off.age = 40;
		obj_off.address = "Kalamaserry, Ernakulam, Kerala";
		obj_off.salary = 25000;
		obj_off.phone_no = "9543097180";
		obj_off.Specialization = "Salesperson";
		
		obj_man.name = "George";
		obj_man.age = 50;
		obj_man.address = "Kakkanad, Ernakulam, Kerala";
		obj_man.salary = 40000;
		obj_man.phone_no = "7082334274";
		obj_man.Department = "Sales";
	
		System.out.println("Officer Details\n---------------\nName: "+obj_off.name+"\nAge: "+obj_off.age+"\nAddress: "+obj_off.address+"\nPhone Number: "+obj_off.phone_no+"\nSpecialization: "+obj_off.Specialization);
		obj_off.print_salary();
		System.out.println("\nManager Details\n---------------\nName: "+obj_man.name+"\nAge: "+obj_man.age+"\nAddress: "+obj_man.address+"\nPhone Number: "+obj_man.phone_no+"\nSpecialization: "+obj_man.Department);
		obj_man.print_salary();
    }
}
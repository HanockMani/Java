class Staff {
	int code;
	String name;
}

class Faculty extends Staff{
	String department, subject_taken, research_area;
}

class Typist extends Staff{
	String office, speed;
}

class Officer extends Staff{
	String rank;
	char grade;
} 

class Permanent extends Typist{
	int salary;
}

class Casual extends Typist{
	int daily_wages;
}

class Staff_Details{
	public static void main(String args[]){
		Casual  cas = new Casual();
		Permanent per = new Permanent();
		Faculty fac = new Faculty();
		Officer off = new Officer();
	
		cas.code = 1001;
		cas.name = "John";
		cas.office = "A-25";
		cas.speed = "40 wpm";
		cas.daily_wages = 300;  
	
		per.code = 1002;
		per.name = "David";     
		per.office = "A-30";
		per.speed = "45 wpm";
		per.salary = 6000;

		fac.code = 2001;
		fac.name = "Jane";    
		fac.department = "Computer Science and Engineering";
		fac.subject_taken = "Artificial Intelligence";
		fac.research_area = "Machine Learning";
	
		off.code = 3001;
		off.name = "Alen";
		off.rank = "Manager";
		off.grade = 'B';

		System.out.println("Staff Details\n-------------");
		System.out.println("\nCode: "+cas.code+"\nName: "+cas.name+"\nOffice: "+cas.office+"\nTyprewriting speed: "+cas.speed+"\nDaily Wage: "+cas.daily_wages);
		System.out.println("\nCode: "+per.code+"\nName: "+per.name+"\nOffice: "+per.office+"\nTyprewriting speed: "+per.speed+"\nSalary: "+per.salary);
		System.out.println("\nCode: "+fac.code+"\nName: "+fac.name+"\nDepartment: "+fac.department+"\nSubject taken: "+fac.subject_taken+"\nResearch area: "+fac.research_area);
		System.out.println("\nCode: "+off.code+"\nName: "+off.name+"\nRank: "+off.rank+"\nGrade: "+off.grade);
	}
}
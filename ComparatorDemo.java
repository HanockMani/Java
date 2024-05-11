import java.util.*;

class Student{
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

}

public class ComparatorDemo {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();

        Comparator<Student> comp =(i,j) -> i.age>j.age?1:-1;
        
        // Comparator<Student> comp = new Comparator<Student>(){
        //     public int compare(Student i, Student j){
        //         if(i.age > j.age)
        //             return 1;
        //         else 
        //             return -1;
        //     }
        // };

        students.add(new Student(22, "Alen"));
        students.add(new Student(20, "Sam"));
        students.add(new Student(23, "Jake"));
        students.add(new Student(21, "Bob"));

        Collections.sort(students, comp);

        for (Student student : students) {
            System.out.println(student.name +": "+ student.age);
        }
    }
}

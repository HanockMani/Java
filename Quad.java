import java.io.*;
import java.util.*;
import java.lang.*;

class Quadratic{
	double a, b, c, disc, root1, root2;
	public void read(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a quadratic eqaution:");
		System.out.print("\nEnter the coefficient of x^2(cannot be zero!): ");
		a = s.nextDouble();
		System.out.print("Enter the coefficient of x: ");
		b = s.nextDouble();
		System.out.print("Enter the constant: ");
		c = s.nextDouble();
	}
	public void root(){
		disc = b*b-(4*a*c);
		if(disc>0){
			root1 = (-b + Math.sqrt(disc))/(2*a);
			root2 = (-b - Math.sqrt(disc))/(2*a);
			System.out.println("The roots of the quadratic equation are "+root1+" and "+root2);
		}
		else if(disc==0){
			root1 = -b/(2*a);
			System.out.println("The quadratic equation have only one root:  "+root1);
		}
		else{
			System.out.println("The quadratic equation doesnt have any roots!");
		}
	}
}

class Quad{
	public static void main(String args[]){
		Quadratic obj = new Quadratic();
		obj.read();
		obj.root();
	}
}
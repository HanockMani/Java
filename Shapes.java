class Circle {
	private double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	public double calculateArea() {
		return Math.PI * radius * radius;
	}
}

class Rectangle {
	private double length;
	private double width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	public double calculateArea() {
		return length * width;
	}
}

class Trapezoid {
	private double base1;
	private double base2;
	private double height;
	public Trapezoid(double base1, double base2, double height) {
		this.base1 = base1;
		this.base2 = base2;
		this.height = height;
	}
	public double calculateArea() {
		return 0.5 * (base1 + base2) * height;
	}
}

class Triangle {
	private double base;
	private double height;
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	public double calculateArea() {
		return 0.5 * base * height;
	}
}

class Shapes {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		Rectangle rectangle = new Rectangle(4, 6);
		Trapezoid trapezoid = new Trapezoid(3, 6, 4);
		Triangle triangle = new Triangle(4, 5);
		System.out.println("Area of Circle: " + circle.calculateArea());
		System.out.println("Area of Rectangle: " + rectangle.calculateArea());
		System.out.println("Area of Trapezoid: " + trapezoid.calculateArea());
		System.out.println("Area of Triangle: " + triangle.calculateArea());
	}
}
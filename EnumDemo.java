enum Fruits{
    Mango(101, 150), Apple(102, 250), Orange(103, 100), Pineapple(104, 100), Grape(105, 175);
    
    private int code;
    private int price;

    private Fruits(int code, int price){
        this.code = code;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }
    
}

public class EnumDemo {
    public static void main(String[] args) {
        Fruits[] fruit = Fruits.values();
        for (Fruits f : fruit) {
            System.out.println(f.getCode()+"\t: "+f+"\t: "+f.getPrice());
        }

        Fruits currentFruit = Fruits.Orange;

        switch (currentFruit) {
            case Apple: System.out.println("Current fruit is Apple");
                break;
            case Mango: System.out.println("Current fruit is Mango");
                break;
            case Orange: System.out.println("Current fruit is Orange");
                break;
            case Pineapple: System.out.println("Current fruit is Pineapple");
                break;
            case Grape: System.out.println("Current fruit is Grape");
                break;
            default:
                break;
        }
    }
}

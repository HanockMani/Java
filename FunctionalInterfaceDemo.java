@FunctionalInterface
interface FIDemo1{
    void run1();
}

@FunctionalInterface
interface FIDemo2{
    void run2(int i);
}

@FunctionalInterface
interface FIDemo3{
    int run3(int i, int j);
}

class FunctionalInterfaceDemo{
    public static void main(String[] args) {
        FIDemo1 obj1 = () -> System.out.println("In Demo 1!");
        FIDemo2 obj2 = (i) -> System.out.println("In Demo 2: "+i+"!");
        FIDemo3 obj3 =(i,j) -> i+j;
        
        obj1.run1();
        obj2.run2(4);
        int result = obj3.run3(5,10);
        System.out.println("In Demo 3: "+result+"!");
    }
}
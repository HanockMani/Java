class Types{
    public static void main(String args[]){

        //Type Conversion...
        int a=10;
        float b = a;
        System.out.println(a+" "+b);

        //Type Casting...
        float d=20.7f;
        int c = (int)d;
        System.out.println(d+" "+c);

        //Type Promotion...
        byte e =10, f=30;
        int g = e*f;
        System.out.println(g);
    }
}
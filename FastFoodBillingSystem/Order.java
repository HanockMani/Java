public class Order {
    
    private int code, quantity;
    private double price;
    private String name;

    public Order(int code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getCode()+": "+getName()+" x "+getQuantity()+" = "+getPrice()*getQuantity()+"$";             
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

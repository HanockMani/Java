enum Menu {
    
    SINGLE_BURGER(101, "Single Burger", 4.00), 
    DOUBLE_BURGER(102, "Double Burger", 5.00), 
    SINGLE_CHEESEBURGER(103, "Single Cheese Burger", 4.50), 
    DOUBLE_CHEESEBURGER(104, "Double Cheese Burger", 5.50), 
    VEGGIE_BURGER(105, "Veggie Burger", 4.00), 
    VEGAN_BURGER(106, "Vegan Burger", 4.50), 
    ORIGINAL_FRIES(201, "Original Fries", 3.00), 
    CHEESE_FRIES(202, "Cheese Fries", 4.00), 
    BACON_FRIES(203, "Bacon Fries", 4.50), 
    BACON_AND_CHEESE_FRIES(204, "Bacon and Cheese Fries", 5.00),
    ORIGINAL_LEMONADE(301, "Original Lemonade", 2.00), 
    SEASONAL_LEMONADE(302, "Seasonal Lemonade", 2.50), 
    FOUNTAIN_SODA(303, "Fountain Soda", 1.75);

    private final int code;
    private final double price;
    private final String name;

    Menu(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return getCode()+": "+getName()+" = "+getPrice()+"$";             
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

}
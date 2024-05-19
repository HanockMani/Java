public class MenuOrderOperations {

    public static Menu getItem(int code){
        for(Menu item : Menu.values()){
            if(item.getCode() == code)
                return item;
        }
        return null;
    }

    public static void getMenu(){
        System.out.println("\nMENU\n=====================================");
        for(Menu item : Menu.values()){
            System.out.println(item.toString());
        }
        System.out.println("------------------------------------");
    }

    public static void updateQuantity(Order item, int quantity){
        item.setQuantity(item.getQuantity()+quantity);
    }
    
}
import java.util.ArrayList;
import java.util.List;

public class OrderList {
    List<Order> orderList;

    public OrderList() {
        orderList = new ArrayList<>();
    }

    public void addItem(int code, int quantity){
        Menu itemToAdd = MenuOrderOperations.getItem(code);
        for (Order item : orderList) {
            if(itemToAdd.getCode() == item.getCode()){
                MenuOrderOperations.updateQuantity(item, quantity);;
                return;
            }
        }
        Order newItem = new Order(itemToAdd.getCode(), itemToAdd.getName(), itemToAdd.getPrice(), quantity);
        orderList.add(newItem);
    }

    public void removeItem(int code){
        Menu itemToRemove = MenuOrderOperations.getItem(code);
        if(orderList.size()==1 && itemToRemove.getCode() == orderList.getFirst().getCode())
            removeAllItems();
        for (Order item : orderList) {
            if(itemToRemove.getCode() == item.getCode()){
                orderList.remove(orderList.indexOf(item));
                return;
            }
        }
    }

    public void removeAllItems(){
        orderList.clear();
    }

    public void yourOrder(){
        if(orderList.isEmpty()){
            System.out.println("No Items Selected!!");
            return;
        }
        else{
            System.out.println("\nYOUR ORDER\n=====================================");
            for (Order item : orderList) {
                System.out.println(item.toString());
            }
            System.out.println("------------------------------------");
        }
    }

}

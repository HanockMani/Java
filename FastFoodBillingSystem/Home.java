import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        OrderList customerOrder = new OrderList();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do{
            MenuOrderOperations.getMenu();
            customerOrder.yourOrder();
            System.out.print("\n[1. ADD ITEM]\t[2. REMOVE ITEM]\t[3. CLEAR ORDER]\t[4. PROCEED]\t[5. EXIT]\n\nEnter Choice: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1: addNewItem(customerOrder, scanner);
                        break;
                case 2: removeAnItem(customerOrder, scanner);
                        break;
                case 3: clearOrder(customerOrder, scanner);
                        break;
                case 4: cutomerOrderBill(customerOrder, scanner);
                        break;
                case 5: System.exit(0);
                default:System.out.println("Invalid Entry");
                        clearScreen();
                        break;
            }
        }
        while(choice != 0);
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    public static void addNewItem(OrderList customerOrder, Scanner scanner){
        char choice = 'y';
        while(choice == 'y'|| choice =='Y'){
            System.out.print("\nEnter Item and Quantity.\nItem(Code): ");
            int code = scanner.nextInt();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            customerOrder.addItem(code, quantity);
            System.out.println("\nPress 'Y' to add another item or press any other key and enter to continue...");
            choice = scanner.next().charAt(0);
        } 
        clearScreen();
    }

    public static void removeAnItem(OrderList customerOrder, Scanner scanner){
        char choice = 'y';
        while(choice == 'y'|| choice =='Y'){
            System.out.print("\nEnter Item to remove\nItem(Code): ");
            int code = scanner.nextInt();
            customerOrder.removeItem(code);
            System.out.println("\nPress 'Y' to remove another item or press any other key and enter to continue...");
            choice = scanner.next().charAt(0);
        }
        clearScreen();  
    }

    public static void clearOrder(OrderList customerOrder, Scanner scanner){
        System.out.println("Are you sure you want to clear your Order? Press 'Y' to continue or any other key to cancel!");
        char choice = scanner.next().charAt(0);
        if(choice == 'y' || choice == 'Y')
            customerOrder.removeAllItems();
        clearScreen();  
    }

    public static void cutomerOrderBill(OrderList customerOrder, Scanner scanner){
        double totalAmount=0 ,tax=0 , finalAmount=0;
        for (Order item : customerOrder.orderList) {
            totalAmount = totalAmount + item.getPrice();
        }
        tax = totalAmount * 0.05;
        finalAmount = totalAmount + tax;

        clearScreen();
        customerOrder.yourOrder();
        System.out.println("Bill Total = "+totalAmount+"$\nTax Amount(5%) = "+tax+"$\nPayable Amount = "+finalAmount+"$");

        System.out.println("\nProceed to Payment -> Y\nEdit Order -> E\nPress any other key and press enter to cancel order!");
        char choice = scanner.next().charAt(0);
        if(choice == 'y' || choice == 'Y'){
            System.out.println("\nProceeding.........");
            try {
                Thread.sleep(1800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Order Placed!\nThank you for ordering from us. Collect your Bill and please approach the counter.\n");
            System.exit(0);
        }
        else if(choice == 'e' || choice == 'E'){
            clearScreen();
            return;
        }
        else
            System.exit(0);
    }
}

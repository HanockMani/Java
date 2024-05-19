import java.sql.*;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Warehouse {
    private Connection connection;

    public Warehouse(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(String name, double price, int quantity) throws SQLException {
        String query = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, quantity);
            statement.executeUpdate();
            System.out.println("Product added successfully.");
        }
    }

    public void processOrder(String productName, int quantity) throws SQLException {
        Product product = getProduct(productName);
        if (product != null && product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            String query = "UPDATE products SET quantity = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, product.getQuantity());
                statement.setInt(2, product.getId());
                statement.executeUpdate();
                System.out.println("Order processed: " + quantity + " " + productName);
            }
        } else {
            System.out.println("Insufficient quantity of " + productName + " in stock.");
        }
    }

    public Product getProduct(String productName) throws SQLException {
        String query = "SELECT * FROM products WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                return new Product(id, productName, price, quantity);
            } else {
                return null;
            }
        }
    }

    public void displayProducts() throws SQLException {
        String query = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("Product ID\tProduct Name\tPrice\tQuantity");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                System.out.println(id + "\t\t" + name + "\t\t$" + price + "\t" + quantity);
            }
        }
    }
}

public class SupplyChainManagement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCM_db?characterEncoding=utf8", "root", "");

            Warehouse warehouse = new Warehouse(connection);
            Scanner scanner = new Scanner(System.in);

            // Supplier login
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Authenticate supplier
            boolean isAuthenticated = authenticateSupplier(connection, username, password);
            if (isAuthenticated) {
                boolean exit = false;
                while (!exit) {
                    // Menu options for authenticated suppliers
                    System.out.println("\nSupply Chain Management System");
                    System.out.println("1. Add Product");
                    System.out.println("2. Process Order");
                    System.out.println("3. View Products");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    switch (choice) {
                        case 1:
                            System.out.print("Enter product name: ");
                            String productName = scanner.nextLine();
                            System.out.print("Enter product price: ");
                            double price = scanner.nextDouble();
                            System.out.print("Enter product quantity: ");
                            int quantity = scanner.nextInt();
                            warehouse.addProduct(productName, price, quantity);
                            break;
                        case 2:
                            System.out.print("Enter product name: ");
                            String orderProductName = scanner.nextLine();
                            System.out.print("Enter quantity to order: ");
                            int orderQuantity = scanner.nextInt();
                            warehouse.processOrder(orderProductName, orderQuantity);
                            break;
                        case 3:
                            warehouse.displayProducts();
                            break;
                        case 4:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
            } else {
                System.out.println("Authentication failed. Exiting...");
            }

            connection.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to authenticate supplier
    private static boolean authenticateSupplier(Connection connection, String username, String password) throws SQLException {
        String query = "SELECT * FROM suppliers WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Return true if supplier exists
        }
    }
}
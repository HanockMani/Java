import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private Connection connection;

    public Warehouse(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(String name, double price, int quantity) throws SQLException {
        String query = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
            updateProductQuantity(product.getId(), product.getQuantity());
            System.out.println("Order processed: " + quantity + " " + productName);
        } else {
            System.out.println("Insufficient quantity of " + productName + " in stock.");
        }
    }

    private Product getProduct(String productName) throws SQLException {
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

    private void updateProductQuantity(int productId, int quantity) throws SQLException {
        String query = "UPDATE products SET quantity = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, quantity);
            statement.setInt(2, productId);
            statement.executeUpdate();
        }
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                Product product = new Product(id, name, price, quantity);
                products.add(product);
            }
        }
        return products;
    }
}

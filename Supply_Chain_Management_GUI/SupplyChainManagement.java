import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SupplyChainManagement {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Warehouse warehouse;

    public SupplyChainManagement() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Supply Chain Management System");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblUsername = new JLabel("Username:");
        loginPanel.add(lblUsername);

        usernameField = new JTextField();
        loginPanel.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        loginPanel.add(lblPassword);

        passwordField = new JPasswordField();
        loginPanel.add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        loginPanel.add(btnLogin);

        frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supplychainmanagement?characterEncoding=utf8", "root", "");
            warehouse = new Warehouse(connection);

            boolean isAuthenticated = authenticateSupplier(connection, username, password);
            if (isAuthenticated) {
                showMainMenu();
            } else {
                JOptionPane.showMessageDialog(frame, "Authentication failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error connecting to database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean authenticateSupplier(Connection connection, String username, String password) throws SQLException {
        String query = "SELECT * FROM suppliers WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Return true if supplier exists
        }
    }

    private void showMainMenu() {
        frame.getContentPane().removeAll();

        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(4, 1, 5, 5));

        JButton btnAddProduct = new JButton("Add Product");
        btnAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddProductDialog();
            }
        });
        mainMenuPanel.add(btnAddProduct);

        JButton btnProcessOrder = new JButton("Process Order");
        btnProcessOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showProcessOrderDialog();
            }
        });
        mainMenuPanel.add(btnProcessOrder);

        JButton btnViewProducts = new JButton("View Products");
        btnViewProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showProductList();
            }
        });
        mainMenuPanel.add(btnViewProducts);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainMenuPanel.add(btnExit);

        frame.getContentPane().add(mainMenuPanel, BorderLayout.CENTER);
        frame.revalidate();
    }

    private void showAddProductDialog() {
        String productName = JOptionPane.showInputDialog(frame, "Enter product name:");
        if (productName != null && !productName.isEmpty()) {
            try {
                double price = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter product price:"));
                int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter product quantity:"));
                warehouse.addProduct(productName, price, quantity);
                JOptionPane.showMessageDialog(frame, "Product added successfully.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error adding product.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showProcessOrderDialog() {
        String productName = JOptionPane.showInputDialog(frame, "Enter product name:");
        if (productName != null && !productName.isEmpty()) {
            try {
                int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter quantity to order:"));
                warehouse.processOrder(productName, quantity);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error processing order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showProductList() {
        try {
            StringBuilder productList = new StringBuilder();
            productList.append("Product ID\tProduct Name\tPrice\tQuantity\n");
            for (Product product : warehouse.getAllProducts()) {
                productList.append(product.getId()).append("\t\t").append(product.getName()).append("\t\t$").append(product.getPrice()).append("\t").append(product.getQuantity()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, new JScrollPane(new JTextArea(productList.toString())), "Product List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error retrieving product list.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){

        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SupplyChainManagement window = new SupplyChainManagement();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
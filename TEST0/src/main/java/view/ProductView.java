package view;

import controller.ProductController;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductView extends JFrame {
    private ProductController productController;
    private JTable productTable;
    private DefaultTableModel tableModel;

    public ProductView(ProductController productController) {
        this.productController = productController;
        setTitle("Product Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Bảng hiển thị danh sách sản phẩm
        String[] columnNames = {"ID", "Name", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);

        // Các nút chức năng
        JButton btnAdd = new JButton("Add Product");
        JButton btnUpdate = new JButton("Update Product");
        JButton btnDelete = new JButton("Delete Product");
        JButton btnRefresh = new JButton("Refresh");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        // Sự kiện cho nút "Add Product"
        btnAdd.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter product name:");
            String priceStr = JOptionPane.showInputDialog(this, "Enter product price:");
            String quantityStr = JOptionPane.showInputDialog(this, "Enter product quantity:");
            try {
                double price = Double.parseDouble(priceStr);
                int quantity = Integer.parseInt(quantityStr);
                Product product = new Product(name, price, quantity);
                productController.addProduct(product);
                loadProducts(); // Refresh bảng
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Sự kiện cho nút "Update Product"
        btnUpdate.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow >= 0) {
                int productId = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                String name = JOptionPane.showInputDialog(this, "Enter new product name:");
                String priceStr = JOptionPane.showInputDialog(this, "Enter new product price:");
                String quantityStr = JOptionPane.showInputDialog(this, "Enter new product quantity:");
                try {
                    double price = Double.parseDouble(priceStr);
                    int quantity = Integer.parseInt(quantityStr);
                    Product product = new Product(productId, name, price, quantity);
                    productController.updateProduct(product);
                    loadProducts(); // Refresh bảng
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a product to update.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Sự kiện cho nút "Delete Product"
        btnDelete.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow >= 0) {
                int productId = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                productController.deleteProduct(productId);
                loadProducts(); // Refresh bảng
            } else {
                JOptionPane.showMessageDialog(this, "Please select a product to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Sự kiện cho nút "Refresh"
        btnRefresh.addActionListener(e -> loadProducts());

        // Layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load sản phẩm vào bảng
        loadProducts();

        setVisible(true);
    }

    private void loadProducts() {
        tableModel.setRowCount(0); // Clear bảng
        List<Product> products = productController.getAllProducts();
        for (Product product : products) {
            tableModel.addRow(new Object[]{
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity()
            });
        }
    }
}

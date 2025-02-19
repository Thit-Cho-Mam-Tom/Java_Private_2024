package View;

import Controller.ProductController;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class ManageProductsView extends JFrame {
    private ProductController productController;
    private JTable productTable;
    private DefaultTableModel tableModel;

    private JTextField txtId, txtName, txtPrice, txtQuantity;
    private JButton btnAdd, btnUpdate, btnDelete, btnRefresh, btnBack;

    private ToggleMenu previousMenu; // Tham chiếu đến `ToggleMenu`

    public ManageProductsView(ToggleMenu previousMenu) {
        this.previousMenu = previousMenu; // Lưu tham chiếu đến `ToggleMenu`
        productController = new ProductController();
        initUI();
    }

    private void initUI() {
        setTitle("Quản lý sản phẩm");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel bảng
        JPanel tablePanel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"ID", "Tên", "Giá", "Số lượng"}, 0);
        productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Panel form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("ID:"));
        txtId = new JTextField();
        txtId.setEnabled(false);
        formPanel.add(txtId);

        formPanel.add(new JLabel("Tên:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Giá:"));
        txtPrice = new JTextField();
        formPanel.add(txtPrice);

        formPanel.add(new JLabel("Số lượng:"));
        txtQuantity = new JTextField();
        formPanel.add(txtQuantity);

        // Panel nút
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));

        btnAdd = new JButton("Thêm");
        btnUpdate = new JButton("Cập nhật");
        btnDelete = new JButton("Xóa");
        btnRefresh = new JButton("Làm mới");
        btnBack = new JButton("Trở lại");
        // Thiết lập màu sắc cho các nút
        Color buttonColor = new Color(255, 209, 0); // Màu vàng
        Color textColor = Color.BLACK; // Màu đen

        btnAdd.setBackground(buttonColor);
        btnAdd.setForeground(textColor);
        btnUpdate.setBackground(buttonColor);
        btnUpdate.setForeground(textColor);
        btnDelete.setBackground(buttonColor);
        btnDelete.setForeground(textColor);
        btnRefresh.setBackground(buttonColor);
        btnRefresh.setForeground(textColor);
        btnBack.setBackground(buttonColor);
        btnBack.setForeground(textColor);

        buttonPanel.add(btnBack);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        buttonPanel.add(btnBack);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        // Thêm các panel vào frame chính
        add(tablePanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Tải dữ liệu vào bảng
        loadProducts();

        // Hành động cho các nút
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProduct();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProduct();
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProducts();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousMenu.setVisible(true);
                dispose();
            }
        });

        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && productTable.getSelectedRow() != -1) {
                int selectedRow = productTable.getSelectedRow();
                txtId.setText(tableModel.getValueAt(selectedRow, 0).toString());
                txtName.setText(tableModel.getValueAt(selectedRow, 1).toString());
                txtPrice.setText(tableModel.getValueAt(selectedRow, 2).toString());
                txtQuantity.setText(tableModel.getValueAt(selectedRow, 3).toString());
            }
        });

        setVisible(true);
    }

    private void loadProducts() {
        tableModel.setRowCount(0);
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

    private void addProduct() {
        String name = txtName.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal price;
        int quantity;
        try {
            price = new BigDecimal(txtPrice.getText());
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ cho giá hoặc số lượng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        productController.addProduct(product);
        JOptionPane.showMessageDialog(this, "Sản phẩm đã được thêm thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        loadProducts();
    }

    private void updateProduct() {
        int id;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String name = txtName.getText();
        BigDecimal price;
        int quantity;
        try {
            price = new BigDecimal(txtPrice.getText());
            quantity = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        productController.updateProduct(product);
        JOptionPane.showMessageDialog(this, "Sản phẩm đã được cập nhật thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        loadProducts();
    }

    private void deleteProduct() {
        int id;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = productController.getProductById(id);
        if (product == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            productController.deleteProduct(id);
            JOptionPane.showMessageDialog(this, "Sản phẩm đã được xóa thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            loadProducts();
        }
    }
}

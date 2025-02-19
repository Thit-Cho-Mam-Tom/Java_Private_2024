package View;

import Controller.CustomerController;
import Model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerView extends JFrame {
    private CustomerController customerController;
    private JTable customerTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, emailField, addressField, phoneField, searchField;
    private JButton addButton, updateButton, deleteButton, backButton, searchButton, refreshButton;
    private ToggleMenu mainMenu;
    private Label txtName,txtEmail,txtPhone,txtAddress;

    public CustomerView(ToggleMenu mainMenu) {
        this.mainMenu = mainMenu;
        customerController = new CustomerController();

        setTitle("Quản lý Khách hàng");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        String[] columnNames = {"ID", "Tên", "Số điện thoại", "Email", "Địa chỉ"};
        tableModel = new DefaultTableModel(columnNames, 0);
        customerTable = new JTable(tableModel);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(customerTable), BorderLayout.CENTER);

        // Tạo panel chứa form
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Dịch các trường nhập sang trái một chút
        gbc.anchor = GridBagConstraints.WEST;

        // Tạo các trường nhập
        nameField = createTextField(formPanel, "Tên:", gbc, 0);
        phoneField = createTextField(formPanel, "Số điện thoại:", gbc, 1);
        emailField = createTextField(formPanel, "Email:", gbc, 2);
        addressField = createTextField(formPanel, "Địa chỉ:", gbc, 3);

        // Đặt panel chứa các nút dưới cùng
        setupFormPanel(formPanel, gbc);

        panel.add(formPanel, BorderLayout.SOUTH);

        // Tạo panel tìm kiếm
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Tìm kiếm căn trái
        searchField = new JTextField(20);
        searchButton = new JButton("Tìm kiếm");
        searchPanel.add(new JLabel("Tìm theo tên:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel, BorderLayout.NORTH);

        Color buttonColor = new Color(255, 209, 0);

        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.BLACK);

        updateButton.setBackground(buttonColor);
        updateButton.setForeground(Color.BLACK);

        deleteButton.setBackground(buttonColor);
        deleteButton.setForeground(Color.BLACK);

        backButton.setBackground(buttonColor);
        backButton.setForeground(Color.BLACK);

        refreshButton.setBackground(buttonColor);
        refreshButton.setForeground(Color.BLACK);

        searchButton.setBackground(buttonColor);
        searchButton.setForeground(Color.BLACK);

        // Action listeners
        addButton.addActionListener(e -> addCustomer());
        updateButton.addActionListener(e -> updateCustomer());
        deleteButton.addActionListener(e -> deleteCustomer());
        backButton.addActionListener(e -> {
            dispose();
            mainMenu.setVisible(true);
        });
        searchButton.addActionListener(e -> searchCustomer());
        refreshButton.addActionListener(e -> refreshCustomerData());  // Action for Refresh button
        customerTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Kiểm tra nếu có dòng nào được chọn trong bảng
                int selectedRow = customerTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Lấy thông tin khách hàng từ bảng
                    int customerId = (int) customerTable.getValueAt(selectedRow, 0);  // Lấy ID từ cột đầu tiên
                    String name = (String) customerTable.getValueAt(selectedRow, 1);   // Lấy tên từ cột thứ 2
                    String phone = (String) customerTable.getValueAt(selectedRow, 2);  // Lấy số điện thoại từ cột thứ 3
                    String email = (String) customerTable.getValueAt(selectedRow, 3);  // Lấy email từ cột thứ 4
                    String address = (String) customerTable.getValueAt(selectedRow, 4); // Lấy địa chỉ từ cột thứ 5

                    // Cập nhật thông tin vào các trường nhập liệu
                    nameField.setText(name);
                    phoneField.setText(phone);
                    emailField.setText(email);
                    addressField.setText(address);
                }
            }
        });

        loadCustomerData();
        setVisible(true);
    }


    // Phương thức tạo trường nhập liệu
    private JTextField createTextField(JPanel formPanel, String labelText, GridBagConstraints gbc, int row) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(label, gbc);
        gbc.gridx = 1;
        formPanel.add(textField, gbc);
        return textField;
    }

    // Phương thức thêm panel chứa các nút vào dưới cùng
    private void setupFormPanel(JPanel formPanel, GridBagConstraints gbc) {
        // Panel chứa các nút dưới cùng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));  // Cân đối các nút
        addButton = new JButton("Thêm");
        updateButton = new JButton("Cập nhật");
        deleteButton = new JButton("Xóa");
        backButton = new JButton("Quay lại");
        refreshButton = new JButton("Làm mới");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);
        buttonPanel.add(refreshButton);

        // Đặt panel nút vào formPanel
        gbc.gridx = 0;
        gbc.gridy = 4; // Row của nút
        gbc.gridwidth = 2; // Chiếm 2 cột
        formPanel.add(buttonPanel, gbc);
    }

    // Hàm tải dữ liệu khách hàng từ controller
    private void loadCustomerData() {
        List<Customer> customers = customerController.getAllCustomers();
        tableModel.setRowCount(0);
        for (Customer customer : customers) {
            tableModel.addRow(new Object[]{customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail(), customer.getAddress()});
        }
    }

    // Thêm khách hàng mới
    private void addCustomer() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String address = addressField.getText();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Customer newCustomer = new Customer(name, phone, email, address);
        customerController.createCustomer(newCustomer);
        JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        loadCustomerData();
    }

    private void updateCustomer() {
        // Lấy thông tin từ các trường nhập liệu
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        // Kiểm tra nếu tên trống
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy ID của khách hàng đã chọn từ bảng
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để cập nhật!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int customerId = (int) customerTable.getValueAt(selectedRow, 0);

        // Tìm khách hàng theo ID trước khi cập nhật
        Customer customerToUpdate = customerController.findCustomerById(customerId);
        if (customerToUpdate == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng để cập nhật!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cập nhật thông tin cho đối tượng khách hàng
        customerToUpdate.setName(name);
        customerToUpdate.setEmail(email);
        customerToUpdate.setPhone(phone);
        customerToUpdate.setAddress(address);

        // Gọi phương thức updateCustomer của controller để cập nhật vào cơ sở dữ liệu
        customerController.updateCustomer(customerToUpdate);

        // Hiển thị thông báo thành công
        JOptionPane.showMessageDialog(this, "Khách hàng đã được cập nhật thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

        // Tải lại danh sách khách hàng
        loadCustomerData();
    }


    // Xóa khách hàng
    private void deleteCustomer() {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chọn khách hàng cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int customerId = (int) customerTable.getValueAt(selectedRow, 0);
        customerController.deleteCustomer(customerId);
        JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        loadCustomerData();
    }

    // Tìm kiếm khách hàng theo tên
    private void searchCustomer() {
        String searchName = searchField.getText().trim();
        List<Customer> customers = customerController.findCustomersByName(searchName);
        tableModel.setRowCount(0);
        for (Customer customer : customers) {
            tableModel.addRow(new Object[]{customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail(), customer.getAddress()});
        }
    }

    // Làm mới dữ liệu khách hàng
    private void refreshCustomerData() {
        loadCustomerData();  // Simply reload the customer data
    }

    // Kiểm tra email hợp lệ
    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailPattern, email);
    }
}

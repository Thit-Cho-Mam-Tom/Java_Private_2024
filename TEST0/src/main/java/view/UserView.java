package view;

import controller.UserController;
import Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserView extends JFrame {
    private UserController userController;
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserView(UserController userController) {
        this.userController = userController;

        setTitle("User Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Bảng hiển thị danh sách người dùng
        String[] columns = {"Username", "Full Name", "Role"};
        tableModel = new DefaultTableModel(columns, 0);
        userTable = new JTable(tableModel);
        loadUserTable();

        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        // Nút thêm, sửa, xóa
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add User");
        JButton btnEdit = new JButton("Edit User");
        JButton btnDelete = new JButton("Delete User");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        // Sự kiện nút
        btnAdd.addActionListener(e -> addUser());
        btnEdit.addActionListener(e -> editUser());
        btnDelete.addActionListener(e -> deleteUser());

        setLocationRelativeTo(null);
        setVisible(true);
    }



    private void addUser() {
        String username = JOptionPane.showInputDialog(this, "Enter Username:");
        if (username != null && !username.isEmpty()) {
            String fullName = JOptionPane.showInputDialog(this, "Enter Full Name:");
            String role = JOptionPane.showInputDialog(this, "Enter Role (ADMIN/USER):");
            User user = new User(username, "default123", fullName, User.Role.valueOf(role.toUpperCase()));
            userController.addUser(user);
            loadUserTable();
        }
    }

    private void editUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow != -1) {
            String username = (String) tableModel.getValueAt(selectedRow, 0);
            String fullName = JOptionPane.showInputDialog(this, "Enter new Full Name:", tableModel.getValueAt(selectedRow, 1));
            String role = JOptionPane.showInputDialog(this, "Enter new Role (ADMIN/USER):", tableModel.getValueAt(selectedRow, 2));

            User user = userController.findUserByUsername(username);
            if (user != null) {
                user.setFullName(fullName);
                user.setRole(User.Role.valueOf(role.toUpperCase()));
                userController.updateUser(user);
                loadUserTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user to edit.");
        }
    }

    private void deleteUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow != -1) {
            String username = (String) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?");
            if (confirm == JOptionPane.YES_OPTION) {
                userController.deleteUser(username);
                loadUserTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
        }
    }
}

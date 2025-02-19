package View;

import Model.User;
import controller.UserController;

import javax.swing.*;

public class RegisterView extends JFrame {
    private UserController userController;

    public RegisterView(UserController userController) {
        this.userController = userController;

        setTitle("Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 100, 30);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 50, 150, 30);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 100, 30);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 100, 150, 30);
        add(txtPassword);

        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(50, 150, 100, 30);
        add(lblFullName);

        JTextField txtFullName = new JTextField();
        txtFullName.setBounds(150, 150, 150, 30);
        add(txtFullName);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(150, 200, 100, 30);
        btnRegister.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String fullName = txtFullName.getText();

            if (!username.isEmpty() && !password.isEmpty() && !fullName.isEmpty()) {
                userController.saveUser(new User(username, password, fullName, User.Role.USER));
                JOptionPane.showMessageDialog(this, "Registration successful!");
                new LoginView(userController);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            }
        });
        add(btnRegister);

        setVisible(true);
    }
}

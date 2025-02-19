package View;

import javax.swing.*;

public class AdminView extends JFrame {

    public AdminView() {
        setTitle("Admin Page");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblWelcome = new JLabel("Welcome Admin!");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(lblWelcome.getFont().deriveFont(24.0f));

        add(lblWelcome);
        setVisible(true);
    }
}

package View;

import Controller.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToggleMenu extends JFrame {

    private JPanel menuPanel, infoPanel;
    private JButton toggleButton;
    private JLabel closeLabel, adminNameLabel, clockLabel, revenueLabel;
    private Timer timer;
    private int menuPosition = -200;
    private boolean isMenuOpen = false;

    public ToggleMenu() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        // Panel chứa các thông tin admin
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1));
        infoPanel.setBounds(450, 10, 330, 80);


        AdminController adminController = new AdminController();

        // Nhãn hiển thị tên Admin
        adminNameLabel = new JLabel("Admin: " + adminController.getAdminName(), SwingConstants.CENTER);
        adminNameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Nhãn hiển thị đồng hồ
        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        updateClock();

        // Nhãn hiển thị doanh thu
        revenueLabel = new JLabel("Doanh thu: " + adminController.getMonthlyRevenue() + " VND | Đơn hàng: " + adminController.getOrderCount(), SwingConstants.CENTER);
        revenueLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        infoPanel.add(adminNameLabel);
        infoPanel.add(clockLabel);
        infoPanel.add(revenueLabel);

        add(infoPanel);

        // Tạo menu
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(255, 209, 0));
        menuPanel.setBounds(menuPosition, 0, 200, getHeight());
        menuPanel.setLayout(null);


        JButton qldh = new JButton("Quản lý Đơn hàng");
        qldh.setBounds(10, 60, 180, 55);
        qldh.setBackground(new Color(34, 34, 34));
        qldh.setForeground(Color.WHITE);

        JButton qlsp = new JButton("Quản lý Sản phẩm");
        qlsp.setBounds(10, 160, 180, 55);
        qlsp.setBackground(new Color(34, 34, 34));
        qlsp.setForeground(Color.WHITE);

        JButton qlkh = new JButton("Quản lý Khách hàng");
        qlkh.setBounds(10, 260, 180, 55);
        qlkh.setBackground(new Color(34, 34, 34));
        qlkh.setForeground(Color.WHITE);

        JButton ctdh = new JButton("Quản lý đơn hàng chi tiết");
        ctdh.setBounds(10, 360, 180, 55);
        ctdh.setBackground(new Color(34, 34, 34));
        ctdh.setForeground(Color.WHITE);

        JButton caidat = new JButton("Cài đặt hệ thống");
        caidat.setBounds(10, 460, 180, 55);
        caidat.setBackground(new Color(34, 34, 34));
        caidat.setForeground(Color.WHITE);

        closeLabel = new JLabel("X");
        closeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        closeLabel.setBounds(160, 10, 30, 30);
        closeLabel.setForeground(Color.RED);
        closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        closeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                closeMenu();
            }
        });


        menuPanel.add(qldh);
        menuPanel.add(qlsp);
        menuPanel.add(qlkh);
        menuPanel.add(ctdh);
        menuPanel.add(caidat);
        menuPanel.add(closeLabel);

        add(menuPanel);

        // Nút Toggle Menu
        toggleButton = new JButton("Menu chính");
        toggleButton.setBounds(0, 0, 200, 55);
        toggleButton.setBackground(new Color(255, 209, 0));
        toggleButton.setForeground(Color.BLACK);
        toggleButton.addActionListener(e -> toggleMenu());
        add(toggleButton);

        JPanel welcomePanel = new JPanel();
        welcomePanel.setBounds(150, 130, 500, 120);
        welcomePanel.setLayout(new GridLayout(2, 1));

        JLabel welcomeLabel = new JLabel("Chào mừng bạn đến với", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(new Color(255, 174, 0));

        JLabel storeLabel = new JLabel("APPLE STORE!", SwingConstants.CENTER);
        storeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        storeLabel.setForeground(new Color(255, 174, 0)); 

        welcomePanel.add(welcomeLabel);
        welcomePanel.add(storeLabel);

        add(welcomePanel);



        qlkh.addActionListener(e -> CustomerView());
        ctdh.addActionListener(e -> ManageOrderDetailsView());
        qlsp.addActionListener(e -> openManageProductsView());
        qldh.addActionListener(e -> openManageOrdersView());
        caidat.addActionListener(e -> openManageSetting());

        setVisible(true);
    }

    private void updateClock() {
        Timer clockTimer = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            clockLabel.setText(sdf.format(new Date()));
        });
        clockTimer.start();
    }

    private void ManageOrderDetailsView() {
        new ManageOrderDetailView();
    }

    private void openManageProductsView() {
        new ManageProductsView(this);
        this.dispose();
    }

    private void openManageOrdersView() {
        this.setVisible(false);
        new ManageOrdersView(this);
    }

    private void CustomerView() {
        new CustomerView(this);
        this.dispose();
    }

    private void openManageSetting() {
        AdminController adminController = new AdminController();
        SettingsView settingsView = new SettingsView(adminController);
        settingsView.setVisible(true);
    }

    private void toggleMenu() {
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isMenuOpen) {
                    if (menuPosition > -200) {
                        menuPosition -= 5;
                        menuPanel.setBounds(menuPosition, 0, 200, getHeight());
                    } else {
                        timer.stop();
                        isMenuOpen = false;
                        toggleButton.setVisible(true);
                    }
                } else {
                    if (menuPosition < 0) {
                        menuPosition += 5;
                        menuPanel.setBounds(menuPosition, 0, 200, getHeight());
                    } else {
                        timer.stop();
                        isMenuOpen = true;
                        toggleButton.setVisible(false);
                    }
                }
            }
        });
        timer.start();
    }

    private void closeMenu() {
        if (isMenuOpen) {
            toggleMenu();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToggleMenu());
    }
}

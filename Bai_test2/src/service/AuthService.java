package service;

import java.util.Scanner;

public interface AuthService {
    public void login(Scanner scanner);
    public void logout();
    public void changePassword(String username, String oldPassword, String newPassword);
    public boolean checkAdmin();
}

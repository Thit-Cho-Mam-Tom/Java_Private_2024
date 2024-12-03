package Service;

import java.util.Scanner;

public interface Iuser {
    public void login(Scanner sc);
    public void logout();
    public boolean checkAdmin();
}

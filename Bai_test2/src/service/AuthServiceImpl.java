package service;

import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AuthServiceImpl implements AuthService {

        ArrayList<Account> userlist = new ArrayList<>();
        private Account currenltUser;

        public AuthServiceImpl() {
            currenltUser = null;
            userlist.add(new Account("admin", "admin123", "ADMIN"));
            userlist.add(new Account("user1", "password1", "USER"));
            userlist.add(new Account("user2", "password2", "USER"));
        }
    @Override
    public void login(Scanner scanner) {
        System.out.println("nhập tên đăng nhập: ");
        String userName =scanner.nextLine();
        System.out.println("nhập mật khẩu");
        String passWord = scanner.nextLine();
    }


    @Override
    public void logout() {
        if(currenltUser != null){
            System.out.println("đăng xuất thành công !");
            currenltUser =null;
        }
        else{
            System.out.println("không có ai đăng nhập !");
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        if (currenltUser == null || !currenltUser.getUsername().equals(username)) {
            System.out.println("Bạn cần đăng nhập để đổi mật khẩu.");
            return;
        }

        if (!currenltUser.getPassword().equals(oldPassword)) {
            System.out.println("Mật khẩu cũ không chính xác.");
            return;
        }

        currenltUser.setPassword(newPassword);
        System.out.println("Đổi mật khẩu thành công!");
    }

    public boolean checkAdmin(){
            return currenltUser != null && currenltUser.getRole().equals("ADMIN");
    }
}

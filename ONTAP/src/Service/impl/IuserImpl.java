package Service.impl;

import Model.User;
import Service.Iuser;

import java.util.ArrayList;
import java.util.Scanner;

public class IuserImpl implements Iuser {
    ArrayList<User> userlist = new ArrayList<>();
    private User currenltUser;

    public IuserImpl() {
        currenltUser = null;
    }

    @Override
    public void login(Scanner sc) {
        System.out.println("nhập tên đăng nhập: ");
        String userName =sc.nextLine();
        System.out.println("nhập mật khẩu");
        String passWord = sc.nextLine();
    }

    @Override
    public void logout() {
        if(currenltUser != null){
            System.out.println("đăng xuất thành công !");
            currenltUser=null;
        }
        else{
            System.out.println("không có ai đăng nhập !");
        }
    }

    @Override
    public boolean checkAdmin() {
        return currenltUser != null && currenltUser.getRole().equals("ADMIN");
    }
}

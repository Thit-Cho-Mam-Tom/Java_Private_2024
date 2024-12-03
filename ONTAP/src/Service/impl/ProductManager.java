package Service.impl;

import Model.Product;
import Model.User;
import Service.IProductManager;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager implements IProductManager {
    ArrayList<Product> P = new ArrayList<>();


    @Override
    public boolean add(Product product) {
        P.add(product);
        return true;
    }

    @Override
    public void display() {
  for(Product x: P){
     x.display();
  }
    }

    @Override
    public void search(String name) {
    for(Product x:P){
        if(x.getName().equalsIgnoreCase(name)){
            x.display();
            return;
        }
    }
    }

    @Override
    public boolean delete(String id) {
        for(Product x : P){
            if(x.getId().equals(id))
            {
                P.remove(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(String id) {
        for (Product x : P) {
            if (x.getId().equalsIgnoreCase(id)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("nhập tên");
                String name = sc.nextLine();
                System.out.println("nhập giá");
                Double price = sc.nextDouble();
                sc.nextLine();
                System.out.println("nhập số lượng");
                int quatity = sc.nextInt();
                sc.nextLine();
            }
        }
        return true;
    }
}

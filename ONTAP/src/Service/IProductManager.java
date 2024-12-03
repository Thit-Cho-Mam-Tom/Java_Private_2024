package Service;

import Model.Product;
import Model.User;

public interface IProductManager {
    public boolean add(Product product);
    public void display();
    public void search(String name);
    public boolean delete(String id);
    public boolean update(String id);
}

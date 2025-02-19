package Service;

import DAO.CartDAO;
import Model.Cart;
import java.util.List;

public class CartService {

    private CartDAO cartDAO = new CartDAO();

    // Save Cart
    public void saveCart(Cart cart) {
        cartDAO.save(cart);
    }

    // Get Cart by ID
    public Cart getCartById(int id) {
        return cartDAO.getById(id);
    }

    // Update Cart
    public void updateCart(Cart cart) {
        cartDAO.update(cart);
    }

    // Delete Cart by ID
    public void deleteCart(int cartId) {
        cartDAO.delete(cartId);
    }


}

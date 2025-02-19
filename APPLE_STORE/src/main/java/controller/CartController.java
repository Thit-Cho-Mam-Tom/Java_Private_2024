package controller;

import Service.CartService;
import Model.Cart;
import java.util.List;

public class CartController {

    private CartService cartService = new CartService();

    // Lưu giỏ hàng
    public void saveCart(Cart cart) {
        cartService.saveCart(cart);
    }

    // Lấy giỏ hàng theo ID
    public Cart getCartById(int id) {
        return cartService.getCartById(id);
    }

    // Cập nhật giỏ hàng
    public void updateCart(Cart cart) {
        cartService.updateCart(cart);
    }

    // Xóa giỏ hàng
    public void deleteCart(int id) {
        cartService.deleteCart(id);
    }
}

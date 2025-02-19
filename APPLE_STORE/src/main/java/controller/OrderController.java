package controller;

import Service.OrderService;
import Model.Order;
import java.util.List;

public class OrderController {

    private OrderService orderService = new OrderService();

    // Lưu đơn hàng
    public void saveOrder(Order order) {
        orderService.saveOrder(order);
    }

    // Lấy đơn hàng theo ID
    public Order getOrderById(int id) {
        return orderService.getOrderById(id);
    }

    // Lấy tất cả đơn hàng
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Cập nhật đơn hàng
    public void updateOrder(Order order) {
        orderService.updateOrder(order);
    }

    // Xóa đơn hàng
    public void deleteOrder(int id) {
        orderService.deleteOrder(id);
    }
}

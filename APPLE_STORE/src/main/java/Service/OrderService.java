package Service;

import DAO.OrderDAO;
import Model.Order;
import java.util.List;

public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();

    // Lưu đơn hàng
    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    // Lấy đơn hàng theo orderId
    public Order getOrderById(int orderId) {
        return orderDAO.getById(orderId);
    }

    // Lấy tất cả đơn hàng
    public List<Order> getAllOrders() {
        return orderDAO.getAll();
    }

    // Cập nhật trạng thái đơn hàng
    public void updateOrder(Order order) {
        orderDAO.update(order);
    }

    // Xóa đơn hàng theo orderId
    public void deleteOrder(int orderId) {
        orderDAO.delete(orderId);
    }
}

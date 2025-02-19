package Service;

import DAO.OrderDetailDAO;
import Model.OrderDetail;
import java.util.List;

public class OrderDetailService {

    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    // Lưu chi tiết đơn hàng
    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.save(orderDetail);
    }

    // Lấy chi tiết đơn hàng theo ID
    public OrderDetail getOrderDetailById(int id) {
        return orderDetailDAO.getById(id);
    }


    // Cập nhật chi tiết đơn hàng
    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.update(orderDetail);
    }

    // Xóa chi tiết đơn hàng theo ID
    public void deleteOrderDetail(int id) {
        orderDetailDAO.delete(id);
    }
}

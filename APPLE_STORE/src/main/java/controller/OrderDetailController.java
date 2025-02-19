package controller;

import Service.OrderDetailService;
import Model.OrderDetail;
import java.util.List;

public class OrderDetailController {

    private OrderDetailService orderDetailService = new OrderDetailService();

    // Lưu chi tiết đơn hàng
    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailService.saveOrderDetail(orderDetail);
    }

    // Lấy chi tiết đơn hàng theo ID
    public OrderDetail getOrderDetailById(int id) {
        return orderDetailService.getOrderDetailById(id);
    }

    // Cập nhật chi tiết đơn hàng
    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailService.updateOrderDetail(orderDetail);
    }

    // Xóa chi tiết đơn hàng
    public void deleteOrderDetail(int id) {
        orderDetailService.deleteOrderDetail(id);
    }
}

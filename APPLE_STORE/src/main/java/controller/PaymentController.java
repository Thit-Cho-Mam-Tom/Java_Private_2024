package controller;

import Service.PaymentService;
import Model.Payment;
import java.util.List;

public class PaymentController {

    private PaymentService paymentService = new PaymentService();

    // Lưu thanh toán
    public void savePayment(Payment payment) {
        paymentService.savePayment(payment);
    }

    // Lấy thanh toán theo ID
    public Payment getPaymentById(int id) {
        return paymentService.getPaymentById(id);
    }


    // Cập nhật thanh toán
    public void updatePayment(Payment payment) {
        paymentService.updatePayment(payment);
    }

    // Xóa thanh toán
    public void deletePayment(int id) {
        paymentService.deletePayment(id);
    }
}

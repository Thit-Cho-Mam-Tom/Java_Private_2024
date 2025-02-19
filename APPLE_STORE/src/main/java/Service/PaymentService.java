package Service;

import DAO.PaymentDAO;
import Model.Payment;
import java.util.List;

public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();

    // Lưu thanh toán
    public void savePayment(Payment payment) {
        paymentDAO.save(payment);
    }

    // Lấy thanh toán theo paymentId
    public Payment getPaymentById(int paymentId) {
        return paymentDAO.getById(paymentId);
    }

    // Cập nhật thanh toán
    public void updatePayment(Payment payment) {
        paymentDAO.update(payment);
    }

    // Xóa thanh toán theo paymentId
    public void deletePayment(int paymentId) {
        paymentDAO.delete(paymentId);
    }
}

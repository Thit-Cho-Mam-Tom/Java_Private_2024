package Service;

import DAO.CustomerDAO;
import Model.Customer;
import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    // Lưu khách hàng
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    // Lấy khách hàng theo id
    public Customer getCustomerByEmail(int email) {
        return customerDAO.getById(email);
    }

    // Cập nhật thông tin khách hàng
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    // Xóa khách hàng theo id
    public void deleteCustomer(int id) {
        customerDAO.delete(id);
    }
}

package controller;

import Service.CustomerService;
import Model.Customer;
import java.util.List;

public class CustomerController {

    private CustomerService customerService = new CustomerService();

    // Lưu khách hàng
    public void saveCustomer(Customer customer) {
        customerService.saveCustomer(customer);
    }

    // Lấy khách hàng theo email
    public Customer getCustomerByEmail(int email) {
        return customerService.getCustomerByEmail(email);
    }

    // Cập nhật khách hàng
    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    // Xóa khách hàng
    public void deleteCustomer(int id) {
        customerService.deleteCustomer(id);
    }
}

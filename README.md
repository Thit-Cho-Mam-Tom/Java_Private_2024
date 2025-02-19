## Quản lý Bán hàng Admin
### Mô tả chung:

Quản lý bán hàng Admin là hệ thống quản lý toàn bộ hoạt động bán hàng của doanh nghiệp thông qua các công cụ quản lý các khách hàng, đơn hàng, sản phẩm. Mục tiêu của Admin trong hệ thống quản lý bán hàng là đảm bảo quá trình bán hàng diễn ra suôn sẻ, tối ưu hóa các quy trình bán hàng và chăm sóc khách hàng. Admin có quyền kiểm soát toàn bộ hệ thống, từ việc theo dõi các đơn hàng cho đến quản lý thông tin khách hàng, sản phẩm.
Các chức năng chính của Quản lý Bán hàng Admin:

1.	Quản lý Tài khoản Admin:
- Tạo, chỉnh sửa và xóa tài khoản Admin.
- Phân quyền người dùng giữa Admin và nhân viên.
- Đảm bảo bảo mật và quản lý thông tin đăng nhập của người dùng.  
2.	Quản lý Khách hàng:
- Tạo mới, sửa đổi và xóa thông tin khách hàng.
- Xem danh sách khách hàng, thông tin liên hệ, lịch sử giao dịch.
- Cập nhật thông tin khách hàng khi cần thiết (chẳng hạn như thay đổi địa chỉ giao hàng, số điện thoại).  
3.	Quản lý Sản phẩm:
- Thêm, sửa đổi, xóa thông tin sản phẩm (tên, giá, số lượng tồn kho).
- Cập nhật thông tin sản phẩm khi có sự thay đổi (giảm giá, thay đổi giá trị sản phẩm, cập nhật số lượng).  
- Kiểm tra mức tồn kho và thống kê doanh thu liên quan đến sản phẩm.
4.	Quản lý Đơn hàng:
- Xem danh sách đơn hàng của khách hàng.
- Thêm sửa xóa tìm kiếm đơn hàng.
- Kiểm tra lịch sử đơn hàng của khách hàng.  
5.	Quản lý Chi tiết đơn hàng:
- Kiểm tra chi tiết từng đơn hàng bao gồm sản phẩm, số lượng, giá cả, và tổng số tiền.
- Quản lý chi tiết về sản phẩm được bán trong mỗi đơn hàng, bao gồm các thông tin về sản phẩm, số lượng, giá bán, thông tin người mua.

### Các công nghệ sử dụng:
- JPA (Java Persistence API): Dùng để tương tác với cơ sở dữ liệu theo cách đối tượng hóa, mà không cần phải viết nhiều câu lệnh SQL thủ công. JPA là một phần của Java EE (hoặc Jakarta EE hiện tại) và có thể được sử dụng với bất kỳ framework quản lý cơ sở dữ liệu nào.
- Hibernate: Đây là một implementation của JPA, hỗ trợ quản lý kết nối và các thao tác dữ liệu. Hibernate sẽ giúp bạn thực hiện các tác vụ như lưu trữ, truy vấn dữ liệu một cách đơn giản hơn.
- MySQL Connector/J: Đây là thư viện cần thiết để Java kết nối với MySQL. Bạn cần cài đặt MySQL JDBC Driver để JPA có thể giao tiếp với MySQL.
- Java Swing: Dùng để xây dựng giao diện người dùng (GUI), trong đó người dùng có thể nhập liệu, xem dữ liệu từ cơ sở dữ liệu, và thực hiện các thao tác CRUD (Create, Read, Update, Delete).
- Quản lý sản phẩm: CMS (Content Management System) cho phép Admin dễ dàng tạo và chỉnh sửa thông tin sản phẩm.
#### Lợi ích:
- Quản lý hiệu quả: Hệ thống giúp Admin dễ dàng theo dõi và quản lý các thông tin khách hàng, đơn hàng, sản phẩm, nhân viên và báo cáo tài chính.
- Tiết kiệm thời gian: Các công cụ tự động hóa trong hệ thống giúp giảm thời gian quản lý thủ công, đồng thời cung cấp các báo cáo chính xác để ra quyết định nhanh chóng.
- Bảo mật: Với tính năng phân quyền rõ ràng, Admin có thể kiểm soát những gì mỗi nhân viên có quyền truy cập, bảo vệ dữ liệu doanh nghiệp và khách hàng.
Tóm tắt Quy trình sử dụng hệ thống:
1.	Đăng nhập vào hệ thống.
2.	Quản lý khách hàng: thêm, cập nhật, xóa, tìm kiếm khách hàng.
3.	Quản lý sản phẩm: thêm, cập nhật, xóa, kiểm tra tồn kho.
4.	Quản lý đơn hàng: xem, tìm kiếm, xóa, tạo, hủy đơn hàng.
5.	Đăng xuất khi kết thúc công việc.


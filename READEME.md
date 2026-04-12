# CRM PRO - Hệ thống Quản lý Khách hàng Tiềm năng (Leads)

Chào mừng bạn đến với dự án **CRM PRO**. Đây là một ứng dụng Web Application được xây dựng nhằm mục đích số hóa và tối ưu hóa quy trình quản lý Khách hàng tiềm năng (Leads) cho đội ngũ Sales/Kinh doanh.

## 🚀 Tính năng nổi bật (Cập nhật đến Task 1.2)

Hệ thống cung cấp đầy đủ các tính năng quản trị khách hàng từ cơ bản đến nâng cao:
- **Quản lý CRUD toàn diện (Task 1.1):** Thêm, Xem, Sửa, Xóa thông tin liên hệ, công ty, SĐT, Email của Khách hàng tiềm năng.
- **Quản lý Nhu cầu Sản phẩm/Dịch vụ (Task 1.2):** Hỗ trợ nhân viên Sales ghi nhận nhanh nhu cầu của khách hàng thông qua hệ thống Checkbox chọn nhiều (Multi-select). Dữ liệu được xử lý tự động và lưu trữ tối ưu thành chuỗi văn bản.
- **Kiểm soát Dữ liệu (Validation):** Tích hợp bộ lọc tự động bắt lỗi định dạng (SĐT phải đủ 10 số, Email đúng chuẩn, CCCD 12 số) và chặn trùng lặp Số điện thoại.
- **Phân loại Trực quan:** Quản lý trạng thái tiến độ (Mới, Đang liên hệ, Đã chuyển đổi) với giao diện nhãn (Badge) màu sắc rõ ràng.
- **Xem chi tiết (View Profile):** Giao diện thẻ (Card) trực quan hiển thị toàn cảnh thông tin kinh doanh, pháp lý và các dịch vụ mà khách hàng đang quan tâm.

## 🛠️ Công nghệ sử dụng (Tech Stack)

Dự án được phát triển dựa trên hệ sinh thái Java/Spring Boot mạnh mẽ:

* **Backend:** Java 17+, Spring Boot 3.x, Spring MVC.
* **Database & ORM:** MySQL 8.0, Spring Data JPA, Hibernate.
* **Frontend:** Thymeleaf (Template Engine), HTML5, Bootstrap 5 (UI/UX), FontAwesome 6 (Icons).
* **Công cụ bổ trợ:** Lombok, Spring Boot Starter Validation.
* **Môi trường phát triển (IDE):** IntelliJ IDEA.

---

## ⚙️ Hướng dẫn Cài đặt & Chạy dự án

Làm theo các bước dưới đây để khởi chạy dự án trên máy tính cá nhân của bạn:

### Bước 1: Chuẩn bị Cơ sở dữ liệu (MySQL)
1. Mở XAMPP/WAMP hoặc MySQL Workbench/phpMyAdmin.
2. Tạo một Database mới với tên: `crm_lead` (Sử dụng Collation `utf8mb4_unicode_ci` để gõ tiếng Việt có dấu).
3. *(Lưu ý cập nhật Task 1.2)*: Nếu bạn import từ file `.sql` cũ, hãy đảm bảo bảng `leads` đã có cột `interested_products` (Kiểu VARCHAR). Nếu dùng `spring.jpa.hibernate.ddl-auto=update`, Spring Boot sẽ tự động thêm cột này giúp bạn!

### Bước 2: Cấu hình kết nối Database
1. Mở dự án bằng **IntelliJ IDEA**.
2. Tìm đến file cấu hình: `src/main/resources/application.properties`.
3. Kiểm tra và sửa lại các thông tin kết nối sao cho khớp với MySQL trên máy của bạn:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/crm_lead?useUnicode=true&characterEncoding=UTF-8
   spring.datasource.username=root
   spring.datasource.password= # Để trống nếu dùng XAMPP mặc định
   
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
### Bước 3: Tải Dependencies (Thư viện Maven)  
Trong IntelliJ, mở tab Maven ở cạnh viền bên phải màn hình.  

Bấm vào biểu tượng Reload All Maven Projects (Hình hai mũi tên xoay tròn) để IntelliJ tải về các thư viện cần thiết (Spring Boot, Thymeleaf, Lombok...).  

### Bước 4: Khởi chạy Ứng dụng  
Mở file chạy chính của dự án: src/main/java/org/example/crmkhtn/CrmKhtnApplication.java.  

Click chuột phải vào file -> Chọn Run 'CrmKhtnApplication' (Hoặc bấm nút ▶️ màu xanh lá cây ở thanh công cụ).  

Đợi vài giây, quan sát tab Console (Run) ở dưới cùng. Nếu thấy dòng chữ Started CrmKhtnApplication in ... seconds nghĩa là server đã chạy thành công!  

📖 Hướng dẫn sử dụng Phần mềm  
Sau khi server khởi chạy thành công, hãy mở trình duyệt web (Chrome/Edge/Safari) và truy cập vào các đường dẫn sau:  

Trang Danh sách Khách hàng (Trang chủ):  
👉 http://localhost:8080/leads  
Tại đây bạn có thể xem toàn bộ danh sách, bấm vào các biểu tượng hành động (Mắt/Bút/Thùng rác) để thao tác.  

Thêm Khách hàng mới & Chọn Dịch vụ:  
👉 Truy cập: http://localhost:8080/leads/new  
Bạn có thể tích chọn nhiều Sản phẩm / Dịch vụ quan tâm cùng lúc ở cuối form. Hệ thống sẽ tự động nối chuỗi và lưu lại.  

⚠️ Một số quy tắc nhập liệu:
SĐT: Phải nhập đủ 10 số (VD: 0912345678). Hệ thống KHÔNG cho phép trùng số điện thoại.  

Email: Phải đúng định dạng chuẩn có @ và tên miền (VD: contact@company.com).  

CCCD: Bắt buộc chuẩn 12 số.  

Doanh thu: Nhập số dương, cho phép nhập số thập phân.  
# CRM PRO - Hệ thống Quản lý Khách hàng Tiềm năng (Leads)

Chào mừng bạn đến với dự án **CRM PRO**. Đây là một ứng dụng Web Application được xây dựng nhằm mục đích số hóa và tối ưu hóa quy trình quản lý Khách hàng tiềm năng (Leads) cho đội ngũ Sales/Kinh doanh.

## 🚀 Tính năng nổi bật (Chức năng hiện tại)

Hệ thống cung cấp đầy đủ các tính năng CRUD (Thêm, Xem, Sửa, Xóa) cho đối tượng Khách hàng:
- **Danh sách Khách hàng:** Quản lý tập trung thông tin liên hệ, công ty, SĐT, Email.
- **Thêm mới/Cập nhật:** Tích hợp bộ lọc kiểm tra dữ liệu (Validation) tự động bắt lỗi định dạng (SĐT 10 số, Email hợp lệ, CCCD 12 số,...).
- **Phân loại trạng thái:** Dễ dàng theo dõi tiến độ chăm sóc (Mới, Đang liên hệ, Đã chuyển đổi).
- **Quản lý Nguồn & Nhóm phụ trách:** Ghi nhận nguồn khách từ đâu (Website, Facebook...) và giao việc cho đúng nhóm Sales.
- **Xem chi tiết (View Profile):** Giao diện thẻ (Card) trực quan hiển thị toàn cảnh thông tin kinh doanh và pháp lý của một khách hàng.

## 🛠️ Công nghệ sử dụng (Tech Stack)

Dự án được phát triển dựa trên hệ sinh thái Java/Spring Boot mạnh mẽ:

* **Backend:** Java 17+, Spring Boot 3.x, Spring MVC.
* **Database & ORM:** MySQL 8.0, Spring Data JPA, Hibernate.
* **Frontend:** Thymeleaf (Template Engine), HTML5, Bootstrap 5 (UI/UX), FontAwesome 6 (Icons).
* **Công cụ bổ trợ:** Lombok, Spring Boot Starter Validation.
* **Môi trường phát triển (IDE):** IntelliJ IDEA.

---

## ⚙️ Hướng dẫn Cài đặt & Chạy dự án (Dành cho IntelliJ IDEA)

Làm theo các bước dưới đây để khởi chạy dự án trên máy tính cá nhân của bạn:

### Bước 1: Chuẩn bị Cơ sở dữ liệu (MySQL)
1. Mở XAMPP/WAMP hoặc MySQL Workbench/phpMyAdmin.
2. Tạo một Database mới với tên: `crm_lead` (Sử dụng Collation `utf8mb4_unicode_ci` để gõ tiếng Việt có dấu).
3. *(Tùy chọn)* Nếu bạn có file file backup `.sql`, hãy Import vào database này. Nếu không, Spring Boot JPA (`hibernate.ddl-auto=update`) sẽ tự động khởi tạo bảng `leads` khi chạy code.

### Bước 2: Cấu hình kết nối Database
1. Mở dự án bằng **IntelliJ IDEA**.
2. Tìm đến file cấu hình: `src/main/resources/application.properties`.
3. Kiểm tra và sửa lại các thông tin kết nối sao cho khớp với MySQL trên máy của bạn:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/crm_lead?useUnicode=true&characterEncoding=UTF-8
   spring.datasource.username=root
   spring.datasource.password= # Để trống nếu dùng XAMPP mặc định, hoặc nhập pass của bạn
   
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
### Bước 3: Tải Dependencies (Thư viện Maven)
1. Trong IntelliJ, mở tab Maven ở cạnh viền bên phải màn hình.
2. Bấm vào biểu tượng Reload All Maven Projects (Hình hai mũi tên xoay tròn) để IntelliJ tải về các thư viện cần thiết (Spring Boot, Thymeleaf, Lombok...).
### Bước 4: Khởi chạy Ứng dụng
1. Mở file chạy chính của dự án: src/main/java/org/example/crmkhtn/CrmKhtnApplication.java.
2. Click chuột phải vào file -> Chọn Run 'CrmKhtnApplication' (Hoặc bấm nút ▶️ màu xanh lá cây ở thanh công cụ).
3. Đợi vài giây, quan sát tab Console (Run) ở dưới cùng. Nếu thấy dòng chữ Started CrmKhtnApplication in ... seconds nghĩa là server đã chạy thành công!.
### 📖 Hướng dẫn sử dụng Phần mềm
Sau khi server khởi chạy thành công, hãy mở trình duyệt web (Chrome/Edge/Safari) và truy cập vào các đường dẫn sau:
Trang Danh sách Khách hàng (Trang chủ):  
👉  http://localhost:8080/leads  
Tại đây bạn có thể xem toàn bộ danh sách, bấm vào các biểu tượng hành động (Mắt/Bút/Thùng rác) để thao tác.
Thêm Khách hàng mới:  
👉  Bấm nút "Thêm mới" màu xanh trên màn hình danh sách, hoặc truy cập: http://localhost:8080/leads/new  
⚠️  Một số lưu ý về Nhập liệu:  
SĐT: Phải nhập đủ 10 số (VD: 0912345678). Không được trùng lặp SĐT giữa các khách hàng (Ràng buộc Unique).  
Email: Phải đúng định dạng chuẩn có @ và tên miền (VD: contact@company.com).  
CCCD: Bắt buộc chuẩn 12 số.  
Doanh thu: Nhập số dương, cho phép nhập số thập phân.  

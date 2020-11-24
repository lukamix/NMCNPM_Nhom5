

**Cấu hình XAMPP để sử dụng database**

Cổng port id chúng tôi sử dụng để demo tính năng database: Apache (8080 + 4433); MySQL (3306)

**Cách thay đổi port ID của Apache trên XAMPP:**

Bước 1: Vào Config Apache (httpd.conf), bạn tìm đến đoạn Listen 80 và thay đổi thành Listen 8080

Bước 2: Tiếp theo bạn tìm đến ServerName localhost:80 và thay thành ServerName localhost:8080 và lưu lại.

Bước 3: Bây giờ các bạn mở từ bảng giao diện chính của phần mềm XAMPP và chọn Apache (httpd-ssl.conf) và tìm đến đoạn Listen 443 thay đổi thành Listen 4433

Bước 4: Tìm đến tiếp đoạn <VirtualHost default:443> ServerName localhost:443 thay đổi thành <VirtualHost default:4433> ServerName localhost:4433 và lưu lại.

Bước 5: Khởi động lại XAMPP. Sau đó bật Apache và MySQL. Vì chúng tôi sử dụng port ID mặc định cho MySQL nên hãy đảm bảo thiết bị của bạn không có process nào đang sử dụng cổng port 3306 của MySQL.

**Cách tạo database**

Bước 1: Truy cập localhost tại địa chỉ localhost:8080/phpmyadmin

Bước 2: Tạo database mới có tên là homework1_db

Bước 3: Trong tab SQL của database vừa tạo, copy câu lệnh SQL trong file homework1_db.sql và ấn thực thi để tạo bảng và dữ liệu demo cho chương trình 

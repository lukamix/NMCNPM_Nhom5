Xin chào ,cảm ơn bạn đã ghé thăm sản phẩm của chúng tôi !

Thay đổi port id trên XAMPP:
Bước 1 : Vào Config Apache(httpd.conf), bạn tìm đến đoạn Listen 80 và thay đổi thành Listen 8080

Bước 2 : Tiếp theo bạn tìm đến ServerName localhost:80 và thay thành ServerName localhost:8080 và lưu lại.

Bước 3 : Bây giờ các bạn mở từ bảng giao diện chính của phần mềm XAMPP và chọn Apache (httpd-ssl.conf) và tìm đến đoạn Listen 443 thay đổi thành Listen 4433

Bước 4 : Tìm đến tiếp đoạn <VirtualHost default:443> ServerName localhost:443 thay đổi thành <VirtualHost default:4433> ServerName localhost:4433 và lưu lại.

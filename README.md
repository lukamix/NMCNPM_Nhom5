
**Cài đặt Phần mềm trên máy**
-Bấm vào nút Code trên github, sau đó bấm Download zip
->Tìm thư mục chứa file và giải nén file.
*Phần mềm yêu cầu sử dụng NetBeans IDE và XAMPP,MySQL .Link download ở đây :
-NetBeans IDE : https://www.apache.org/dyn/closer.cgi/netbeans/netbeans/12.1/Apache-NetBeans-12.1-bin-windows-x64.exe
-XAMPP : https://www.apachefriends.org/xampp-files/7.4.12/xampp-windows-x64-7.4.12-0-VC15-installer.exe
- MySQL : https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-8.0.22.0.msi
*- Môi trường java trên máy : https://download.oracle.com/otn/java/jdk/14.0.2+12/205943a0976c4ed48cb16f1043c5c647/jdk-14.0.2_windows-x64_bin.exe
(Sau đó chuột phải vào This PC trên Desktop,Chọn Properties ->Advanced system settings ->Environment Variables ->ở phần System variables ở dưới ,tìm mục Path ,bấm vào Browse -> tìm đến thư mục chứa JDK C:\Program Files\Java\jdk-14.0.2\bin)*

**Thêm Thư Viện Vào Project**
- Ở giao diện Netbeans, Chọn File->Open Project ,tìm đến thư mục chứa project vừa tải (Project sẽ có icon là hình cốc cà phê) ,chọn project và bấm Open Project
-Sẽ có thông báo Project Problem -> bấm chọn Close
- Bấm chuột phải vào Libraries trên project-> Add Jar/Folder, tìm đếm đường dẫn NMCNPM_Nhom5-master/dist/lib và bấm Ctrl+A -> Open

***Tiếp theo bạn phải cấu hình XAMPP để có thể sử dụng database ***

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

**Cách lấy dữ liệu từ google sheet**

+ Biểu mẫu để lấy dữ liệu Tết thiếu nhi: https://docs.google.com/forms/d/18nCG4FMcXF6CC-Naw8D_AKeGyaBLO-J6ehHoRKTMEEU/edit
+ Biểu mẫu để lấy dữ liệu Trung thu: https://docs.google.com/forms/d/1ylUXNeo_bWjxBrXZvNUodR_5YZI_2Vfoyi1JjfEVz60/edit
+ Biểu mẫu để lấy dữ liệu Cuối năm: https://docs.google.com/forms/d/1A24QK-o0YfC4baGOVbnP-dgU0gvy244dbNk3piPtLoQ/edit

+ GG Sheet lưu dữ liệu Tết thiếu nhi: https://docs.google.com/spreadsheets/d/1J3nIeCa54XzUfyPMjxARNuEDsDnfnNeT3ToxUEe0LXc/edit#gid=732156435
+ GG Sheet lưu dữ liệu Trung thu: https://docs.google.com/spreadsheets/d/1jzUZlUmLuYL7JqUsq80hGmnzYwVevtDaNIUExvZwax4/edit#gid=2087115799
+ GG Sheet lưu dữ liệu Cuối năm: https://docs.google.com/spreadsheets/d/1FhwhQNRZfvuXvfIdJav8y5d3NJ3jcqLHzHsAwhtfZlI/edit#gid=1866053596

Sau khi người dùng nhập dữ liệu vào biểu mẫu, dữ liệu sẽ được hiển thị trong gg sheet tương ứng. 
Mở phần mềm, chọn sự kiện tương ứng, nhấn Update từ sheet dữ liệu từ sheet sẽ được tự động cập nhật vào database
- Người dùng có thể xem minh chứng bằng cách vào gg sheet tương ứng, nhấn vào link trong cột Ảnh minh chứng để hiển thị


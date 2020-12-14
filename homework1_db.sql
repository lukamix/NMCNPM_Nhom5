-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 13, 2020 lúc 03:46 PM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `homework1_db`
--
CREATE DATABASE IF NOT EXISTS `homework1_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `homework1_db`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `achievement`
--

DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement` (
  `ID` int(8) NOT NULL,
  `Achievement_Name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Cắt ngắn bảng trước khi chèn `achievement`
--

TRUNCATE TABLE `achievement`;
--
-- Đang đổ dữ liệu cho bảng `achievement`
--

INSERT DELAYED IGNORE INTO `achievement` (`ID`, `Achievement_Name`) VALUES
(1, 'Học sinh Giỏi'),
(2, 'Học sinh Tiên tiến '),
(3, NULL),
(4, 'Dịp đặc biệt'),
(8, 'Dịp đặc biệt'),
(15, 'Dịp đặc biệt'),
(16, 'Dịp đặc biệt'),
(17, 'Dịp đặc biệt'),
(18, 'Dịp đặc biệt'),
(19, 'Dịp đặc biệt'),
(20, 'Dịp đặc biệt'),
(21, 'Học sinh giỏi'),
(22, 'Học sinh giỏi'),
(23, 'Dịp đặc biệt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `ID` int(8) NOT NULL,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Year` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Cắt ngắn bảng trước khi chèn `event`
--

TRUNCATE TABLE `event`;
--
-- Đang đổ dữ liệu cho bảng `event`
--

INSERT DELAYED IGNORE INTO `event` (`ID`, `Name`, `Year`) VALUES
(2, 'Trung thu', '2020'),
(3, 'Tết thiếu nhi', '2020'),
(4, 'Cuối năm học', '2020'),
(11, 'Trung thu', '2019'),
(18, 'Trung thu', '2018');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `family`
--

DROP TABLE IF EXISTS `family`;
CREATE TABLE `family` (
  `ID` int(8) NOT NULL,
  `Father` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Mother` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Address` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ID_E` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Cắt ngắn bảng trước khi chèn `family`
--

TRUNCATE TABLE `family`;
--
-- Đang đổ dữ liệu cho bảng `family`
--

INSERT DELAYED IGNORE INTO `family` (`ID`, `Father`, `Mother`, `Address`, `ID_E`) VALUES
(1, 'Lê Việt Hùng ', 'Trần Thanh Hà ', 'Hà Nội ', 2),
(2, 'Phạm Tùng', 'Nguyễn Dương', 'Hà Nội ', 3),
(3, 'Lê Mạnh Hùng', 'Nguyễn Thanh Hải', '', 2),
(4, 'Phạm Tùng     ', 'Nguyễn Hoài Thu', '', 4),
(5, 'Lê Mạnh Hùng', 'Nguyễn Thị Hoài', 'Hà Nội', 4),
(6, 'Nguyễn Hùng', 'Lê Thỏ', 'Hà Nội', 3),
(15, 'Nguyễn Đức Hào', 'Bùi Thị Trà', 'Hà Nội', 2),
(17, 'Nguyễn Hoàng Mạnh', 'Nguyễn Thị Ngọc', 'Hải Dương', 3),
(21, 'Nguyễn Minh Quang', 'Trịnh Thị Hằng', '25 LTN', 11),
(28, 'Trần Minh Đức', 'Lê Thanh Tâm', '46 TDN', 11),
(29, 'Nguyễn Văn X', 'Lộc Thị X', 'KTX DHBK', 18),
(33, 'Nguyễn Nhất Thành', 'Đinh Nhật Linh', '256 TĐN', 2),
(36, 'Nguyễn Văn Thành', 'Đinh Lệ Hằng', '35 TĐN', 3),
(37, 'Trần Văn Minh', 'Nguyễn Thị Bích', '25 LĐH', 4),
(39, 'Nguyễn Định Công', 'Nguyễn Lệ Nhi', '108 Định Công', 4),
(40, 'Nguyễn Nhất Hòa', 'Đinh Lệ Hằng', '206 B6 Trại Găng', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `gift`
--

DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
  `ID` int(8) NOT NULL,
  `Gift_Name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Cost` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Cắt ngắn bảng trước khi chèn `gift`
--

TRUNCATE TABLE `gift`;
--
-- Đang đổ dữ liệu cho bảng `gift`
--

INSERT DELAYED IGNORE INTO `gift` (`ID`, `Gift_Name`, `Cost`) VALUES
(1, 'Bánh', 10000),
(2, 'Kẹo', 5000),
(3, 'Hoa quả', 5000),
(4, 'Hoa quả', 10000),
(27, 'Bánh', 15000),
(34, 'Kẹo', 50000),
(41, 'Kẹo', 15000),
(42, 'Bánh', 20000),
(43, 'Bánh', 50000),
(45, 'Kẹo', 15000),
(46, 'Kẹo', 15000),
(47, 'Kẹo', 20000),
(50, 'Bánh', 15000),
(51, 'Kẹo', 20000),
(53, 'Sách', 50000),
(54, 'Kẹo', 350000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receive_gift`
--

DROP TABLE IF EXISTS `receive_gift`;
CREATE TABLE `receive_gift` (
  `ID` int(8) NOT NULL,
  `ID_Recipient` int(8) NOT NULL,
  `ID_Gift` int(8) NOT NULL,
  `ID_Event` int(8) NOT NULL,
  `ID_Achievement` int(8) NOT NULL,
  `Quantity` int(8) NOT NULL,
  `MinhChung` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Cắt ngắn bảng trước khi chèn `receive_gift`
--

TRUNCATE TABLE `receive_gift`;
--
-- Đang đổ dữ liệu cho bảng `receive_gift`
--

INSERT DELAYED IGNORE INTO `receive_gift` (`ID`, `ID_Recipient`, `ID_Gift`, `ID_Event`, `ID_Achievement`, `Quantity`, `MinhChung`) VALUES
(1, 1, 1, 2, 1, 5, NULL),
(2, 1, 1, 3, 1, 5, NULL),
(9, 9, 27, 2, 4, 10, NULL),
(10, 10, 27, 2, 4, 10, NULL),
(11, 11, 27, 2, 4, 10, NULL),
(15, 15, 34, 11, 8, 5, NULL),
(21, 21, 41, 11, 15, 5, NULL),
(22, 22, 42, 11, 16, 3, NULL),
(23, 23, 43, 18, 17, 10, NULL),
(25, 25, 47, 2, 19, 3, NULL),
(26, 26, 50, 3, 20, 2, NULL),
(27, 27, 51, 4, 21, 15, NULL),
(28, 28, 53, 4, 22, 5, NULL),
(29, 29, 54, 3, 23, 15, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `recipient`
--

DROP TABLE IF EXISTS `recipient`;
CREATE TABLE `recipient` (
  `ID` int(8) NOT NULL,
  `Name` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `Age` int(4) NOT NULL,
  `Sex` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `School` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `ID_Family` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Cắt ngắn bảng trước khi chèn `recipient`
--

TRUNCATE TABLE `recipient`;
--
-- Đang đổ dữ liệu cho bảng `recipient`
--

INSERT DELAYED IGNORE INTO `recipient` (`ID`, `Name`, `Age`, `Sex`, `School`, `ID_Family`) VALUES
(1, 'Lê Mạnh Tú', 10, NULL, 'HUST', 1),
(2, 'Nguyễn Thu Thảo', 19, NULL, 'TMU ', 1),
(8, 'Nguyễn Đình Hùng', 20, 'Nam', 'HUST', 15),
(9, 'Nguyễn Hoàng Long', 17, 'Nam', 'HUST', 17),
(10, 'Nguyễn Hoàng Hải', 17, 'Nam', 'HUST', 17),
(11, 'Nguyễn Hoàng Lộc', 17, 'Nam', 'HUST', 17),
(15, 'Nguyễn Thị Hạnh', 18, 'Nữ', 'Hust', 21),
(21, 'Nguyễn Tất Thành', 10, 'Nam', 'Tiểu học Minh Khai', 21),
(22, 'Trần Quang Thắng', 12, 'Nam', 'THCS HBT', 28),
(23, 'Nguyễn Thị Liên', 18, 'Nữ', 'BK', 29),
(25, 'Nguyễn Tất Thanh', 18, 'Nam', 'HUST', 33),
(26, 'Nguyễn Tất Thanh', 12, 'Nam', 'BKA', 36),
(27, 'Trần Thị Ngân', 14, 'Nữ', 'THCS HBT', 37),
(28, 'Nguyễn Công Vinh', 13, 'Nam', 'THCS MK', 39),
(29, 'Nguyễn Đình Quý', 15, 'Nam', 'THCS Bạch Đằng', 40);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `family`
--
ALTER TABLE `family`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_FM_E` (`ID_E`);

--
-- Chỉ mục cho bảng `gift`
--
ALTER TABLE `gift`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `receive_gift`
--
ALTER TABLE `receive_gift`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_RG_Recipient` (`ID_Recipient`),
  ADD KEY `FK_RG_Gift` (`ID_Gift`),
  ADD KEY `FK_RG_Event` (`ID_Event`),
  ADD KEY `FK_RG_Achievement` (`ID_Achievement`);

--
-- Chỉ mục cho bảng `recipient`
--
ALTER TABLE `recipient`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Family_Recipient` (`ID_Family`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `achievement`
--
ALTER TABLE `achievement`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `event`
--
ALTER TABLE `event`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `family`
--
ALTER TABLE `family`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `gift`
--
ALTER TABLE `gift`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT cho bảng `receive_gift`
--
ALTER TABLE `receive_gift`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT cho bảng `recipient`
--
ALTER TABLE `recipient`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `family`
--
ALTER TABLE `family`
  ADD CONSTRAINT `FK_FM_E` FOREIGN KEY (`ID_E`) REFERENCES `event` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `receive_gift`
--
ALTER TABLE `receive_gift`
  ADD CONSTRAINT `FK_RG_Achievement` FOREIGN KEY (`ID_Achievement`) REFERENCES `achievement` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RG_Event` FOREIGN KEY (`ID_Event`) REFERENCES `event` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RG_Gift` FOREIGN KEY (`ID_Gift`) REFERENCES `gift` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RG_Recipient` FOREIGN KEY (`ID_Recipient`) REFERENCES `recipient` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `recipient`
--
ALTER TABLE `recipient`
  ADD CONSTRAINT `FK_Family_Recipient` FOREIGN KEY (`ID_Family`) REFERENCES `family` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

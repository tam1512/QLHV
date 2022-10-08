-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 08, 2022 lúc 04:34 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `project_mhpl`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course`
--

CREATE TABLE `course` (
  `CourseID` varchar(11) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Credits` varchar(150) NOT NULL,
  `DepartmentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `course`
--

INSERT INTO `course` (`CourseID`, `Title`, `Credits`, `DepartmentID`) VALUES
('1045', 'Calculus', '4', 7),
('1050', 'Chemistry', '4', 1),
('1061', 'Physics', '4', 1),
('2021', 'Composition', '3', 2),
('2030', 'Poetry', '2', 2),
('2042', 'Literature', '4', 2),
('3141', 'Trigonometry', '4', 7),
('4022', 'Microeconomics', '3', 4),
('4041', 'Macroeconomics', '3', 4),
('4061', 'Quantitative', '2', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `courseinstructor`
--

CREATE TABLE `courseinstructor` (
  `CourseID` varchar(11) NOT NULL,
  `LecturerID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `department`
--

CREATE TABLE `department` (
  `DepartmentID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `PublishDate` datetime DEFAULT NULL,
  `Administrator` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `department`
--

INSERT INTO `department` (`DepartmentID`, `Name`, `PublishDate`, `Administrator`) VALUES
(1, 'Engineering', '2007-09-01 00:00:00', '2'),
(2, 'English', '2007-09-01 00:00:00', '6'),
(4, 'Economics', '2007-09-01 00:00:00', '4'),
(7, 'Mathematics', '2007-09-01 00:00:00', '3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lecturer`
--

CREATE TABLE `lecturer` (
  `LecturerID` varchar(11) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `HiringDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `onlinecourse`
--

CREATE TABLE `onlinecourse` (
  `CourseID` varchar(11) NOT NULL,
  `URL` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `onsitecourse`
--

CREATE TABLE `onsitecourse` (
  `CourseID` varchar(11) NOT NULL,
  `Location` varchar(50) NOT NULL,
  `Schedule` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `StudentID` varchar(11) NOT NULL,
  `LastName` varchar(150) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(5) NOT NULL,
  `RegisterDay` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`StudentID`, `LastName`, `FirstName`, `DOB`, `Gender`, `RegisterDay`) VALUES
('SD1', 'Lê Tùng', 'Lâm', '2000-11-21', 'Male', '2022-09-13'),
('SD2', 'xczc', 'zxczxc', '2022-10-17', 'Femal', '2022-10-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `studentgrade`
--

CREATE TABLE `studentgrade` (
  `EnrollmentID` int(11) NOT NULL,
  `CourseID` varchar(11) NOT NULL,
  `StudentID` varchar(11) NOT NULL,
  `Grade` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseID`),
  ADD KEY `course_ibfk_1` (`DepartmentID`);

--
-- Chỉ mục cho bảng `courseinstructor`
--
ALTER TABLE `courseinstructor`
  ADD PRIMARY KEY (`CourseID`,`LecturerID`),
  ADD KEY `courseinstructor_ibfk_3` (`LecturerID`);

--
-- Chỉ mục cho bảng `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Chỉ mục cho bảng `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`LecturerID`);

--
-- Chỉ mục cho bảng `onlinecourse`
--
ALTER TABLE `onlinecourse`
  ADD PRIMARY KEY (`CourseID`);

--
-- Chỉ mục cho bảng `onsitecourse`
--
ALTER TABLE `onsitecourse`
  ADD PRIMARY KEY (`CourseID`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`);

--
-- Chỉ mục cho bảng `studentgrade`
--
ALTER TABLE `studentgrade`
  ADD PRIMARY KEY (`EnrollmentID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `CourseID` (`CourseID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `department`
--
ALTER TABLE `department`
  MODIFY `DepartmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `studentgrade`
--
ALTER TABLE `studentgrade`
  MODIFY `EnrollmentID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`);

--
-- Các ràng buộc cho bảng `courseinstructor`
--
ALTER TABLE `courseinstructor`
  ADD CONSTRAINT `courseinstructor_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`),
  ADD CONSTRAINT `courseinstructor_ibfk_2` FOREIGN KEY (`LecturerID`) REFERENCES `lecturer` (`LecturerID`),
  ADD CONSTRAINT `courseinstructor_ibfk_3` FOREIGN KEY (`LecturerID`) REFERENCES `lecturer` (`LecturerID`);

--
-- Các ràng buộc cho bảng `onlinecourse`
--
ALTER TABLE `onlinecourse`
  ADD CONSTRAINT `onlinecourse_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`);

--
-- Các ràng buộc cho bảng `onsitecourse`
--
ALTER TABLE `onsitecourse`
  ADD CONSTRAINT `onsitecourse_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`);

--
-- Các ràng buộc cho bảng `studentgrade`
--
ALTER TABLE `studentgrade`
  ADD CONSTRAINT `studentgrade_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`),
  ADD CONSTRAINT `studentgrade_ibfk_2` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

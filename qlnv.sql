--Tạo CSDL: QLSanpham 
Create DataBase QLSNV 
use QLSNV 

Create Table NHANVIEN
( 
	 	MANV nvarchar(10), 
	 	TENNV nvarchar(50), 
		NAMSINH smalldatetime
) 

Insert into NHANVIEN values(N'PRO52139',N'Mai Xuân Lợi',03/11/2000) 
Insert into NHANVIEN values(N'GA52135',N'Nguyễn Quang Hiệp',09/05/2000) 
Insert into NHANVIEN values(N'GA52139',N'Huỳnh Ngọc Thành',28/12/2000) 
Insert into NHANVIEN values(N'GA41548',N'Ngô Minh Nhật',21/07/2000) 

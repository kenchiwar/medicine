USE MASTER 
GO
DROP DATABASE  IF EXISTS qlht1
CREATE DATABASE qlht1
GO
USE qlht1 
GO
DROP TABLE IF EXISTS Medicine
CREATE TABLE Medicine

(
IdMedicine INT IDENTITY PRIMARY KEY,
RegisNumber NVARCHAR(50) NOT NULL,
NameMedicine NVARCHAR(50) ,
Class NVARCHAR(50),
GroupMedicine NVARCHAR(50),
Active NVARCHAR(50),
Content	NVARCHAR(50),
CoverForm NVARCHAR(50),
Packing NVARCHAR (50),
[Standard] NVARCHAR(50),
IdSupplier int not null,
DateManufacture date NOT NULL,
DateOut date  NOT NULL,
Unit NVARCHAR(50),
PriceEnter float,
UnitPrice  float ,
NumImport int ,
DateImport DATE,
PriceOut FLOAT,
PriceRetailOut FLOAT DEFAULT 0,
AmountNow INT,
AmountRetailDefault FLOAT DEFAULT 0,
DeleteStatus bit DEFAULT 0,
UnitRetail NVARCHAR(50),
ProNumOut int ,
StatusImport bit DEFAULT 1,
)
GO


DROP TABLE IF EXISTS DetailBill
CREATE TABLE DetailBill

(
IdBill NVARCHAR(50)  NOT NULL,
IdMedicine int NOT NULL,
UnitPrice  float DEFAULT 0,
Unit NVARCHAR(50),
Sale float default 0,
Amount FLOAT default 0 ,
PriceOut Float ,
IdEvent int DEFAULT 0,

PRIMARY KEY(IdBill,IdMedicine)
)
GO

/**
ALTER TABLE DetailBill
DROP CONSTRAINT  FK_DetailBill_SuKien
GO
***/

DROP TABLE IF EXISTS Address
CREATE TABLE Address
(
IdAddress INT IDENTITY PRIMARY KEY,
NumHome NVARCHAR(50),
[Name] NVARCHAR(50),
Ward NVARCHAR(50),
County NVARCHAR(50),
City NVARCHAR(50),
Country  NVARCHAR(50),
)
GO



DROP TABLE IF EXISTS Customer
CREATE TABLE Customer
(
IdCustomer int IDENTITY PRIMARY KEY,
[FirstName] NVARCHAR(50),
LastName NVARCHAR(50),
BirthDay DATE,
Gender bit,
CCCD  NVARCHAR(50),
NumPhone NVARCHAR(50),
IdAddress INT NOT NULL,
DeleteStaus bit default 0,
)
GO



DROP TABLE IF EXISTS Supplier
CREATE TABLE Supplier
(
IdSupplier INT IDENTITY PRIMARY KEY,
[Name] NVARCHAR(50),
NumPhone NVARCHAR(50),
Gmail NVARCHAR(50),
IdAddress INT NOT NULL,
DeleteStatus bit DEFAULT 0,
)
GO



DROP TABLE IF EXISTS Staff
CREATE TABLE Staff
(
IdStaff  INT IDENTITY PRIMARY KEY ,
[Shift] NVARCHAR(50),
LastName NVARCHAR(50),
FirstName NVARCHAR(50),
BirthDay date,
Gender bit,
CCCD NVARCHAR(50),
NumPhone NVARCHAR(50),
IdAddress INT NOT NULL,
Username  NVARCHAR(50) NOT NULL,
[Password] NVARCHAR(50),
[Rank] tinyint DEFAULT 1,
DeleteStatus BIT DEFAULT 0,
Gmail NVARCHAR(50)

)
GO


DROP TABLE IF EXISTS Bill
CREATE TABLE Bill
(
IdBill NVARCHAR(50) PRIMARY KEY,
DateFounded date,
IdStaff INT NOT NULL,
IdCustomer  INT DEFAULT 1,
Sale Float DEFAULT 0,
Total FLOAT DEFAULT 0,
)
GO

ALTER TABLE Staff
ADD CONSTRAINT FK_Staff_Address
FOREIGN KEY (IdAddress)
REFERENCES Address(IdAddress)
GO
ALTER TABLE Customer
ADD CONSTRAINT FK_Customer_Address
FOREIGN KEY (IdAddress)
REFERENCES Address(IdAddress)
GO
ALTER TABLE Supplier
ADD CONSTRAINT FK_Supplier_Address
FOREIGN KEY (IdAddress)
REFERENCES Address(IdAddress)
GO
ALTER TABLE Medicine
ADD CONSTRAINT FK_Medicine_Supplier
FOREIGN KEY (IdSupplier)
REFERENCES Supplier(IdSupplier)
GO
ALTER TABLE DetailBill
ADD CONSTRAINT FK_DetailBill_Medicine
FOREIGN KEY (IdMedicine)
REFERENCES Medicine(IdMedicine)
GO
ALTER TABLE DetailBill
ADD CONSTRAINT FK_DetaIlBill_Bill
FOREIGN KEY (IdBill)
REFERENCES Bill(IdBill)
GO
ALTER TABLE Bill  
ADD CONSTRAINT  FK_Bill_Staff
FOREIGN KEY (IdStaff)
REFERENCES Staff(IdStaff)
GO 
ALTER TABLE Bill  
ADD CONSTRAINT  FK_Bill_Customer
FOREIGN KEY (IdCustomer)
REFERENCES Customer(IdCustomer)
GO 
--ALTER TABLE DetailBill  
--ADD CONSTRAINT  FK_DetailBill_SuKien
--FOREIGN KEY (IdEvent)
--REFERENCES SuKien(IdEvent)
--GO 

--INSERT INTO [Address](NumHome,[Name],Ward,County,City,Country)
--VALUES(N'345',N'ko vui',N'Chan Lam',N'hay ha',N'hay ko',N'chan chet')
--GO 

--Insert Into SuKien(Sale,Medicine,Category)
--VALUES(100,N'HẦDSFSAD',0)
--GO
--INSERT INTO Supplier([Name],IdAddress)
--VALUES(N'Chan',1)
--GO

--INSERT INTO Medicine(RegisNumber,NameMedicine,IdSupplier,DateManufacture,DateOut,PriceEnter,NumImport
--,AmountNow,AmountRetailDefault,ProNumOut,PriceOut)
--VALUES(N'aax23xxxa87467',N'hayaaz22334',1,'2025/10/05','2025/12/25',2000,60,60,100,10,40000)
--GO  
--Select * from Medicine

--INSERT INTO Staff(FirstName,LastName,IdAddress,Username)
--VALUES (N'vui lamI',N'chan' ,1,N'chan')
--GO
--INSERT INTO Customer([FirstName],IdAddress,NumPhone)
--VALUES (N'caaa',1,'0975752579')
--GO 
--INSERT INTO DetailBill(IdMedicine,UnitPrice,Unit,Sale,Amount,IdBill)
--VALUES(1,2000,N'viên',3000,1,N'HD00001NV120221026')
--GO 

/*** TẠO FUNCTION TẠO ID BILL TRẢ VỀ LÀ SELECT CÁI BILL ĐÓ    ***/
 
CREATE PROCEDURE CreateIdBillSelect
@IdStaff INT ,@IdCustomer INT
AS 
	BEGIN
	DECLARE @id NVARCHAR(50)
	
	IF(SELECT COUNT(IdBill) FROM Bill) = 0
		SET @id = '0'
	else 
		
		SELECT @id = MAX(RIGHT(LEFT(IdBill,7),5)) FROM Bill
		SELECT @id = CASE 
				WHEN @id = 99999 then 'HD00001'+CONVERT(nvarchar,CONVERT(int,@id)+1) + 'NV'+CONVERT(nvarchar(255),@IdStaff) + CONVERT(nvarchar(255),GETDATE(),112)
				WHEN @id >= 0 and @id < 9 then 'HD0000'+CONVERT(nvarchar,CONVERT(int,@id)+1) + 'NV'+CONVERT(nvarchar(255),@IdStaff) + CONVERT(nvarchar(255),GETDATE(),112)
				WHEN @id >= 9 then 'HD000'+CONVERT(nvarchar,CONVERT(int,@id)+1) + 'NV'+CONVERT(nvarchar(255),@IdStaff) + CONVERT(nvarchar(255),GETDATE(),112)
				WHEN @id >= 99 then 'HD00'+CONVERT(nvarchar,CONVERT(int,@id)+1) + 'NV'+CONVERT(nvarchar(255),@IdStaff) + CONVERT(nvarchar(255),GETDATE(),112)
				WHEN @id >= 999 then 'HD0'+CONVERT(nvarchar,CONVERT(int,@id)+1) + 'NV'+CONVERT(nvarchar(255),@IdStaff) + CONVERT(nvarchar(255),GETDATE(),112)
				WHEN @id >= 9999 then 'HD'+CONVERT(nvarchar,CONVERT(int,@id)+1) + 'NV'+CONVERT(nvarchar(255),@IdStaff) + CONVERT(nvarchar(255),GETDATE(),112)
		END 
	INSERT INTO Bill(IdBill,DateFounded,IdStaff,IdCustomer)
	VALUES (@id,GETDATE(),@IdStaff,@IdCustomer)
	Select * FROM Bill WHERE IdBill = @id 
	END	
GO

CREATE PROCEDURE exportBill
@idBill NVARCHAR(50),@unitPrice FLOAT,@sale FLOAT,@IdCustomer INT,@total Float
AS
BEGIN
	
	UPDATE Bill 
	SET Total = @total,Sale=@sale,IdCustomer=@IdCustomer
	where IdBill = @idBill 
	END
GO
/***tạo detail bill nhưng chia trườngh họp giá cả ra ***/

CREATE PROCEDURE CreateDetailBill 
@idBill NVARCHAR(50),@regisNumber NVARCHAR(50) ,@idCustomer int ,@amount float,@unit NVARCHAR(50),@priceOut FLOAT
,@priceRetailOut FLOAT,@idMedicine INT 
AS
BEGIN
	

	
			IF (@idCustomer=1)
			BEGIN
			INSERT INTO DetailBill(IdBill,IdMedicine,UnitPrice,Unit,Amount,PriceOut)
			Values (@idBill,@idMedicine,@priceRetailOut*@amount,@unit,@amount,@priceRetailOut)
			END
			Else 
			BEGIN
			INSERT INTO DetailBill(IdBill,IdMedicine,UnitPrice,Unit,Amount,PriceOut)
			Values (@idBill,@idMedicine,@PriceOut*@amount,@unit,@amount,@priceOut)
			END
	
	 
	
	
	

END 
GO



/*** DÙNG ĐỂ SAU KHI XUẤT HÓA ĐƠN THÌ CẬP NHẬP LẠI MEDICINE ***/

CREATE PROCEDURE exportDetailBill
@RegisNumber NVARCHAR(50) ,@amount FLOAT
AS
BEGIN
	DECLARE @AmountNow INT
	DECLARE @IdMedicine INT
	Select @IdMedicine= IdMedicine from Medicine  WHERE DeleteStatus = 0 and RegisNumber=@RegisNumber and   DateDiff(day,getDate(),DateOut)>0
ORDER BY DateOut ASC ,DateImport Asc
OFFSET 0 ROWS 
FETCH NEXT 1 ROWS ONLY
	Select @AmountNow =  AmountNow from Medicine  
	WHERE DeleteStatus = 0 and IdMedicine = @IdMedicine
	ORDER BY DateOut ASC ,DateImport Asc
OFFSET 0 ROWS 
FETCH NEXT 1 ROWS ONLY
		IF(@AmountNow < @amount)
		BEGIN 
		Update Medicine
		set AmountNow=0 ,DeleteStatus = 1 
		where IdMedicine=@IdMedicine
		set @amount = @amount - @AmountNow
				while(@AmountNow<@amount)
				Begin
				

				Select @IdMedicine= IdMedicine from Medicine  WHERE DeleteStatus = 0 and RegisNumber=@RegisNumber and   DateDiff(day,getDate(),DateOut)>0
				ORDER BY DateOut ASC ,DateImport Asc
				OFFSET 0 ROWS 
				FETCH NEXT 1 ROWS ONLY
				
				Select @AmountNow =  AmountNow from Medicine  
				WHERE DeleteStatus = 0 and IdMedicine = @IdMedicine
				ORDER BY DateOut ASC ,DateImport Asc
				OFFSET 0 ROWS 
				FETCH NEXT 1 ROWS ONLY
				Update Medicine
			set AmountNow=0 ,DeleteStatus = 1 
			where IdMedicine=@IdMedicine
			set @amount = @amount - @AmountNow
				END 

				Select @IdMedicine= IdMedicine from Medicine  WHERE DeleteStatus = 0 and RegisNumber=@RegisNumber and   DateDiff(day,getDate(),DateOut)>0
				ORDER BY DateOut ASC ,DateImport Asc
				OFFSET 0 ROWS 
				FETCH NEXT 1 ROWS ONLY
				
				Select @AmountNow =  AmountNow from Medicine  
				WHERE DeleteStatus = 0 and IdMedicine = @IdMedicine
				ORDER BY DateOut ASC ,DateImport Asc
				OFFSET 0 ROWS 
				Update Medicine
				set AmountNow=(@AmountNow - @amount)
				where IdMedicine=@IdMedicine
			
		END 
		ELSE 
		BEGIN
		Update Medicine
				set AmountNow=(@AmountNow - @amount)
				where IdMedicine=@IdMedicine
		END 

/***
	if(@AmountNow - @amount )<=0
	BEGIN
	UPDATE Medicine 
	SET AmountNow=0,DeleteStatus=1 
	WHERE IdMedicine=@IdMedicine
	SET @amount=@amount-@AmountNow
				/*** trừ lần hai ***/
					while ((@AmountNow - @amount )<=0)
			BEGIN
						Select @IdMedicine= IdMedicine from Medicine  WHERE DeleteStatus = 0 and RegisNumber=@RegisNumber and   DateDiff(day,getDate(),DateOut)>0
			ORDER BY DateOut ASC ,DateImport Asc
			OFFSET 0 ROWS 
			FETCH NEXT 1 ROWS ONLY
				Select @AmountNow =  AmountNow from Medicine  
				WHERE DeleteStatus = 0 and IdMedicine = @IdMedicine
				ORDER BY DateOut ASC ,DateImport Asc
				OFFSET 0 ROWS
						if(@AmountNow - @amount )<=0
							BEGIN
							UPDATE Medicine 
							SET AmountNow=0,DeleteStatus=1 
							WHERE IdMedicine=@IdMedicine
							SET @amount=@amount-@AmountNow
							END 
							ELSE 
							BEGIN
							UPDATE Medicine 
							SET AmountNow=@Amount - @amount 
							WHERE IdMedicine=@IdMedicine
							END
			END 
			Select @IdMedicine= IdMedicine from Medicine  WHERE DeleteStatus = 0 and RegisNumber=@RegisNumber and   DateDiff(day,getDate(),DateOut)>0
			ORDER BY DateOut ASC ,DateImport Asc
			OFFSET 0 ROWS 
			FETCH NEXT 1 ROWS ONLY
				Select @AmountNow =  AmountNow from Medicine  
				WHERE DeleteStatus = 0 and IdMedicine = @IdMedicine
				ORDER BY DateOut ASC ,DateImport Asc
				OFFSET 0 ROWS
			UPDATE Medicine 
				SET AmountNow=@Amount - @amount 
				WHERE IdMedicine=@IdMedicine
	END 
		
	ELSE 
	BEGIN
	UPDATE Medicine 
	SET AmountNow=@Amount - @amount 
	WHERE IdMedicine=@IdMedicine

	END
***/


END 
GO
/*** trường hợp mà người ta thanh toán ko thành công hay sao ấy để xem ***/

CREATE PROCEDURE deleteBill
@IdBill NVARCHAR(50)
AS
BEGIN
DELETE FROM DetailBill  WHERE IdBill=@IdBill
DELETE FROM Bill WHERE IdBill=@IdBill
END
GO
/***   nhập dữ liệu cho customer  ***/

CREATE PROCEDURE InsertCustomer
@FirstName NVARCHAR(50),@LastName NVARCHAR(50),@BirthDay DATE,@Gender BIT,@CCCD NVARCHAR(50),@NumPhone NVARCHAR(50),
@NumHome NVARCHAR(50),@Name NVARCHAR(50),@Ward NVARCHAR(50),@County NVARCHAR(50),@City NVARCHAR(50),@Country NVARCHAR(50)
AS
BEGIN
DECLARE @IdAddress INT

INSERT INTO Address(NumHome,[Name],Ward,County,City,Country)
VALUES(@NumHome,@Name,@Ward,@County,@City,@Country)
/***   nhập dữ liệu cho tẠO IDAddress  ***/
SELECT @IdAddress = IdAddress FROM Address where (NumHome=@NumHome or NumHome is Null  ) and (Country=@Country or Country is null)
	ORDER BY IdAddress DESC 
	OFFSET 0 ROWS 
	FETCH NEXT 1 ROWS ONLY
	/***   com mịa nó id adress có khả năng bị null đó ***/


INSERT INTO Customer(FirstName,LastName,BirthDay,Gender,CCCD,NumPhone,IdAddress)
VALUES (@FirstName,@LastName ,@BirthDay,@Gender,@CCCD,@NumPhone,@IdAddress)
END 
GO 



/***   nhập dữ liệu cho tẠO update customer  ***/


CREATE PROCEDURE  updateCusomer
@FirstName NVARCHAR(50),@LastName NVARCHAR(50),@BirthDay DATE,@Gender BIT,@CCCD NVARCHAR(50),@NumPhone NVARCHAR(50),
@NumHome NVARCHAR(50),@Name NVARCHAR(50),@Ward NVARCHAR(50),@County NVARCHAR(50),@City NVARCHAR(50)
,@Country NVARCHAR(50),@IdAddress INT,@IdCustomer INT
AS
BEGIN

update Address
Set NumHome=@NumHome,[Name]=@Name,Ward=@Ward,County=@County,City=@City,Country=@Country
WHERE IdAddress=@IdAddress

/***   nhập dữ liệu cho tẠO IDAddress  ***/


update Customer
set FirstName=@FirstName,LastName=@LastName,Gender=@Gender,CCCD=@CCCD,NumPhone=@NumPhone,BirthDay=@Birthday
where IdCustomer = @IdCustomer
END 
GO 


CREATE PROCEDURE insertMedicine
@RegisNumber NVARCHAR(50),@NameMedicine  NVARCHAR(50),@Class  NVARCHAR(50),@GroupMedicine  NVARCHAR(50),
@Active  NVARCHAR(50),@Content  NVARCHAR(50),@CoverForm  NVARCHAR(50)
,@Packing NVARCHAR(50),@Standard NVARCHAR(50),@IdSupplier int ,@DateManufacture DATE ,@DateOut DATE ,@Unit NVARCHAR(50)
,@PriceEnter FLOAT ,@UnitPrice FLOAT ,@NumImport INT ,
@DateImport DATE ,@PriceOut FLOAT ,@PriceRetailOut FLOAT ,@AmountNow INT 
,@AmountRetailDefault FLOAT ,@UnitRetail NVARCHAR(50),@ProNumOut INT 
AS
BEGIN
INSERT INTO Medicine(RegisNumber, NameMedicine, Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], IdSupplier, DateManufacture, DateOut, Unit, PriceEnter, UnitPrice, NumImport, DateImport, PriceOut, PriceRetailOut, AmountNow, 
                  AmountRetailDefault, UnitRetail, ProNumOut)
VALUES(@RegisNumber,@NameMedicine,@Class,@GroupMedicine,@Active,@Content,@CoverForm,@Packing,@Standard,@IdSupplier,@DateManufacture,@DateOut,@Unit,@PriceEnter,@UnitPrice,@NumImport,@DateImport,@PriceOut,@PriceRetailOut,@AmountNow,@AmountRetailDefault,@UnitRetail,@ProNumOut)
END
GO

CREATE PROCEDURE InsertSupplier
@Name1 NVARCHAR(50),@NumPhone NVARCHAR(50),@Gmail NVARCHAR(50),
@NumHome NVARCHAR(50),@Name2 NVARCHAR(50),@Ward NVARCHAR(50),@County NVARCHAR(50),@City NVARCHAR(50),@Country NVARCHAR(50)
AS
BEGIN
DECLARE @IdAddress INT

INSERT INTO Address(NumHome,[Name],Ward,County,City,Country)
VALUES(@NumHome,@Name2,@Ward,@County,@City,@Country)
/***   nhập dữ liệu cho tẠO IDAddress  ***/
SELECT @IdAddress = IdAddress FROM Address where (NumHome=@NumHome or NumHome is Null  ) and (Country=@Country or Country is null)
	ORDER BY IdAddress DESC 
	OFFSET 0 ROWS 
	FETCH NEXT 1 ROWS ONLY
	/***   com mịa nó id adress có khả năng bị null đó ***/


INSERT INTO Supplier([Name],NumPhone,Gmail,IdAddress)
VALUES (@Name1,@NumPhone,@Gmail,@IdAddress)
END 
GO 

CREATE PROC SelectAllStaff
AS
BEGIN
	SELECT IdStaff, Username, [Password], FirstName, LastName,[Rank],[Shift], Address.NumHome, Address.[Name], Address.Ward, Address. County, Address.City, Address.Country , BirthDay, Gender,NumPhone,CCCD, Gmail, DeleteStatus From Staff INNER JOIN Address ON Staff.IdAddress = Address.IdAddress
END
GO

--PROC phan trang
create proc selectStaff
@PageNumber int, @RowOfPage int
as
begin
	SELECT IdStaff, Username, [Password], FirstName, LastName,[Rank],[Shift], Address.NumHome, Address.[Name], Address.Ward, Address. County, Address.City, Address.Country , BirthDay, Gender,NumPhone,CCCD, Gmail, DeleteStatus From Staff INNER JOIN Address ON Staff.IdAddress = Address.IdAddress
	order by IdStaff
	offset (@PageNumber -1)* @RowOfPage Rows
	FETCH NEXT @RowOfPage Rows only
end
go

create proc getStaffById
@idStaff int
as
begin
	SELECT IdStaff, Username, [Password], FirstName, LastName,[Rank],[Shift], Address.NumHome, Address.[Name], Address.Ward, Address. County, Address.City, Address.Country , BirthDay, Gender,NumPhone,CCCD, Gmail, DeleteStatus From Staff INNER JOIN Address ON Staff.IdAddress = Address.IdAddress
	where IdStaff = @idStaff
end
go

create proc countStaff
as
begin
	select count(IdStaff) total from Staff
end
go

CREATE PROCEDURE InsertStaff
@Username NVARCHAR(50), @Password NVARCHAR(50), @Firstname NVARCHAR(50), @Lastname NVARCHAR(50),@BirthDay DATE,  @Shift NVARCHAR(50), @Gender BIT, @NumPhone NVARCHAR(50), @CCCD NVARCHAR(50), @Gmail NVARCHAR(50),
 @NumHome NVARCHAR(50), @Name2 NVARCHAR(50), @Ward NVARCHAR(50) , @County NVARCHAR(50) , @City NVARCHAR(50), @Country NVARCHAR(50)
AS
BEGIN
DECLARE @IdAddress INT

INSERT INTO dbo.Address(NumHome,[Name],Ward,County,City,Country)
VALUES(@NumHome,@Name2,@Ward,@County,@City,@Country)
/***   nhập dữ liệu cho tẠO IDAddress  ***/
SELECT @IdAddress = IdAddress FROM Address where (NumHome=@NumHome or NumHome is Null  ) and (County=@County or County is null)
	ORDER BY IdAddress DESC 
	OFFSET 0 ROWS 
	FETCH NEXT 1 ROWS ONLY
	/***   com mịa nó id adress có khả năng bị null đó ***/

INSERT INTO Staff(Username, [Password], FirstName, LastName, BirthDay, [Shift], Gender, NumPhone, CCCD, Gmail,IdAddress)
VALUES (@Username ,@Password, @Firstname, @Lastname,@BirthDay,  @Shift, @Gender, @NumPhone, @CCCD, @Gmail, @IdAddress)

END 
GO
--INSERT INTO Address(NumHome,[Name],Ward,County,City,Country)
--VALUES(N'abc0', N'1234', N'abc', N'bca',N'aga',N'216')

Create proc UpdateStaff 
@Username NVARCHAR(50), @Password NVARCHAR(50), @Firstname NVARCHAR(50), @Lastname NVARCHAR(50),@BirthDay DATE,  @Shift NVARCHAR(50), @Gender BIT, @NumPhone NVARCHAR(50), @CCCD NVARCHAR(50), @Gmail NVARCHAR(50),
 @NumHome NVARCHAR(50), @Name2 NVARCHAR(50), @Ward NVARCHAR(50) , @County NVARCHAR(50) , @City NVARCHAR(50), @Country NVARCHAR(50),@IdAddress INT,@IdStaff INT
as
begin
	Update Address 
	SET NumHome = @NumHome, [Name] = @Name2, Ward = @Ward, County = @County, City = @City, Country = @Country
	WHERE IdAddress=@IdAddress

	Update Staff
	SET Username = @Username, [Password] = @Password, FirstName =@Firstname, LastName = @Lastname, BirthDay = @BirthDay, [Shift] = @Shift, Gender = @Gender, NumPhone = @NumPhone, CCCD = @CCCD, Gmail = @Gmail, IdAddress = @IdAddress
	WHERE IdStaff=@IdStaff
end
go

Create proc UpdateSupplier
@Name NVARCHAR(50),@NumPhone NVARCHAR(50),@Gmail NVARCHAR(50),
 @NumHome NVARCHAR(50), @Name2 NVARCHAR(50), @Ward NVARCHAR(50) , @County NVARCHAR(50) , @City NVARCHAR(50), @Country NVARCHAR(50),@IdAddress INT,@IdSupplier INT
as
begin
	Update Address 
	SET NumHome = @NumHome, [Name] = @Name2, Ward = @Ward, County = @County, City = @City, Country = @Country
	WHERE IdAddress=@IdAddress

	Update Supplier
	SET [Name]=@Name ,NumPhone=@NumPhone,Gmail=@Gmail
	WHERE IdSupplier=@IdSupplier
end
go

--UpdateStaff N'Nv005', N'147852',N'asgas',N'agsag','1472/11/12', N'12-13', 0, N'1251', N'32236', N'Sg@sag', N'nh2', N'ashs', N'ahh', N'sg', N'sdhsd', N'sdhsd',1,1
CREATE PROC updateDetailMedi
@DateManufacture DATE ,@DateOut DATE,@PriceEnter FLOAT ,@NumImport INT,@PriceOut FLOAT,@PriceRetailOut FLOAT,@DateImport DATE,@IdMedicine INT 
AS 
BEGIN
UPDATE Medicine 
SET DateOut=@DateOut ,PriceEnter=@PriceEnter
,NumImport =@NumImport,PriceOut=@PriceOut,PriceRetailOut=@PriceRetailOut,DateManufacture =@DateManufacture
,DateImport=@DateImport WHERE IdMedicine=@IdMedicine

END
GO

CREATE PROC updatelMedicine
 @RegisNumber NVARCHAR(50), @NameMedicine NVARCHAR(50)
 , @Class NVARCHAR(50), @GroupMedicine NVARCHAR(50), 
 @Active NVARCHAR(50), @Content NVARCHAR(50)
 ,@CoverForm NVARCHAR(50) , @Packing NVARCHAR(50), @Standard NVARCHAR(50), 
 @IdSupplier INT , @Unit NVARCHAR(50) , @AmountRetailDefault FLOAT  , @UnitRetail NVARCHAR(50)
 , @ProNumOut NVARCHAR(50),@search NVARCHAR(50)
AS 
BEGIN
UPDATE Medicine 
SET RegisNumber=@RegisNumber, NameMedicine=@NameMedicine, 
Class=@Class, GroupMedicine=@GroupMedicine, Active=@Active, [Content]=@Content, 
CoverForm=@CoverForm, Packing=@Packing, [Standard]=@Standard, IdSupplier=@IdSupplier, Unit=@Unit
, AmountRetailDefault=@AmountRetailDefault, UnitRetail=@UnitRetail, ProNumOut=@ProNumOut
WHERE RegisNumber=@search

END
GO

CREATE PROCEDURE insertSuKien
@NameEvent NVARCHAR(50),@Category SMALLINT,@Sale FLOAT
,@Medicine TEXT , @Gift NVARCHAR(50),@StartDate DATE,@EndDate DATE ,
@Quanity INT,@Price FLOAT 
AS
BEGIN
INSERT INTO SuKien(NameEvent ,Category,Sale,Medicine,Gift,StartDate,EndDate,Quanity,Price)
VALUES(@NameEvent ,@Category,@Sale,@Medicine,@Gift,@StartDate,@EndDate,@Quanity,@Price)
END
GO
CREATE PROCEDURE updateSuKien
@NameEvent NVARCHAR(50),@Category SMALLINT,@Sale FLOAT
,@Medicine TEXT , @Gift NVARCHAR(50),@StartDate DATE,@EndDate DATE ,
@Quanity INT,@Price FLOAT ,@IdEvent INT
AS
BEGIN
UPDATE SuKien
SET NameEvent=@NameEvent ,Category=@Category,Sale=@Sale,Medicine=@Medicine,
Gift=@Gift,StartDate=@StartDate,EndDate=@EndDate,Quanity=@Quanity,Price=@Price
WHERE IdEvent=@IdEvent
END
GO

/*** 
Select  DISTINCT RegisNumber,IdMedicine,NameMedicine  ,Class ,GroupMedicine ,Active ,Content	,CoverForm ,
Packing ,[Standard] ,IdSupplier ,DateManufacture ,DateOut ,Unit ,PriceEnter ,UnitPrice   ,
NumImport  ,DateImport ,PriceOut ,PriceRetailOut ,AmountNow ,AmountRetailDefault ,
DeleteStatus ,UnitRetail ,ProNumOut  ,
StatusImport  from Medicine WHERE NameMedicine LIKE N'%hay%' Order by DateManufacture asc,DateOut asc

Select * from Medicine where NameMedicine like N'%hay%'

 InsertCustomer N'nghi',N'trung','2000/11/11',0,N'3123',N'312312',N'312312',N'EQEQW',N'EQEE',N'1312',N'DQWE',N'hay'

SELECT Customer.FirstName, Customer.LastName, Customer.BirthDay, Customer.CCCD, Customer.Gender, Customer.NumPhone, Customer.DeleteStaus, Address.*, Customer.IdCustomer
FROM     Address INNER JOIN
                  Customer ON Address.IdAddress = Customer.IdAddress
WHERE NumPhone=N'0937844494'

SELECT Customer.FirstName, Customer.LastName, Customer.BirthDay, Customer.CCCD, Customer.Gender, Customer.NumPhone, Customer.DeleteStaus, Address.*, Customer.IdCustomer
FROM     Address INNER JOIN
                  Customer ON Address.IdAddress = Customer.IdAddress
WHERE NumPhone=N'0975752588'

CreateIdBillSelect 1,1
 Delete Bill
 go
 exportBill N'HD00009NV120221030' ,20,30

 WHERE CONVERT(VARCHAR(25), register_date, 126) LIKE '2009-10-10%'

 Select * from Medicine where NameMedicine like N'%c%' and DeleteStatus=0
 SELECT Bill.IdBill, Bill.DateFounded, Bill.IdStaff, Bill.IdCustomer
, Bill.Sale, Bill.Total, Staff.FirstName + ' ' + Staff.LastName AS NameStaff, 
Customer.FirstName + ' ' + Customer.LastName AS NameCustomer
FROM     Customer INNER JOIN
          Bill ON Customer.IdCustomer = Bill.IdCustomer INNER JOIN
          Staff ON Bill.IdStaff = Staff.IdStaff
WHERE Sale>0 or Total>0
ORDER BY DateFounded DESC 
OFFSET 0 ROWS 
FETCH NEXT 1000 ROWS ONLY 
		
		SELECT * FROM DetailBill where IdBill



//
SELECT SUM(Bill.Total-Bill.Sale) as Bill from Bill WHERE DATEDIFF(month, Bill.DateFounded,GETDATE())<=0
///
SELECT Sum(Medicine.UnitPrice)  as Medicine FROM Medicine WHERE DATEDIFF(month, Medicine.DateManufacture,GETDATE())<=1

//
SELECT SUM(Bill.Total-Bill.Sale) as Bill from Bill WHERE DATEDIFF(day, Bill.DateFounded,GETDATE())<=0


 SELECT SUM(Bill.Total-Bill.Sale) from Bill WHERE CONVERT(NVARCHAR,DateFounded,101) LIKE N'%01/2022'
 //
SELECT CONVERT(NVARCHAR,Medicine.DateManufacture,103) as Medicine FROM Medicine WHERE CONVERT(NVARCHAR,Medicine.DateManufacture,101)
LIKE N'%22%' 
 ***/

 /*** 
SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], IdSupplier
FROM     Medicine

GROUP BY RegisNumber,NameMedicine, Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], IdSupplier

 Insert INTO Medicine( RegisNumber, NameMedicine, Class, GroupMedicine, Active, [Content], CoverForm, Packing, Standard, IdSupplier, DateManufacture, DateOut, Unit, PriceEnter, UnitPrice, NumImport, DateImport, PriceOut, PriceRetailOut, AmountNow, 
                  AmountRetailDefault, UnitRetail, ProNumOut)
VALUES(


INSERT INTO Supplier  [Name], NumPhone, Gmail, IdAddress, DeleteStatus
Values()
SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], IdSupplier
FROM     Medicine

GROUP BY RegisNumber,NameMedicine, Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], IdSupplier

SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], IdSupplier
FROM     Medicine




SELECT RegisNumber,NameMedicine ,Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], Supplier.Name ,Sum(AmountNow) as AmountNow
FROM     Medicine INNER JOIN
                  Supplier ON Medicine.IdSupplier = Supplier.IdSupplier
GROUP BY RegisNumber,NameMedicine, Class, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard],Supplier.Name

SELECT DateManufacture, DateOut, Unit, PriceEnter, UnitPrice, NumImport, DateImport, PriceOut, AmountNow, DeleteStatus
FROM     Medicine
where Regisnumber

Select  NameMedicine,Sum(AmountNow)
From
Medicine
WHERE DATEDIFF(day, DateOut, GETDATE())>=0
Group by NameMedicine

SELECT	RegisNumber, Class, NameMedicine, GroupMedicine, Active, [Content], CoverForm, Packing, [Standard], IdSupplier, AmountRetailDefault, Unit
FROM     Medicine
where Regisnumber
ORDER BY IdMedicine  DESC 
OFFSET 0 ROWS 
FETCH NEXT 1 ROWS ONLY 
		
	UPDate Medicine
	SET StatusImport =0 WHERE RegisNumber=N'HAY'

***/


INSERT INTO [Address](NumHome, [Name], Ward, County, City, Country)
VALUES(1, N'NGUYEN VAN NGHI', N'GO VAP', N'P7', N'HCM', N'VIET NAM')
GO
INSERT INTO [Address](NumHome, [Name], Ward, County, City, Country)
VALUES(123, N'NGUYEN VAN NGHI', N'GO VAP', N'P7', N'HCM', N'VIET NAM')
GO
INSERT INTO Staff([Shift], LastName, FirstName, BirthDay, Gender, CCCD, NumPhone, IdAddress, Username, [Password], [Rank], Gmail)
VALUES(N'12H', N'TOAN', N'LE', '2003/09/27', 1, N'012475689453', N'0329011622', 1, N'ADMIN', N'0123456', 0, N'THAITOAN@GMAIL.COM')
GO

INSERT INTO Staff([Shift], LastName, FirstName, BirthDay, Gender, CCCD, NumPhone, IdAddress, Username, [Password], [Rank], Gmail)
VALUES(N'12H', N'THAO', N'LE', '2003/09/27', 1, N'012475469', N'0329011611', 1, N'nv001', N'0123456', 0, N'THAITOAN123@GMAIL.COM')
GO

INSERT INTO Supplier([Name], NumPhone, Gmail, IdAddress)
values(N'CTY AN KHANG', N'0123589654', N'ankhang@gmail.com', 1)
go
INSERT INTO Supplier([Name], NumPhone, Gmail, IdAddress)
values(N'CTY LONG CHAU', N'0254697532', N'logchau@gmail.com', 1)
go
INSERT INTO Customer([FirstName], LastName, BirthDay, Gender, CCCD, NumPhone, IdAddress)
Values(N'Le', N'Van Tam', '12/12/2003', 1, N'125478965422', N'02489631258', 2)
Go

INSERT INTO Customer([FirstName], LastName, BirthDay, Gender, CCCD, NumPhone, IdAddress)
Values(N'Le', N'Thi Nga', '12/10/2003', 0, N'125478965533', N'02489631488', 2)
Go

INSERT INTO Medicine(RegisNumber,NameMedicine,Class,GroupMedicine,Active,Content,CoverForm,Packing ,[Standard],IdSupplier,DateManufacture,DateOut,Unit,PriceEnter,UnitPrice ,NumImport,DateImport,PriceOut, AmountNow, UnitRetail, ProNumOut)
VALUES(N'1', N'THUOC CAM', N'ABC', N'ABC', N'ABG', N'1 NGAY 2 LAN', N'ASG', N'ASG', N'ASG', 1, '2022/12/10', '2023/12/31', N'2', 20000.0, 20000.0, 50, '2022/12/10', 20000.0,200, N'20000', 20)
GO

INSERT INTO Medicine(RegisNumber,NameMedicine,Class,GroupMedicine,Active,Content,CoverForm,Packing ,[Standard],IdSupplier,DateManufacture,DateOut,Unit,PriceEnter,UnitPrice ,NumImport,DateImport,PriceOut, AmountNow, UnitRetail, ProNumOut)
VALUES(N'2', N'THUOC HO', N'ABC', N'ABC', N'ABG', N'1 NGAY 2 LAN', N'ASG', N'ASG', N'ASG', 1, '2022/12/10', '2023/12/31', N'2', 20000.0, 20000.0, 50, '2022/12/10', 20000.0,200, N'20000', 20)
GO





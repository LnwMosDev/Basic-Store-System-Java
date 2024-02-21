-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2024 at 03:50 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cit3535`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `commission` ()   BEGIN
	SELECT employeeCode,employeeName,sum(price*qty)*0.15 as commission
  FROM orderdetail 
    join customerorder USING(orderNo)
    JOIN employee USING(employeeCode)
    group by employeeCode;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cursor_sum` ()   BEGIN
    DECLARE done BOOLEAN DEFAULT FALSE;
    DECLARE sprice INT DEFAULT 0;
    DECLARE sqty INT DEFAULT 0;
    DECLARE sum1 INT DEFAULT 0;

    DECLARE myCursor CURSOR FOR
        SELECT price, qty FROM orderdetail;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN myCursor;
    read_loop: LOOP
        FETCH myCursor INTO sprice, sqty;

        IF done THEN
            LEAVE read_loop;
        END IF;

        SET sum1 = sum1 + (sprice * sqty);
    END LOOP;

    CLOSE myCursor;

    SELECT sum1 AS TotalSum;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteOrderDetail` (IN `no` INT(8), IN `code` INT(4))   BEGIN
		DELETE  from orderdetail
		WHERE orderNo=no and itemCode=code;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteTableColumn` (IN `name1` VARCHAR(100), IN `columnName` VARCHAR(100), IN `name2` VARCHAR(100))   BEGIN
	DECLARE command varchar(250);
    set @command=concat('delete from ',name1,' where ',columnName,' = ',name2 ) ;
    prepare statement from @command;
    EXECUTE statement;
	deallocate prepare statement;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findOrderDetail` (IN `no` INT(8))   begin
   select orderNo,orderdetail.itemCode,itemName,orderdetail.price,orderdetail.qty,orderdetail.price*orderdetail.qty as total
   from orderdetail 
    JOIN item USING(itemCode)
   where orderNo=no;
  end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getItemMaxPrice` ()   BEGIN
declare MaxP int;
set MaxP=(SELECT MAX(price) FROM item);
SELECT * FROM item WHERE price =  MaxP;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `initCustomerTotalSale` (IN `cusCode` INT)   BEGIN
	declare x int;
	SET x = (SELECT SUM(price * qty) AS total
                         FROM customerorder
             			JOIN orderdetail USING(orderNo)
                         WHERE customerCode = cusCode);
                         

 	UPDATE customer
   	 	SET totalSale = x
    	WHERE customerCode = cusCode;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `initEmployeeTotalSale` (IN `empCode` INT)   BEGIN
	declare x int;
	SET x = (SELECT SUM(price * qty) AS total
                         FROM customerorder
             			JOIN orderdetail USING(orderNo)
                         WHERE employeeCode = empCode);
                         

 	UPDATE employee
   	 	SET totalSale = x
    	WHERE employeeCode = empCode;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCustomerOrder` (IN `date1` DATE, IN `cusCode` INT, IN `empCode` INT, IN `tot` INT)   BEGIN
	INSERT INTO customerorder (orderDate, customerCode, employeeCode, total)
	VALUES (date1, cusCode, empCode, tot);

	UPDATE customer
	SET totalSale = (SELECT SUM(price * qty) AS total 
					FROM customerorder 
					WHERE customerorder.CustomerCode = cusCode);

	UPDATE employee
	SET totalSale = (SELECT SUM(price * qty) AS total 
					FROM customerorder 
					WHERE customerorder.EmployeeCode = empCode);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertItem` (IN `code` INT(5), IN `name` VARCHAR(100), IN `price` INT, IN `qty` INT, IN `type` INT)   BEGIN
	INSERT INTO item VALUES(code,name,price,qty,type);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `MaxCommis` ()   BEGIN
	SELECT employeeCode,Max(commission) from
	(select employeeCode,sum(price*qty)*0.15 as commission
	FROM orderdetail 
	join customerorder USING(orderNo)
	group by employeeCode) as t1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `saleYear` ()   BEGIN
        SELECT LEFT(orderDate, 4) as "ปี", SUM(price * qty) as "ยอดขายสินค้า" 
        FROM customerorder 
        JOIN orderdetail USING(orderNo)
        GROUP BY LEFT(orderDate, 4);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `saleYear2` (IN `year1` INT)   BEGIN
        SELECT year(orderDate) as "ปี",month(orderDate) as "เดือน",monthname(orderDate), SUM(price * qty) as "ยอดขายสินค้า" 
        FROM customerorder 
        JOIN orderdetail USING(orderNo)
        WHERE year(orderDate)=year1
        GROUP BY เดือน;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectData` (IN `tableName` VARCHAR(100))   BEGIN
	DECLARE command varchar(250);
    set @command=concat('select * from ',tableName) ;
    prepare statement from @command;
    EXECUTE statement;
	deallocate prepare statement;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectItem` ()   BEGIN
	SELECT * FROM item;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showCustomerorderCursor` ()   BEGIN   
DECLARE done BOOLEAN ;
     DECLARE  corderNo INT;
     DECLARE  corderDate varchar(100);
     DECLARE  ccustomerCode int;
     DECLARE  cemployeeCode varchar(100);
     DECLARE  ctotal int;
    DECLARE customerName1 varchar(100);
    DECLARE employeeName1 varchar(100);

    DECLARE myCursor CURSOR FOR SELECT * FROM customerorder;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN myCursor;

    read_loop: LOOP
          FETCH myCursor INTO corderNo, corderDate,ccustomerCode,cemployeeCode,ctotal ;
         
        IF done THEN
            LEAVE read_loop;
        END IF;
        select customerName into customerName1 from customer WHERE customerCode=ccustomerCode;
        SELECT employeeName into employeeName1 from employee where employeeCode=cemployeeCode;
         SELECT corderNo,getDateThai(corderDate),ccustomerCode,cemployeeCode,ctotal,customerName1,employeeName1;
 
    END LOOP;
    CLOSE myCursor;
  
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showDepartment_cursor` ()   BEGIN
    DECLARE sCode INT ;
    DECLARE sName varchar(100);
 	DECLARE done BOOLEAN ;
    
    DECLARE myCursor CURSOR FOR SELECT * FROM department;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN myCursor;
    
		loop1: LOOP
        FETCH myCursor INTO sCode , sName;   
        SELECT sCode, sName ;
        IF done THEN
        	CLOSE myCursor;
            LEAVE loop1;
        END IF;
    END LOOP;
  
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNameColumn` (IN `name` VARCHAR(100), IN `columnName` VARCHAR(100))   BEGIN
	DECLARE command varchar(250);
    set @command=concat('select ',columnName,' ','from',' ', name) ;
    prepare statement from @command;
    EXECUTE statement;
	deallocate prepare statement;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNumber` ()   BEGIN
	DECLARE i int DEFAULT 1;
	DECLARE ms varchar(100) DEFAULT '';
	loop1:Loop
    	set ms=concat(ms,' ',i);
        SET i=i+1;
        if i>10 THEN
        	LEAVE loop1;
        end IF;
    end Loop loop1;
SELECT ms;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNumber2` (IN `no` INT)   BEGIN
    DECLARE i int DEFAULT no;
     declare ms varchar(100) DEFAULT '';
    loop1:LOOP
        set ms= concat(ms,' ',i,',');
        set i=i-1;
        if i<1 THEN
            leave loop1;
        end if;
    end LOOP loop1;
    SELECT ms;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNumber3` (IN `no` INT)   BEGIN
	DECLARE i int DEFAULT 2;
    DECLARE ms varchar(100) DEFAULT '';
    loop1:Loop
    	set ms=concat(ms,' ',i);
        	set i=i+2;
            if i>no THEN
            	leave loop1;
            end if;
    end Loop loop1;
    select ms;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNumber4` (IN `a` INT, IN `no` INT)   BEGIN   
 DECLARE i INT;
    DECLARE ms VARCHAR(100) DEFAULT '';
    IF a % 2 <> 0 THEN
        SET a = a + 1;
    END IF;
    SET i = a;
    loop1:LOOP
        SET ms = CONCAT(ms, ' ', i);
        SET i = i + 2;
        IF i > no THEN
            LEAVE loop1;
        END IF;
    END LOOP loop1;
    SELECT ms AS EvenNumbersInRange;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNumber5` (IN `a` INT, IN `no` INT)   BEGIN
    DECLARE i INT;
    DECLARE ms VARCHAR(100) DEFAULT '';
    IF a % 2 = 0 THEN
        SET a = a + 1;
    END IF;
    SET i = a;
    loop1:LOOP
        SET ms = CONCAT(ms, ' ', i);
        SET i = i + 2;
        IF i > no THEN
            LEAVE loop1;
        END IF;
    END LOOP loop1;
    SELECT ms AS OddNumbersInRange;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNumberWhileDo` ()   BEGIN
    DECLARE i INT DEFAULT 10;
    DECLARE ms VARCHAR(100) DEFAULT '';
    
    loop1: WHILE i >= 1 DO
        SET ms = CONCAT(ms, ' ', i, ',');
        SET i = i - 1;
    END WHILE loop1;
    
    SELECT ms;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showNumberWhileDO2` (IN `a` INT, IN `no` INT)   BEGIN
    DECLARE i int DEFAULT a;
    declare ms varchar(100) DEFAULT '';
     WHILE i<=no DO
        IF i % 2 = 0 THEN
            SET ms = CONCAT(ms, ' ', i);
        END IF;
        SET i = i + 1;
    END while;
    SELECT ms;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showOrder` ()   BEGIN
		SELECT orderNo,orderDate,customerCode,customerName,employeeCode,employeeName
        FROM customerorder
        JOIN customer USING(customerCode)
        JOIN employee USING(employeeCode);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showtotalItemCur` ()   BEGIN
    DECLARE done BOOLEAN DEFAULT FALSE;
    DECLARE ctype INT;
    DECLARE ntype varchar(100);
    DECLARE total int;
    
    DECLARE cur1 CURSOR FOR SELECT * FROM itemtype ;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur1;
    read_loop: LOOP
        FETCH cur1 INTO ctype, ntype;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SELECT sum(price*qty)INTO total FROM item WHERE typeCode=ctype;
        SELECT ctype,ntype,total;
    END LOOP;
    CLOSE cur1;
 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sumBillSale` (IN `no` INT)   BEGIN
select orderNo,sum(orderdetail.price*orderdetail.qty) as total
   from orderdetail 
   where orderNo=no;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sumItem` ()   BEGIN
    SELECT sum(price*qty)as total from item;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateItem` (IN `code` INT(5), IN `name` VARCHAR(100), IN `price` INT, IN `qty` INT)   BEGIN
	UPDATE item set  itemName=name,price=price,qty=qty WHERE itemCode=code;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStock` (IN `code` INT, IN `qty` INT)   BEGIN
		 UPDATE item set qty=qty WHERE itemCode=code;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateTableColumn` (IN `tablename` VARCHAR(100), IN `name2` VARCHAR(100), IN `name3` VARCHAR(100), IN `columnName` VARCHAR(100), IN `name4` VARCHAR(100))   BEGIN
	DECLARE command varchar(250);
    set @command=concat('update ',tablename,' set ',name2,' = ',name3 ,' where ' , columnName, ' = ' , name4) ;
    prepare statement from @command;
    EXECUTE statement;
	deallocate prepare statement;
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `getDateThai` (`date1` DATE) RETURNS VARCHAR(50) CHARSET utf8mb4 COLLATE utf8mb4_general_ci  BEGIN
    DECLARE days varchar(50) DEFAULT day(date1);
    DECLARE years varchar(50) DEFAULT year(date1);
      DECLARE months varchar(50) DEFAULT month(date1);
     DECLARE result VARCHAR(100) DEFAULT "";
   
set result = CONCAT(days,' ',getMonthName(months),' ',years+543);
RETURN result;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getDayName` (`no` INT) RETURNS VARCHAR(50) CHARSET utf8mb4 COLLATE utf8mb4_general_ci  BEGIN
	DECLARE dayName varchar(50) DEFAULT '';
    case no
    	when 1 THEN set dayName='Monday';
        when 2 THEN set dayName='Tuesday';
        when 3 THEN set dayName='Wednesday';
        when 4 THEN set dayName='Tuesday';
        when 5 THEN set dayName='Friday';
        when 6 THEN set dayName='Saturday';
        when 7 THEN set dayName='Sunday';
     END CASE;
     return dayName;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getGrade` (`score` INT) RETURNS VARCHAR(5) CHARSET utf8mb4 COLLATE utf8mb4_general_ci  BEGIN
	DECLARE scoreGrade varchar(5) DEFAULT '';
    case
    	when score>=80 AND score<=100 THEN set scoreGrade='A';
        when score>=75 AND score<=79 THEN set scoreGrade='B+';
        when score>=70 AND score<=74 THEN set scoreGrade='B';
        when score>=60 AND score<=69 THEN set scoreGrade='C+';
        when score>=50 AND score<=59 THEN set scoreGrade='C';
        when score>=45 AND score<=49 THEN set scoreGrade='D+';
        when score>=40 AND score<=44 THEN set scoreGrade='D';
        when score<=39 THEN set scoreGrade='F';
     END CASE;
     return scoreGrade;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getMonthName` (`month` INT) RETURNS VARCHAR(50) CHARSET utf8mb4 COLLATE utf8mb4_general_ci  BEGIN
    DECLARE monthName VARCHAR(50) DEFAULT '';
    CASE month
        WHEN 1 THEN SET monthName = 'มกราคม';
        WHEN 2 THEN SET monthName = 'กุมภาพันธ์';
        WHEN 3 THEN SET monthName = 'มีนาคม';
        WHEN 4 THEN SET monthName = 'เมษายน';
        WHEN 5 THEN SET monthName = 'พฤษภาคม';
        WHEN 6 THEN SET monthName = 'มิถุนายน';
        WHEN 7 THEN SET monthName = 'กรกฎาคม';
        WHEN 8 THEN SET monthName = 'สิงหาคม';
        WHEN 9 THEN SET monthName = 'กันยายน';
        WHEN 10 THEN SET monthName = 'ตุลาคม';
        WHEN 11 THEN SET monthName = 'พฤศจิกายน';
        WHEN 12 THEN SET monthName = 'ธันวาคม';
END CASE;
RETURN monthName;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `showNumder1` (`no` INT) RETURNS INT(11)  BEGIN
    DECLARE i int DEFAULT 1;
    declare ms int DEFAULT 0;
    loop1:LOOP
         set ms=ms+i;
        set i=i+1;
        if i>no THEN
            leave loop1;
        end if;
    end LOOP loop1;
    RETURN ms;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `totalAmount` () RETURNS INT(11)  BEGIN
	DECLARE t int;
	select sum(total) into t from customerorder;
    return t;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerCode` int(4) UNSIGNED ZEROFILL NOT NULL,
  `customerName` varchar(100) NOT NULL,
  `address` varchar(250) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `totalSale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerCode`, `customerName`, `address`, `tel`, `totalSale`) VALUES
(0001, 'นายสมหมาย', 'CRRU', '1111111111', 145615),
(0002, 'นายสง่า', 'Bandu', '2222222222', 53150),
(0003, 'นางสาวปราณี', '', '3333333333', 24045),
(0004, 'นายอภิชาติ', '', '', 112780),
(0005, 'นางอารีย์', '', '', 135350),
(0006, 'นายพิชิต', '', '', 28430),
(0007, 'นางกัลยา', '', '', 61095),
(0008, 'นางสาวก้อย', '', '', 108090),
(0009, 'นายวิภพ', '', '', 40790),
(0010, 'นางเดือนเพ็ญ', '', '', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `customerorder`
--

CREATE TABLE `customerorder` (
  `orderNo` int(8) UNSIGNED ZEROFILL NOT NULL,
  `orderDate` date NOT NULL,
  `customerCode` int(4) UNSIGNED ZEROFILL NOT NULL,
  `employeeCode` int(3) UNSIGNED ZEROFILL NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerorder`
--

INSERT INTO `customerorder` (`orderNo`, `orderDate`, `customerCode`, `employeeCode`, `total`) VALUES
(00000001, '2021-01-21', 0001, 001, 8200),
(00000002, '2021-01-21', 0004, 003, 3180),
(00000003, '2021-01-21', 0005, 004, 29000),
(00000004, '2021-01-21', 0003, 002, 4295),
(00000005, '2021-01-21', 0001, 001, 26115),
(00000006, '2021-01-21', 0007, 001, 19980),
(00000007, '2022-01-21', 0004, 003, 26000),
(00000008, '2022-01-21', 0005, 004, 4350),
(00000009, '2022-01-21', 0009, 005, 5000),
(00000010, '2022-01-21', 0010, 001, 15000),
(00000011, '2013-02-21', 0002, 008, 3150),
(00000012, '2013-02-21', 0003, 004, 6400),
(00000013, '2013-02-21', 0004, 007, 4650),
(00000014, '2013-02-21', 0008, 001, 68200),
(00000015, '2013-02-21', 0009, 002, 35000),
(00000016, '2020-02-21', 0001, 004, 750),
(00000017, '2020-02-21', 0007, 005, 475),
(00000018, '2020-02-21', 0008, 008, 5640),
(00000019, '2021-04-21', 0009, 003, 790),
(00000020, '2021-04-21', 0001, 007, 5950),
(00000021, '2021-04-21', 0005, 002, 52000),
(00000022, '2021-04-21', 0007, 003, 20640),
(00000023, '2019-04-21', 0008, 004, 30000),
(00000024, '2019-04-21', 0006, 002, 300),
(00000025, '2019-04-21', 0001, 005, 61000),
(00000026, '2020-04-21', 0004, 008, 75000),
(00000027, '2020-04-21', 0006, 003, 3130),
(00000028, '2013-05-21', 0001, 001, 13600),
(00000029, '2021-06-21', 0002, 002, 50000),
(00000030, '2021-06-21', 0003, 007, 13350),
(00000031, '2021-01-22', 0001, 001, 30000),
(00000032, '2021-01-22', 0005, 003, 50000),
(00000033, '2022-01-22', 0007, 004, 20000),
(00000034, '2022-01-22', 0004, 005, 3950),
(00000035, '2022-01-22', 0006, 001, 25000),
(00000036, '2023-11-01', 0008, 003, 4250),
(00000555, '2024-02-05', 0005, 005, 222);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `departmentCode` int(2) UNSIGNED ZEROFILL NOT NULL,
  `departmentName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`departmentCode`, `departmentName`) VALUES
(01, 'Accounting'),
(02, 'Marketing'),
(03, 'Personnel');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employeeCode` int(3) UNSIGNED ZEROFILL NOT NULL,
  `employeeName` varchar(100) NOT NULL,
  `sex` char(1) NOT NULL,
  `departmentCode` int(2) UNSIGNED ZEROFILL NOT NULL,
  `totalSale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeCode`, `employeeName`, `sex`, `departmentCode`, `totalSale`) VALUES
(001, 'ทิพวรรณ', 'F', 01, 206095),
(002, 'วิโรจน์', 'M', 02, 141595),
(003, 'จิณณวัตร', 'M', 01, 107990),
(004, 'ทศพล', 'M', 03, 90500),
(005, 'ไพรัตน์', 'F', 01, 70425),
(006, 'นที', 'F', 03, 0),
(007, 'จารุเศรษฐ์', 'M', 03, 23950),
(008, 'นรินทร์', 'F', 02, 83790),
(009, 'เรวัตร', 'M', 02, 0),
(010, 'วัฒนา', 'M', 02, 0);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `itemCode` int(4) UNSIGNED ZEROFILL NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `typeCode` int(2) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itemCode`, `itemName`, `price`, `qty`, `typeCode`) VALUES
(0001, 'ปากกา', 25, 100, 01),
(0002, 'พัดลม', 1200, 10, 02),
(0003, 'ตู้เย็น', 7000, 5, 02),
(0004, 'กระดาษถ่ายเอกสาร 80 แกรม', 110, 100, 06),
(0005, 'คัตเตอร์', 45, 200, 06),
(0006, 'เสื้อสูทชาย', 3000, 3, 03),
(0007, 'เสื้อสูทหญิง', 2000, 6, 03),
(0008, 'น้ำองุ่น', 55, 20, 05),
(0009, 'ยาสระผม', 75, 10, 05),
(0010, 'แอร์บ้านแบบแขวน', 25000, 4, 02),
(0011, 'ดินสอ', 100, 300, 06),
(0012, 'น้ำเปล่า 1.50 ลิตร', 15, 200, 05),
(0013, 'ยาสีฟัน', 125, 50, 05),
(0014, 'notebook', 30000, 5, 01),
(0015, 'ที่เหลาดินสอ', 250, 10, 06),
(0016, 'น้ำอัดลม 750 ซีซี', 10, 60, 05),
(0017, 'ตู้เอกสาร', 1200, 5, 06),
(0018, 'แฟ้มใส่เอกสารแบบห่วง', 110, 50, 06),
(0019, 'น้ำยาล้างจาน', 20, 70, 05),
(0020, 'ลำโพงคอมพิวเตอร์', 300, 40, 01),
(0021, 'ไมโครเวป', 3950, 16, 02),
(0022, 'ยางลบ', 10, 400, 06),
(0023, 'Flash Drive', 300, 20, 01),
(0024, 'ผักคะน้า 1 กิโลกรัม', 50, 10, 04),
(0025, 'เครื่องซักผ้า', 20000, 5, 02),
(0026, 'เนื้อหมู 1 กิโลกรัม', 180, 20, 04),
(0027, 'พัดลมดูดอากาศ', 800, 60, 02),
(0028, 'ไข่ 1 แพค', 40, 30, 04),
(0029, 'ทีวีดิจิตอล 60 นิ้ว', 50000, 2, 02),
(0030, 'ไม้บรรทัด', 35, 300, 06),
(2424, 'มาม่า', 7, 100, 04);

-- --------------------------------------------------------

--
-- Table structure for table `itemtype`
--

CREATE TABLE `itemtype` (
  `typeCode` int(2) UNSIGNED ZEROFILL NOT NULL,
  `typeName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `itemtype`
--

INSERT INTO `itemtype` (`typeCode`, `typeName`) VALUES
(07, 'test'),
(01, 'คอมพิวเตอร์'),
(04, 'อาหาร'),
(06, 'อุปกรณ์สำนักงาน'),
(05, 'อุปโภค-บริโภค'),
(02, 'เครื่องใช้ไฟฟ้า'),
(03, 'เสื้อผ้า');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `orderNo` int(8) UNSIGNED ZEROFILL NOT NULL,
  `itemCode` int(4) UNSIGNED ZEROFILL NOT NULL,
  `price` int(11) NOT NULL,
  `qty` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`orderNo`, `itemCode`, `price`, `qty`) VALUES
(00000001, 0002, 1200, 1),
(00000001, 0003, 7000, 1),
(00000002, 0004, 100, 10),
(00000002, 0005, 49, 20),
(00000002, 0017, 1200, 1),
(00000003, 0014, 29000, 1),
(00000004, 0021, 3900, 1),
(00000004, 0026, 180, 2),
(00000004, 0028, 35, 1),
(00000005, 0019, 23, 10),
(00000005, 0020, 300, 20),
(00000005, 0021, 3950, 5),
(00000005, 0022, 9, 15),
(00000006, 0025, 19000, 1),
(00000006, 0026, 180, 1),
(00000006, 0027, 800, 1),
(00000007, 0010, 26000, 1),
(00000008, 0020, 300, 1),
(00000008, 0021, 3950, 1),
(00000008, 0022, 10, 10),
(00000009, 0006, 3000, 1),
(00000009, 0007, 2000, 1),
(00000010, 0003, 7500, 2),
(00000011, 0011, 100, 5),
(00000011, 0012, 15, 10),
(00000011, 0013, 125, 20),
(00000012, 0015, 250, 2),
(00000012, 0016, 10, 40),
(00000012, 0017, 1200, 1),
(00000012, 0018, 110, 20),
(00000012, 0019, 20, 30),
(00000012, 0020, 300, 5),
(00000013, 0021, 3950, 1),
(00000013, 0022, 10, 10),
(00000013, 0023, 300, 2),
(00000014, 0005, 45, 10),
(00000014, 0006, 3000, 2),
(00000014, 0007, 2000, 3),
(00000014, 0008, 55, 50),
(00000014, 0009, 75, 40),
(00000014, 0010, 25000, 2),
(00000015, 0010, 35000, 1),
(00000016, 0012, 15, 50),
(00000017, 0009, 75, 3),
(00000017, 0013, 125, 2),
(00000018, 0004, 110, 5),
(00000018, 0005, 45, 2),
(00000018, 0006, 3000, 1),
(00000018, 0007, 2000, 1),
(00000019, 0015, 250, 3),
(00000019, 0016, 10, 4),
(00000020, 0019, 20, 5),
(00000020, 0020, 300, 6),
(00000020, 0021, 3950, 1),
(00000020, 0022, 10, 10),
(00000021, 0003, 7000, 1),
(00000021, 0029, 45000, 1),
(00000022, 0024, 50, 2),
(00000022, 0025, 20000, 1),
(00000022, 0026, 180, 3),
(00000023, 0023, 300, 100),
(00000024, 0022, 15, 20),
(00000025, 0014, 30000, 2),
(00000025, 0023, 250, 4),
(00000026, 0010, 25000, 3),
(00000027, 0017, 1200, 2),
(00000027, 0018, 110, 3),
(00000027, 0019, 20, 5),
(00000027, 0020, 300, 1),
(00000028, 0003, 6800, 2),
(00000029, 0029, 50000, 1),
(00000030, 0002, 1200, 2),
(00000030, 0003, 7000, 1),
(00000030, 0021, 3950, 1),
(00000031, 0014, 30000, 1),
(00000032, 0029, 50000, 1),
(00000033, 0025, 20000, 1),
(00000034, 0021, 3950, 1),
(00000035, 0010, 25000, 1),
(00000036, 0001, 25, 80),
(00000036, 0005, 45, 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerCode`);

--
-- Indexes for table `customerorder`
--
ALTER TABLE `customerorder`
  ADD PRIMARY KEY (`orderNo`),
  ADD KEY `customerorder_ibfk_1` (`customerCode`),
  ADD KEY `customerorder_ibfk_2` (`employeeCode`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`departmentCode`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeCode`),
  ADD KEY `departmentCode` (`departmentCode`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`itemCode`),
  ADD KEY `typeCode` (`typeCode`);

--
-- Indexes for table `itemtype`
--
ALTER TABLE `itemtype`
  ADD PRIMARY KEY (`typeCode`),
  ADD UNIQUE KEY `typeName` (`typeName`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`orderNo`,`itemCode`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customerorder`
--
ALTER TABLE `customerorder`
  ADD CONSTRAINT `customerorder_ibfk_1` FOREIGN KEY (`customerCode`) REFERENCES `customer` (`customerCode`),
  ADD CONSTRAINT `customerorder_ibfk_2` FOREIGN KEY (`employeeCode`) REFERENCES `employee` (`employeeCode`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentCode`) REFERENCES `department` (`departmentCode`);

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`typeCode`) REFERENCES `itemtype` (`typeCode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

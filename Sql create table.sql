create table LOCATION
(
Location_ID INT Primary Key,
regional_Group varchar2(5)
);

create table Department
(
Department_ID INT Primary key,
Name varchar2(15),
Location_ID INT Foreign key references Location(Location_ID)
);

create table JOB
(
JOB_ID INT Primary Key,
Function varchar2(15)
);

create table EMPLOYEE
(
	Employee_ID INT primary key,
 	Last_Name varchar2(15),
 	First_Name varchar2(15),
 	Middle_Name varchar2(15),
 	Job_ID INT Foreign key references JOB(JOB_ID)
 	Manager_ID INT,
	HireDate Date,
 	Salary Number,
 	Comm Number,
 	Department_ID INT Foreign key references Department(Department_ID)
);

1)
ALTER TABLE LOCATION ALTER COLUMN regional_group VARCHAR2(15);

2)
INSERT INTO LOCATION
VALUES (122,'NEW YORK');

INSERT INTO LOCATION
VALUES (123,'DALLAS');

INSERT INTO DEPARTMENT
VALUES (10,'ACCOUNTING',122);

INSERT INTO JOB
VALUES (667,'CLERK');

INSERT INTO EMPLOYEE
VALUES (7369,'SMITH','JOHN','Q',667,7902,17-DEC-84,800,NULL,20);

3)
Select Employee_id,Last_Name,First_Name,Salary
From Employee

4)
SElect *
from Employees
where salary between 2000 and 4500;

5)
SELECT *
FROM EMPLOYEES
Where First_Name like 'S___';

6)
SELCT *
from employees
order by last_name,salary desc;

7)
Select Department_id,max(salary),min(salary),avg(sal)
From department,Employees
group by Department_id;

8)
select count(employee_id),Month(HireDate)
from Employees
group by Month(Hiredate);

9)
select count(Employee_id)
from Employee
where Month(date)='03' AND Year(date)='1985';

10)
select Employee.*
from Employee,Department
where Name='Sales';

11)
select *
from Employee
where salary=max(salary);

12)
select *
from Employee
group by department_id
having salary=max(salary)
where department_id=30;

13)<!--QUESTION nai samja muje -_- >

14)
???????

15)
update Employee
set salaray=salary+salary*0.1
where department_id IN(select department_id
						from Department
						where Name='Clerk');

16)
Create view detail AS
select Employee.*,Name
from Employee,Department
where Employee.Department_id=Department.Department_id;

17)
Create Trigger trigg
After update on Department
for each row
begin
  update Employee
  set department_id=new.Department_id
	where department_id=old.department_id;
end trigg;

<!--====>
Q2)

create table LOCATION
(
Location_ID INT Primary Key,
regional_Group varchar2(5)
);

create table Department
(
Department_ID INT Primary key,
Name varchar2(15),
Location_ID INT Foreign key references Location(Location_ID)
);

create table JOB
(
JOB_ID INT Primary Key,
Function varchar2(15)
);

create table EMPLOYEE
(
	Employee_ID INT primary key,
 	Last_Name varchar2(15),
 	First_Name varchar2(15),
 	Middle_Name varchar2(15),
 	Job_ID INT Foreign key references JOB(JOB_ID)
 	Manager_ID INT,
	HireDate Date,
 	Salary Number,
 	Comm Number,
 	Department_ID INT Foreign key references Department(Department_ID)
);

1)
ALTER TABLE Department ALTER COLUMN  VARCHAR2(15);

2)
INSERT INTO LOCATION
VALUES (122,'NEW YORK');

INSERT INTO LOCATION
VALUES (123,'DALLAS');

INSERT INTO DEPARTMENT
VALUES (10,'ACCOUNTING',122);

INSERT INTO JOB
VALUES (667,'CLERK');

INSERT INTO EMPLOYEE
VALUES (7369,'SMITH','JOHN','Q',667,7902,17-DEC-84,800,NULL,20);

3)
Select Employee_id 'ID of the Employee',Last_Name 'Name of the Employee',Department_id 'Department id'
From Employee

4)
Select *
from Employee
where department_id=10 OR department_id=20;

5)
Select *
from Employee
where First_Name like 'S%H'

6)
Select *
from Employee
order by Last_name,Department_id desc;

7)
Select Department_id,count(Employee_id)
form Employee
group by Department_id;

8)
Select Job_id,max(salary),min(salary),avg(salary)
from Employee
group by Job_id;

9)
Select department_id
From Employee
group by department_id
having count(department_id)>=4;

10)
Select count(employee_id)
from employee
where Year(HireDate)='1985';

11)
Select Employee.*
From Employee,Job
where Job_id IN(Select Job_ID
						From Job
						where Function='Clerk');
						
12)
select *
from Employee
where salary>max(salary) AND Department_id=30;

13)
Select Employee.*,Name
From Employee,Department
Where Employee_id=Department_id;

14)
delete 
from Employee
where Department_id IN(Select department_id
						from Department
							where Name='Accounting');
						
15)
Create view detail AS
select Employee.*,Name
from Employee,Department
where Employee.Department_id=Department.Department_id;

16)
Create Trigger trigg
After update on Job
for each row
begin
  update Employee
  set JOb_id=new.Job_id
	where Job_id=old.Job_id;
end trigg;

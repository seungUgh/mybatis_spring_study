CREATE TABLE DEPARTMENT(
	deptno NUMBER NOT null,
	deptname VARchar2(50) NOT null,
	floor NUMBER null,
	PRIMARY key(deptno)
);

CREATE TABLE EMPLOYEE(
	empno NUMBER NOT null PRIMARY key,
	empname varchar2(50) NOT null,
	title varchar2(50) null,	
	manager NUMBER null,
	salary NUMBER null,
	dno NUMBER null,
	FOREIGN key(manager) REFERENCES employee(empno),
	FOREIGN key(dno) REFERENCES department(deptno)
);

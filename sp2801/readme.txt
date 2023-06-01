pom.xml 의존성 추가 시 https://mvnrepository.com/ 에서 검색해서 넣을 것 (STS에서 안되는 경우)

[sp28] SQL 문 

create table board (
    mId number(4) primary key,
    mWriter varchar2(100),
    mContent varchar2(300)
    );
    
COMMIT;

create sequence board_seq;


[sp25-tmp] 
1. 프로젝트에 서버 라이브러리 추가 
		프로젝트명 [마우스 우클릭] >> Build Path >> Add Libraries >> Server Runtime
2. 서버런타임 라이브러리 추가 없이 사용 
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
			<scope>provided</scope>
		</dependency>

[sp22-oracle-01] 트랜잭션 


[sp21-oracle-02 : contentView() 변경] JDBC 를 이용한 코드축약 
1. contentView() 수정
	upHit(strID);
	String query = "select * from mvc_board where bId = ?";
	return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
2. upHit() 수정
3. write() 수정
4. ...


[sp21-oracle-01 : list 변경] JDBC 를 이용한 코드축약 
1. pom.xml 추가
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>
		
		${org.springframework-version} 은 구버젼인 3.1.1 사용

2. servlet-context.xml 추가
	<beans:bean name="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<beans:property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<beans:property name="url" value="jdbc:oracle:thin:@localhost:1521:xe" />
		<beans:property name="username" value="scott" />
		<beans:property name="password" value="tiger" />
	</beans:bean>

	<beans:bean name="template" class="org.springframework.jdbc.core.JdbcTemplate">
		<beans:property name="dataSource" ref="dataSource"/>
	</beans:bean>	

3. 순서대로 진행 후 다음 추가
BController 의 setTemplate() 메소드에 
		Constant.template = this.template;
추가
	

[sp16-oracle-01]
[오라클 DB 설정]
1. oracle 11g express db 설치
2. Oracle SQL Developer 설치
3. SQL 설정(사용자생성, 테이블생성)
4. 오라클용 jdbc 파일 복사 "C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar" 을 "C:\Program Files\Java\jre1.8.0_172\lib\ext" 디렉토리로 복사
5. 서버설정수정


[DOS & SQL명령]
MSDOS> sqlplus system/oracle
SQL> create user scott identified by tiger; 
SQL> grant connect, resource to scott;
SQL> exit
MSDOS>> sqlplus scott/tiger
SQL> CREATE SEQUENCE mvc_board_seq;

DROP TABLE mvc_board;
CREATE table mvc_board(
    bId NUMBER(4) PRIMARY KEY,
    bName VARCHAR2(20),
    bTitle VARCHAR2(100),
    bContent VARCHAR2(300),
    bDate DATE DEFAULT SYSDATE,
    bHit NUMBER(4) DEFAULT 0,
    bGroup NUMBER(4),
    bStep NUMBER(4),
    bIndent NUMBER(4)
    );
    
DROP SEQUENCE mvc_board_seq;
CREATE SEQUENCE mvc_board_seq;

INSERT INTO mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) 
    values (mvc_board_seq.nextval, 'abcd', 'is title', 'is content', 0, mvc_board_seq.currval, 0, 0);
INSERT INTO mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) 
    values (mvc_board_seq.nextval, 'joy', 'Happy man', '그는 항상 행복합니다.', 0, mvc_board_seq.currval, 0, 0);


[server 설정]
1. Tomcat 7.0 의 context.xml 설정

<Resource auth="Container"
	driverClassName = "oracle.jdbc.driver.OracleDriver"
	maxActive="50"
	maxWait="1000"
	name="jdbc/Oracle11g"
	username="scott"
	password="tiger"
	type="javax.sql.DataSource"
	url="jdbc:oracle:thin:@localhost:1521:xe"
/>
	
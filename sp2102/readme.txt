[sp21-oracle-02 : contentView() 변경] JDBC 를 이용한 코드축약 
1. contentView() 수정
	upHit(strID);
	String query = "select * from mvc_board where bId = ?";
	return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
2. upHit() 수정
3. write() 수정
4. ...


[sp2101]
jre11 대신 jre1.8 사용 -- JRE System Library 우클릭 -- properties - 1.8로 교체, 1.6(jre8)설정 
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

3. 순서대로 진행 
BController 클래스에 아래 줄 추가
	public JdbcTemplate template;

template - setter 추가 후 내용에 아래 줄 코드 추가 & @Autowired 어노테이션
	Constant.template = this.template;

--.util 패치지 & Constant 클래스 작성 & template 필드를 를 static 으로 생성 
	public static JdbcTemplate template;

4. 리스트 작성
BDao 클래스에 
	JdbcTemplate template = null; 필드추가
BDao 생성자에
	this.template = Constant.template; 추가 & 다른 내용 (나중 )삭제	
list() 수정
ArrayList<BDto> dtos = null;
	
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));

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
	
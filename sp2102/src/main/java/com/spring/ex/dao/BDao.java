package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.spring.ex.dto.BDto;
import com.spring.ex.util.Constant;

public class BDao {

	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public BDao() {
		// try 문을 이후 주석처리
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.template = Constant.template;
	}
	
	public void write(final String bName, final String bTitle, final String bContent) {

		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setString(1,bName);
				psmt.setString(2,bTitle);
				psmt.setString(3,bContent);
				return psmt;
			}
		});
	}
	
	public ArrayList<BDto> list() {
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public BDto contentView(final String strID) {
		
		upHit(strID);
		String query = "select * from mvc_board where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,  bName);
				ps.setString(2,  bTitle);
				ps.setString(3,  bContent);
				ps.setInt(4,  Integer.parseInt(bId));
			}
		});
	}
	
	public void delete(final String bId) {
		String query = "delete from mvc_board where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bId);
			}
		});
	}
	
	public BDto reply_view(String str) {
		String query = "select * from mvc_board where bId = " + str;
		return this.template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void reply( String bId,  final String bName,  final String bTitle,  final String bContent,  final String bGroup,  final String bStep,  final String bIndent) {
		replyShape(bGroup, bStep);

		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});		
	}
	
	private void replyShape(final String strGroup, final String strStep) {
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, strGroup);
				ps.setString(2, strStep);
			}
		});
	}
	
	private void upHit(final String bId) {
		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}
}

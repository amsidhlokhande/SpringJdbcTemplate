package com.amsidh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.amsidh.dao.CircleDao;
import com.amsidh.model.Circle;

@Component
public class CircleDaoImpl implements CircleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Circle getCircle(int circleId) {
		return null;

	}
	@SuppressWarnings("deprecation")
	public int getCircleCount()
	{
		String query="SELECT COUNT(*) FROM CIRCLE";
	    return jdbcTemplate.queryForInt(query);
	}
	
	public Circle getCircleById(int circleId)
	{
		String query="SELECT * FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(query, new Object[]{circleId},new CircleRowMapper());
	}
	@SuppressWarnings("unchecked")
	public List<Circle> getAllCircle()
	{
		String query="SELECT * FROM CIRCLE";
		return (List<Circle>) jdbcTemplate.query(query,new CircleRowMapper());
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	private static final class CircleRowMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rst, int rowNumber) throws SQLException {
			Circle circle=new Circle();
			circle.setId(rst.getInt("ID"));
			circle.setName(rst.getString("NAME"));
			return circle;
		}
		
	}
}

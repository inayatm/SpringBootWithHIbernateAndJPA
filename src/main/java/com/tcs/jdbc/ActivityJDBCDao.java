package com.tcs.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tcs.model.Activity;

@Repository
public class ActivityJDBCDao {

	//connection to database
	 /*
	  * 1.JdbcTemplate   - does not support named params and onlu support place holders (?)
	  * 2.NamedParameterJdbcTemplate  -- To support named parameter (:paramName) 
	  *    a. SqlNamedParameterSource ---> MapSqlNamedParaters
	  *    
	  * 3.SimpleJdbcTemplate  --> Support both place holders (?) , Named parameters
	  * 
	  * 
	  * */
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	 
	//Custom RowMapper can be used if the database columns and bean properties names are different.
	
	class ActivityRowMapper implements RowMapper<Activity>{
     
		@Override
		public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Activity activity=new Activity();
		  activity.setId(rs.getInt("id"));
		  activity.setDuration(rs.getString("duration"));
		  activity.setDescription(rs.getString("description"));
		  activity.setActivity_date(rs.getTimestamp("activity_date"));
		
			return activity;
		}
		
	}
	
	public List<Activity> findAllActvities(){
	//Default way 

	  //   return jdbcTemplate.query("SELECT * FROM ACTIVITY",new BeanPropertyRowMapper<Activity>(Activity.class));
		
		//using Custom Rowmapper
		return jdbcTemplate.query("SELECT * FROM ACTIVITY",new ActivityRowMapper());
		
		
	}
	
	public Activity findByid(int id) {
//		return jdbcTemplate.queryForObject("SELECT * FROM ACTIVITY WHERE ID=?",
//										new BeanPropertyRowMapper<Activity>(Activity.class),
//										new Object[] {id});
		
		return jdbcTemplate.queryForObject("SELECT * FROM ACTIVITY WHERE ID=?",
				new ActivityRowMapper(),
				new Object[] {id});
	}
	
	
	public int updateActivityById(int id) {
		
		//Timestamp tm=new Timestamp(new Date().getTime());
		
		return jdbcTemplate.update("UPDATE ACTIVITY SET DURATION=?,ACTIVITY_DATE=? where id=?",new Object[] {"10min",new Timestamp(new Date().getTime()),id});
	}
	
	public int deleteActiviyById(int id) {
	 return jdbcTemplate.update("DELETE ACTIVITY WHERE ID=?",new Object[] {id});
	}
	
	
	public int insertActivity(Activity activity) {
		
		return jdbcTemplate.update("INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE)"
								 + "VALUES(?,?,?,?)",
									 new Object[] {
									 activity.getId(),
									 activity.getDescription(),
									 activity.getDuration(),
								     new Timestamp(activity.getActivity_date().getTime())
								     
								     });
		
	}
}

package com.cloudea.concrete;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.SystemActivityDAO;
import com.cloudea.models.SystemActivity;

public class SystemActivityDAOImpl extends SqlServerConnector implements SystemActivityDAO {

	private static SystemActivityDAOImpl instance = new SystemActivityDAOImpl();
    public static SystemActivityDAOImpl getInstance() {return SystemActivityDAOImpl.instance;};
    private SystemActivityDAOImpl() {}
		
		private static final String insertSql = "insert into SystemActivity (sa_name,sa_start_time,sa_lap1_end_time,sa_lap2_end_time) values(?,?,?,?)";

		 private static final String deleteSql = "delete from SystemActivity where sa_id = ?";

		 private static final String updateSql = "update SystemActivity set sa_name = ?, sa_start_time = ?,sa_lap1_end_time=?,sa_lap2_end_time=? where sa_id=?";

		 private static final String selectSql = "select * from SystemActivity where sa_id = ?";
	public void insert(SystemActivity systemActivity) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);

		statement.setString(1,systemActivity.getSa_name());
		statement.setString(2, systemActivity.getSa_start_time());
		statement.setString(3, systemActivity.getSa_lap1_end_time());
		statement.setString(4, systemActivity.getSa_lap2_end_time());
		statement.execute();
		
	}

	public void delete(SystemActivity systemActivity) throws Exception {
		PreparedStatement statement=connect().prepareStatement(deleteSql);
		statement.setInt(1,systemActivity.getSa_id());
		statement.execute();
		
	}

	@Override
	public void update(SystemActivity systemActivity) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement statement=connect().prepareStatement(updateSql);
		statement.setString(1,systemActivity.getSa_name());
		statement.setString(2,systemActivity.getSa_start_time());
		statement.setString(3,systemActivity.getSa_lap1_end_time());
		statement.setString(4,systemActivity.getSa_lap2_end_time());
		statement.setInt(5, systemActivity.getSa_id());
		statement.execute();
		
	}

	@Override
	public SystemActivity select(int id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement statement=connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet results=statement.executeQuery();
		if(results.next())
		{
			SystemActivity systemActivity=new SystemActivity();
			systemActivity.setSa_id(results.getInt(1));
			systemActivity.setSa_name(results.getString(2));
			systemActivity.setSa_start_time(results.getString(3));
			systemActivity.setSa_lap1_end_time(results.getString(4));
			systemActivity.setSa_lap2_end_time(results.getString(5));
			return systemActivity;
			
		}
		 return null;
	}

	@Override
	public SystemActivity select(String key, String value) throws Exception {
		// TODO Auto-generated method stub
		String sql1 = "select * from SystemActivity where "+key+"= '"+value+"'";
		PreparedStatement statement=connect().prepareStatement(sql1);
		ResultSet results=statement.executeQuery();
		if(results.next())
		{
			SystemActivity systemActivity=new SystemActivity();
			systemActivity.setSa_id(results.getInt(1));
			systemActivity.setSa_name(results.getString(2));
			systemActivity.setSa_start_time(results.getString(3));
			systemActivity.setSa_lap1_end_time(results.getString(4));
			systemActivity.setSa_lap2_end_time(results.getString(5));
			return systemActivity;	
		}
		return null;
	}
	@Override
	public SystemActivity select(String key, int value) throws Exception {
		// TODO Auto-generated method stub
		String sql1 = "select * from SystemActivity where "+key+"="+String.valueOf(value);
		PreparedStatement statement=connect().prepareStatement(sql1);

		ResultSet results=statement.executeQuery();
		if(results.next())
		{
			SystemActivity systemActivity=new SystemActivity();
			systemActivity.setSa_id(results.getInt(1));
			systemActivity.setSa_name(results.getString(2));
			systemActivity.setSa_start_time(results.getString(3));
			systemActivity.setSa_lap1_end_time(results.getString(4));
			systemActivity.setSa_lap2_end_time(results.getString(5));
			return systemActivity;	
		}
		return null;
	}

	@Override
	public List<SystemActivity> selectAll() throws Exception {
		String sql="select * from SystemActivity";
		PreparedStatement statement=connect().prepareStatement(sql);
		List <SystemActivity> SystemActivitys=new ArrayList<SystemActivity>();
		ResultSet results=statement.executeQuery();
		while(results.next())
		{
			SystemActivity t=new SystemActivity(results.getInt(1),results.getString(2),results.getString(3),results.getString(4),results.getString(5));
			SystemActivitys.add(t);
		}
		return SystemActivitys;
	}

	@Override
	public List<SystemActivity> selectAll(String condition) throws Exception {
		String sql="select * from SystemActivity"+condition;
		PreparedStatement statement=connect().prepareStatement(sql);
		List <SystemActivity> SystemActivitys=new ArrayList<SystemActivity>();
		ResultSet results=statement.executeQuery();
		while(results.next())
		{
			SystemActivity t=new SystemActivity(results.getInt(1),results.getString(2),results.getString(3),results.getString(4),results.getString(5));
			SystemActivitys.add(t);
		}
		return SystemActivitys;
		
	}
	

}

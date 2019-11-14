package com.cloudea.concrete;

import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.AdministratorDAO;
import com.cloudea.models.Administrator;
import com.cloudea.models.Major;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministratorDAOImpl extends SqlServerConnector implements AdministratorDAO {

	private static AdministratorDAOImpl instance= new AdministratorDAOImpl();
	public static AdministratorDAOImpl getInstance() {return AdministratorDAOImpl.instance;};
	
	private AdministratorDAOImpl() {}
	private static final String insertSql="insert into Administrator(u_id,ad_name) values(?,?)";
	private static final String deleteSql="delete from Administrator where u_id = ?";
	private static final String updateSql="update Administrator set ad_name=?  where u_id=?";
	private static final String selectSql="select * from Administrator where u_id=?";
	@Override
	public void insert(Administrator administrator) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, administrator.getU_id());
		statement.setString(2, administrator.getAd_name());
		statement.execute();
	}

	@Override
	public void delete(Administrator administrator) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,administrator.getU_id());
		statement.execute();
	}

	@Override
	public void update(Administrator administrator) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setString(1, administrator.getAd_name());
		statement.setInt(2, administrator.getU_id());
		statement.execute();
	}

	@Override
	public Administrator select(int mjr_id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1, mjr_id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Administrator a=new Administrator();
			a.setU_id(result.getInt("u_id"));
			a.setAd_name(result.getString("ad_name"));
			return a;
		}
		return null;
	}

	@Override
	public Administrator select(String key, String value) throws Exception {
		String sql="select * from Administrator where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Administrator a=new Administrator();
			a.setU_id(result.getInt("u_id"));
			a.setAd_name(result.getString("ad_name"));
			return a;
		}
		return null;
	}

	public Administrator select(String key, int value) throws Exception {
		String sql="select * from Administrator where "+key+"='"+String.valueOf(value)+"'";
		PreparedStatement statement = connect().prepareStatement(sql);
		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Administrator a=new Administrator();
			a.setU_id(result.getInt("u_id"));
			a.setAd_name(result.getString("ad_name"));
			return a;
		}
		return null;
	}
	
	@Override
	public List<Administrator> selectAll() throws Exception {
		String sql="select * from Administrator";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Administrator> administrators=new ArrayList<Administrator>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Administrator t = new Administrator(result.getInt(1),result.getString(2));
			administrators.add(t);
		}
		return administrators;
	}

	@Override
	public List<Administrator> selectAll(String condition) throws Exception {
		String sql="select * from Administrator "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Administrator> administrators=new ArrayList<Administrator>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Administrator t = new Administrator(result.getInt(1),result.getString(2));
			administrators.add(t);
		}
		return administrators;
	}
		

}

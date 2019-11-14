package com.cloudea.concrete;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.UserTypeDAO;
import com.cloudea.models.UserType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserTypeDAOImpl extends SqlServerConnector implements UserTypeDAO {

	private static UserTypeDAOImpl instance= new UserTypeDAOImpl();
	public static UserTypeDAOImpl getInstance() {return UserTypeDAOImpl.instance;};
	
	private UserTypeDAOImpl() {}
	private static final String insertSql="insert into UserType values(?,?)";
	private static final String deleteSql="delete from UserType where ut_id = ?";
	private static final String updateSql="update UserType set name=? where ut_id=?";
	private static final String selectSql="select * from UserType where ut_id=?";
	
	
	@Override
	public void insert(UserType userType) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, userType.getU_id());
		statement.setString(2, userType.getName());
		statement.execute();
	}

	@Override
	public void delete(UserType userType) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,userType.getU_id());
		statement.execute();
	}

	@Override
	public void update(UserType userType) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(2, userType.getU_id());
		statement.setString(1, userType.getName());
		statement.execute();
	}

	@Override
	public UserType select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			UserType userType=new UserType();
			userType.setU_id(result.getInt(1));
			userType.setName(result.getString(2));
			return userType;
		}
		return null;
	}


	@Override
	public List<UserType> selectAll() throws Exception {
		String sql="select * from UserType";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<UserType>Perms=new ArrayList<UserType>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			UserType t = new UserType(result.getInt(1),result.getString(2));
			Perms.add(t);
		}
		return Perms;
	}

	public List<UserType> selectAll(String condition) throws Exception {
		String sql="select * from UserType "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<UserType>Perms=new ArrayList<UserType>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			UserType t = new UserType(result.getInt(1),result.getString(2));
			Perms.add(t);
		}
		return Perms;
	}
	public static void main(String args[])
	{
		UserType ll=new UserType();
		ll.setName("lihua");
		ll.setU_id(1);
		UserTypeDAOImpl l=new UserTypeDAOImpl();
		try {
			l.insert(ll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



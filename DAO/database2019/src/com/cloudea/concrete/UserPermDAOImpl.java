package com.cloudea.concrete;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.UserPermDAO;
import com.cloudea.models.UserPerm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserPermDAOImpl extends SqlServerConnector implements UserPermDAO {

	private static UserPermDAOImpl instance= new UserPermDAOImpl();
	public static UserPermDAOImpl getInstance() {return UserPermDAOImpl.instance;};
	
	private UserPermDAOImpl() {}
	private static final String insertSql="insert into UserPerm values(?,?)";
	private static final String deleteSql="delete from UserPerm where u_id = ?";
	private static final String updateSql="update UserPerm set u_id=?,pmt_id=?";
	private static final String selectSql="select * from UserPerm where u_id=? and pmt_id=?";
	
	
	@Override
	public void insert(UserPerm userPerm) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, userPerm.getU_id());
		statement.setInt(2, userPerm.getPmt_id());
		statement.execute();
	}

	@Override
	public void delete(UserPerm userPerm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,userPerm.getU_id());
		statement.execute();
	}

	@Override
	public void update(UserPerm userPerm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, userPerm.getU_id());
		statement.setInt(2, userPerm.getPmt_id());
		statement.execute();
	}

	@Override
	public UserPerm select(int u_id) throws Exception{
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,u_id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			UserPerm UserPerm=new UserPerm(result.getInt(1),result.getInt(2));
			return UserPerm;
		}
		return null;
	}


	@Override
	public List<UserPerm> selectAll() throws Exception {
		String sql="select * from UserPerm";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<UserPerm>UserPerms=new ArrayList<UserPerm>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			UserPerm t = new UserPerm(result.getInt(1),result.getInt(2));
			UserPerms.add(t);
		}
		return UserPerms;
	}

	public List<UserPerm> selectAll(String condition) throws Exception {
		String sql="select * from UserPerm "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<UserPerm>UserPerms=new ArrayList<UserPerm>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			UserPerm t = new UserPerm(result.getInt(1),result.getInt(2));
			UserPerms.add(t);
		}
		return UserPerms;
	}
	

	@Override
	public List<UserPerm> selectAll(int u_id) throws Exception {
		String sql="select * from UserPerm where u_id="+String.valueOf(u_id);
		PreparedStatement statement = connect().prepareStatement(sql);
		List<UserPerm>UserPerms=new ArrayList<UserPerm>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			UserPerm t = new UserPerm(result.getInt(1),result.getInt(2));
			UserPerms.add(t);
		}
		return UserPerms;
	}
//	public static void main(String args[])
//	{
//		UserPerm perm = new UserPerm(1,2);
//		UserPermDAOImpl l=new UserPermDAOImpl();
//		try {
//			l.insert(perm);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}



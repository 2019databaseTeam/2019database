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
	private static final String deleteSql="delete from UserPerm where u_id = ? and pmt_id=?";
	private static final String updateSql="update UserPerm set u_id=?,pmt_id=?";
	private static final String selectSql="select * from UserPerm where 'u_id'=? and pmt_id=?";
	
	
	@Override
	public void insert(UserPerm UserPerm) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, UserPerm.getU_id());
		statement.setInt(2, UserPerm.getPmt_id());
		statement.execute();
	}

	@Override
	public void delete(UserPerm UserPerm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,UserPerm.getU_id());
		statement.execute();
	}

	@Override
	public void update(UserPerm UserPerm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, UserPerm.getU_id());
		statement.setInt(2, UserPerm.getPmt_id());
		statement.execute();
	}

	@Override
	public UserPerm select(int u_id, int pmt_id) throws Exception{
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,u_id);
		statement.setInt(2, pmt_id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			UserPerm UserPerm=new UserPerm();
			statement.setInt(1, UserPerm.getU_id());
			statement.setInt(2, UserPerm.getPmt_id());
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
	//public static void main(String args[]) throws Exception {
		//MajorDAOImpl t=new MajorDAOImpl();
		//t.selectAll("where mjr_id=1");
	//}

//	@Override
//	public void insert(UserPerm UserPerm) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(UserPerm UserPerm) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(UserPerm UserPerm) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public UserPerm select(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public UserPerm select(String key, String value) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public void main(String args[])
	{
		UserPerm ll=new UserPerm();
		UserPermDAOImpl l=new UserPermDAOImpl();
		try {
			l.insert(ll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<UserPerm> selectAll(int u_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}



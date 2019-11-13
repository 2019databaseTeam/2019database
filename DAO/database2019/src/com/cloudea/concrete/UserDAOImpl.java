package com.cloudea.concrete;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.UserDAO;
import com.cloudea.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl extends SqlServerConnector implements UserDAO {

	private static UserDAOImpl instance= new UserDAOImpl();
	public static UserDAOImpl getInstance() {return UserDAOImpl.instance;};
	
	private UserDAOImpl() {}
	private static final String insertSql="insert into User values(?,?,?,?,?)";
	private static final String deleteSql="delete from User where u_id = ?";
	private static final String updateSql="update User set u_id=?,u_type=?,u_mailbox=?,adm=?,pawd=?";
	private static final String selectSql="select * from User where 'u_id'=?";
	
	
	@Override
	public void insert(User User) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, User.getU_id());
		statement.setString(2,User.getU_type());
		statement.setString(3,User.getU_mailbox());
		statement.setString(4,User.getAdm());
		statement.setString(5,User.getPawd());
		statement.execute();
	}

	@Override
	public void delete(User User) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,User.getU_id());
		statement.execute();
	}

	@Override
	public void update(User User) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1,User.getU_id() );
		statement.setString(2, User.getU_type());
		statement.setString(3,User.getU_mailbox());
		statement.setString(4,User.getAdm());
		statement.setString(5,User.getPawd());
		statement.execute();
	}

	@Override
	public User select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			User User=new User();
			User.setU_id(result.getInt("u_id"));
			User.setU_type(result.getString("u_type") );
			User.setU_mailbox(result.getString("u_mailbox"));
			User.setAdm(result.getString("adm"));
			User.setPawd(result.getString("pawd"));
			return User;
		}
		return null;
	}

	@Override
	public User select(String key, String value) throws Exception {
		String sql="select * from User where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			User User=new User();
			User.setU_id(result.getInt("u_id"));
			User.setU_type(result.getString("u_type") );
			User.setU_mailbox(result.getString("u_mailbox"));
			User.setAdm(result.getString("adm"));
			User.setPawd(result.getString("pawd"));
			return User;
		}
		return null;
	}

	@Override
	public List<User> selectAll() throws Exception {
		String sql="select * from User";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<User>Users=new ArrayList<User>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			User t = new User(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
			Users.add(t);
		}
		return Users;
	}

	@Override
	public List<User> selectAll(String condition) throws Exception {
		String sql="select * from User "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<User>Users=new ArrayList<User>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			User t = new User(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
			Users.add(t);
		}
		return Users;
	}
	//public static void main(String args[]) throws Exception {
		//MajorDAOImpl t=new MajorDAOImpl();
		//t.selectAll("where mjr_id=1");
	//}

//	@Override
//	public void insert(User User) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(User User) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(User User) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public User select(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User select(String key, String value) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public void main(String args[])
	{
		User ll=new User();
		UserDAOImpl l=new UserDAOImpl();
		try {
			l.insert(ll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



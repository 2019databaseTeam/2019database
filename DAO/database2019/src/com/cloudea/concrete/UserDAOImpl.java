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
	private static final String insertSql="insert into Admission values(?,?,?,?)";
	private static final String deleteSql="delete from Admission where u_id = ?";
	private static final String updateSql="update Admission set u_type=?,u_mailbox=?,adm=?,pawd=? where u_id=?";
	private static final String selectSql="select * from Admission where u_id=?";
	
	
	@Override
	public void insert(User user) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);

		statement.setInt(1,user.getU_type());
		statement.setString(2,user.getU_mailbox());
		statement.setString(3,user.getAdm());
		statement.setString(4,user.getPawd());
		statement.execute();
	}

	@Override
	public void delete(User user) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,user.getU_id());
		statement.execute();
	}

	@Override
	public void update(User user) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, user.getU_type());
		statement.setString(2,user.getU_mailbox());
		statement.setString(3,user.getAdm());
		statement.setString(4,user.getPawd());
		statement.setInt(5, user.getU_id());
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
			User.setU_type(result.getInt("u_type") );
			User.setU_mailbox(result.getString("u_mailbox"));
			User.setAdm(result.getString("adm"));
			User.setPawd(result.getString("pawd"));
			return User;
		}
		return null;
	}

	@Override
	public User select(String key, String value) throws Exception {
		String sql="select * from Admission where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			User User=new User();
			User.setU_id(result.getInt("u_id"));
			User.setU_type(result.getInt("u_type") );
			User.setU_mailbox(result.getString("u_mailbox"));
			User.setAdm(result.getString("adm"));
			User.setPawd(result.getString("pawd"));
			return User;
		}
		return null;
	}

	@Override
	public List<User> selectAll() throws Exception {
		String sql="select * from Admission";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<User>Users=new ArrayList<User>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			User t = new User(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5));
			Users.add(t);
		}
		return Users;
	}

	@Override
	public List<User> selectAll(String condition) throws Exception {
		String sql="select * from Admission "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<User>Users=new ArrayList<User>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			User t = new User(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5));
			Users.add(t);
		}
		return Users;
	}

//	public static void main(String args[])
//	{
//	User user=new User(2,1,"te","te","t");
//	UserDAOImpl l=new UserDAOImpl();
//	try {
//		l.update(user);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	}
}



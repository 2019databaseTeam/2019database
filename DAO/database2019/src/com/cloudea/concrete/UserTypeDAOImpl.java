package DAO1;
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
	private static final String deleteSql="delete from UserType where u_id = ?";
	private static final String updateSql="update UserType set u_id=?,name=?";
	private static final String selectSql="select * from UserType where 'u_id'=?";
	
	
	@Override
	public void insert(UserType UserType) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, UserType.getU_id());
		statement.setString(2, UserType.getName());
		statement.execute();
	}

	@Override
	public void delete(UserType UserType) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,UserType.getU_id());
		statement.execute();
	}

	@Override
	public void update(UserType UserType) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, UserType.getU_id());
		statement.setString(2, UserType.getName());
		statement.execute();
	}

	@Override
	public UserType select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			UserType UserType=new UserType();
			statement.setInt(1, UserType.getU_id());
			statement.setString(2, UserType.getName());
			return UserType;
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
	//public static void main(String args[]) throws Exception {
		//MajorDAOImpl t=new MajorDAOImpl();
		//t.selectAll("where mjr_id=1");
	//}

//	@Override
//	public void insert(UserType UserType) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(UserType UserType) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(UserType UserType) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public UserType select(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public UserType select(String key, String value) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public void main(String args[])
	{
		UserType ll=new UserType();
		UserTypeDAOImpl l=new UserTypeDAOImpl();
		try {
			l.insert(ll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



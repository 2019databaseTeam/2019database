package DAO1;

import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.LogInDAO;
import com.cloudea.models.LogIn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogInDAOImpl extends SqlServerConnector implements LogInDAO {

	private static LogInDAOImpl instance= new LogInDAOImpl();
	public static LogInDAOImpl getInstance() {return LogInDAOImpl.instance;};
	
	private LogInDAOImpl() {}
	private static final String insertSql="insert into Log_in values(?,?,?,?)";
	private static final String deleteSql="delete from Log_in where log_id = ?";
	private static final String updateSql="update Log_in set log_id=?,u_id=?,in_time=?,out_time=?";
	private static final String selectSql="select * from Log_in where 'log_id'=?";
	
	
	@Override
	public void insert(LogIn login) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, login.getLog_id());
		statement.setInt(2, login.getU_id());
		statement.setString(3,login.getIn_time());
		statement.setString(4,login.getOut_time());
		statement.execute();
	}

	@Override
	public void delete(LogIn login) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,login.getLog_id());
		statement.execute();
	}

	@Override
	public void update(LogIn login) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1,login.getLog_id() );
		statement.setInt(2, login.getU_id());
		statement.setString(3,login.getIn_time() );
		statement.setString(4,login.getOut_time() );
		statement.execute();
	}

	@Override
	public LogIn select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			LogIn login=new LogIn();
			login.setLog_id(result.getInt("log_id"));
			login.setU_id(result.getInt("u_id"));
			login.setIn_time(result.getString("in_time"));
			login.setOut_time(result.getString("out_time"));
			return login;
		}
		return null;
	}

	@Override
	public LogIn select(String key, String value) throws Exception {
		String sql="select * from Log_in where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			LogIn login=new LogIn();
			login.setLog_id(result.getInt("log_id"));
			login.setU_id(result.getInt("u_id"));
			login.setIn_time(result.getString("in_time"));
			login.setOut_time(result.getString("out_time"));
			return login;
		}
		return null;
	}

	@Override
	public List<LogIn> selectAll() throws Exception {
		String sql="select * from Log_in";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<LogIn>logins=new ArrayList<LogIn>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			LogIn t = new LogIn(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4));
			logins.add(t);
		}
		return logins;
	}

	@Override
	public List<LogIn> selectAll(String condition) throws Exception {
		String sql="select * from Log_in "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<LogIn>logins=new ArrayList<LogIn>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			LogIn t = new LogIn(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4));
			logins.add(t);
		}
		return logins;
	}
	//public static void main(String args[]) throws Exception {
		//MajorDAOImpl t=new MajorDAOImpl();
		//t.selectAll("where mjr_id=1");
	//}

//	@Override
//	public void insert(LogIn logIn) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(LogIn logIn) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(LogIn logIn) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public LogIn select(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public LogIn select(String key, String value) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public void main(String args[])
	{
		LogIn ll=new LogIn();
		LogInDAOImpl l=new LogInDAOImpl();
		try {
			l.insert(ll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



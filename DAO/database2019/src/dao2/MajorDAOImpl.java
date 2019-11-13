package dao2;

import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.MajorDAO;
import com.cloudea.models.Major;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MajorDAOImpl extends SqlServerConnector implements MajorDAO {

	private static MajorDAOImpl instance= new MajorDAOImpl();
	public static MajorDAOImpl getInstance() {return MajorDAOImpl.instance;};
	
	private MajorDAOImpl() {}
	private static final String insertSql="insert into Major values(?,?)";
	private static final String deleteSql="delete from Major where jr_id = ?";
	private static final String updateSql="update Major set mjr_id=?,mjr_name=?";
	private static final String selectSql="select * from major where 'mjr_id'=?";
	
	
	@Override
	public void insert(Major major) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, major.getMajorId());
		statement.setString(2, major.getMajorName());
		statement.execute();
	}

	@Override
	public void delete(Major major) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,major.getMajorId());
		statement.execute();
	}

	@Override
	public void update(Major major) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, major.getMajorId());
		statement.setString(2, major.getMajorName());
		statement.execute();
	}

	@Override
	public Major select(int mjr_id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1, mjr_id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Major major=new Major();
			major.setMajorId(result.getInt("mjr_id"));
			major.setMajorName(result.getString("mjr_name"));
			return major;
		}
		return null;
	}

	@Override
	public Major select(String key, String value) throws Exception {
		String sql="select * from major where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Major major =new Major();
			major.setMajorId(result.getInt("mjr_id"));
			major.setMajorName(result.getString("mjr_name"));
			return major;
		}
		return null;
	}

	public Major select(String key, int value) throws Exception {
		String sql="select * from major where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Major major =new Major();
			major.setMajorId(result.getInt("mjr_id"));
			major.setMajorName(result.getString("mjr_name"));
			return major;
		}
		return null;
	}
	@Override
	public List<Major> selectAll() throws Exception {
		String sql="select * from major";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Major>majors=new ArrayList<Major>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Major t = new Major(result.getInt(1),result.getString(2));
			majors.add(t);
		}
		return majors;
	}

	@Override
	public List<Major> selectAll(String condition) throws Exception {
		String sql="select * from major "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Major>majors=new ArrayList<Major>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Major t = new Major(result.getInt(1),result.getString(2));
			majors.add(t);
		}
		return majors;
	}
	//public static void main(String args[]) throws Exception {
		//MajorDAOImpl t=new MajorDAOImpl();
		//t.selectAll("where mjr_id=1");
	//}
}


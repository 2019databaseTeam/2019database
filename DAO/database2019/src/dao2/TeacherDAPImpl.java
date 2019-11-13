package dao2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.TeacherDAO;
import com.cloudea.models.Teacher;

public class TeacherDAPImpl extends SqlServerConnector implements TeacherDAO{
	
	private static TeacherDAPImpl instance= new TeacherDAPImpl();
	public static TeacherDAPImpl getInstance() { 
		return TeacherDAPImpl.instance;
	}
	private TeacherDAPImpl() {}
	//pl_id,tch_id,plt_id,max_person;
	//pl_name,pl_degree,pl_need,pl_eva_mode;
	private static final String insertSql="insert into Teacher values(?,?,?)";
	private static final String deleteSql="delete from Teacher where tch_id = ?";
	private static final String updateSql="update Teacher set tch_id=?,u_id=?,tch_name=?";
	private static final String selectSql="select * from Teacher where 'tch_id'=?";
	
	public void insert(Teacher teacher) throws Exception{
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, teacher.getTch_id());
		statement.setInt(2, teacher.getU_id());
		statement.setString(3, teacher.getTch_name());
		statement.execute();
	}
	public void delete(Teacher teacher) throws Exception{
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1, teacher.getTch_id());
		statement.execute();
	}
	public void update(Teacher teacher) throws Exception{
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, teacher.getTch_id());
		statement.setInt(2, teacher.getU_id());
		statement.setString(3, teacher.getTch_name());
		statement.execute();
	}
	public Teacher select(int tch_id) throws Exception{
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1, tch_id);
		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Teacher teacher=new Teacher();
			teacher.setTch_id(result.getInt("tch_id"));
			teacher.setU_id(result.getInt("u_id"));
			teacher.setTch_name(result.getString("tch_name"));
			return teacher;
		}
		return null;
	}
	public Teacher select(String key, String value) throws Exception{
		String sql="select * from teacher where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);
		
		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Teacher teacher=new Teacher();
			teacher.setTch_id(result.getInt("tch_id"));
			teacher.setU_id(result.getInt("u_id"));
			teacher.setTch_name(result.getString("tch_name"));
			return teacher;
		}
		return null;
	}
	public List<Teacher> selectAll() throws Exception{
		String sql="select * from teacher";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Teacher>teachers=new ArrayList<Teacher>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Teacher teacher = new Teacher(result.getInt(1),result.getInt(2),result.getString(3));
			teachers.add(teacher);
		}
		return teachers;
	}
	public List<Teacher> selectAll(String condition) throws Exception{
		String sql="select * from teacher"+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Teacher>teachers=new ArrayList<Teacher>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Teacher teacher = new Teacher(result.getInt(1),result.getInt(2),result.getString(3));
			teachers.add(teacher);
		}
		return teachers;
	}

}

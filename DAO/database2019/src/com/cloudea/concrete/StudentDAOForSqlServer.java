package com.cloudea.concrete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.StudentDAO;
import com.cloudea.models.Selection;
import com.cloudea.models.Student;

public class StudentDAOForSqlServer extends SqlServerConnector implements StudentDAO {

	private static StudentDAOForSqlServer instance = new StudentDAOForSqlServer();
    public static StudentDAOForSqlServer getInstance() {return StudentDAOForSqlServer.instance;};
    private StudentDAOForSqlServer() {}
		
		private static final String insertSql = "insert into Student (u_id,SN,mjr_id) values(?, ?,?)";

		 private static final String deleteSql = "delete from Student where stu_id = ?";

		 private static final String updateSql = "update Materila set u_id = ?, SN = ?,mjr_id=? where stu_id=?";

		 private static final String selectSql = "select * from Material where stu_id = ?";
	public void insert(Student student) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, student.getU_id());
		statement.setString(2,student.getSN());
		statement.setInt(3, student.getMjr_id());
		statement.execute();
		
	}

	public void delete(Student student) throws Exception {
		PreparedStatement statement=connect().prepareStatement(deleteSql);
		statement.setInt(1,student.getStu_id());
		statement.execute();
		
	}

	@Override
	public void update(Student student) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement statement=connect().prepareStatement(updateSql);
		statement.setInt(1, student.getU_id());
		statement.setString(2,student.getSN());
		statement.setInt(3, student.getMjr_id());
		statement.setInt(4, student.getStu_id());
		statement.execute();
		
	}

	@Override
	public Student select(int id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement statement=connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet results=statement.executeQuery();
		if(results.next())
		{
			Student student=new Student();
			student.setStu_id(results.getInt("stu_id"));
			student.setU_id(results.getInt("u_id"));
			student.setSN(results.getString("SN"));
			student.setMjr_id(results.getInt("mjr_id"));
			return student;
			
		}
		 return null;
	}

	@Override
	public Student select(String key, String value) throws Exception {
		// TODO Auto-generated method stub
		String sql1 = "select * from Selection where ? = ?";
		PreparedStatement statement=connect().prepareStatement(sql1);
		if(key=="stu_id")
		{
			statement.setString(1, "stu_id");
			ResultSet results=statement.executeQuery();
			if(results.next())
			{
				Student student=new Student();
				student.setStu_id(results.getInt("stu_id"));
				student.setU_id(results.getInt("u_id"));
				student.setSN(results.getString("SN"));
				student.setMjr_id(results.getInt("mjr_id"));
				return student;
				
			}
		}
		else if(key=="u_id")
		{
			statement.setString(1, "u_id");
			statement.setInt(2,Integer.parseInt(value));
			ResultSet results=statement.executeQuery();
			if(results.next())
			{
				Student student=new Student();
				student.setStu_id(results.getInt("stu_id"));
				student.setU_id(results.getInt("u_id"));
				student.setSN(results.getString("SN"));
				student.setMjr_id(results.getInt("mjr_id"));
				return student;
			}
		}
		else if(key=="SN")
		{
			statement.setString(1, "SN");
			statement.setString(2,value);
			ResultSet results=statement.executeQuery();
			if(results.next())
			{
				Student student=new Student();
				student.setStu_id(results.getInt("stu_id"));
				student.setU_id(results.getInt("u_id"));
				student.setSN(results.getString("SN"));
				student.setMjr_id(results.getInt("mjr_id"));
				return student;
			}
			
		}
		else if(key=="mjr_id")
		{
			statement.setString(1, "mjr_id");
			statement.setInt(2,Integer.parseInt(value));
			ResultSet results=statement.executeQuery();
			if(results.next())
			{
				Student student=new Student();
				student.setStu_id(results.getInt("stu_id"));
				student.setU_id(results.getInt("u_id"));
				student.setSN(results.getString("SN"));
				student.setMjr_id(results.getInt("mjr_id"));
				return student;
			}
		}
		return null;
	}

	@Override
	public List<Student> selectAll() throws Exception {
		String sql="select * from Student";
		PreparedStatement statement=connect().prepareStatement(sql);
		List <Student> students=new ArrayList<Student>();
		ResultSet results=statement.executeQuery();
		while(results.next())
		{
			Student t=new Student(results.getInt(1),results.getInt(2),results.getString(3),results.getInt(4));
			students.add(t);
		}
		return students;
	}

	@Override
	public List<Student> selectAll(String condition) throws Exception {
		String sql="select * from Student"+condition;
		PreparedStatement statement=connect().prepareStatement(sql);
		List <Student> students=new ArrayList<Student>();
		ResultSet results=statement.executeQuery();
		while(results.next())
		{
			Student t=new Student(results.getInt(1),results.getInt(2),results.getString(3),results.getInt(4));
			students.add(t);
		}
		return students;
		
	}
	

}

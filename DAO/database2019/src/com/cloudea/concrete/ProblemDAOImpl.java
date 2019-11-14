package com.cloudea.concrete;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.daoes.ProblemDAO;
import com.cloudea.models.Problem;

import com.cloudea.connector.SqlServerConnector;
import java.sql.ResultSet;

public class ProblemDAOImpl extends SqlServerConnector implements ProblemDAO{
	
	private static ProblemDAOImpl instance= new ProblemDAOImpl();
	public static ProblemDAOImpl getInstance() { 
		return ProblemDAOImpl.instance;
	}
	private ProblemDAOImpl() {}
	//pl_id,tch_id,plt_id,max_person;
	//pl_name,pl_degree,pl_need,pl_eva_mode;
	private static final String insertSql="insert into Problem(tch_id,plt_id,pl_name,pl_degree,pl_need,pl_eva_mode,max_person) values(?,?,?,?,?,?,?)";
	private static final String deleteSql="delete from Problem where pl_id = ?";
	private static final String updateSql="update Problem set tch_id=?,plt_id=?,pl_name=?,pl_degree=?,pl_need=?,pl_eva_mode=?,max_person=? where pl_id=?";
	private static final String selectSql="select * from Problem where pl_id=?";
	@Override
	public void insert(Problem problem) throws Exception{
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1,problem.getTch_id());
		statement.setInt(2, problem.getPlt_id());
		statement.setString(3,problem.getPl_name());
		statement.setString(4, problem.getPl_degree());
		statement.setString(5, problem.getPl_need());
		statement.setString(6, problem.getPl_eva_mode());
		statement.setInt(7, problem.getMax_person());
		statement.execute();
	}
	@Override
	public void delete(Problem problem)  throws Exception
	{
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1, problem.getPl_id());
		statement.execute();
	}
	@Override
	public void update(Problem problem) throws Exception{
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1,problem.getTch_id());
		statement.setInt(2, problem.getPlt_id());
		statement.setString(3,problem.getPl_name());
		statement.setString(4, problem.getPl_degree());
		statement.setString(5, problem.getPl_need());
		statement.setString(6, problem.getPl_eva_mode());
		statement.setInt(7, problem.getMax_person());
		statement.setInt(8, problem.getPl_id());
		statement.execute();
	}
	@Override
	public Problem select(int pl_id) throws Exception{
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1, pl_id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Problem problem=new Problem();
			problem.setPl_id(result.getInt("pl_id"));
			problem.setTch_id(result.getInt("tch_id"));
			problem.setPlt_id(result.getInt("plt_id"));
			problem.setPl_name(result.getString("pl_name"));
			problem.setPl_degree(result.getString("pl_degree"));
			problem.setPl_need(result.getString("pl_degree"));
			problem.setPl_eva_mode(result.getString("pl_eva_mode"));
			problem.setMax_person(result.getInt("max_person"));
			
			return problem;
		}
		return null;
	} 
	
	
	@Override
	public Problem select(String key,String value) throws Exception{
		String sql="select * from problem where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Problem problem =new Problem();
			problem.setPl_id(result.getInt("pl_id"));
			problem.setTch_id(result.getInt("tch_id"));
			problem.setPlt_id(result.getInt("plt_id"));
			problem.setPl_name(result.getString("pl_name"));
			problem.setPl_degree(result.getString("pl_degree"));
			problem.setPl_need(result.getString("pl_degree"));
			problem.setPl_eva_mode(result.getString("pl_eva_mode"));
			problem.setMax_person(result.getInt("max_person"));
			return problem;
		}
		return null;
	}

	@Override
	public List<Problem> selectAll() throws Exception{
		String sql="select * from problem";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Problem>problems=new ArrayList<Problem>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Problem problem = new Problem(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),
					result.getString(5),result.getString(6),result.getString(7),result.getInt(8));
			problems.add(problem);
		}
		return problems;
	}
	@Override
	public List<Problem> selectAll(String condition) throws Exception{
		String sql="select * from problem "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Problem>problems=new ArrayList<Problem>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Problem problem = new Problem(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),
					result.getString(5),result.getString(6),result.getString(7),result.getInt(8));
			problems.add(problem);
		}
		return problems;
	}
}

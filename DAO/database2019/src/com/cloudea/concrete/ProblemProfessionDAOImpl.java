package com.cloudea.concrete;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.ProblemProfessionDAO;
import com.cloudea.models.ProblemProfession;

public class ProblemProfessionDAOImpl extends SqlServerConnector implements ProblemProfessionDAO{
	private static ProblemProfessionDAOImpl instance= new ProblemProfessionDAOImpl();
	public static ProblemProfessionDAOImpl getInstance() { 
		return ProblemProfessionDAOImpl.instance;
	}
	private ProblemProfessionDAOImpl() {}
	
	
	private static final String insertSql="insert into Teacher values(?,?)";
	private static final String deleteSql="delete from Teacher where pl_id = ? and mjr_id=?";
	private static final String updateSql="update Teacher set pl_id = ?,mjr_id=?";
	private static final String selectSql="select * from Teacher where 'pl_id'=?";
	public void insert(ProblemProfession PP) throws Exception{
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, PP.getPl_id());
		statement.setInt(2, PP.getMjr_id());
		statement.execute();
	}
	public void delete(ProblemProfession PP) throws Exception{
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1, PP.getPl_id());
		statement.setInt(2, PP.getMjr_id());
		statement.execute();
	}
	public void update(ProblemProfession PP) throws Exception{
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, PP.getPl_id());
		statement.setInt(2, PP.getMjr_id());
		statement.execute();
	}
	
	
	public List<ProblemProfession> selectAll() throws Exception{
		String sql="select * from ProblemProfession";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<ProblemProfession>PPs=new ArrayList<ProblemProfession>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			ProblemProfession PP = new ProblemProfession(result.getInt(1),result.getInt(2));
			PPs.add(PP);
		}
		return PPs;
	}
	@Override
	public List<ProblemProfession> selectAll(int pl_id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1, pl_id);
		List<ProblemProfession> PPs =new ArrayList<ProblemProfession>();
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			ProblemProfession PP =new ProblemProfession();
			PP.setPl_id(result.getInt("pl_id"));
			PP.setMjr_id(result.getInt("mjr_id"));
			PPs.add(PP);
		}
		return PPs;
	}

}

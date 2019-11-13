package com.cloudea.concrete;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.PermDAO;
import com.cloudea.models.Perm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PermDAOImpl extends SqlServerConnector implements PermDAO {

	private static PermDAOImpl instance= new PermDAOImpl();
	public static PermDAOImpl getInstance() {return PermDAOImpl.instance;};
	
	private PermDAOImpl() {}
	private static final String insertSql="insert into Perm values(?,?)";
	private static final String deleteSql="delete from Perm where pmt_id = ?";
	private static final String updateSql="update Perm set pmt_id=?,per_context=?";
	private static final String selectSql="select * from Perm where 'pmt_id'=?";
	
	
	@Override
	public void insert(Perm Perm) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, Perm.getPmt_id());
		statement.setString(2, Perm.getPer_context());
		statement.execute();
	}

	@Override
	public void delete(Perm Perm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,Perm.getPmt_id());
		statement.execute();
	}

	@Override
	public void update(Perm Perm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, Perm.getPmt_id());
		statement.setString(2, Perm.getPer_context());
		statement.execute();
	}

	@Override
	public Perm select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Perm Perm=new Perm();
			statement.setInt(1, Perm.getPmt_id());
			statement.setString(2, Perm.getPer_context());
			return Perm;
		}
		return null;
	}


	@Override
	public List<Perm> selectAll() throws Exception {
		String sql="select * from Perm";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Perm>Perms=new ArrayList<Perm>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Perm t = new Perm(result.getInt(1),result.getString(2));
			Perms.add(t);
		}
		return Perms;
	}

	public List<Perm> selectAll(String condition) throws Exception {
		String sql="select * from Perm "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Perm>Perms=new ArrayList<Perm>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Perm t = new Perm(result.getInt(1),result.getString(2));
			Perms.add(t);
		}
		return Perms;
	}
	//public static void main(String args[]) throws Exception {
		//MajorDAOImpl t=new MajorDAOImpl();
		//t.selectAll("where mjr_id=1");
	//}

//	@Override
//	public void insert(Perm Perm) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(Perm Perm) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void update(Perm Perm) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Perm select(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Perm select(String key, String value) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public void main(String args[])
	{
		Perm ll=new Perm();
		PermDAOImpl l=new PermDAOImpl();
		try {
			l.insert(ll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



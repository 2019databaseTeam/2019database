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
	public void insert(Perm perm) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, perm.getPmt_id());
		statement.setString(2, perm.getPer_context());
		statement.execute();
	}

	@Override
	public void delete(Perm perm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,perm.getPmt_id());
		statement.execute();
	}

	@Override
	public void update(Perm perm) throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, perm.getPmt_id());
		statement.setString(2, perm.getPer_context());
		statement.execute();
	}

	@Override
	public Perm select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Perm perm=new Perm(result.getInt(1),result.getString(2));
			return perm;
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
		String sql="select * from Perm where"+condition;
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
	
//	public static void main(String args[])
//	{
//		Perm perm = new Perm(5,"≤‚ ‘”√»®œﬁ");
//		PermDAOImpl l=new PermDAOImpl();
//		try {
//			l.selectAll();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}



package com.cloudea.concrete;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.SelectionDAO;
import com.cloudea.models.Selection;

public class SelectionDAOImpl extends SqlServerConnector implements SelectionDAO {
	
	private static SelectionDAOImpl instance = new SelectionDAOImpl();
    public static SelectionDAOImpl getInstance() {return SelectionDAOImpl.instance;};
    private SelectionDAOImpl() {}
		
		private static final String insertSql = "insert into Selection(stu_id,priority,pl_id,m_id,sa_id) values(?,?,?,?,?)";

		 private static final String deleteSql = "delete from Selection where sec_id = ?";

		 private static final String updateSql = "update Selection set stu_id = ?, priority = ?,pl_id=?,m_id=?,sa_id=? where sec_id = ?";

		 private static final String selectSql = "select * from Selection where sec_id = ?";

	
	public void insert(Selection selection) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, selection.getStu_id());
		statement.setInt(2,selection.getPriority());
		statement.setInt(3, selection.getPl_id());
		statement.setInt(4,selection.getM_id());
		statement.setInt(5,selection.getSa_id());
		statement.execute();
		
	}

	public void delete(Selection selection) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement statement=connect().prepareStatement(deleteSql);
		statement.setInt(1,selection.getSec_id());
		statement.execute();
	}

	public void update(Selection selection) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement statement=connect().prepareStatement(updateSql);
		statement.setInt(1, selection.getStu_id());
		statement.setInt(2,selection.getPriority());
		statement.setInt(3, selection.getPl_id());
		statement.setInt(4,selection.getM_id() );
		statement.setInt(5,selection.getSa_id());
		statement.setInt(6, selection.getSec_id());
		statement.execute();
	}

	@Override
	public Selection select(int id) throws Exception {
		PreparedStatement statement=connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet results=statement.executeQuery();
		if(results.next())
		{
			Selection selection=new Selection();
			selection.setSec_id(results.getInt("sec_id"));
			selection.setStu_id(results.getInt("stu_id"));
			selection.setPriority(results.getInt("priority"));
			selection.setPl_id(results.getInt("pl_id"));
			selection.setM_id(results.getInt("m_id"));
			selection.setSa_id(results.getInt("sa_id"));
			return selection;
			
		}
		 return null;
	}

	@Override
	public Selection select(String key, String value) throws Exception {
		String sql1 = "select * from Selection where "+key+"='"+value+"'";
		PreparedStatement statement=connect().prepareStatement(sql1);
			ResultSet results=statement.executeQuery();
			if(results.next())
			{
				Selection selection=new Selection();
				selection.setSec_id(results.getInt("sec_id"));
				selection.setStu_id(results.getInt("stu_id"));
				selection.setPriority(results.getInt("priority"));
				selection.setPl_id(results.getInt("pl_id"));
				selection.setM_id(results.getInt("m_id"));
				return selection;
				
			}
		
		
		return null;
	}

	public List<Selection> selectAll() throws Exception {
		String sql="select * from Selection";
		PreparedStatement statement=connect().prepareStatement(sql);
		List <Selection> selections=new ArrayList<Selection>();
		ResultSet results=statement.executeQuery();
		while(results.next())
		{
			Selection t=new Selection(results.getInt(1),results.getInt(2),results.getInt(3),results.getInt(4),results.getInt(5),results.getInt(6));
			selections.add(t);
		}
		return selections;
	}

	@Override
	public List<Selection> selectAll(String condition) throws Exception {
		String sql="select * from Selection "+condition;
		PreparedStatement statement=connect().prepareStatement(sql);
		List <Selection> selections=new ArrayList<Selection>();
		ResultSet results=statement.executeQuery();
		while(results.next())
		{
			Selection t=new Selection(results.getInt(1),results.getInt(2),results.getInt(3),results.getInt(4),results.getInt(5),results.getInt(6));
			selections.add(t);
		}
		return selections;
	}
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}
}

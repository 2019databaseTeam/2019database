package com.cloudea.concrete;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.SelectedTopicDAO;
import com.cloudea.models.SelectedTopic;
import com.cloudea.models.Student;


public class SelectedTopicDAOImpl extends SqlServerConnector implements SelectedTopicDAO {
   
	private static SelectedTopicDAOImpl instance = new SelectedTopicDAOImpl();
    public static SelectedTopicDAOImpl getInstance() {return SelectedTopicDAOImpl.instance;};
    private SelectedTopicDAOImpl() {}
		
		private static final String insertSql = "insert into SelectedTopic values(?, ?,?)";

		 private static final String deleteSql = "delete from SelectedTopic where stu_id = ?";

		 private static final String updateSql = "update SelectedTopic set select_time=? where stu_id=? AND pl_id=?";

		 private static final String selectSql = "select * from SelectedTopic where stu_id = ?";
		 
		 public void insert(SelectedTopic selectedTopic) throws Exception {
				PreparedStatement statement=connect().prepareStatement(insertSql);
				statement.setInt(1, selectedTopic.getStu_id());
				statement.setInt(2, selectedTopic.getPl_id());
				statement.setString(3, selectedTopic.getSelect_time());
				statement.execute();
				
			}
		 
		 public void delete(SelectedTopic selectedTopic) throws Exception {
				PreparedStatement statement=connect().prepareStatement(deleteSql);
				statement.setInt(1,selectedTopic.getStu_id());
				statement.execute();
			}
		 
		 public void update(SelectedTopic selectedTopic) throws Exception {
				// TODO Auto-generated method stub
				PreparedStatement statement=connect().prepareStatement(updateSql);
				statement.setInt(2, selectedTopic.getStu_id());
				statement.setInt(3, selectedTopic.getPl_id());
				statement.setString(1, selectedTopic.getSelect_time());
				statement.execute();
			}
		 
		 public SelectedTopic select(int id) throws Exception {
				// TODO Auto-generated method stub
				PreparedStatement statement=connect().prepareStatement(selectSql);
				statement.setInt(1,id);
				ResultSet results=statement.executeQuery();
				if(results.next())
				{
					SelectedTopic selectedTopic=new SelectedTopic();
					selectedTopic.setStu_id(results.getInt("stu_id"));
					selectedTopic.setPl_id(results.getInt("pl_id"));
					return selectedTopic;
					
				}
				 return null;
			}
		 
		 public SelectedTopic select(String key, String value) throws Exception {
				// TODO Auto-generated method stub
			 String sql1 = "select * from SelectedTopic where "+key+" =  "+value+"   ";
				PreparedStatement statement=connect().prepareStatement(sql1);
					ResultSet results=statement.executeQuery();
					if(results.next())
					{
						SelectedTopic a=new SelectedTopic();
						a.setStu_id(results.getInt("stu_id"));
					    a.setPl_id(results.getInt("pl_id"));
						a.setSelect_time(results.getString("select_time"));
						return a;
						
					}
				return null;
		 }
		 
		 

	 public static void main(String[] args) {
		 SelectedTopicDAOImpl a=new SelectedTopicDAOImpl();
		 try {
			//a.insert(new SelectedTopic(2,3,"2019-1-1"));
			 //a.delete(new SelectedTopic(2,3,"2019-1-1"));
			 a.update(new SelectedTopic(1,4,"2019-9-9"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public List<SelectedTopic> selectAll(String condition) throws Exception {
			String sql="select * from SelectedTopic "+condition;
			PreparedStatement statement=connect().prepareStatement(sql);
			List <SelectedTopic> selectedTopics = new ArrayList<SelectedTopic>();
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				SelectedTopic t=new SelectedTopic(results.getInt(1),results.getInt(2),results.getString(3));
				selectedTopics.add(t);
			}
			return selectedTopics;
	}
	@Override
	public List<SelectedTopic> selectAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from SelectedTopic";
		PreparedStatement statement=connect().prepareStatement(sql);
		List <SelectedTopic> selectedTopics = new ArrayList<SelectedTopic>();
		ResultSet results=statement.executeQuery();
		while(results.next())
		{
			SelectedTopic t=new SelectedTopic(results.getInt(1),results.getInt(2),results.getString(3));
			selectedTopics.add(t);
		}
		return selectedTopics;
	}
	 
	

}

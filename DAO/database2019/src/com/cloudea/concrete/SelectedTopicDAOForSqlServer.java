package dao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.SelectedTopicDAO;
import com.cloudea.models.SelectedTopic;
import com.cloudea.models.Student;
import com.cloudea.models.SelectedTopic;

public class SelectedTopicDAOForSqlServer extends SqlServerConnector implements SelectedTopicDAO {
   
	private static SelectedTopicDAOForSqlServer instance = new SelectedTopicDAOForSqlServer();
    public static SelectedTopicDAOForSqlServer getInstance() {return SelectedTopicDAOForSqlServer.instance;};
    private SelectedTopicDAOForSqlServer() {}
		
		private static final String insertSql = "insert into SelectedTopic values(?, ?)";

		 private static final String deleteSql = "delete from SelectedTopic where stu_id = ?";

		 private static final String updateSql = "update SelectedTopic set  stu_id = ?, pl_id = ?";

		 private static final String selectSql = "select * from SelectedTopic where stu_id = ?";
		 
		 public void insert(SelectedTopic selectedTopic) throws Exception {
				PreparedStatement statement=connect().prepareStatement(insertSql);
				statement.setInt(1, selectedTopic.getStu_id());
				statement.setInt(2, selectedTopic.getPl_id());
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
				statement.setInt(1, selectedTopic.getStu_id());
				statement.setInt(2, selectedTopic.getPl_id());
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
				String sql1 = "select * from SelectedTopic where ? = ?";
				PreparedStatement statement=connect().prepareStatement(sql1);
				if(key=="stu_id")
				{
					statement.setString(1, "stu_id");
					statement.setInt(2,Integer.parseInt(value));
					ResultSet results=statement.executeQuery();
					if(results.next())
					{
						SelectedTopic selectedTopic=new SelectedTopic();
						selectedTopic.setStu_id(results.getInt("stu_id"));
						selectedTopic.setPl_id(results.getInt("pl_id"));
						return selectedTopic;
						
					}
				}
				else if(key=="pl_id")
				{
					statement.setString(1, "pl_id");
					statement.setInt(2,Integer.parseInt(value));
					ResultSet results=statement.executeQuery();
					if(results.next())
					{
						SelectedTopic selectedTopic=new SelectedTopic();
						selectedTopic.setStu_id(results.getInt("stu_id"));
						selectedTopic.setPl_id(results.getInt("pl_id"));
						return selectedTopic;
					}
				}
				return null;
		 }
		 
		 public List<SelectedTopic> selectAll() throws Exception {
				String sql="select * from SelectedTopic";
				PreparedStatement statement=connect().prepareStatement(sql);
				List <SelectedTopic> selectedTopics=new ArrayList<SelectedTopic>();
				ResultSet results=statement.executeQuery();
				while(results.next())
				{
					SelectedTopic t=new SelectedTopic(results.getInt(1),results.getInt(2));
					selectedTopics.add(t);
				}
				return selectedTopics;
			}

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	//}

}

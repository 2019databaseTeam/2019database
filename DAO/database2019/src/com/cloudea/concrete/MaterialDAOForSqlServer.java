package com.cloudea.concrete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.MaterialDAO;
import com.cloudea.models.Material;

public  class MaterialDAOForSqlServer extends SqlServerConnector implements MaterialDAO {

	   private static MaterialDAOForSqlServer instance = new MaterialDAOForSqlServer();
       public static MaterialDAOForSqlServer getInstance() {return MaterialDAOForSqlServer.instance;};
       MaterialDAOForSqlServer() {}
		
		private static final String insertSql = "insert into Material(stu_id,m_text) values(?, ?)";

		 private static final String deleteSql = "delete from Material where m_id = ?";

		 private static final String updateSql = "update Material set stu_id = ?, m_text = ? where m_id=?";

		 private static final String selectSql = "select * from Material where m_id = ?";
		 
		 
		public void insert(Material material) throws Exception
		{
			PreparedStatement statement=connect().prepareStatement(insertSql);
			statement.setInt(1, material.getStu_id());
			statement.setString(2, material.getM_text());
			statement.execute();
		}
		public void delete(Material material) throws Exception
		{
		    PreparedStatement statement=connect().prepareStatement(deleteSql);
			statement.setInt(1, material.getM_id());
			statement.execute();
		}
		public void update(Material material) throws Exception
		{
			PreparedStatement statement=connect().prepareStatement(updateSql);
			statement.setInt(1, material.getStu_id());
			statement.setString(2, material.getM_text());
			statement.setInt(3, material.getM_id());
			statement.execute();
		}
		public Material select(int m_id) throws Exception
		{
			PreparedStatement statement=connect().prepareStatement(selectSql);
			statement.setInt(1, m_id);
			ResultSet results=statement.executeQuery();
			System.out.println("m_id"+"  "+"stu_id"+"  "+"m_text");
			if(results.next())
			{
				Material material=new Material();
				material.setM_id(results.getInt("m_id"));
				material.setStu_id(results.getInt("stu_id"));
				material.setM_text(results.getString("m_text"));
				
				return material;
				
			}
			 return null;
		}
		public Material select(String key, String value) throws Exception
		{
			String sql1 = "select * from Material where ? = ?";
			PreparedStatement statement=connect().prepareStatement(sql1);
			if(key=="m_id")
			{
				statement.setString(1, "m_id");
				statement.setInt(2,Integer.parseInt(value));
				ResultSet results=statement.executeQuery();
				if(results.next())
				{
					Material material=new Material();
					material.setM_id(results.getInt("m_id"));
					material.setStu_id(results.getInt("stu_id"));
					material.setM_text(results.getString("m_text"));
					return material;
					
				}
			}
			else if(key=="stu_id")
			{
				statement.setString(1, "stu_id");
				statement.setInt(2,Integer.parseInt(value));
				ResultSet results=statement.executeQuery();
				if(results.next())
				{
					Material material=new Material();
					material.setM_id(results.getInt("m_id"));
					material.setStu_id(results.getInt("stu_id"));
					material.setM_text(results.getString("m_text"));
					return material;
					
				}
			}
			else if(key=="m_text")
			{
				statement.setString(1, "m_text");
				statement.setString(2,value);
				ResultSet results=statement.executeQuery();
				if(results.next())
				{
					Material material=new Material();
					material.setM_id(results.getInt("m_id"));
					material.setStu_id(results.getInt("stu_id"));
					material.setM_text(results.getString("m_text"));
					return material;
					
				}
			}
			return null;
		}
		public List<Material> selectAll() throws Exception
		{
			String sql="select * from Material";
			PreparedStatement statement=connect().prepareStatement(sql);
			List <Material> materials=new ArrayList<Material>();
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				Material t=new Material(results.getInt(1),results.getInt(2),results.getString(3));
				materials.add(t);
			}
			return materials;
		}
		public List<Material> selectAll(String condition) throws Exception {
			String sql="select * from Material "+condition;
			PreparedStatement statement=connect().prepareStatement(sql);
			List <Material> materials=new ArrayList<Material>();
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				Material t=new Material(results.getInt(1),results.getInt(2),results.getString(3));
				materials.add(t);
			}
			return materials;
			
			}

	public static void main(String[] args) {
		
	    	try
	    	{
		    MaterialDAOForSqlServer b=new MaterialDAOForSqlServer();
	    	Material a=new Material(5 ,1,"wo") ;
	    	
	    	//b.insert(a);
	    	//b.delete(new Material(2,1,"wo"));
	    	//b.insert(a);
	    	//Material c=new Material(3 ,1,"ni") ;
	    	//b.update(c);
	    	//b.select(3);
	    	}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	  

	}
	
	

	
	

}

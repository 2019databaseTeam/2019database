package com.cloudea.concrete;

import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.ChatRecordDAO;
import com.cloudea.models.ChatRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ChatRecordDAOImpl extends SqlServerConnector implements ChatRecordDAO{
	private static ChatRecordDAOImpl instance= new ChatRecordDAOImpl();
	public static ChatRecordDAOImpl getInstance() {return ChatRecordDAOImpl.instance;};
	
	private ChatRecordDAOImpl() {}
	private static final String insertSql="insert into ChatRecord(u_id_send,u_id_receive,time,content) values(?,?,?,?)";
	private static final String deleteSql="delete from ChatRecord where mes_id = ?";
	private static final String updateSql="update ChatRecord set u_id_send=?,u_id_receive=?,time=?,content=? where mes_id=?";
	private static final String selectSql="select * from ChatRecord where mes_id=?";
	
	@Override
	public void insert(ChatRecord chatrecord) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		//statement.setInt(1, chatrecord.getMes_id());
		statement.setInt(1, chatrecord.getU_id_send());
		statement.setInt(2, chatrecord.getU_id_receive());
		statement.setString(3, chatrecord.getTime());
		statement.setString(4, chatrecord.getContent());
		statement.execute();
	}
	
	@Override
	public void delete(ChatRecord chatrecord) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,chatrecord.getMes_id());
		statement.execute();
	}
	
	@Override
	public void update(ChatRecord chatrecord)throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, chatrecord.getU_id_send());
		statement.setInt(2, chatrecord.getU_id_receive());
		statement.setString(3, chatrecord.getTime());
		statement.setString(4, chatrecord.getContent());
		statement.setInt(5, chatrecord.getMes_id());
		statement.execute();
	}
	
	@Override
	public ChatRecord select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
	
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			ChatRecord chatrecord=new ChatRecord();
			chatrecord.setMes_id(result.getInt("mes_id"));
			chatrecord.setU_id_send(result.getInt("u_id_send"));
			chatrecord.setU_id_receive(result.getInt("u_id_receive"));
			chatrecord.setTime(result.getString("time"));
			chatrecord.setContent(result.getString("content"));
			return chatrecord;
		}
		return null;
	}
	
	
	@Override
	public ChatRecord select(String key, String value) throws Exception {
		String sql="select * from ChatRecord where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			ChatRecord chatrecord =new ChatRecord();
			chatrecord.setMes_id(result.getInt("mes_id"));
			chatrecord.setU_id_send(result.getInt("u_id_send"));
			chatrecord.setU_id_receive(result.getInt("u_id_receive"));
			chatrecord.setTime(result.getString("time"));
			chatrecord.setContent(result.getString("content"));
			return chatrecord;
		}
		return null;
	}
	
	@Override
	public List<ChatRecord> selectAll() throws Exception {
		String sql="select * from ChatRecord";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<ChatRecord>chatrecords=new ArrayList<ChatRecord>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			ChatRecord t = new ChatRecord(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5));
			chatrecords.add(t);
		}
		return chatrecords;
	}
	
	@Override
	public List<ChatRecord> selectAll(String condition) throws Exception {
		String sql="select * from ChatRecord "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<ChatRecord>chatrecords=new ArrayList<ChatRecord>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			ChatRecord t = new ChatRecord(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4),result.getString(5));
			chatrecords.add(t);
		}
		return chatrecords;
	}
//≤‚ ‘
//	public static void main(String[] args) throws Exception {
//		ChatRecord chatrecord=new ChatRecord(7,2,3,"2019-9-10","good good");
//		ChatRecord chatrecord1=new ChatRecord(8,1,2,"2019-9-11","not good");
//		ChatRecord chatrecord2=new ChatRecord();
//		ChatRecordDAOImpl.getInstance().insert(chatrecord);
//		ChatRecordDAOImpl.getInstance().delete(chatrecord);
//		ChatRecordDAOImpl.getInstance().update(chatrecord1);
//		chatrecord2=ChatRecordDAOImpl.getInstance().select(5);
//		System.out.println(chatrecord2.getMes_id()+"  "+chatrecord2.getU_id_send()+" "+chatrecord2.getU_id_receive()+" "+chatrecord2.getTime()+" "+chatrecord2.getContent());
//		chatrecord2=ChatRecordDAOImpl.getInstance().select("u_id_send","2");
//		chatrecord2=ChatRecordDAOImpl.getInstance().select("u_id_receive","1");
//		System.out.println(chatrecord2.getMes_id()+"  "+chatrecord2.getU_id_send()+" "+chatrecord2.getU_id_receive()+" "+chatrecord2.getTime()+" "+chatrecord2.getContent());
//		List<ChatRecord> chatrecords;
//		chatrecords=ChatRecordDAOImpl.getInstance().selectAll();
//		for(ChatRecord chatrecord2:chatrecords) {
//			System.out.println(chatrecord2.getMes_id()+"  "+chatrecord2.getU_id_send()+" "+chatrecord2.getU_id_receive()+" "+chatrecord2.getTime()+" "+chatrecord2.getContent());
//		}
//		chatrecords=ChatRecordDAOImpl.getInstance().selectAll("where u_id_send = 2 ");
//		for(ChatRecord chatrecord2:chatrecords) {
//		System.out.println(chatrecord2.getMes_id()+"  "+chatrecord2.getU_id_send()+" "+chatrecord2.getU_id_receive()+" "+chatrecord2.getTime()+" "+chatrecord2.getContent());
//		}
		
//		}
}
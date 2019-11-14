package com.cloudea.concrete;

import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.ScoreDAO;
import com.cloudea.models.Score;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ScoreDAOImpl extends SqlServerConnector implements ScoreDAO{
	private static ScoreDAOImpl instance= new ScoreDAOImpl();
	public static ScoreDAOImpl getInstance() {return ScoreDAOImpl.instance;};	
	private ScoreDAOImpl() {}
	private static final String insertSql="insert into Score values(?,?,?,?)";
	private static final String deleteSql="delete from Score where rep_id = ?";
	private static final String updateSql="update Score set tch_id=?,score=?,comments=? where rep_id=?";
	private static final String selectSql="select * from Score where rep_id=?";
	
	@Override
	public void insert(Score score) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, score.getRep_id());
		statement.setInt(2, score.getTch_id());
		statement.setString(3, score.getComments());
		statement.setInt(4, score.getScore());
		statement.execute();
	}
	
	@Override
	public void delete(Score score) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,score.getRep_id());
		statement.execute();
	}
	
	@Override
	public void update(Score score)throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, score.getTch_id());
		statement.setInt(2, score.getScore());
		statement.setString(3, score.getComments());
		statement.setInt(4,score.getRep_id());
		statement.execute();
	}
	
	@Override
	public Score select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
	
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Score score=new Score();
			score.setRep_id(result.getInt("rep_id"));
			score.setTch_id(result.getInt("tch_id"));
			score.setScore(result.getInt("score"));
			score.setComments(result.getString("comments"));
			return score;
		}
		return null;
	}
	
	
	@Override
	public Score select(String key, String value) throws Exception {
		String sql="select * from Score where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Score score =new Score();
			score.setRep_id(result.getInt("rep_id"));
			score.setTch_id(result.getInt("tch_id"));
			score.setScore(result.getInt("score"));
			score.setComments(result.getString("comments"));
			return score;
		}
		return null;
	}
	
	@Override
	public List<Score> selectAll() throws Exception {
		String sql="select * from Score";
		PreparedStatement statement=connect().prepareStatement(sql);
		List<Score>scores=new ArrayList<Score>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Score t = new Score(result.getInt(1),result.getInt(2),result.getString(3),result.getInt(4));
			scores.add(t);
		}
		return scores;
	}
	
	@Override
	public List<Score> selectAll(String condition) throws Exception {
		String sql="select * from Score "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Score>scores=new ArrayList<Score>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Score t = new Score(result.getInt(1),result.getInt(2),result.getString(3),result.getInt(4));
			scores.add(t);
		}
		return scores;
	}
	
	
	
	//≤‚ ‘
//	public static void main(String[] args) throws Exception {
//		Score score=new Score(12,1,"good good",100);
//		Score score1=new Score(15,1,"not good",59);
//		Score score2=new Score();
//		ScoreDAOImpl.getInstance().insert(score);
//		ScoreDAOImpl.getInstance().delete(score);
//		ScoreDAOImpl.getInstance().update(score1);
//		score2=ScoreDAOImpl.getInstance().select(15);
//		System.out.println(score2.getRep_id()+"  "+score2.getTch_id()+" "+score2.getComments()+" "+score2.getScore());
//		score2=ScoreDAOImpl.getInstance().select("tch_id","1");
//		score2=ScoreDAOImpl.getInstance().select("comment","1");
//		System.out.println(score2.getRep_id()+" "+score2.getTch_id()+" "+score2.getComments()+" "+score2.getScore());
//		List<Score> scores;
//		scores=ScoreDAOImpl.getInstance().selectAll();
//		for(Score score2:scores) {
//			System.out.println(score2.getRep_id()+" "+score2.getTch_id()+" "+score2.getComments()+" "+score2.getScore());
//		}
//		scores=ScoreDAOImpl.getInstance().selectAll("where score > 60 ");
//		for(Score score2:scores) {
//			System.out.println(score2.getRep_id()+" "+score2.getTch_id()+" "+score2.getComments()+" "+score2.getScore());
//		}
		
//	}
}
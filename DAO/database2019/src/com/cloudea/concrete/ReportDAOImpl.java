package dao4;

import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.ReportDAO;
import com.cloudea.models.Report;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ReportDAOImpl extends SqlServerConnector implements ReportDAO{
	private static ReportDAOImpl instance= new ReportDAOImpl();
	public static ReportDAOImpl getInstance() {return ReportDAOImpl.instance;};
	
	private ReportDAOImpl() {}
	private static final String insertSql="insert into Report values(?,?,?,?,?)";
	private static final String deleteSql="delete from Report where rep_id = ?";
	private static final String updateSql="update Report set rep_id=?,stu_id=?,pl_id=?,rept_id=?,time=?,content_report=?";
	private static final String selectSql="select * from Report where rep_id=?";
	
	@Override
	public void insert(Report report) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, report.getRep_id());
		statement.setInt(2, report.getStu_id());
		statement.setInt(3, report.getPl_id());
		statement.setInt(4, report.getRept_id());
		statement.setString(5, report.getTime());
		statement.setString(6, report.getContent_report());
		statement.execute();
	}
	
	@Override
	public void delete(Report report) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,report.getRep_id());
		statement.execute();
	}
	
	@Override
	public void update(Report report)throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setInt(1, report.getRep_id());
		statement.setInt(2, report.getStu_id());
		statement.setInt(3, report.getPl_id());
		statement.setInt(4, report.getRept_id());
		statement.setString(5, report.getTime());
		statement.setString(6, report.getContent_report());
		statement.execute();
	}
	
	@Override
	public Report select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
	
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			Report report=new Report();
			report.setRep_id(result.getInt("rep_id"));
			report.setStu_id(result.getInt("stu_id"));
			report.setPl_id(result.getInt("pl_id"));
			report.setRept_id(result.getInt("rept_id"));
			report.setTime(result.getString("time"));
			report.setContent_report(result.getString("content_report"));
			return report;
		}
		return null;
	}
	
	
	@Override
	public Report select(String key, String value) throws Exception {
		String sql="select * from Report where "+key+"='"+value+"'";
		PreparedStatement statement = connect().prepareStatement(sql);

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			Report report =new Report();
			report.setRep_id(result.getInt("rep_id"));
			report.setStu_id(result.getInt("stu_id"));
			report.setPl_id(result.getInt("pl_id"));
			report.setRept_id(result.getInt("rept_id"));
			report.setTime(result.getString("time"));
			report.setContent_report(result.getString("content_report"));
			return report;
		}
		return null;
	}
	
	@Override
	public List<Report> selectAll() throws Exception {
		String sql="select * from Report";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Report>reports=new ArrayList<Report>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Report t = new Report(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4),result.getString(5),result.getString(6));
			reports.add(t);
		}
		return reports;
	}
	
	@Override
	public List<Report> selectAll(String condition) throws Exception {
		String sql="select * from Report "+condition;
		PreparedStatement statement = connect().prepareStatement(sql);
		List<Report>reports=new ArrayList<Report>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			Report t = new Report(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4),result.getString(5),result.getString(6));
			reports.add(t);
		}
		return reports;
	}
}
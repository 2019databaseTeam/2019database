package com.cloudea.concrete;

import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.ReportTypeDAO;
import com.cloudea.models.ReportType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ReportTypeDAOImpl extends SqlServerConnector implements ReportTypeDAO{
	private static ReportTypeDAOImpl instance= new ReportTypeDAOImpl();
	public static ReportTypeDAOImpl getInstance() {return ReportTypeDAOImpl.instance;};
	
	private ReportTypeDAOImpl() {}
	private static final String insertSql="insert into ReportType values(?,?)";
	private static final String deleteSql="delete from ReportType where rept_id=?";
	private static final String updateSql="update ReportType set report_type=? where rept_id = ?";
	private static final String selectSql="select * from ReportType where rept_id=?";
	
	@Override
	public void insert(ReportType reporttype) throws Exception {
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, reporttype.getRept_id());
		statement.setString(2, reporttype.getReport_type());
		statement.execute();
	}
	
	@Override
	public void delete(ReportType reporttype) throws Exception {
		PreparedStatement statement = connect().prepareStatement(deleteSql);
		statement.setInt(1,reporttype.getRept_id());
		statement.execute();
	}
	
	@Override
	public void update(ReportType reporttype)throws Exception {
		PreparedStatement statement = connect().prepareStatement(updateSql);
		statement.setString(1, reporttype.getReport_type());
		statement.setInt(2, reporttype.getRept_id());
		statement.execute();
	}
	
	@Override
	public ReportType select(int id) throws Exception {
		PreparedStatement statement = connect().prepareStatement(selectSql);
		statement.setInt(1,id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			ReportType reporttype=new ReportType();
			reporttype.setRept_id(result.getInt("rept_id"));
			reporttype.setReport_type(result.getString("report_type"));
			return reporttype;
		}
		return null;
	}
	@Override
	public List<ReportType> selectAll() throws Exception {
		String sql="select * from ReportType";
		PreparedStatement statement = connect().prepareStatement(sql);
		List<ReportType>reports=new ArrayList<ReportType>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			ReportType t = new ReportType(result.getInt(1),result.getString(2));
			reports.add(t);
		}
		return reports;
	}
	
	
	
	
	//测试
//	public static void main(String[] args) throws Exception {
//		ReportType reporttype=new ReportType(6,"月报2");
//		ReportType reporttype1=new ReportType(3,"月报3");
//		ReportType reporttype2=new ReportType();
//		ReportTypeDAOImpl.getInstance().insert(reporttype);
//		ReportTypeDAOImpl.getInstance().delete(reporttype);
//		ReportTypeDAOImpl.getInstance().update(reporttype1);
//		reporttype2=ReportTypeDAOImpl.getInstance().select(2);
//		System.out.println(reporttype2.getRept_id()+"  "+reporttype2.getReport_type());

//		List<ReportType> reporttypes;
//		reporttypes=ReportTypeDAOImpl.getInstance().selectAll();
//		for(ReportType reporttype2:reporttypes) {
//			System.out.println(reporttype2.getRept_id()+"  "+reporttype2.getReport_type());
//		}
//
//		}	
//	
}
package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestReport {
	
	//创建一个工厂
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//从工厂获取DAO
		ReportDAO d = (ReportDAO) factory.getDAO("Report");
		
		
		
		//插入数据测试（插入两条）
		Report ad1 = new Report();
	    ad1.setRep_id(2);;
	    ad1.setPl_id(1);
	    ad1.setRept_id(1);
	    ad1.setStu_id(1);
	    ad1.setContent_report("测试用例");
	    
	    
	    
//		d.insert(ad1);
////		
////		//更新数据测试
//		ad1.setContent_report("测试");
//		d.update(ad1);
		
		//删除数据测试
		d.delete(ad1);
//		
//		
		//查询数据测试1
//	    Report ad3 = d.select(2);
//		show(ad3);
		
		//查询数据测试2
//		Report ad4 = d.select("rep_id","2");
//		show(ad4);
		
//		查询数据测试3
		List<Report> ads1 = d.selectAll();
		for(Report ad : ads1) {
			show(ad);
		}
		
		//查询数据测试4
		List<Report> ads2 = d.selectAll("where rept_id = 1");
		for(Report ad : ads2) {
			show(ad);
		}
	}
	
	public void show(Report ad) {
		System.out.println("u_id : " + ad.getContent_report());
	}
}

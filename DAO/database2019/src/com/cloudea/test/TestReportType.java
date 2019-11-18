
package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestReportType {
	
	//创建一个工厂
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//从工厂获取DAO
		ReportTypeDAO d = (ReportTypeDAO) factory.getDAO("ReportType");
		
		
		
		//插入数据测试（插入两条）
		ReportType ad1 = new ReportType();
	    ad1.setReport_type("测试用例");
	    ad1.setRept_id(4);

//		d.insert(ad1);
		
		//更新数据测试
		ad1.setReport_type("sad1");
		d.update(ad1);
		
//		删除数据测试
		d.delete(ad1);
		
		

//		//查询数据测试2
//		ReportType ad4 = d.select(2);
//		show(ad4);
		
		//查询数据测试4
		List<ReportType> ads2 = d.selectAll();
		for(ReportType ad : ads2) {
			show(ad);
		}
	}
	
	public void show(ReportType ad) {
		System.out.println("u_id : " + ad.getReport_type());
	}
}

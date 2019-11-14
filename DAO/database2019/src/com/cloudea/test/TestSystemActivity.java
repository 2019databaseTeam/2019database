package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestSystemActivity {
	
	//创建一个工厂
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//从工厂获取DAO
		SystemActivityDAO d = (SystemActivityDAO) factory.getDAO("SystemActivity");
		
		
		
		//插入数据测试（插入两条）
		SystemActivity ad1 = new SystemActivity();
	    ad1.setSa_id(3);
	    ad1.setSa_name("测试用例");
	    
	    
	    
//		d.insert(ad1);
////		
//		//更新数据测试
		ad1.setSa_name("测试");
		d.update(ad1);
		
		//删除数据测试
		d.delete(ad1);
		
		//查询数据测试1
//	    SystemActivity ad3 = d.select(3);
//		show(ad3);
		
		//查询数据测试2
//		SystemActivity ad4 = d.select("sa_id",3);
//		show(ad4);
		
//		查询数据测试3
		List<SystemActivity> ads1 = d.selectAll();
		for(SystemActivity ad : ads1) {
			show(ad);
		}
		
		//查询数据测试4
		List<SystemActivity> ads2 = d.selectAll("where sa_id = 3");
		for(SystemActivity ad : ads2) {
			show(ad);
		}
	}
	
	public void show(SystemActivity ad) {
		System.out.println("u_id : " + ad.getSa_name());
	}
}

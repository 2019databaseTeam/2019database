package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cloudea.models.Major;
import com.cloudea.daoes.MajorDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;

public class TestMajor {
	
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void TestA() throws Exception {
		MajorDAO d=(MajorDAO) factory.getDAO("Major");
		
		//插入
		Major ad1=new Major();
		Major ad2=new Major();
		ad1.setMajorName("日语");
		ad2.setMajorName("人力资源管理");
		//d.insert(ad1);
		//d.insert(ad2);
		
		
		//更新
		//ad2.setMajorName("艺术设计");
		//ad2.setMajorId(12);
		//d.update(ad2);
		
		//删除
		ad1.setMajorId(11);
		d.delete(ad1);
		
		//查询
		Major ad3=d.select(5);
		show(ad3);
		//Major ad4=d.select("mjr_name","日语");
		//show(ad4);
		
		List<Major>ads1=d.selectAll();
		for(Major ad:ads1) {
			show(ad);
		}
		
		List<Major>ads2= d.selectAll("where mjr_id=6");
		for(Major ad:ads2) {
			show(ad);
		}
		
	}

	private void show(Major ad) {
		System.out.println("mjr_id : "+ad.getMajorId());
		System.out.println("mjr_name : "+ad.getMajorName());
		
	}

}

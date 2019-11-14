package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestScore {
	
	//创建一个工厂
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//从工厂获取DAO
		ScoreDAO d = (ScoreDAO) factory.getDAO("Score");
		
		
		
		//插入数据测试（插入两条）
		Score ad1 = new Score();
	    ad1.setRep_id(3);;
	    ad1.setTch_id(1);
	    ad1.setComments("测试用例");
	    ad1.setScore(100);

	    
	    
	    
//		d.insert(ad1);
////		
////		//更新数据测试
//		ad1.setComments("测试");
//		d.update(ad1);
		
		//删除数据测试
		d.delete(ad1);
//		
//		
		//查询数据测试1
//	    Score ad3 = d.select(3);
//		show(ad3);
		
		//查询数据测试2
//		Score ad4 = d.select("rep_id","3");
//		show(ad4);
		
//		查询数据测试3
		List<Score> ads1 = d.selectAll();
		for(Score ad : ads1) {
			show(ad);
		}
		
		//查询数据测试4
		List<Score> ads2 = d.selectAll("where tch_id = 1");
		for(Score ad : ads2) {
			show(ad);
		}
	}
	
	public void show(Score ad) {
		System.out.println("u_id : " + ad.getComments());
	}
}

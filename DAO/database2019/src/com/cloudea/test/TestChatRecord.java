package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestChatRecord {
	
	//创建一个工厂
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//从工厂获取DAO
		ChatRecordDAO d = (ChatRecordDAO) factory.getDAO("ChatRecord");
		
		
		
		//插入数据测试（插入两条）
		ChatRecord ad1 = new ChatRecord();
	    ad1.setMes_id(2);
	    ad1.setU_id_send(1);
	    ad1.setU_id_receive(3);
	    ad1.setContent("sad");;
//		d.insert(ad1);
//		
//		//更新数据测试
//		ad1.setContent("sad1");
//		d.update(ad1);
		
		//删除数据测试
		d.delete(ad1);
//		
//		
		//查询数据测试1
//	    ChatRecord ad3 = d.select(2);
//		show(ad3);
		
		//查询数据测试2
//		ChatRecord ad4 = d.select("mes_id","2");
//		show(ad4);
		
		//查询数据测试3
//		List<ChatRecord> ads1 = d.selectAll();
//		for(ChatRecord ad : ads1) {
//			show(ad);
//		}
		
		//查询数据测试4
		List<ChatRecord> ads2 = d.selectAll("where u_id_receive = 3");
		for(ChatRecord ad : ads2) {
			show(ad);
		}
	}
	
	public void show(ChatRecord ad) {
		System.out.println("u_id : " + ad.getContent());
	}
}

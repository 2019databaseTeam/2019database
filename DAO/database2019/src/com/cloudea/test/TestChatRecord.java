package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestChatRecord {
	
	//����һ������
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//�ӹ�����ȡDAO
		ChatRecordDAO d = (ChatRecordDAO) factory.getDAO("ChatRecord");
		
		
		
		//�������ݲ��ԣ�����������
		ChatRecord ad1 = new ChatRecord();
	    ad1.setMes_id(2);
	    ad1.setU_id_send(1);
	    ad1.setU_id_receive(3);
	    ad1.setContent("sad");;
//		d.insert(ad1);
//		
//		//�������ݲ���
//		ad1.setContent("sad1");
//		d.update(ad1);
		
		//ɾ�����ݲ���
		d.delete(ad1);
//		
//		
		//��ѯ���ݲ���1
//	    ChatRecord ad3 = d.select(2);
//		show(ad3);
		
		//��ѯ���ݲ���2
//		ChatRecord ad4 = d.select("mes_id","2");
//		show(ad4);
		
		//��ѯ���ݲ���3
//		List<ChatRecord> ads1 = d.selectAll();
//		for(ChatRecord ad : ads1) {
//			show(ad);
//		}
		
		//��ѯ���ݲ���4
		List<ChatRecord> ads2 = d.selectAll("where u_id_receive = 3");
		for(ChatRecord ad : ads2) {
			show(ad);
		}
	}
	
	public void show(ChatRecord ad) {
		System.out.println("u_id : " + ad.getContent());
	}
}

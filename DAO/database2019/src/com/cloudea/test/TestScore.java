package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestScore {
	
	//����һ������
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//�ӹ�����ȡDAO
		ScoreDAO d = (ScoreDAO) factory.getDAO("Score");
		
		
		
		//�������ݲ��ԣ�����������
		Score ad1 = new Score();
	    ad1.setRep_id(3);;
	    ad1.setTch_id(1);
	    ad1.setComments("��������");
	    ad1.setScore(100);

	    
	    
	    
//		d.insert(ad1);
////		
////		//�������ݲ���
//		ad1.setComments("����");
//		d.update(ad1);
		
		//ɾ�����ݲ���
		d.delete(ad1);
//		
//		
		//��ѯ���ݲ���1
//	    Score ad3 = d.select(3);
//		show(ad3);
		
		//��ѯ���ݲ���2
//		Score ad4 = d.select("rep_id","3");
//		show(ad4);
		
//		��ѯ���ݲ���3
		List<Score> ads1 = d.selectAll();
		for(Score ad : ads1) {
			show(ad);
		}
		
		//��ѯ���ݲ���4
		List<Score> ads2 = d.selectAll("where tch_id = 1");
		for(Score ad : ads2) {
			show(ad);
		}
	}
	
	public void show(Score ad) {
		System.out.println("u_id : " + ad.getComments());
	}
}

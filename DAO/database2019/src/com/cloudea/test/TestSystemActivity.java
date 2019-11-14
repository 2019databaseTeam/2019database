package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestSystemActivity {
	
	//����һ������
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//�ӹ�����ȡDAO
		SystemActivityDAO d = (SystemActivityDAO) factory.getDAO("SystemActivity");
		
		
		
		//�������ݲ��ԣ�����������
		SystemActivity ad1 = new SystemActivity();
	    ad1.setSa_id(3);
	    ad1.setSa_name("��������");
	    
	    
	    
//		d.insert(ad1);
////		
//		//�������ݲ���
		ad1.setSa_name("����");
		d.update(ad1);
		
		//ɾ�����ݲ���
		d.delete(ad1);
		
		//��ѯ���ݲ���1
//	    SystemActivity ad3 = d.select(3);
//		show(ad3);
		
		//��ѯ���ݲ���2
//		SystemActivity ad4 = d.select("sa_id",3);
//		show(ad4);
		
//		��ѯ���ݲ���3
		List<SystemActivity> ads1 = d.selectAll();
		for(SystemActivity ad : ads1) {
			show(ad);
		}
		
		//��ѯ���ݲ���4
		List<SystemActivity> ads2 = d.selectAll("where sa_id = 3");
		for(SystemActivity ad : ads2) {
			show(ad);
		}
	}
	
	public void show(SystemActivity ad) {
		System.out.println("u_id : " + ad.getSa_name());
	}
}

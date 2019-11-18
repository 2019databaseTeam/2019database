package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestReport {
	
	//����һ������
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//�ӹ�����ȡDAO
		ReportDAO d = (ReportDAO) factory.getDAO("Report");
		
		
		
		//�������ݲ��ԣ�����������
		Report ad1 = new Report();
	    ad1.setRep_id(2);;
	    ad1.setPl_id(1);
	    ad1.setRept_id(1);
	    ad1.setStu_id(1);
	    ad1.setContent_report("��������");
	    
	    
	    
//		d.insert(ad1);
////		
////		//�������ݲ���
//		ad1.setContent_report("����");
//		d.update(ad1);
		
		//ɾ�����ݲ���
		d.delete(ad1);
//		
//		
		//��ѯ���ݲ���1
//	    Report ad3 = d.select(2);
//		show(ad3);
		
		//��ѯ���ݲ���2
//		Report ad4 = d.select("rep_id","2");
//		show(ad4);
		
//		��ѯ���ݲ���3
		List<Report> ads1 = d.selectAll();
		for(Report ad : ads1) {
			show(ad);
		}
		
		//��ѯ���ݲ���4
		List<Report> ads2 = d.selectAll("where rept_id = 1");
		for(Report ad : ads2) {
			show(ad);
		}
	}
	
	public void show(Report ad) {
		System.out.println("u_id : " + ad.getContent_report());
	}
}

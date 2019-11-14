
package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.cloudea.daoes.*;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.*;


public class TestReportType {
	
	//����һ������
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//�ӹ�����ȡDAO
		ReportTypeDAO d = (ReportTypeDAO) factory.getDAO("ReportType");
		
		
		
		//�������ݲ��ԣ�����������
		ReportType ad1 = new ReportType();
	    ad1.setReport_type("��������");
	    ad1.setRept_id(4);

//		d.insert(ad1);
		
		//�������ݲ���
		ad1.setReport_type("sad1");
		d.update(ad1);
		
//		ɾ�����ݲ���
		d.delete(ad1);
		
		

//		//��ѯ���ݲ���2
//		ReportType ad4 = d.select(2);
//		show(ad4);
		
		//��ѯ���ݲ���4
		List<ReportType> ads2 = d.selectAll();
		for(ReportType ad : ads2) {
			show(ad);
		}
	}
	
	public void show(ReportType ad) {
		System.out.println("u_id : " + ad.getReport_type());
	}
}

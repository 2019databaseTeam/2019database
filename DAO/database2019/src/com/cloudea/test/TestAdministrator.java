package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cloudea.daoes.AdministratorDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.Administrator;


public class TestAdministrator {
	
	//����һ������
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//�ӹ�����ȡDAO
		AdministratorDAO d = (AdministratorDAO) factory.getDAO("Administrator");
		
		
		
		//�������ݲ��ԣ�����������
	    /*Administrator ad1 = new Administrator();
	    Administrator ad2 = new Administrator();
	    ad1.setAd_name("����Ա����1");
	    ad1.setU_id(3);
	    ad2.setAd_name("����Ա����2");
	    ad2.setU_id(4);
		d.insert(ad1);
		d.insert(ad2);
		
		//�������ݲ���
		ad2.setAd_name("���ĺ�Ĺ���Ա����");
		d.update(ad2);
		
		//ɾ�����ݲ���
		d.delete(ad1);
		*/
		
		//��ѯ���ݲ���1
		Administrator ad3 = d.select(4);
		show(ad3);
		
		//��ѯ���ݲ���2
		Administrator ad4 = d.select("ad_name", "���ĺ�Ĺ���Ա����");
		show(ad4);
		
		//��ѯ���ݲ���3
		List<Administrator> ads1 = d.selectAll();
		for(Administrator ad : ads1) {
			show(ad);
		}
		
		//��ѯ���ݲ���4
		List<Administrator> ads2 = d.selectAll("where u_id = 4");
		for(Administrator ad : ads2) {
			show(ad);
		}
	}
	
	public void show(Administrator ad) {
		System.out.println("u_id : " + ad.getU_id());
		System.out.println("ad_name : " + ad.getAd_name());
	}
}

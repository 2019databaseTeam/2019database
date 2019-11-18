package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cloudea.daoes.AdministratorDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.Administrator;


public class TestAdministrator {
	
	//创建一个工厂
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception {
		
		//从工厂获取DAO
		AdministratorDAO d = (AdministratorDAO) factory.getDAO("Administrator");
		
		
		
		//插入数据测试（插入两条）
	    /*Administrator ad1 = new Administrator();
	    Administrator ad2 = new Administrator();
	    ad1.setAd_name("管理员名字1");
	    ad1.setU_id(3);
	    ad2.setAd_name("管理员名字2");
	    ad2.setU_id(4);
		d.insert(ad1);
		d.insert(ad2);
		
		//更新数据测试
		ad2.setAd_name("更改后的管理员名字");
		d.update(ad2);
		
		//删除数据测试
		d.delete(ad1);
		*/
		
		//查询数据测试1
		Administrator ad3 = d.select(4);
		show(ad3);
		
		//查询数据测试2
		Administrator ad4 = d.select("ad_name", "更改后的管理员名字");
		show(ad4);
		
		//查询数据测试3
		List<Administrator> ads1 = d.selectAll();
		for(Administrator ad : ads1) {
			show(ad);
		}
		
		//查询数据测试4
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

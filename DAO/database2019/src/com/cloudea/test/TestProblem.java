package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cloudea.daoes.ProblemDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.Problem;

public class TestProblem {

	DAOFactoryForSqlServer factory= new DAOFactoryForSqlServer();

	@Test
	public void testA() throws Exception{
		ProblemDAO d= (ProblemDAO) factory.getDAO("Problem");
		
		Problem ad1 = new Problem();
		Problem ad2 = new Problem();
		/*
		//插入
		ad1.setTch_id(1);
		ad1.setPlt_id(2);
		ad1.setPl_name("基于XX的对于XX的认识");
		ad1.setPl_degree("2");
		ad1.setPl_need("需求测试————基于XX的对于XX的认识");
		ad1.setPl_eva_mode("考核模式————基于XX的对于XX的认识");
		ad1.setMax_person(5);
		//d.insert(ad1);
		
		
		//更新
		ad2.setTch_id(1);
		ad2.setPlt_id(2);
		ad2.setPl_name("基于XX的对于XX的认识");
		ad2.setPl_degree("2");
		ad2.setPl_need("需求测试————基于XX的对于XX的认识");
		ad2.setPl_eva_mode("考核模式————基于XX的对于XX的认识");
		ad2.setMax_person(5);
		ad2.setPl_id(5);
		//d.update(ad2);
		
		//删除
		d.delete(ad2);
		
		Problem ad3 = d.select(3);
		show(ad3);*/
		
		List<Problem>ads1=d.selectAll();
		for(Problem ad:ads1) {
			show(ad);
		}
		
		List<Problem>ads2=d.selectAll("where tch_id=1");
		for(Problem ad:ads2) {
			show(ad);
		}
	}

	private void show(Problem ad) {
		System.out.println("pl_id : " + ad.getPl_id());
		System.out.println("tch_id : " + ad.getTch_id());
		System.out.println("plt_id : " + ad.getPlt_id());
		System.out.println("pl_name : " + ad.getPl_name());
		System.out.println("pl_degree : " + ad.getPl_degree());
		System.out.println("pl_need : " + ad.getPl_need());
		System.out.println("pl_eva_mode : " +ad.getPl_eva_mode());
		System.out.println("max_person : " + ad.getMax_person());
		
		
	}
}

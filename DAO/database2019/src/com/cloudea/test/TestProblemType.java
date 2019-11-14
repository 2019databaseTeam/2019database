package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cloudea.daoes.ProblemTypeDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.ProblemType;

public class TestProblemType {
	DAOFactoryForSqlServer factory = new DAOFactoryForSqlServer();
	
	@Test
	public void TestA() throws Exception{
		ProblemTypeDAO d= (ProblemTypeDAO) factory.getDAO("ProblemType");
		//����
		ProblemType ad1=new ProblemType();
		ad1.setPl_type("�������");
		//d.insert(ad1);
		
		//����
		ProblemType ad2=new ProblemType();
		ad2.setPl_type("��������");
		ad2.setPlt_id(2);
		//d.update(ad2);
		
		//ɾ��
		ad1.setPlt_id(3);
		//d.delete(ad1);
		
		//��
		ProblemType ad3=d.select(2);
		show(ad3);
		
		List<ProblemType> ads1=d.selectAll();
		for(ProblemType ad:ads1) {
			show(ad);
		}
	}

	private void show(ProblemType ad) {
		System.out.println("plt_id : "+ad.getPlt_id());
		System.out.println("pl_type : "+ad.getPl_type());
	}
}

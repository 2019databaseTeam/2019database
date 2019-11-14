package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cloudea.daoes.ProblemProfessionDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.ProblemProfession;
import com.cloudea.models.ProblemType;

public class TestProblemProfession {

		DAOFactoryForSqlServer factory= new DAOFactoryForSqlServer();
		
		@Test
		public void testA() throws Exception{
			ProblemProfessionDAO d=  (ProblemProfessionDAO)factory.getDAO("ProblemProfession");
			
			//增加
			ProblemProfession ad1 = new ProblemProfession();
			ad1.setMjr_id(12);
			ad1.setPl_id(2);
			//d.insert(ad1);
			
			//修改
			ProblemProfession newad = new ProblemProfession();
			ProblemProfession oldad = ad1;
			newad.setMjr_id(12);
			newad.setPl_id(1);
			//d.update(oldad,newad);
			
			//删
			//d.delete(newad);
			
			//查
			
			List<ProblemProfession>ads1=d.selectAll();
			for(ProblemProfession ad:ads1) {
				show(ad);
			}
			
			List<ProblemProfession>ads2=d.selectAll(1);
			for(ProblemProfession ad:ads2) {
				show(ad);
			}
		}
		private void show(ProblemProfession ad) {
			System.out.println("plt_id : "+ad.getPl_id());
			System.out.println("pl_type : "+ad.getMjr_id());
		}
}

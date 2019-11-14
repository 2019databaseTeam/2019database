package com.cloudea.test;
import java.util.*;

import org.junit.Test;

import com.cloudea.daoes.PermDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.Perm;

public class TestPerm {
	
	DAOFactoryForSqlServer factory =new DAOFactoryForSqlServer();
	@Test
	public void testA()throws Exception{
		PermDAO d=(PermDAO) factory.getDAO("Perm"); 
		//插入数据测试（插入两条）
//		Perm t1=new Perm(9,"111111111");
//		Perm t2=new Perm(10,"222222222");
//		d.insert(t1);
//		d.insert(t2);
//		
//		//更新数据
//		Perm t2=new Perm(9,"1234898");
//		d.update(t2);
//		
		//删除数据
//		Perm t2=new Perm(10,"1111");
//		d.delete(t2);
////		
//		//查询数据测试1
//		Perm u3=d.select(2);
//		show(u3);
		
//		
//		//查询数据测试3
//		List<Perm>u5 =d.selectAll();
//		for(Perm u:u5) {
//			show(u);
//		}
//		
//		
	}
	public void show(Perm u) {
		System.out.println("pmt_id="+u.getPmt_id()+"   "+"per_context"+u.getPer_context());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestAdmission t=new TestAdmission();
		try {
			t.testA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

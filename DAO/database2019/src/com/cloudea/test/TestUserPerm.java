package com.cloudea.test;
import java.util.*;

import org.junit.Test;

import com.cloudea.daoes.UserPermDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.UserPerm;

public class TestUserPerm {
	
	DAOFactoryForSqlServer factory =new DAOFactoryForSqlServer();
	@Test
	public void testA()throws Exception{
		UserPermDAO d=(UserPermDAO) factory.getDAO("UserPerm"); 
//		//插入数据测试（插入两条）
//		UserPerm t1=new UserPerm(1,3);
//		UserPerm t2=new UserPerm(3,1);
//		d.insert(t1);
//		d.insert(t2);
//		
		
		//删除数据
//		UserPerm t2=new UserPerm(1,3);
//		d.delete(t2);
//		
//		//查询数据测试1
//		UserPerm u3=d.select(1,1);
//		show(u3);
//		
//		
//		//查询数据测试3
//		List<UserPerm>u5 =d.selectAll();
//		for(UserPerm u:u5) {
//			show(u);
//		}
//		
//		
	}
	public void show(UserPerm u) {
		System.out.println("pmt_id="+u.getPmt_id()+"   "+"u_id"+u.getU_id());
		
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

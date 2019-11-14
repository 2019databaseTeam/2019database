package com.cloudea.test;
import java.util.*;

import org.junit.Test;

import com.cloudea.daoes.UserTypeDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.UserType;

public class TestUserType {
	
	DAOFactoryForSqlServer factory =new DAOFactoryForSqlServer();
	@Test
	public void testA()throws Exception{
		UserTypeDAO d=(UserTypeDAO) factory.getDAO("UserType"); 
////		//插入数据测试（插入两条）
//		UserType t2=new UserType(88,"222222222");
//		d.insert(t2);
//		
//		//更新数据
//		UserType t2=new UserType(10,"1234898");
//		d.update(t2);
////		
//		//删除数据
//		UserType t2=new UserType(10,"1111");
//		d.delete(t2);
////		
//		//查询数据测试1
//		UserType u3=d.select(2);
//		show(u3);
//		
//		
//		//查询数据测试3
//		List<UserType>u5 =d.selectAll();
//		for(UserType u:u5) {
//			show(u);
//		}
//		
//		
	}
	public void show(UserType u) {
		System.out.println("u_id="+u.getU_id()+"   "+"Name"+u.getName());
		
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

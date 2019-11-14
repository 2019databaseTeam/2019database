package com.cloudea.test;
import java.util.*;

import org.junit.Test;

import com.cloudea.daoes.LogInDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.LogIn;

public class TestLog_in {
	
	DAOFactoryForSqlServer factory =new DAOFactoryForSqlServer();
	@Test
	public void testA()throws Exception{
		LogInDAO d=(LogInDAO) factory.getDAO("LogIn"); 
//		//�������ݲ��ԣ�����������
//		LogIn t1=new LogIn();
//		t1.setU_id(4);
//		LogIn t2=new LogIn(2,3,"2019-11-29");
//		d.insert(t1);
//		d.insert(t2);
		
//		//��������
//		LogIn t2=new LogIn(4,3,"2003-1-1");
//		d.update(t2);
//		
//		//ɾ������
//		LogIn t2=new LogIn(1,1,"1999-11-29");
//		d.delete(t2);
//		
//		//��ѯ���ݲ���1
//		LogIn u3=d.select(2);
//		show(u3);
		
//		//��ѯ���ݲ���2
//		LogIn u4=d.select("u_id","1");
//		show(u4);
//		
//		//��ѯ���ݲ���3
//		List<LogIn>u5 =d.selectAll();
//		for(LogIn u:u5) {
//			show(u);
//		}
//		
//		//��ѯ���ݲ���4
//		List<LogIn>u6=d.selectAll("where u_id=1");
//		for(LogIn u:u6) {
//			show(u);
//		}
//		
	}
	public void show(LogIn u) {
		System.out.println("log_id="+u.getLog_id()+"   "+"u_id"+u.getU_id()+"   "+"in_time"+u.getIn_time());
		
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

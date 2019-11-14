package com.cloudea.test;
import java.util.*;

import org.junit.Test;

import com.cloudea.daoes.UserDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.User;

public class TestAdmission {
	
	DAOFactoryForSqlServer factory =new DAOFactoryForSqlServer();
	@Test
	public void testA()throws Exception{
		UserDAO d=(UserDAO) factory.getDAO("User"); 
		//�������ݲ��ԣ�����������
//		User t1=new User(1,1,"1111","1111","1111");
//		User t2=new User(2,2,"1111","1111","1111");
//		d.insert(t1);
//		d.insert(t2);
		
//		//��������
//		User t2=new User(18,2,"update","up","up");
//		d.update(t2);
//		
//		//ɾ������
//		User t2=new User(18,2,"update","up","up");
//		d.delete(t2);
//		
//		//��ѯ���ݲ���1
//		User u3=d.select(1);
//		show(u3);
		
//		//��ѯ���ݲ���2
//		User u4=d.select("u_type","1");
//		show(u4);
//		
//		//��ѯ���ݲ���3
//		List<User>u5 =d.selectAll();
//		for(User u:u5) {
//			show(u);
//		}
//		
//		//��ѯ���ݲ���4
//		List<User>u6=d.selectAll("where u_type=1");
//		for(User u:u6) {
//			show(u);
//		}
		
	}
	public void show(User u) {
		System.out.println("u_id="+u.getU_id()+"   "+"u_type"+u.getU_type()+"   "+"u_mailbox"+u.getU_mailbox()+"   "+"adm"+u.getAdm()+"   "+"pawd"+u.getPawd());
		
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

package com.cloudea.test;
import java.util.List;

import org.junit.Test;

import com.cloudea.daoes.StudentDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.Student;
public class TestStudent {
	 DAOFactoryForSqlServer factory=new DAOFactoryForSqlServer();
	    @Test
	    public void testA() throws Exception{
	    	StudentDAO d=(StudentDAO) factory.getDAO("Student");
	    	
	    	
	    	//�������ݲ��ԣ�����������
	    	Student student1=new Student(5,5,"sq",5);
	    	//d.insert(student1);
	        //d.insert(new Student(6,5,"���",6));
	    	
	    	//�������ݲ���
	        //d.update(new Student(5,5,"hello",7)); 
	    	
	    	//ɾ�����ݲ���
	    	//d.delete(new Student(5,5,"hello",10));
	    	
	    	//��ѯ���ݲ���1
	    	//Student a=d.select(2);
	    	//show(a);
	    	
	    	//��ѯ���ݲ���2
	    	//Student a=d.select("stu_id", "6");
	    	//show(a);
	    	
	    	//��ѯ���ݲ���3
	    	/*List <Student> a1=d.selectAll();
	    	for(Student a2 : a1)
	    	{
	    		show (a2);
	    	}*/
	    	
	    	//��ѯ���ݲ���4
	    	List <Student> a1=d.selectAll("where stu_id=6");
	    	for(Student a2 : a1)
	    	{
	    		show (a2);
	    	}
	    	
	     }
	    	
	    	
	    	 public void show(Student a)
	    	{
	    		System.out.println("stu_id:"+a.getStu_id()+" u_id:"+a.getU_id()+" SN:"+a.getSN()+" mjr_id:"+a.getMjr_id());
	    		
	    	}
	    	 
	    	
	 }



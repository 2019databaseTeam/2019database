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
	    	
	    	
	    	//插入数据测试（插入两条）
	    	Student student1=new Student(5,5,"sq",5);
	    	//d.insert(student1);
	        //d.insert(new Student(6,5,"你好",6));
	    	
	    	//更新数据测试
	        //d.update(new Student(5,5,"hello",7)); 
	    	
	    	//删除数据测试
	    	//d.delete(new Student(5,5,"hello",10));
	    	
	    	//查询数据测试1
	    	//Student a=d.select(2);
	    	//show(a);
	    	
	    	//查询数据测试2
	    	//Student a=d.select("stu_id", "6");
	    	//show(a);
	    	
	    	//查询数据测试3
	    	/*List <Student> a1=d.selectAll();
	    	for(Student a2 : a1)
	    	{
	    		show (a2);
	    	}*/
	    	
	    	//查询数据测试4
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



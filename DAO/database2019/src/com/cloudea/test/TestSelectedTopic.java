package com.cloudea.test;
import java.util.List;

import org.junit.Test;

import com.cloudea.daoes.SelectedTopicDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.SelectedTopic;
import com.cloudea.models.Student;

public class TestSelectedTopic {

	DAOFactoryForSqlServer factory=new DAOFactoryForSqlServer();
    @Test
    public void testA() throws Exception{
    	SelectedTopicDAO d=(SelectedTopicDAO) factory.getDAO("SelectedTopic");
    	
    	
    	//�������ݲ��ԣ�����������
    	SelectedTopic p=new SelectedTopic(2,4,"1998-08-10");
    	//d.insert(p);
        //d.insert(new SelectedTopic(6,3,"2010-10-11"));
    	
    	//�������ݲ���
        //d.update(new SelectedTopic(1,4,"2008-11-11")); 
    	
    	//ɾ�����ݲ���
    	//d.delete(new SelectedTopic(1,4,"hello"));
    	
    	//��ѯ���ݲ���1
    	//SelectedTopic a=d.select(6);
    	//show(a);
    	
    	//��ѯ���ݲ���2
    	//SelectedTopic a=d.select("stu_id","6");
    	//show(a);
    	
    	//��ѯ���ݲ���3
    	/*List <SelectedTopic> a1=d.selectAll();
    	for(SelectedTopic a2 : a1)
    	{
    		show (a2);
    	}*/
    	
    	//��ѯ���ݲ���4
    	List <SelectedTopic> a1=d.selectAll("where stu_id=6");
    	for(SelectedTopic a2 : a1)
    	{
    		show (a2);
    	}
    	
     }
    	
    	
    	 public void show(SelectedTopic a)
    	{
    		System.out.println("stu_id:"+a.getStu_id()+" pl_id:"+a.getPl_id()+" select_time:"+a.getSelect_time());
    		
    	}
}

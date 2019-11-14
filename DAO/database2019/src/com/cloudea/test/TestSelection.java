package com.cloudea.test;
import java.util.List;

import org.junit.Test;

import com.cloudea.daoes.SelectedTopicDAO;
import com.cloudea.daoes.SelectionDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.SelectedTopic;
import com.cloudea.models.Selection;
import com.cloudea.models.Selection;

public class TestSelection {
	DAOFactoryForSqlServer factory=new DAOFactoryForSqlServer();
    @Test
    public void testA() throws Exception{
    	SelectionDAO d=(SelectionDAO) factory.getDAO("Selection");
    	
    	
    	//插入数据测试（插入两条）
    	Selection p=new Selection(1,1,1,1,1,1);
    	//d.insert(p);
        //d.insert(new Selection(2,2,2,2,2,1));
    	
    	//更新数据测试
        //d.update(new Selection(9,2,3,3,3,1)); 
    	
    	//删除数据测试
    	//d.delete(new Selection(9,2,3,3,3,1));
    	
    	//查询数据测试1
    	//Selection a=d.select(7);
    	//show(a);
    	
    	//查询数据测试2
    	//Selection a=d.select("sec_id","7");
    	//show(a);
    	
    	//查询数据测试3
    	/*List <Selection> a1=d.selectAll();
    	for(Selection a2 : a1)
    	{
    		show (a2);
    	}*/
    	
    	//查询数据测试4
    	List <Selection> a1=d.selectAll("where sec_id=6");
    	for(Selection a2 : a1)
    	{
    		show (a2);
    	}
    	
     }
    	
    	
    	 public void show(Selection a)
    	{
    		System.out.println("sec_id:"+a.getSec_id()+" stu_id:"+a.getStu_id()+" priority:"+a.getPriority()+" pl_id:"+a.getPl_id()+" m_id:"+a.getM_id()+" sa_id"+a.getSa_id());
    		
    	}

}

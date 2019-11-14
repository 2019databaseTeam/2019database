package com.cloudea.test;

import java.util.List;

import org.junit.Test;

import com.cloudea.daoes.MaterialDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.Material;

public class TestMaterial {
    DAOFactoryForSqlServer factory=new DAOFactoryForSqlServer();
    @Test
    public void testA() throws Exception{
    	MaterialDAO d=(MaterialDAO) factory.getDAO("Material");
    	
    	//插入数据测试（插入两条）
    	Material material1=new Material();
    	material1.setStu_id(1);
    	material1.setM_text("大家好");
    	material1.setM_proof("text");
        //d.insert(material1);
        //d.insert(new Material(2,2,"你好","text"));
    	
    	//更新数据测试
        //d.update(new Material(4,1,"hello","texttext")); 
    	
    	//删除数据测试
    	//d.delete(new Material(4,1,"hello","text"));
    	
    	//查询数据测试1
    	//Material a=d.select(5);
    	//show(a);
    	
    	//查询数据测试2
    	//Material a=d.select("m_id", "5");
    	//show(a);
    	
    	//查询数据测试3
    	/*List <Material> a1=d.selectAll();
    	for(Material a2 : a1)
    	{
    		show (a2);
    	}*/
    	
    	//查询数据测试4
    	/*List <Material> a1=d.selectAll("where stu_id=1");
    	for(Material a2 : a1)
    	{
    		show (a2);
    	}*/
    	
     }
    	
    	
    	 public void show(Material a)
    	{
    		System.out.println("m_id:"+a.getM_id()+" stu_id:"+a.getStu_id()+" m_text:"+a.getM_text()+" m_proof:"+a.getM_proof());
    		
    	}
    	 
    	
 }


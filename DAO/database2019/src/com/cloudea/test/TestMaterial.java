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
    	
    	//�������ݲ��ԣ�����������
    	Material material1=new Material();
    	material1.setStu_id(1);
    	material1.setM_text("��Һ�");
    	material1.setM_proof("text");
        //d.insert(material1);
        //d.insert(new Material(2,2,"���","text"));
    	
    	//�������ݲ���
        //d.update(new Material(4,1,"hello","texttext")); 
    	
    	//ɾ�����ݲ���
    	//d.delete(new Material(4,1,"hello","text"));
    	
    	//��ѯ���ݲ���1
    	//Material a=d.select(5);
    	//show(a);
    	
    	//��ѯ���ݲ���2
    	//Material a=d.select("m_id", "5");
    	//show(a);
    	
    	//��ѯ���ݲ���3
    	/*List <Material> a1=d.selectAll();
    	for(Material a2 : a1)
    	{
    		show (a2);
    	}*/
    	
    	//��ѯ���ݲ���4
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


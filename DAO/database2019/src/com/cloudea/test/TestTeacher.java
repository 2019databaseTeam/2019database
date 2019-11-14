package com.cloudea.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cloudea.daoes.TeacherDAO;
import com.cloudea.factory.DAOFactoryForSqlServer;
import com.cloudea.models.Teacher;

public class TestTeacher {
	DAOFactoryForSqlServer factory= new DAOFactoryForSqlServer();
	
	@Test
	public void testA() throws Exception{
		TeacherDAO d=(TeacherDAO) factory.getDAO("Teacher");
		
		
		//增加.
		Teacher ad1 = new Teacher();
		ad1.setTch_id(2);
		ad1.setTch_name("崔晓辉");
		ad1.setU_id(5);
		//d.insert(ad1);
		
		//改
		Teacher ad2 = new Teacher();
		ad2.setTch_id(1);
		ad2.setTch_name("郭富城");
		ad2.setU_id(4);
		//d.update(ad2);
		
		//查
		Teacher ad3 = d.select(1);
		show(ad3);
		
		//删除
		d.delete(ad1);
		
		List<Teacher>ads1=d.selectAll();
		for(Teacher ad:ads1) {
			show(ad);
		}
	}

	private void show(Teacher ad) {
		System.out.println("tch_id : "+ad.getTch_id());
		System.out.println("u_id : "+ ad.getU_id());
		System.out.println("tch_name : "+ad.getTch_name());
		
		
	}
}
	

package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Administrator;

public interface AdministratorDAO extends DAO {
	void insert(Administrator administrator) throws Exception;
	void delete(Administrator administrator) throws Exception;
	void update(Administrator administrator) throws Exception;
	Administrator select(int id) throws Exception;
	Administrator select(String key, String value) throws Exception;
	List<Administrator> selectAll() throws Exception;
	List<Administrator> selectAll(String condition) throws Exception;
}

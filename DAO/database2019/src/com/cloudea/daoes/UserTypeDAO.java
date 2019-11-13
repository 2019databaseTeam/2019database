package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.UserType;

public interface UserTypeDAO extends DAO {
	void insert(UserType usertype) throws Exception;
	void delete(UserType usertype) throws Exception;
	void update(UserType usertype) throws Exception;
	UserType select(int id) throws Exception;
	List<UserType> selectAll() throws Exception;
	List<UserType> selectAll(String condition) throws Exception;
}

package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.UserPerm;

public interface UserPermDAO extends DAO {
	void insert(UserPerm userPerm) throws Exception;
	void delete(UserPerm userPerm) throws Exception;
	UserPerm select(int u_id,int pmt_id) throws Exception;
	List<UserPerm> selectAll() throws Exception;
	List<UserPerm> selectAll(int u_id,int pmt_id) throws Exception;
}

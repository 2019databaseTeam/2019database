package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Perm;

public interface PermDAO extends DAO {
	void insert(Perm perm) throws Exception;
	void delete(Perm perm) throws Exception;
	void update(Perm perm) throws Exception;
	Perm select(int id) throws Exception;
	List<Perm> selectAll() throws Exception;

}

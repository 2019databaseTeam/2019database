package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.ProblemType;

public interface ProblemTypeDAO extends DAO {
	void insert(ProblemType problemType) throws Exception;
	void delete(ProblemType problemType) throws Exception;
	void update(ProblemType problemType) throws Exception;
	ProblemType select(int id) throws Exception;
	List<ProblemType> selectAll() throws Exception;
}

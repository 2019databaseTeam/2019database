package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Problem;

public interface ProblemDAO extends DAO {
	void insert(Problem problem) throws Exception;
	void delete(Problem problem)  throws Exception;
	void update(Problem problem) throws Exception;
	Problem select(int id) throws Exception;
	Problem select(String condition) throws Exception;
	List<Problem> selectAll() throws Exception;
	List<Problem> selectAll(String condition) throws Exception;
}

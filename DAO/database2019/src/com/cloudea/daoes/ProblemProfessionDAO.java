package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.ProblemProfession;

public interface ProblemProfessionDAO extends DAO {
	void insert(ProblemProfession problemProfession) throws Exception;
	void delete(ProblemProfession problemProfession) throws Exception;
	void update(ProblemProfession problemProfession) throws Exception;
	List<ProblemProfession> selectAll() throws Exception;
	List<ProblemProfession> selectAll(int pl_id) throws Exception;
}

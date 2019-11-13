package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.ProblemProfession;

public interface ProblemProfessionDAO extends DAO {
	void insert(ProblemProfession problemProfession) throws Exception;
	void delete(ProblemProfession problemProfession) throws Exception;
	void update(ProblemProfession problemProfession) throws Exception;
	public ProblemProfession select(int pl_id,int mjr_id) throws Exception;
	List<ProblemProfession> selectAll() throws Exception;
}

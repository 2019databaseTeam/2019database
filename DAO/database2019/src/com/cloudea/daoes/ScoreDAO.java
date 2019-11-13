package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Score;

public interface ScoreDAO extends DAO {
	void insert(Score score) throws Exception;
	void delete(Score score) throws Exception;
	void update(Score score) throws Exception;
	Score select(int rep_id) throws Exception;
	Score select(String key, String value) throws Exception;
	List<Score> selectAll() throws Exception;
	List<Score> selectAll(String condition) throws Exception;
}

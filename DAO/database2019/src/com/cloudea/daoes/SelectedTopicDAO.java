package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.SelectedTopic;

public interface SelectedTopicDAO extends DAO {
	void insert(SelectedTopic selectedTopic) throws Exception;
	void delete(SelectedTopic selectedTopic) throws Exception;
	void update(SelectedTopic selectedTopic) throws Exception;
	SelectedTopic select(int stu_id) throws Exception;
    SelectedTopic select(String string, String string2)throws Exception;
    List<SelectedTopic> selectAll() throws Exception;
	List<SelectedTopic> selectAll(String string)throws Exception;
}

package com.cloudea.daoes;

import com.cloudea.models.SelectedTopic;

public interface SelectedTopicDAO extends DAO {
	void insert(SelectedTopic selectedTopic) throws Exception;
	void delete(SelectedTopic selectedTopic) throws Exception;
	void update(SelectedTopic selectedTopic) throws Exception;
	SelectedTopic select(int stu_id) throws Exception;
	SelectedTopic selectAll() throws Exception;
}

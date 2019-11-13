package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.ChatRecord;

public interface ChatRecordDAO extends DAO {
	void insert(ChatRecord chatRecord) throws Exception;
	void delete(ChatRecord chatRecord) throws Exception;
	void update(ChatRecord chatRecord) throws Exception;
	ChatRecord select(int id) throws Exception;
	ChatRecord select(String key, String value) throws Exception;
	List<ChatRecord> selectAll() throws Exception;
	List<ChatRecord> selectAll(String condition) throws Exception;
}

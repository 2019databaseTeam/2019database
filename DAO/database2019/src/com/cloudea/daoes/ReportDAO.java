package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Report;

public interface ReportDAO extends DAO {
	void insert(Report report) throws Exception;
	void delete(Report report) throws Exception;
	void update(Report report) throws Exception;
	Report select(int id) throws Exception;
	Report select(String key, String value) throws Exception;
	List<Report> selectAll() throws Exception;
	List<Report> selectAll(String condition) throws Exception;
}

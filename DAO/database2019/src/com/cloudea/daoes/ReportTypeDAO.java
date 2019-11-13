package com.cloudea.daoes;

import java.util.List;
import com.cloudea.models.ReportType;

public interface ReportTypeDAO extends DAO {
	void insert(ReportType reportType) throws Exception;
	void delete(ReportType reportType) throws Exception;
	void update(ReportType reportType) throws Exception;
	ReportType select(int id) throws Exception;
	List<ReportType> selectAll() throws Exception;
}

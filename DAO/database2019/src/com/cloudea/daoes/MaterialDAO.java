package com.cloudea.daoes;

import java.util.List;

import com.cloudea.models.Material;

public interface MaterialDAO extends DAO {
	void inset(Material material) throws Exception;
	void delete(Material material) throws Exception;
	void update(Material material) throws Exception;
	Material select(int id) throws Exception;
	Material select(String key, String value) throws Exception;
	List<Material> selectAll() throws Exception;
	List<Material> selectAll(String condition) throws Exception;
}

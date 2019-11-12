package com.cloudea.factory;

import com.cloudea.daoes.DAO;

public class DAOFactoryForSqlServer extends DAOFactory {

	@Override
	DAO getDAO(String name) {
		/*if(name.equals("ChatRecord")) {
			return .......
		}*/
		return null;
	}
	
}

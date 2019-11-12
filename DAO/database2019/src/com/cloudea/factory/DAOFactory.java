package com.cloudea.factory;

import com.cloudea.daoes.DAO;

public abstract class DAOFactory {
	abstract DAO getDAO(String name);
}

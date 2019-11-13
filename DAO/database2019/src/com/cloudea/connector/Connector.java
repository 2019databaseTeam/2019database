package com.cloudea.connector;
import java.sql.Connection;
import java.util.List;

import com.cloudea.models.Perm;

public interface Connector {
	Connection connect();
}



package com.cloudea.factory;

import com.cloudea.daoes.DAO;
import com.cloudea.concrete.*;

public class DAOFactoryForSqlServer extends DAOFactory {

	@Override
	DAO getDAO(String name) {
		if(name.equals("Administrator")) {
			return AdministratorDAOImpl.getInstance();
		}
		else if(name.equals("ChatRecord")){
			return ChatRecordDAOImpl.getInstance();
		}
		else if(name.equals("LogIn")){
			return LogInDAOImpl.getInstance();
		}
		else if(name.equals("Major")){
			return MajorDAOImpl.getInstance();
		}
		else if(name.equals("Material")){
			return MaterialDAOImpl.getInstance();
		}
		else if(name.equals("Perm")){
			return PermDAOImpl.getInstance();
		}
		else if(name.equals("Problem")){
			return ProblemDAOImpl.getInstance();
		}
		else if(name.equals("ProblemProfession")){
			return ProblemProfessionDAOImpl.getInstance();
		}
		else if(name.equals("ProblemType")){
			return ProblemTypeDAOImpl.getInstance();
		}
		else if(name.equals("Report")){
			return ReportDAOImpl.getInstance();
		}
		else if(name.equals("ReportType")){
			return ReportTypeDAOImpl.getInstance();
		}
		else if(name.equals("Score")){
			return ScoreDAOImpl.getInstance();
		}
		else if(name.equals("SelectedTopic")){
			return SelectedTopicDAOImpl.getInstance();
		}
		else if(name.equals("Selection")){
			return SelectionDAOImpl.getInstance();
		}
		else if(name.equals("SystemActivity")){
			return SystemActivityDAOImpl.getInstance();
		}
		else if(name.equals("Student")){
			return StudentDAOImpl.getInstance();
		}
		else if(name.equals("Teacher")){
			return TeacherDAOImpl.getInstance();
		}
		else if(name.equals("User")){
			return UserDAOImpl.getInstance();
		}
		else if(name.equals("UserPerm")){
			return UserPermDAOImpl.getInstance();
		}
		else if(name.equals("UserTypeDAO")){
			return UserTypeDAOImpl.getInstance();
		}
		
		
		return null;
	}
	
}

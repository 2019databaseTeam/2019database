package dao2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cloudea.connector.SqlServerConnector;
import com.cloudea.daoes.ProblemTypeDAO;
import com.cloudea.models.ProblemType;

public class ProblemTypeDAOImpl extends SqlServerConnector implements ProblemTypeDAO{
	private static ProblemTypeDAOImpl instance= new ProblemTypeDAOImpl();
	public static ProblemTypeDAOImpl getInstance() { 
		return ProblemTypeDAOImpl.instance;
	}
	private ProblemTypeDAOImpl() {}
	//pl_id,tch_id,plt_id,max_person;
	//pl_name,pl_degree,pl_need,pl_eva_mode;
	private static final String insertSql="insert into ProblemType values(?,?)";
	private static final String deleteSql="delete from ProblemType where plt_id = ?";
	private static final String updateSql="update ProblemType set plt_id=?,pl_type=?";
	private static final String selectSql="select * from ProblemType where 'plt_id'=?";
	
	@Override
	public void insert(ProblemType problemType) throws Exception{
		PreparedStatement statement=connect().prepareStatement(insertSql);
		statement.setInt(1, problemType.getPlt_id());
		statement.setString(2, problemType.getPl_type());
		statement.execute();
	}
	@Override
	public void delete(ProblemType problemType) throws Exception{
		PreparedStatement statement=connect().prepareStatement(deleteSql);
		statement.setInt(1, problemType.getPlt_id());
		statement.execute();
	}
	@Override
	public void update(ProblemType problemType) throws Exception{
		PreparedStatement statement=connect().prepareStatement(updateSql);
		statement.setInt(1, problemType.getPlt_id());
		statement.setString(2, problemType.getPl_type());
		statement.execute();
	}
	@Override
	public ProblemType select(int plt_id) throws Exception{
		PreparedStatement statement=connect().prepareStatement(selectSql);
		statement.setInt(1, plt_id);
		ResultSet result=statement.executeQuery();
		if(result.next()) {
			ProblemType pt=new ProblemType();
			pt.setPlt_id(result.getInt("plt_id"));
			pt.setPl_type(result.getString("pl_type"));
			return pt;
		}
		return null;
	}
	@Override
	public List<ProblemType> selectAll() throws Exception {
		String sql="select * from ProblemType";
		PreparedStatement statement=connect().prepareStatement(sql);
		List<ProblemType>PTs=new ArrayList<ProblemType>();
		ResultSet result=statement.executeQuery();
		while(result.next())
		{
			ProblemType PT = new ProblemType(result.getInt(1),result.getString(2));
			PTs.add(PT);
		}
		return PTs;
	}
}

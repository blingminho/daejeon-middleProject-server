package dao.login;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import dao.main.MainLoginDao;
import vo.BoardVO;
import vo.JoinVO;
import vo.UserVO;

public class JoinDao implements JoinDaoInf{

	private static JoinDao dao = new JoinDao();
	
	private SqlMapClient smc;
	
	private JoinDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JoinDao getInstance() {
		return dao;
	}
	@Override
	public int getSearchId(String userId) {
		int id = 0;
		
		try {
			id = (int) smc.queryForObject("Join.CheckId", userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public int InsertJoinInfo(UserVO usVo) {
		int join = 0;
		
		try {
			Object obj = smc.insert("Join.joinInsert", usVo);
			if(obj == null) {
				join=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return join;
	}

	@Override
	public List<JoinVO> setJoinTable(JoinVO jvo) throws RemoteException {
		List<JoinVO> joinList = null;
		try {
			joinList = (List<JoinVO>) smc.insert("Join.joinTableInsert", jvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return joinList;
	}
}

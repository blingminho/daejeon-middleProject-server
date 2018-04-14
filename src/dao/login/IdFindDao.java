package dao.login;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.UserVO;

public class IdFindDao implements IdFindDaoInf{

	private static IdFindDao dao = new IdFindDao();
	
	private SqlMapClient smc;
	
	private IdFindDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static IdFindDao getInstance() {
		return dao;
	}

	@Override
	public List<UserVO> getUserInfo(String userNm) {
		List<UserVO> userList = null;
		
		try {
			userList = smc.queryForList("IdFind.getSearchUser", userNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
}

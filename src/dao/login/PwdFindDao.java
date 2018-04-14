package dao.login;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.UserVO;

public class PwdFindDao implements PwdFindDaoInf{
	
private static PwdFindDao dao = new PwdFindDao();
	
	private SqlMapClient smc;
	
	private PwdFindDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static PwdFindDao getInstance() {
		return dao;
	}

	@Override
	public List<UserVO> getUserInfo(String userId) {
		List<UserVO> userList = null;
		
		try {
			userList = smc.queryForList("PwdFind.getSearchUser", userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public int updatePwd(UserVO userPwd) {
		int cnt = 0;
		
		try {
			cnt = smc.update("PwdFind.updatePwd", userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	

}

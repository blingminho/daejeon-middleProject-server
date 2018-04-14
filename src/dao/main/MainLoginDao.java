package dao.main;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.JoinVO;
import vo.UserVO;

public class MainLoginDao implements MainLoginDaoInf{

	private static MainLoginDao dao = new MainLoginDao();
	
	private SqlMapClient smc;
	
	private MainLoginDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MainLoginDao getInstance() {
		return dao;
	}

	@Override
	public int getLoginId(String userid) {
		int id = 0;
		try {
			id = (int) smc.queryForObject("Login.getUserId", userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public int getLoginPwd(String userPwd) {
		int pw = 0;
		try {
			pw = (int) smc.queryForObject("Login.getUserPwd", userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pw;
	}

	@Override
	public List<UserVO> getLoginUser(String userId) {
		List<UserVO> userList = null;
		
		try {
			userList = smc.queryForList("Login.getLoginUser", userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public List<JoinVO> getJoinInfo(String userId) {
		List<JoinVO> joinList = null;
		
		try {
			joinList = smc.queryForList("Login.getJoinInfo",userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return joinList;
	}

}

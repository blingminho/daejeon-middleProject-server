package dao.my;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.UserVO;


/**
 * server 마이페이지의 홈 화면에 관련된 DAO
 * @author sun
 *
 */
public class MyHomeDao implements MyHomeDaoInf{

	private static MyHomeDao dao = new MyHomeDao();
	
	private SqlMapClient smc;
	
	public MyHomeDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MyHomeDao getInstance() {
		return dao;
	}



	
	@Override
	public UserVO getUserInfo(String us_id) {
		UserVO userInfoList =null;
		try {
			userInfoList = (UserVO) smc.queryForObject("MyHome.getUserInfo",us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userInfoList;
	}

	@Override
	public int updateUser(UserVO vo) {
		int result = 0;
		try {
			result = smc.update("MyHome.updateUser", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteUser(String us_id) {
		int result = 0;
		try {
			result = smc.update("MyHome.deleteUser", us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return true;
		}
		return false;
	}
	

	
}

package dao.team;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 팀페이지의 메뉴 화면에 관련된 DAO
 * @author Jun
 *
 */
public class TeamMenuDao implements TeamMenuDaoInf{

	private static TeamMenuDao dao = new TeamMenuDao();
	
	private SqlMapClient smc;
	
	private TeamMenuDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamMenuDao getInstance() {
		return dao;
	}

	@Override
	public String getJoinMemberState(String jo_tm_id, String jo_us_id) {
		String result = null;
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("jo_tm_id", jo_tm_id);
		parameterMap.put("jo_us_id", jo_us_id);
		try {
			result = (String) smc.queryForObject("TeamMenu.getJoinMemberState", parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			result = "";
		}
		return result;
	}

	@Override
	public String getTeamLeaderId(String tm_id) {
		String result = null;
		try {
			result = (String) smc.queryForObject("TeamMenu.getTeamLeaderId", tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteTeamMemberSelf(String jo_tm_id, String jo_us_id) {
		int result = 0;
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("jo_tm_id", jo_tm_id);
		parameterMap.put("jo_us_id", jo_us_id);
		try {
			result = smc.delete("TeamMenu.deleteTeamMemberSelf", parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}
}

package dao.team;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.TeamVO;


/**
 * 팀페이지의 홈 화면에 관련된 DAO
 * @author Jun
 *
 */
public class TeamHomeDao implements TeamHomeDaoInf{

	private static TeamHomeDao dao = new TeamHomeDao();
	
	private SqlMapClient smc;
	
	private TeamHomeDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamHomeDao getInstance() {
		return dao;
	}

	@Override
	public TeamVO getTeamInfo(String tm_id) {
		TeamVO resultVO = null;
		try {
			resultVO = (TeamVO) smc.queryForObject("TeamHome.getTeamInfo", tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultVO;
	}

	@Override
	public int getTeamMemberTotalCount(String jo_tm_id) {
		int totalCount = 0;
		try {
			totalCount = (int) smc.queryForObject("TeamHome.getTeamMemberTotalCount", jo_tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public String getJoinMemberState(String jo_tm_id, String jo_us_id) {
		String result = null;
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("jo_tm_id", jo_tm_id);
		parameterMap.put("jo_us_id", jo_us_id);
		try {
			result = (String) smc.queryForObject("TeamHome.getJoinMemberState", parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean deleteJoinMember(String jo_tm_id, String jo_us_id) {
		int result = 0;
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("jo_tm_id", jo_tm_id);
		parameterMap.put("jo_us_id", jo_us_id);
		try {
			result = smc.delete("TeamHome.deleteJoinMember", parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insertJoinMember(String jo_tm_id, String jo_us_id) {
		Object result = "";
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("jo_tm_id", jo_tm_id);
		parameterMap.put("jo_us_id", jo_us_id);
		try {
			result = smc.insert("TeamHome.insertJoinMemberWait", parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateJoinMember(String jo_tm_id, String jo_us_id) {
		int result = 0;
		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("jo_tm_id", jo_tm_id);
		parameterMap.put("jo_us_id", jo_us_id);
		try {
			result = smc.delete("TeamHome.updateJoinMember", parameterMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}
}

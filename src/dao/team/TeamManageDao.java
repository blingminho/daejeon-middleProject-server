package dao.team;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.TeamVO;
import vo.UserVO;


/**
 * 팀페이지의 팀 관리에 관련된 DAO
 * @author Jun
 *
 */
public class TeamManageDao implements TeamManageDaoInf{

	private static TeamManageDao dao = new TeamManageDao();
	
	private SqlMapClient smc;
	
	private TeamManageDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamManageDao getInstance() {
		return dao;
	}

	@Override
	public List<UserVO> getTeamMemberTotal(String jo_tm_id) {
		List<UserVO> resultList = null;
		try {
			resultList = smc.queryForList("TeamManage.getTeamMemberTotal", jo_tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<UserVO> getTeamUserTotal(String jo_tm_id) {
		List<UserVO> resultList = null;
		try {
			resultList = smc.queryForList("TeamManage.getTeamUserTotal", jo_tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public boolean deleteTeam(String tm_id) {
		int resultInt = 0;
		try {
			resultInt = smc.delete("TeamManage.deleteTeam", tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (resultInt > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertJoinMemberInvite(String jo_us_id, String jo_tm_id) {
		Map<String, String> mapVo = new HashMap<>();
		mapVo.put("jo_us_id", jo_us_id);
		mapVo.put("jo_tm_id", jo_tm_id);
		Object result = null;
		try {
			result = smc.insert("TeamManage.insertJoinMemberInvite", mapVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteJoin(String jo_us_id) {
		int resultInt = 0;
		try {
			resultInt = smc.delete("TeamManage.deleteJoin", jo_us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (resultInt > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateJoinMember(String jo_us_id, String jo_tm_id) {
		Map<String, String> mapVo = new HashMap<>();
		mapVo.put("jo_us_id", jo_us_id);
		mapVo.put("jo_tm_id", jo_tm_id);
		int resultInt = 0;
		try {
			resultInt = smc.update("TeamManage.updateJoinMember", mapVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (resultInt > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateTeam(TeamVO teamVo) {
		int resultInt = 0;
		try {
			resultInt = smc.update("TeamManage.updateTeam", teamVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (resultInt > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getTeamPN(String tm_id) {
		int resultInt = 0;
		try {
			resultInt = (int) smc.queryForObject("TeamManage.getTeamPN", tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultInt;
	}

}

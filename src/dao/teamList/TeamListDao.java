package dao.teamList;

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

/**
 * 팀페이지의 메뉴 화면에 관련된 DAO
 * @author Jun
 *
 */
public class TeamListDao implements TeamListDaoInf{

	private static TeamListDao dao = new TeamListDao();
	
	private SqlMapClient smc;
	
	private TeamListDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamListDao getInstance() {
		return dao;
	}

	@Override
	public List<TeamVO> getTeamList() {
		List<TeamVO> result = null;
		try {
			result = smc.queryForList("TeamList.getTeamList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Map<String, String>> getTeamPN() {
		List<Map<String, String>> result = null;
		try {
			result = smc.queryForList("TeamList.getTeamPN");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

package dao.team;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.UserVO;

/**
 * 팀페이지의 프로필 화면에 관련된 DAO
 * @author Jun
 *
 */
public class TeamProfileDao implements TeamProfileDaoInf{

	private static TeamProfileDao dao = new TeamProfileDao();
	
	private SqlMapClient smc;
	
	private TeamProfileDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamProfileDao getInstance() {
		return dao;
	}

	@Override
	public List<UserVO> getTeamMemberList(String tm_id) {
		List<UserVO> result = null;
		try {
			result = smc.queryForList("TeamProfile.getTeamMemberList", tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UserVO getTeamMemberProfile(String us_id) {
		UserVO result = new UserVO();
		try {
			result = (UserVO) smc.queryForObject("TeamProfile.getTeamMemberProfile", us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}

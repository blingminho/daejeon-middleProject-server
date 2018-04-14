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

import vo.CalendarVO;
import vo.TeamVO;


/**
 * 팀페이지의 일정관리 및 마이페이지의 내 일정 화면에 관련된 DAO
 * @author Jun
 *
 */
public class TeamCalendarDao implements TeamCalendarDaoInf{

	private static TeamCalendarDao dao = new TeamCalendarDao();
	
	private SqlMapClient smc;
	
	private TeamCalendarDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamCalendarDao getInstance() {
		return dao;
	}

	@Override
	public List<String> getJoinTeamIdList(String jo_us_id) {
		List<String> result = null;
		try {
			result = smc.queryForList("TeamCalendar.getJoinTeamIdList", jo_us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CalendarVO> getCalendarBy_TM_ID(String cal_tm_id) {
		List<CalendarVO> result = null;
		try {
			result = smc.queryForList("TeamCalendar.getCalendarBy_TM_ID", cal_tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertCalendar(CalendarVO calendarVO) {
		Object result = null;
		try {
			result = smc.insert("TeamCalendar.insertCalendar", calendarVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return true;
		}
		return false;
	}

	@Override
	public TeamVO getTeamVO(String tm_id) {
		TeamVO result = null;
		try {
			result = (TeamVO) smc.queryForObject("TeamCalendar.getTeamVO", tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getCalendar(CalendarVO calendarVO) {
		int result = 0;
		try {
			result = (int) smc.queryForObject("TeamCalendar.getCalendar", calendarVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteCalendar(CalendarVO calendarVO) {
		int result = 0;
		try {
			result = smc.delete("TeamCalendar.deleteCalendar", calendarVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return true;
		}
		return false;
	}
}

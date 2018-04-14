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

import vo.TravelListVO;


/**
 * 팀페이지의 여행지 즐겨찾기에 관련된 DAO
 * @author Jun
 *
 */
public class TeamTravelDao implements TeamTravelDaoInf{

	private static TeamTravelDao dao = new TeamTravelDao();
	
	private SqlMapClient smc;
	
	private TeamTravelDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamTravelDao getInstance() {
		return dao;
	}

	@Override
	public List<TravelListVO> getTravelList(String trv_tm_id) {
		List<TravelListVO> resultList = null;
		try {
			resultList = (List<TravelListVO>) smc.queryForList("TeamTravelList.getTravelList", trv_tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public int getTravelOnSchedule(String cal_tm_id, String cal_trv_id) {
		int totalCount = 0;
		Map<String, String> map = new HashMap<>();
		map.put("cal_tm_id", cal_tm_id);
		map.put("trv_tm_id", cal_tm_id);
		map.put("cal_trv_id", cal_trv_id);
		try {
			totalCount = (int) smc.queryForObject("TeamTravelList.getTravelOnSchedule", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public boolean deleteTravel(String trv_id) {
		int result = 0;
		try {
			result = smc.delete("TeamTravelList.deleteTravel", trv_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertTravel(TravelListVO travelVO) {
		Object result = "";
		try {
			result = smc.insert("TeamTravelList.insertTravel", travelVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return true;
		}
		return false;
	}
}

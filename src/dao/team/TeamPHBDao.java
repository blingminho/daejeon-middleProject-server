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

import vo.PhbVO;

/**
 * 팀페이지의 사진첩 및
 * 관리자의 사진첩관리에 관련된 DAO
 * @author Jun
 *
 */
public class TeamPHBDao implements TeamPHBDaoInf{

	private static TeamPHBDao dao = new TeamPHBDao();
	
	private SqlMapClient smc;
	
	private TeamPHBDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TeamPHBDao getInstance() {
		return dao;
	}


	@Override
	public List<PhbVO> getAllPhb() {
		List<PhbVO> result = null;
		try {
			result = smc.queryForList("TeamPHB.getAllPhb");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PhbVO> getPhb(PhbVO phbvo) {
		List<PhbVO> result = null;
		try {
			result = smc.queryForList("TeamPHB.getPhb", phbvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deletePhb(PhbVO phbvo) {
		int result = 0;
		try {
			result = smc.delete("TeamPHB.deletePhb", phbvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateGood(PhbVO phbvo) {
		int result = 0;
		try {
			result = smc.update("TeamPHB.updateGood", phbvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}
}

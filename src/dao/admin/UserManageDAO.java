package dao.admin;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.BlackListVO;
import vo.ReportVO;
import vo.UserVO;
/**
 * servar 회원관리 dao 구현체
 * @author sk.baek
 *
 */
public class UserManageDAO implements UserManageDAOInf{
	private static UserManageDAO dao = new UserManageDAO();
	private SqlMapClient smc;
	
	public UserManageDAO() {
		try {
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static UserManageDAO getInstance() {
		return dao;
	}


	@Override
	public List<UserVO> userInfoTable() {
		List<UserVO> userList = null;
		
		try {
			userList = smc.queryForList("UserManage.getUserAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public List<ReportVO> reportInfoTable() {
		List <ReportVO> reportList = null;
		try {
			reportList = smc.queryForList("UserManage.getReportAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportList;
	}

	@Override
	public List<BlackListVO> blackInfoTable() {
		List <BlackListVO> blackList = null;
		try {
			blackList = smc.queryForList("UserManage.getBlackAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blackList;
	}


	@Override
	public int delUser(String us_id) {
		int result = 0;
		try {
			result = smc.delete("UserManage.delUser", us_id);	//삭제한 행 개수 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int reportUser(String us_id) {
		int result = 0;
		try {
			result = smc.update("UserManage.upUserRt", us_id);	//업데이트한 행 개수 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int reportDel(String re_id) {	
		int result = 0;
		try {
			result = smc.delete("UserManage.delRt", re_id);		//삭제한 행 개수 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int bListUser(String us_id) {
		int result = 0;
		try {
			Object tmp = smc.insert("UserManage.inBlist", us_id);
			if(tmp==null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}

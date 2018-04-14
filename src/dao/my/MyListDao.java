package dao.my;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import java.util.List;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;




/**
 * MyList 화면에 관련된 DAO
 * @author sun
 * @param <TeamStatusVO>
 *
 */
public class MyListDao<TeamStatusVO> implements MyListDaoInf{

	private static MyListDao dao = new MyListDao();
	
	private SqlMapClient smc;
	
	private MyListDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MyListDao getInstance() {
		return dao;
	}

	@Override
	public List<TeamStatusVO> tableEnrolledTeam(String jo_us_id) {
		List<TeamStatusVO> joiningList = null;
		try {
			joiningList= smc.queryForList("MyList.tableEnrolledTeam", jo_us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return joiningList;
	}
	
	@Override
	public List<TeamStatusVO> tableInvitedTeam(String jo_us_id) {
		List<TeamStatusVO> invitedList = null;
		try {
			invitedList = smc.queryForList("MyList.tableInvitedTeam", jo_us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invitedList;	
	}
	
	@Override
	public List<TeamStatusVO> tabeSignedUpTeam(String jo_us_id) {
		List<TeamStatusVO> singnedUpList = null;
		try {
			singnedUpList = smc.queryForList("MyList.tabeSignedUpTeam", jo_us_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return singnedUpList;
	}

	

	}

	


	


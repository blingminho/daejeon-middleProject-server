package dao.my;

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
 * 팀 생성 화면에 관련된 DAO
 * @author sun
 *
 */
public class MyTeamParoduceDao implements MyTeamProduceDaoInf{

	private static MyTeamParoduceDao dao = new MyTeamParoduceDao();
	
	private SqlMapClient smc;
	
	private MyTeamParoduceDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MyTeamParoduceDao getInstance() {
		return dao;
	}

	@Override
	public  int insertTeam(TeamVO vo) {
		Object result = 0;
		try {
			result = smc.insert("MyTeamParoduce.insertTeam", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (int) result;
	}

	
}

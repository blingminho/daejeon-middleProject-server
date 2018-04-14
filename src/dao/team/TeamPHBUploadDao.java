package dao.team;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.FileVO;
import vo.PhbVO;

/**
 * 사진첩에 제공할 서비스와 연결된 DAO
 * @author sk.baek
 *
 */
public class TeamPHBUploadDao implements TeamPHBUploadDaoInf{
	
	private static TeamPHBUploadDao dao = new TeamPHBUploadDao();
	
	private SqlMapClient smc;
	
	private TeamPHBUploadDao() {
		try {
			
			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(read);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static TeamPHBUploadDao getInstance() {
		return dao;
	}
	

	@Override
	public int phbInsert(PhbVO phbVo) {
		int result = 0;
		try {
			Object obj = smc.insert("TeamPHBUpload.phbInsert", phbVo);
			if (obj == null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int phbFileInsert(FileVO fileVo) {
		int result = 0;
		try {
			Object tmp = smc.insert("TeamPHBUpload.phbFileInsert", fileVo);
			if(tmp==null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int phbFileupdate(FileVO fileVo) {
		int result = 0;
		try {
			result = smc.update("TeamPHBUpload.phbFileupdate", fileVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int phbDel(String phb_id) {	//종속 삭제, file삭제할 필요 없음
		int result = 0;
		try {
			result = smc.delete("TeamPHBUpload.phbDel", phb_id);		//삭제한 행 개수 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getPhbID() {
		String phbID =null;
		try {
			phbID = (String) smc.queryForObject("TeamPHBUpload.getPhbID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return phbID;
	}

	@Override
	public PhbVO selectPhbVo(String phb_id) {
		PhbVO phbVo = null;
		try {
			phbVo = (PhbVO) smc.queryForObject("TeamPHBUpload.selectPhbVo", phb_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phbVo;
	}

}

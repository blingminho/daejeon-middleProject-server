package dao.board;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.BoardVO;
import vo.ComentVO;
import vo.FileVO;
import vo.UserVO;

public class BoardComentDao implements BoardComentDaoInf{

private static BoardComentDao dao = new BoardComentDao();
	
	private SqlMapClient smc;
	
	private BoardComentDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static BoardComentDao getInstance() {
		return dao;
	}

	@Override
	public String getBoardInfo(String userId) {
		String content = null;
		
		try {
			content = (String) smc.queryForObject("BoardComent.getBoardInfo", userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return content;
	}

	@Override
	public int setComent(ComentVO cvo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("BoardComent.setComent", cvo);
			if(obj ==null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<UserVO> getUserInfo(String us_id) {
		List<UserVO> userList = null;
		
		try {
			userList = smc.queryForList("BoardComent.getUserInfo", us_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public List<ComentVO> getComentInfo(String bd_id) {
		List<ComentVO> comentList = null;
		
		try {
		    comentList = smc.queryForList("BoardComent.getComentInfo", bd_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentList;
	}

	@Override
	public int deleteBoard(String bd_id) {
		int result = 0;
		
		try {
			result = smc.delete("BoardComent.deleteboard", bd_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateBoard(BoardVO bvo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("BoardComent.updateBoard", bvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<FileVO> getFile(String id) {
		List<FileVO> fileList = null;
		
		try {
			fileList = smc.queryForList("BoardComent.getFile",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileList;
	}
}

package dao.board;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.BoardVO;
import vo.FileVO;

public class BoardHomeDao implements BoardHomeDaoInf{
	
	private static BoardHomeDao dao = new BoardHomeDao();
	
	private SqlMapClient smc;
	
	private BoardHomeDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static BoardHomeDao getInstance() {
		return dao;
	}

	/**
	 * ahems
	 */
	@Override
	public List<BoardVO> getAllBoard() {
		List<BoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("BoardHome.getAllBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public List<BoardVO> getBoardTitle(String search) {
		List<BoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("BoardHome.getBoardTitle", search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public List<BoardVO> getBoardContent(String search) {
		List<BoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("BoardHome.getBoardContent", search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public List<BoardVO> getBoardUserId(String search) {
		List<BoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("BoardHome.getBoardUserId", search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

}

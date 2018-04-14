package dao.board;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.BoardVO;
import vo.FileVO;

public class BoardWriteDao implements BoardWriteDaoInf{

	private static BoardWriteDao dao = new BoardWriteDao();
	
	private SqlMapClient smc;
	
	private BoardWriteDao() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardWriteDao getInstance() {
		return dao;
	}
	
	@Override
	public int setBoardWrite(BoardVO bvo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("BoardWrite.setBoard", bvo);
			if(obj == null) {
				cnt = 2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	@Override
	public String getFileSeqId() {
		String num = "";
		
		try {
			num = (String) smc.queryForObject("BoardWrite.getFileSeqNum");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public String getBoardSeqId() {
		
		String num = "";
		
		try {
			num = (String) smc.queryForObject("BoardWrite.getBoardSeqNum");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	@Override
	public void setBoardWriteFile(List<FileVO> fileList) {
		
		for (FileVO fileVO : fileList) {
			try {
				smc.insert("BoardWrite.setFile", fileVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		try {
//			smc.insert("BoardWrite.setFile", fileList);
//		} catch (SQLException e) {
//			System.out.println("실패");
//			e.printStackTrace();
//		}
	}


	
}

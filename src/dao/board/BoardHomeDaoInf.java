package dao.board;

import java.rmi.RemoteException;
import java.util.List;

import vo.BoardVO;
import vo.FileVO;

public interface BoardHomeDaoInf {
	/**
	 * Board테이블의 모든 정보를 불러온다.
	 * @return
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 검색어에 입력한 제목내용과 관련된 정보를 뽑아옴
	 * @param search
	 * @return
	 * @throws RemoteException
	 */
	public List<BoardVO> getBoardTitle(String search);
	
	/**
	 * 검색어에 입력한 내용과 관련된 정보를 뽑아옴
	 * @param search
	 * @return
	 * @throws RemoteException
	 */
	public List<BoardVO> getBoardContent(String search);
	
	/**
	 * 검색어에 입력한 id와 관련된 정보를 뽑아옴
	 * @param search
	 * @return
	 * @throws RemoteException
	 */
	public List<BoardVO> getBoardUserId(String search);
	
}

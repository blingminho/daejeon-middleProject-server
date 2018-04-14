package dao.board;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.BoardVO;
import vo.FileVO;

public interface BoardWriteDaoInf{

	/**
	 * BoardVO를 파라미터로 넘겨줘서 DB에 저장
	 * @param bvo
	 * @return
	 * @throws RemoteException
	 */
	public int setBoardWrite(BoardVO bvo);
	
	/**
	 * 파일시퀀스번호를 얻어와서 이미지저장에 사용
	 * @return
	 */
	public String getFileSeqId();
	
	/**
	 * 게시판시퀀스번호를 얻어와서 이미지저장에 사용
	 * @return
	 * @throws RemoteException
	 */
	public String getBoardSeqId();
	
	/**
	 * FileVO를 파라미터값으로 넘겨줘서 db에 저장
	 * @param fvo
	 * @return
	 * @throws RemoteException
	 */
	public void setBoardWriteFile(List<FileVO> fileList);
	
}

package service.board;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.board.BoardComentDao;
import dao.board.BoardComentDaoInf;
import vo.BoardVO;
import vo.ComentVO;
import vo.FileVO;
import vo.UserVO;

public class BoardComentService extends UnicastRemoteObject implements BoardComentServiceInf{

	private BoardComentDaoInf dao;
	
	public BoardComentService() throws RemoteException{
		dao = BoardComentDao.getInstance();
	}

	@Override
	public String getBoardInfo(String userId) throws RemoteException {
		return dao.getBoardInfo(userId);
	}

	@Override
	public int setComent(ComentVO cvo) throws RemoteException {
		return dao.setComent(cvo);
	}

	@Override
	public List<UserVO> getUserInfo(String us_id) throws RemoteException {
		return dao.getUserInfo(us_id);
	}

	@Override
	public List<ComentVO> getComentInfo(String bd_id) throws RemoteException {
		return dao.getComentInfo(bd_id);
	}

	@Override
	public int deleteBoard(String bd_id) throws RemoteException {
		return dao.deleteBoard(bd_id);
	}

	@Override
	public int updateBoard(BoardVO bvo) throws RemoteException {
		return dao.updateBoard(bvo);
	}

	@Override
	public List<FileVO> getFile(String id) throws RemoteException {
		return dao.getFile(id);
	}
}

package service.login;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.login.JoinDao;
import dao.login.JoinDaoInf;
import vo.BoardVO;
import vo.JoinVO;
import vo.UserVO;


public class JoinService extends UnicastRemoteObject implements JoinServiceInf{

	private JoinDaoInf dao;
	
	public JoinService() throws RemoteException{
		dao = JoinDao.getInstance();
	}

	@Override
	public int getSearchId(String userId) throws RemoteException {
		return dao.getSearchId(userId);
	}

	@Override
	public int InsertJoinInfo(UserVO usVo) throws RemoteException {
		return dao.InsertJoinInfo(usVo);
	}

	@Override
	public List<JoinVO> setJoinTable(JoinVO jvo) throws RemoteException {
		return dao.setJoinTable(jvo);
	}

}

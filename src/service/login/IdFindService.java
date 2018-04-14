package service.login;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.login.IdFindDao;
import dao.login.IdFindDaoInf;
import vo.UserVO;

public class IdFindService extends UnicastRemoteObject implements IdFindServiceInf{

	private IdFindDaoInf dao;
	
	public IdFindService() throws RemoteException{
		dao = IdFindDao.getInstance();
	}

	@Override
	public List<UserVO> getUserInfo(String userNm) throws RemoteException {
		return dao.getUserInfo(userNm);
	}
}

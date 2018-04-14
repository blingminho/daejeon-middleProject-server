package service.login;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.login.IdFindDao;
import dao.login.IdFindDaoInf;
import dao.login.PwdFindDao;
import vo.UserVO;

public class PwdFindService extends UnicastRemoteObject implements PwdFindServiceInf{

	private PwdFindDao dao;
	
	public PwdFindService() throws RemoteException{
		dao = PwdFindDao.getInstance();
	}

	@Override
	public List<UserVO> getUserInfo(String userId) throws RemoteException {
		return dao.getUserInfo(userId);
	}

	@Override
	public int updatePwd(UserVO userPwd) throws RemoteException {
		return dao.updatePwd(userPwd);
	}

	
}

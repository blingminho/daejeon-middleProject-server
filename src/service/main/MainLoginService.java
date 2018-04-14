package service.main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.main.MainLoginDao;
import dao.main.MainLoginDaoInf;
import vo.JoinVO;
import vo.UserVO;

public class MainLoginService extends UnicastRemoteObject implements MainLoginServiceInf{

	
	private MainLoginDaoInf dao;
	
	public MainLoginService() throws RemoteException{
		dao = MainLoginDao.getInstance();
	}
	
	@Override
	public int getLoginId(String userid) throws RemoteException{
		return dao.getLoginId(userid);
	}

	@Override
	public int getLoginPwd(String userPwd) throws RemoteException {
		return dao.getLoginPwd(userPwd);
	}

	@Override
	public List<UserVO> getLoginUser(String userId) throws RemoteException {
		return dao.getLoginUser(userId);
	}

	@Override
	public List<JoinVO> getJoinInfo(String userId) throws RemoteException {
		return dao.getJoinInfo(userId);
	}


}

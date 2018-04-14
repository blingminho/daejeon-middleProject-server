package service.my;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import dao.my.MyHomeDao;
import dao.my.MyHomeDaoInf;

import vo.UserVO;

//server myhomeservice
public class MyHomeService extends UnicastRemoteObject implements MyHomeServiceInf{
	
	private MyHomeDaoInf dao;
	
	public MyHomeService() throws RemoteException{
		dao = MyHomeDao.getInstance();
	}
	
	@Override
	public UserVO getUserInfo(String us_id) throws RemoteException {
		return dao.getUserInfo(us_id);
	}

	@Override
	public int updateUser(UserVO vo) throws RemoteException {
		
		return dao.updateUser(vo);
	}

	@Override
	public boolean deleteUser(String us_id) throws RemoteException {
		return dao.deleteUser(us_id);
	}
	

	

}

package service.my;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.my.MyTeamParoduceDao;
import dao.my.MyTeamProduceDaoInf;
import vo.TeamVO;

public class MyTeamProduceService extends UnicastRemoteObject implements MyTeamProduceServiceInf{
	
	private MyTeamProduceDaoInf dao;
	
	public MyTeamProduceService() throws RemoteException{
		dao = MyTeamParoduceDao.getInstance();
	}
	
	
	@Override
	public int insertTeam(TeamVO vo) throws RemoteException {
		return dao.insertTeam(vo);
	}
	
	

}

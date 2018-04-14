package service.my;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.my.MyListDao;
import dao.my.MyListDaoInf;
import vo.JoinVO;




public class MyListService<TeamStatusVO> extends UnicastRemoteObject implements MyListServiceInf{
	
	private MyListDaoInf dao;
	
	public MyListService() throws RemoteException{
		dao = MyListDao.getInstance();
	}
	

	@Override
	public List<TeamStatusVO> tableEnrolledTeam(String jo_us_id) throws RemoteException {
		return dao.tableEnrolledTeam(jo_us_id);
	}


	@Override
	public List<TeamStatusVO> tableInvitedTeam(String jo_us_id) throws RemoteException {
		return dao.tableInvitedTeam(jo_us_id);
	}


	@Override
	public List<TeamStatusVO> tabeSignedUpTeam(String jo_us_id) throws RemoteException {
		return dao.tabeSignedUpTeam(jo_us_id);
	}

}

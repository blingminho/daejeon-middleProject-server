package service.team;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.team.TeamMenuDao;
import dao.team.TeamMenuDaoInf;

public class TeamMenuService extends UnicastRemoteObject implements TeamMenuServiceInf{
	
	private TeamMenuDaoInf dao;
	
	public TeamMenuService() throws RemoteException{
		dao = TeamMenuDao.getInstance();
	}

	@Override
	public String getJoinMemberState(String jo_tm_id, String jo_us_id) throws RemoteException {
		return dao.getJoinMemberState(jo_tm_id, jo_us_id);
	}

	@Override
	public String getTeamLeaderId(String tm_id) throws RemoteException {
		return dao.getTeamLeaderId(tm_id);
	}

	@Override
	public boolean deleteTeamMemberSelf(String jo_tm_id, String jo_us_id) throws RemoteException {
		return dao.deleteTeamMemberSelf(jo_tm_id, jo_us_id);
	}
	

}

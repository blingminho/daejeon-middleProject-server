package service.team;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.team.TeamHomeDao;
import dao.team.TeamHomeDaoInf;
import vo.TeamVO;

public class TeamHomeService extends UnicastRemoteObject implements TeamHomeServiceInf{
	
	private TeamHomeDaoInf dao;
	
	public TeamHomeService() throws RemoteException{
		dao = TeamHomeDao.getInstance();
	}
	
	@Override
	public TeamVO getTeamInfo(String tm_id) throws RemoteException {
		return dao.getTeamInfo(tm_id);
	}

	@Override
	public int getTeamMemberTotalCount(String jo_tm_id) throws RemoteException {
		return dao.getTeamMemberTotalCount(jo_tm_id);
	}

	@Override
	public String getJoinMemberState(String jo_tm_id, String jo_us_id) throws RemoteException {
		return dao.getJoinMemberState(jo_tm_id, jo_us_id);
	}

	@Override
	public boolean deleteJoinMember(String jo_tm_id, String jo_us_id) throws RemoteException {
		return dao.deleteJoinMember(jo_tm_id, jo_us_id);
	}

	@Override
	public boolean insertJoinMember(String jo_tm_id, String jo_us_id) throws RemoteException {
		return dao.insertJoinMember(jo_tm_id, jo_us_id);
	}
	
	@Override
	public boolean updateJoinMember(String jo_tm_id, String jo_us_id) throws RemoteException {
		return dao.updateJoinMember(jo_tm_id, jo_us_id);
	}

}

package service.team;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.team.TeamHomeDao;
import dao.team.TeamHomeDaoInf;
import dao.team.TeamManageDao;
import dao.team.TeamManageDaoInf;
import vo.TeamVO;
import vo.UserVO;

public class TeamManageService extends UnicastRemoteObject implements TeamManageServiceInf{
	
	private TeamManageDaoInf dao;
	
	public TeamManageService() throws RemoteException{
		dao = TeamManageDao.getInstance();
	}

	@Override
	public List<UserVO> getTeamMemberTotal(String jo_tm_id) throws RemoteException {
		return dao.getTeamMemberTotal(jo_tm_id);
	}

	@Override
	public List<UserVO> getTeamUserTotal(String jo_tm_id) throws RemoteException {
		return dao.getTeamUserTotal(jo_tm_id);
	}

	@Override
	public boolean deleteTeam(String tm_id) throws RemoteException {
		return dao.deleteTeam(tm_id);
	}

	@Override
	public boolean insertJoinMemberInvite(String jo_us_id, String jo_tm_id) throws RemoteException {
		return dao.insertJoinMemberInvite(jo_us_id, jo_tm_id);
	}

	@Override
	public boolean deleteJoin(String jo_us_id) throws RemoteException {
		return dao.deleteJoin(jo_us_id);
	}

	@Override
	public boolean updateJoinMember(String jo_us_id, String jo_tm_id) throws RemoteException {
		return dao.updateJoinMember(jo_us_id, jo_tm_id);
	}

	@Override
	public boolean updateTeam(TeamVO teamVo) throws RemoteException {
		return dao.updateTeam(teamVo);
	}

	@Override
	public int getTeamPN(String tm_id) throws RemoteException {
		return dao.getTeamPN(tm_id);
	}
}

package service.team;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.team.TeamProfileDao;
import dao.team.TeamProfileDaoInf;
import vo.UserVO;
/**
 * TeamProfileServiceInf 구현체
 * @author Jun
 *
 */
public class TeamProfileService extends UnicastRemoteObject implements TeamProfileServiceInf{
	
	private TeamProfileDaoInf dao;
	
	public TeamProfileService() throws RemoteException{
		dao = TeamProfileDao.getInstance();
	}

	@Override
	public List<UserVO> getTeamMemberList(String tm_id) throws RemoteException {
		return dao.getTeamMemberList(tm_id);
	}

	@Override
	public UserVO getTeamMemberProfile(String us_id) throws RemoteException {
		return dao.getTeamMemberProfile(us_id);
	}
}

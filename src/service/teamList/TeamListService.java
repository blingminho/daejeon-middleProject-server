package service.teamList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import dao.team.TeamTravelDao;
import dao.team.TeamTravelDaoInf;
import dao.teamList.TeamListDao;
import dao.teamList.TeamListDaoInf;
import vo.TeamVO;
import vo.TravelListVO;

/**
 * 팀 여행지 즐겨찾기와 관련된 서비스
 * @author Jun
 *
 */
public class TeamListService extends UnicastRemoteObject implements TeamListServiceInf{
	
	private TeamListDaoInf dao;
	
	public TeamListService() throws RemoteException{
		dao = TeamListDao.getInstance();
	}
	
	@Override
	public List<TeamVO> getTeamList() throws RemoteException {
		return dao.getTeamList();
	}

	@Override
	public List<Map<String, String>> getTeamPN() throws RemoteException {
		return dao.getTeamPN();
	}

}

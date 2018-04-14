package service.team;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.team.TeamTravelDao;
import dao.team.TeamTravelDaoInf;
import vo.TravelListVO;

/**
 * 팀 여행지 즐겨찾기와 관련된 서비스
 * @author Jun
 *
 */
public class TeamTravelService extends UnicastRemoteObject implements TeamTravelServiceInf{
	
	private TeamTravelDaoInf dao;
	
	public TeamTravelService() throws RemoteException{
		dao = TeamTravelDao.getInstance();
	}
	

	@Override
	public List<TravelListVO> getTravelList(String trv_tm_id) throws RemoteException {
		return dao.getTravelList(trv_tm_id);
	}

	@Override
	public int getTravelOnSchedule(String cal_tm_id, String cal_trv_id) throws RemoteException {
		return dao.getTravelOnSchedule(cal_tm_id, cal_trv_id);
	}

	@Override
	public boolean deleteTravel(String trv_id) throws RemoteException {
		return dao.deleteTravel(trv_id);
	}

	@Override
	public boolean insertTravel(TravelListVO travelVO) throws RemoteException {
		return dao.insertTravel(travelVO);
	}

}

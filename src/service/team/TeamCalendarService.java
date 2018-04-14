package service.team;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.team.TeamCalendarDao;
import dao.team.TeamCalendarDaoInf;
import vo.CalendarVO;
import vo.TeamVO;

public class TeamCalendarService extends UnicastRemoteObject implements TeamCalendarServiceInf{
	
	private TeamCalendarDaoInf dao;
	
	public TeamCalendarService() throws RemoteException{
		dao = TeamCalendarDao.getInstance();
	}
	
	@Override
	public List<String> getJoinTeamIdList(String jo_us_id) throws RemoteException {
		return dao.getJoinTeamIdList(jo_us_id);
	}

	@Override
	public List<CalendarVO> getCalendarBy_TM_ID(String cal_tm_id) throws RemoteException {
		return dao.getCalendarBy_TM_ID(cal_tm_id);
	}

	@Override
	public boolean insertCalendar(CalendarVO calendarVO) throws RemoteException {
		return dao.insertCalendar(calendarVO);
	}

	@Override
	public TeamVO getTeamVO(String tm_id) throws RemoteException {
		return dao.getTeamVO(tm_id);
	}

	@Override
	public int getCalendar(CalendarVO calendarVO) throws RemoteException {
		return dao.getCalendar(calendarVO);
	}

	@Override
	public boolean deleteCalendar(CalendarVO calendarVO) throws RemoteException {
		return dao.deleteCalendar(calendarVO);
	}
}

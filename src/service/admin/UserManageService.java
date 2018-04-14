package service.admin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.admin.UserManageDAO;
import dao.admin.UserManageDAOInf;
import vo.BlackListVO;
import vo.ReportVO;
import vo.UserVO;
/**
 * server 회원관리 서비스 
 * @author sk Back
 *
 */
public class UserManageService extends UnicastRemoteObject implements UserManageServiceInf{
	private UserManageDAOInf dao;
	
	public UserManageService() throws RemoteException {
		dao = UserManageDAO.getInstance();
	}

	@Override
	public List<UserVO> userInfoTable() throws RemoteException {
		
		return dao.userInfoTable();
	}

	@Override
	public List<ReportVO> reportInfoTable() throws RemoteException {
		return dao.reportInfoTable();
	}

	@Override
	public List<BlackListVO> blackInfoTable() throws RemoteException {
		return dao.blackInfoTable();
	}

	@Override
	public int delUser(String us_id) throws RemoteException {
		return dao.delUser(us_id);
	}

	@Override
	public int reportUser(String us_id) throws RemoteException {
		return dao.reportUser(us_id);
	}

	@Override
	public int reportDel(String re_id) throws RemoteException {
		return dao.reportDel(re_id);
	}

	@Override
	public int bListUser(String us_id) throws RemoteException {
		return dao.bListUser(us_id);
	}

}

package service.team;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import dao.team.ChatDaoServer;
import vo.ChattingVO;
import vo.ReportVO;

public class ChatServiceServer extends UnicastRemoteObject implements ChatServiceServerInf {
	
	private ChatDaoServer dao;
	
	
	public ChatServiceServer() throws RemoteException {
		dao = ChatDaoServer.getInstance();
	}

	@Override
	public void insertChat(ChattingVO vo) throws RemoteException {
		dao.insertChat(vo);
	}

	@Override
	public String chatTeamId(String tm_id) throws RemoteException {
		return null;
	}

	@Override
	public List<ChattingVO> getTeamChat(String tm_id) throws RemoteException {
		return dao.getTeamChat(tm_id);
	}

	@Override
	public void setMessage(String tm_id, String msg) throws RemoteException {
		dao.setMessage(tm_id, msg);
	}

	@Override
	public List<String> memList(String tm_id) throws RemoteException {
		return dao.memList(tm_id);
	}

	@Override
	public boolean userReport(ReportVO vo) throws RemoteException {
		return dao.userReport(vo);
	}

	

	@Override
	public boolean makeChat(String ct_tm_id) throws RemoteException {
		return dao.makeChat(ct_tm_id);
	}

	@Override
	public void joinChat(String ct_tm_id, ChatServiceClientInf client) throws RemoteException {
		dao.joinChat(ct_tm_id, client);
		
	}

	@Override
	public void excel(String tm_id, List<ChattingVO> list) throws RemoteException {
		dao.excel(tm_id, list);
		
	}


}

package dao.team;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import service.team.ChatServiceClientInf;
import vo.ChattingVO;
import vo.ReportVO;

public class ChatDaoServer implements ChatDaoServerInf {
	
	private static ChatDaoServer dao = new ChatDaoServer();
	private SqlMapClient smc;
	private TreeMap<String,ArrayList<ChatServiceClientInf>> chatList = 
			new TreeMap<String,ArrayList<ChatServiceClientInf>>();
	
	private ArrayList<ChatServiceClientInf> adminList = new ArrayList<ChatServiceClientInf>();
	
	
	private ChatDaoServer() {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ChatDaoServer getInstance() {
		return dao;
	}

	@Override
	public void insertChat(ChattingVO vo) throws RemoteException {
		
		try {
			smc.insert("chatting.insertChatt",vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String chatTeamId(String tm_id) throws RemoteException {
		String result = null;
		try {
			result = (String) smc.queryForObject("chatting.getTeamId",tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChattingVO> getAllChat() throws RemoteException {
		ArrayList<ChattingVO> list=null;
		
		try {
			list = (ArrayList<ChattingVO>) smc.queryForList("chatting.getAllList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ChattingVO> getTeamChat(String tm_id) throws RemoteException {
		ArrayList<ChattingVO>teamChatList = null;
		
		try {
			teamChatList = (ArrayList<ChattingVO>) smc.queryForList("chatting.getChattList",tm_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teamChatList;
	}

	@Override
	public void setMessage( String tm_id, String msg) throws RemoteException {
		
			ArrayList<ChatServiceClientInf> list = chatList.get(tm_id);
			System.out.println("chatClient => " + list.size());
			for (ChatServiceClientInf client : list) {
				client.setMessage(msg);
			}
		
			System.out.println("chatClient => " + adminList.size());
			for(ChatServiceClientInf client : adminList) {
				client.setMessage(msg);
			
		}
	}

	
	@Override
	public List<String> memList(String tm_id) throws RemoteException {
		ArrayList<String>result = null;
		try {
			result = (ArrayList<String>) smc.queryForList("chatting.getMemberId",tm_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean userReport(ReportVO vo) throws RemoteException {
		boolean result=false;
		try {
			Object obj = smc.insert("chatting.insertReport",vo);
			if( obj == null) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	@Override
	public boolean makeChat(String ct_tm_id) throws RemoteException {
		boolean isExist = chatList.keySet().contains(ct_tm_id.trim());
	
//		boolean result = false;
		if(!isExist) {
			ArrayList<ChatServiceClientInf> chat = new
					ArrayList<ChatServiceClientInf>();
			chatList.put(ct_tm_id, chat);
		}
		
		return isExist;
	}

	@Override
	public void joinChat(String ct_tm_id, ChatServiceClientInf client) throws RemoteException {
		
			ArrayList<ChatServiceClientInf> list = chatList.get(ct_tm_id);

			list.add(client);
	
	}

	@Override
	public void excel(String tm_id, List<ChattingVO> list) throws RemoteException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(tm_id+"loge");
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell;
		
		cell = row.createCell(0);
		cell.setCellValue("유저 아이디");
		
		cell = row.createCell(1);
		cell.setCellValue("팀 아이디");
		
		cell = row.createCell(2);
		cell.setCellValue("채팅 아이디");
		
		cell = row.createCell(3);
		cell.setCellValue("채팅내용");
		
		cell = row.createCell(4);
		cell.setCellValue("채팅 날짜");
		
		ChattingVO chat ;
		for (int i = 0; i < list.size(); i++) {
			chat = list.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell(0);
			cell.setCellValue(chat.getCt_us_id());

			cell = row.createCell(1);
			cell.setCellValue(chat.getCt_tm_id());

			cell = row.createCell(2);
			cell.setCellValue(chat.getCt_id());

			cell = row.createCell(3);
			cell.setCellValue(chat.getCt_content());
			
			cell = row.createCell(4);
			cell.setCellValue(chat.getCt_dt());
		}
	
		File file = new File("C:\\chatList\\"+tm_id+"TeamLog.xls");
		FileOutputStream fout = null;
		
		try {
			fout = new FileOutputStream(file);
			wb.write(fout);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fout!=null)fout.close();
				if(wb!=null) wb.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}




}

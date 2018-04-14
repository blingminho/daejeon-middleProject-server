package main;

import java.rmi.server.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.admin.UserManageService;
import service.admin.UserManageServiceInf;
import service.admin.UserManageService;
import service.admin.UserManageServiceInf;
import service.board.BoardComentService;
import service.board.BoardHomeService;
import service.board.BoardWriteService;
import service.login.IdFindService;
import service.login.JoinService;
import service.login.JoinServiceInf;
import service.login.PwdFindService;
import service.main.MainLoginService;
import service.main.MainLoginServiceInf;
import service.my.MyHomeService;
import service.my.MyListService;
import service.team.ChatServiceServer;
import service.team.ChatServiceServerInf;
import service.team.TeamCalendarService;
import service.team.TeamHomeService;
import service.team.TeamManageService;
import service.team.TeamMenuService;
import service.team.TeamPHBService;
import service.team.TeamPHBUploadService;
import service.team.TeamProfileService;
import service.team.TeamTravelService;
import service.teamList.TeamListService;

/**
 * Server Start Main
 * @author Jun
 *
 */
public class Main {
	public static void main(String[] args) {
		
		try {
			MainLoginServiceInf login = new MainLoginService();
			JoinServiceInf join = new JoinService(); 
			ChatServiceServerInf chat = new ChatServiceServer();
			
			Registry reg = LocateRegistry.createRegistry(9988);
			
			reg.rebind("login", login);
			reg.rebind("Join", join);
			reg.rebind("Chat", chat );
			reg.rebind("IdFind", new IdFindService());
			reg.rebind("PwdFind", new PwdFindService());
			reg.rebind("BoardHome", new BoardHomeService());
			reg.rebind("BoardWrite",new BoardWriteService());
			reg.rebind("BoardComent", new BoardComentService());
			reg.rebind("Chat", new ChatServiceServer());
			reg.rebind("TeamHome", new TeamHomeService());
			reg.rebind("TeamMenu", new TeamMenuService());
			reg.rebind("TeamProfile", new TeamProfileService());
			reg.rebind("TeamTravelList", new TeamTravelService());
			reg.rebind("TeamManage", new TeamManageService());
			reg.rebind("adminMain", new UserManageService());
			reg.rebind("MyHome", new MyHomeService());
			reg.rebind("TeamList", new TeamListService());
			reg.rebind("TeamCalendar", new TeamCalendarService());
			reg.rebind("teamPTBUpLoad", new TeamPHBUploadService());
			reg.rebind("teamPTBReUpLoad", new TeamPHBUploadService());
			reg.rebind("MyList", new MyListService());
			
			reg.rebind("TeamPHB", new TeamPHBService());

			System.out.println("서버 준비 완료");
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

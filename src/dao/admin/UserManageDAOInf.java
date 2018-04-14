package dao.admin;

import java.rmi.RemoteException;
import java.util.List;

import vo.BlackListVO;
import vo.ReportVO;
import vo.UserVO;
/**
 * server 회원관리 dao 인터페이스
 * @author sk Back
 *
 */
public interface UserManageDAOInf{
	/**
	 * 모든 회원정보를 리스트 형태로 반환 
	 * @return ArrayList(UserVO)
	 * @throws RemoteException
	 * @author 백선경
	 */
	public List<UserVO> userInfoTable();
	
	/**
	 * 신고 회원 정보를 리스트 형태로 반환 
	 * @return ArrayList(ReportVO)
	 * @throws RemoteException
	 * @author 백선경
	 */
	public List<ReportVO> reportInfoTable();
	
	/**
	 * 블랙리스트 회원 정보를 리스트 형태로 반환 
	 * @return ArrayList(BlackListVO)
	 * @throws RemoteException
	 * @author 백선경
	 */
	public List<BlackListVO> blackInfoTable();
	
	/**
	 * 강퇴할 유저id를 매개변수로 DB에서 회원 정보 삭제
	 * @param 강퇴할 us_id
	 * @return 성공시 1이상, 실패시 0 반환
	 * @author 백선경
	 */
	public int delUser(String us_id);
	
	/**
	 * 신고 승인할 유저id를 매개변수로 DB회원 정보 변경
	 * us테이블 경고횟수 1회 증가(update)
	 * @param 해당 us_id
	 * @return 성공시 1이상, 실패시 0
	 * @author 백선경
	 */
	public int reportUser(String us_id);
	
	/**
	 * 신고 승인할 리폿리스트 행을 삭제(delete)
	 * @param 삭제할 신고번호 re_id
	 * @return 성공시 1이상, 실패시 0
	 * @author 백선경
	 */
	public int reportDel(String re_id);
	
	/**
	 * 신고 승인 3회 달성시 black테이블 행 추가(insert)
	 * @param us_id
	 * @return 성공시 1이상, 실패시 0
	 * @author 백선경
	 */
	public int bListUser(String us_id);
	
}

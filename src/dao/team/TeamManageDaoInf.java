package dao.team;

import java.util.List;

import vo.TeamVO;
import vo.UserVO;;
/**
 * 팀페이지의 팀 관리에 관련된 DAO 인터페이스
 * @author Jun
 *
 */
public interface TeamManageDaoInf {
	
	/**
	 * 팀아이디를 제공하여 멤버의 이름과 아이디 목록을 불러옴
	 * @param 팀아이디
	 * @return 이름, 아이디를 가진 리스트
	 */
	public List<UserVO> getTeamMemberTotal(String jo_tm_id);

	
	/**
	 * 팀아이디를 제공하여 가입대기중인 유저의 이름과 아이디 목록을 불러옴
	 * @param 팀아이디
	 * @return 이름, 아이디를 가진 리스트
	 */
	public List<UserVO> getTeamUserTotal(String jo_tm_id);
	
	/**
	 * 팀아이디를 제공하여 팀을 제거
	 * @param 팀 아이디
	 * @return 성공시 true
	 */
	public boolean deleteTeam(String tm_id);
	
	/**
	 * 유저 초대하기
	 * @param 유저아이디와 팀아이디
	 * @return 성공시 true
	 */
	public boolean insertJoinMemberInvite(String jo_us_id, String jo_tm_id);
	
	/**
	 * 가입테이블에서 해당 유저 제거하기
	 * @param 유저아이디
	 * @return 성공시 true
	 */
	public boolean deleteJoin(String jo_us_id);
	
	/**
	 * 가입 테이블의 해당 회원을 가입시킴(상태를 Y로 변경)
	 * @param 유저아이디, 팀아이디
	 * @return 성공시 true
	 */
	public boolean updateJoinMember(String jo_us_id, String jo_tm_id);
	
	/**
	 * 해당 팀의 정보를 수정함
	 * @param 팀정보를 가진 Map
	 * @return 성공시 true
	 */
	public boolean updateTeam(TeamVO teamVo);
	
	/**
	 * 해당 팀의 최대 인원수를 가져옴
	 * @param 팀아이디
	 * @return 최대 인원수
	 */
	public int getTeamPN(String tm_id);
}

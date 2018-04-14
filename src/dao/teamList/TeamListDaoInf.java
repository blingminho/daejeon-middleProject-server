package dao.teamList;

import java.util.List;
import java.util.Map;

import vo.TeamVO;

/**
 * 공개팀 목록에 관련된 DAO 인터페이스
 * @author Jun
 *
 */
public interface TeamListDaoInf {
	
	/**
	 * 팀아이디를 제공하여 가입 가능한 공개된 팀 목록을 가져옴
	 * @return 팀VO 리스트
	 */
	public List<TeamVO> getTeamList();
	
	/**
	 * 가입테이블의 팀아이디와 해당 팀의 가입한 인원수를 보내줌
	 * @return jo_tm_id 팀아이디, jo_pn 팀가입수
	 */
	public List<Map<String, String>> getTeamPN();
}

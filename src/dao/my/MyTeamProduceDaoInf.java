package dao.my;

import vo.TeamVO;
/**
 * 팀 생성 화면에 관련된 DAO 인터페이스
 * @author sun
 *
 */
public interface MyTeamProduceDaoInf {

	/**
	 * 팀을 생성하여 팀 테이블에 넣음
	 * @param vo 
	 * @return
	 */
	public  int insertTeam(TeamVO vo);
	
	
}

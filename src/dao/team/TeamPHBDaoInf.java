package dao.team;

import java.util.List;

import vo.CalendarVO;
import vo.PhbVO;
import vo.TeamVO;
/**
 * 팀페이지의 사진첩 및
 * 관리자의 사진첩관리에 관련된 DAO 인터페이스
 * @author Jun
 */
public interface TeamPHBDaoInf {
	
	/**
	 * 관리자가 모든 사진첩의 정보를 가져올때 사용
	 * @return 모든 사진첩 리스트
	 */
	public List<PhbVO> getAllPhb();

	/**
	 * 관리자가 모든 사진첩의 정보를 가져올때 사용
	 * @return 모든 사진첩 리스트
	 */
	
	/**
	 * 팀원이 팀아이디를 이용하여 팀의 사진첩 리스트 가져옴
	 * @param 팀아이디를 담은 PhbVO
	 * @return 해당 팀의 모든 사진첩 리스트
	 */
	public List<PhbVO> getPhb(PhbVO phbvo);
	
	/**
	 * 글쓴이 또는 관리자가 사진을 지울때 사용
	 * @param 사진첩아이디를 담은 PhbVO
	 * @return 성공시 1 반환
	 */
	public boolean deletePhb(PhbVO phbvo);
	
	/**
	 * 좋아요수를 증가시킬때 사용
	 * @param 사진첩아이디를 담은 PhbVO
	 * @return 성공시 1 반환
	 */
	public boolean updateGood(PhbVO phbvo);
	
}

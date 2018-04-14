package dao.main;

import java.util.List;

import vo.JoinVO;
import vo.UserVO;

public interface MainLoginDaoInf {
	
	/**
	 * id값이 있으면 1을 반환 없으면 0을 반환
	 * @param user
	 * @return
	 */
	public int getLoginId(String userid);
	
	/**
	 * password값이 있으면 1을 반환 없으면 0을 반환
	 * @param user
	 * @return
	 */
	public int getLoginPwd(String userPwd);
	
	/**
	 * 로그인을 하기전 해당 ID가 있는지 확인
	 * @param userId
	 * @return
	 */
	public List<UserVO> getLoginUser(String userId);
	
	/**
	 * 로그인을 하면 팀id를 넘겨주기 위해 사용
	 * @param userId
	 * @return
	 */
	public List<JoinVO> getJoinInfo(String userId);
}

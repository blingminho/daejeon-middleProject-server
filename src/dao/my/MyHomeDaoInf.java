package dao.my;

import vo.UserVO;
/**
 * 
 * server 팀페이지의 홈 화면에 관련된 DAO 인터페이스
 * @author sun
 *
 */
public interface MyHomeDaoInf {
	
	/**
	 * 유저아이디를 매개변수로 가입된 유저의 정보를 가져옴
	 * @param us_id 유저아이디
	 * @return 해당 아이디에 대한 유저의가입 정보 UserVO 
	 */
	public UserVO getUserInfo(String us_id);
	
	/**
	 *  유저아이디를 매개변수로 가입된 유저의 정보를 변경함
	 * @param us_id
	 * @return 변경된 유저의 정보를 유저아디로 return
	 */
	public int updateUser(UserVO vo);

	/**
	 * 유저아이디를 매개변수로 가입된 유저의 탈퇴 컬럼을 'Y'로 수정
	 * @param us_id
	 * @return 성공시 true
	 */
	public boolean deleteUser(String us_id);
	
}

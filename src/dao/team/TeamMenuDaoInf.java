package dao.team;

/**
 * 팀페이지의 메뉴 화면에 관련된 DAO 인터페이스
 * @author Jun
 *
 */
public interface TeamMenuDaoInf {
	
	/**
	 * 팀아이디와 유저아이디를 제공하여 해당 팀의 가입 또는 초대 여부를 가져옴
	 * @param jo_tm_id 팀아이디
	 * @param jo_us_id 유저아이디
	 * @return jo_stt (가입 상태)
	 */
	public String getJoinMemberState(String jo_tm_id, String jo_us_id);
	
	/**
	 * 팀아이디를 제공하여 해당 팀의 리더 아이디를 가져옴
	 * @param tm_id 팀아이디
	 * @return tm_ld_id (리더 아이디)
	 */
	public String getTeamLeaderId(String tm_id);
	
	/**
	 * 팀아이디와 유저아이디를 제공하여 Join테이블에서 제거
	 * @param jo_tm_id 팀아이디
	 * @param jo_us_id 유저아이디
	 * @return 성공시 true
	 */
	public boolean deleteTeamMemberSelf(String jo_tm_id, String jo_us_id);
}

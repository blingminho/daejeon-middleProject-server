package dao.my;

import java.rmi.RemoteException;
import java.util.List;




/**
 * 
 * @author PC08
 *
 * @param <TeamStatusVO>
 */
public interface MyListDaoInf<TeamStatusVO> {
	
	/**
	 * 
	 * @param jo_stt
	 * @return
	 */
	public List<TeamStatusVO> tabeSignedUpTeam(String jo_us_id) ;
	
	/**
	 * 
	 * @param jo_stt
	 * @return
	 */
	public List<TeamStatusVO> tableInvitedTeam(String jo_us_id) ;
	
	/**
	 * 
	 * @param jo_stt
	 * @return
	 */
	public List<TeamStatusVO> tableEnrolledTeam(String jo_us_id);
	
	}
	

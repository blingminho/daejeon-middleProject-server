package dao.login;

import java.rmi.RemoteException;
import java.util.List;

import vo.UserVO;

public interface PwdFindDaoInf {

	public List<UserVO> getUserInfo(String userId);
	
	public int updatePwd(UserVO userPwd);
}

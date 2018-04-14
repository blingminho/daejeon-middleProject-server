package dao.login;

import java.rmi.RemoteException;
import java.util.List;

import vo.UserVO;

public interface IdFindDaoInf {

	public List<UserVO> getUserInfo(String userNm);
}

package service.team;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.team.TeamPHBUploadDao;
import dao.team.TeamPHBUploadDaoInf;
import vo.FileInfoVO;
import vo.FileVO;
import vo.PhbVO;

public class TeamPHBUploadService extends UnicastRemoteObject implements TeamPHBUploadServiceInf{
	
	private TeamPHBUploadDaoInf dao;

	public TeamPHBUploadService() throws RemoteException{
		dao = TeamPHBUploadDao.getInstance();
	}

	@Override
	public int phbInsert(PhbVO phbVo) throws RemoteException {
		return dao.phbInsert(phbVo);
	}

	@Override
	public int phbFileInsert(FileVO fileVo) throws RemoteException {
		return dao.phbFileInsert(fileVo);
	}

	@Override
	public int phbFileupdate(FileVO fileVo) throws RemoteException {
		return dao.phbFileupdate(fileVo);
	}

	@Override
	public int phbDel(String phb_id) throws RemoteException {
		return dao.phbDel(phb_id);
	}


	@Override
	public String getPhbID() throws RemoteException {
		return dao.getPhbID();
	}

	@Override
	public PhbVO selectPhbVo(String phb_id) throws RemoteException {
		return dao.selectPhbVo(phb_id);
	}

	/**
	 * 서버에 file이름과 팀아이디를 이용하여 파일을 만듬
	 * @param FileInfoVO
	 * @param 팀아이디
	 * @throws RemoteException
	 */
	public FileInfoVO setFiles(FileInfoVO info, String tm_id) throws RemoteException {
		FileOutputStream fout = null;
		String dir = "C:/travelMaker/PHB/server/" + tm_id + "/";
		
		File file = new File(dir);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		try {
			String path = info.getFileName();
			fout = new FileOutputStream(path);
			fout.write(info.getFileData());
			fout.close();
			info.setFileName(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return info;
	}

}

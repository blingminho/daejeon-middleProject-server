package service.team;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.team.TeamPHBDao;
import dao.team.TeamPHBDaoInf;
import vo.FileInfoVO;
import vo.PhbVO;

public class TeamPHBService extends UnicastRemoteObject implements TeamPHBServiceInf{
	private TeamPHBDaoInf dao;
	public TeamPHBService() throws RemoteException{
		dao = TeamPHBDao.getInstance();
	}

	String outdir = "C:/travelMaker/PHB/client/";
	
	/**
	 * 서버로부터 FileInfoVO배열을 받음
	 * @param 팀아이디
	 * @return 초기화된 FileInfoVO배열
	 * @throws RemoteException
	 */
	public FileInfoVO[] getFiles(String tm_id) throws RemoteException{
		
		
		FileInputStream fin = null;
		String indir = "C:/travelMaker/PHB/server/" + tm_id + "/";
		
		File dirFile = new File(indir);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		
		File[] fileList = dirFile.listFiles();
		int fileCnt = fileList.length;
		
		// 파일 읽기
		FileInfoVO[] finfo = new FileInfoVO[fileCnt];
		if(fileCnt != 0) {
			for(int i = 0; i<finfo.length; i++) {
				int len = (int) fileList[i].length();
				byte[] data = new byte[len];
				
				try {
					fin = new FileInputStream(fileList[i]);
					fin.read(data);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			    String tempFileName = fileList[i].getName();
				
				finfo[i] = new FileInfoVO();
				finfo[i].setFileName(tempFileName);
				finfo[i].setFileData(data);
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		}
		return finfo;
	}
	
	/**
	 * 서버로부터 받은 FileInfoVO[]과 팀아이디를 이용하여 파일을 만듬
	 * @param FileInfoVO[]
	 * @param 팀아이디
	 * @throws RemoteException
	 */
	public FileInfoVO[] setFiles(FileInfoVO[] info, String tm_id) throws RemoteException {
		FileOutputStream fout = null;
		String dir = "C:/travelMaker/PHB/client/" + tm_id + "/";
		
		File file = new File(dir);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		for (int i = 0; i < info.length; i++) {
			try {
				String path = dir+info[i].getFileName();
				fout = new FileOutputStream(path);
				fout.write(info[i].getFileData());
				fout.close();
				info[i].setFileName(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public List<PhbVO> getAllPhb() throws RemoteException {
		return dao.getAllPhb();
	}

	@Override
	public List<PhbVO> getPhb(PhbVO phbvo) throws RemoteException {
		return dao.getPhb(phbvo);
	}

	@Override
	public boolean deletePhb(PhbVO phbvo) throws RemoteException {
		return dao.deletePhb(phbvo);
	}

	@Override
	public boolean updateGood(PhbVO phbvo) throws RemoteException {
		return dao.updateGood(phbvo);
	}
}

package service.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.board.BoardWriteDao;
import dao.board.BoardWriteDaoInf;
import vo.BoardVO;
import vo.FileInfoVO;
import vo.FileVO;

public class BoardWriteService extends UnicastRemoteObject implements BoardWriteServiceInf{

	private BoardWriteDaoInf dao;
	
	public BoardWriteService() throws RemoteException{
		dao = BoardWriteDao.getInstance();
	}

	@Override
	public int setBoardWrite(BoardVO bvo) throws RemoteException {
		return dao.setBoardWrite(bvo);
	}


	@Override
	public String getFileSeqId() throws RemoteException {
		return dao.getFileSeqId();
	}

	@Override
	public void setFiles(FileInfoVO[] info) throws RemoteException {
		FileOutputStream fout = null;
		String dir = "C:/Image/";
		
		File file = new File(dir);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		for (int i = 0; i < info.length; i++) {
			try {
				fout = new FileOutputStream(dir+info[i].getFileName());
				
				fout.write(info[i].getFileData());
				fout.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("파일저장끝");
		
	}

	@Override
	public void setBoardWriteFile(List<FileVO> fileList) throws RemoteException {
		dao.setBoardWriteFile(fileList);
	}

	@Override
	public String getBoardSeqId() throws RemoteException {
		return dao.getBoardSeqId();
	}


	
	
	
}

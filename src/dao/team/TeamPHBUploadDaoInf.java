package dao.team;

import java.rmi.RemoteException;

import vo.FileVO;
import vo.PhbVO;

/**
 * server 사진첩 upload, reUpload DAO 인터페이스
 * @author sk.Back
 *
 */
public interface TeamPHBUploadDaoInf{
	
	/**
	 * 사진첩정보를 db에 insert
	 * @param PhbVO
	 * @return 성공시 1이상, 실패시 0
	 * @author 백선경
	 */
	public int phbInsert(PhbVO phbVo);

	
	/**
	 * user가 올리는 이미지 정보를 DB에 insert
	 * @param FileVO
	 * @return 성공시 1이상, 실패시 0
	 * @author 백선경
	 */
	public int phbFileInsert(FileVO fileVo);
	
	/**
	 * user가 수정한 이미지 정보를 DB에 update
	 * ReamPTBReUpLoad 버튼 액션버튼에 사용
	 * @param FileVO
	 * @return 성공시 1이상, 실패시 0
	 * @author 백선경
	 */
	public int phbFileupdate(FileVO fileVo);
	
	/**
	 * 사진첩에 올린 사진첩 게시물 삭제(delete)
	 * @param 삭제할 사진첩 게시물의 id
	 * @return 성공시 1이상, 실패시 0
	 * @author 백선경
	 */
	public int phbDel(String phb_id);
	
	/**
	 * 가장 최근에 저장된 사진첩에 저장된 사진첩id를 가져옴(select)
	 * @return 사진첩ID
	 * @author 백선경
	 */
	public String getPhbID();
	
	/**
	 * 가장 최근에 저장된 사진첩 정보를 가져옴(select)
	 * @return 사진첩 정보(가져온팀아이디로 저장 경로지정)
	 * @param 방금 저장한 사진첩 ID
	 * @author 백선경
	 */
	public PhbVO selectPhbVo(String phb_id);

}

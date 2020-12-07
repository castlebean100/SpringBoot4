package com.iu.sb4.board;

import java.util.List;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.board.notice.NoticeVO;
import com.iu.sb4.util.Pager;

public interface BoardMapper {

	public long getCount(Pager pager) throws Exception;
	
	// 글쓰기
	public int setInsert(BoardVO boardVO) throws Exception;
	
	// 파일 첨부
	public int setInsertFile(FileVO fileVO) throws Exception;
	
	// 글수정
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	// 글삭제
	public int setDelete(BoardVO boardVO) throws Exception;
	
	// 글조회
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public FileVO getFileOne(FileVO fileVO) throws Exception;
	
	public FileVO getFile(FileVO fileVO) throws Exception;
	
	
}

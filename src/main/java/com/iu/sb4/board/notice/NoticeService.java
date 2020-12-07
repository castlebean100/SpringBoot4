package com.iu.sb4.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb4.board.BoardService;
import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.FileManager;
import com.iu.sb4.util.FilePathGenerator;
import com.iu.sb4.util.Pager;


@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		long totalCount = noticeMapper.getCount(pager);
		pager.makePage(totalCount);
		return noticeMapper.getList(pager); //리스트 갖고옴
	}
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		
		int result = noticeMapper.setInsert(boardVO);
		
		System.out.println("Num : "+boardVO.getNum());
		/*
		1. HDD에 File을 저장하기
		- 저장할 폴더의 실제 경로명이 필요하다.
		*/
		File file = filePathGenerator.getUseResourceLoader(filePath);
		
		for (MultipartFile multipartFile:files) {
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName = fileManager.saveFileCopy(multipartFile, file);
			System.out.println(fileName);
			
			FileVO fileVO = new FileVO();
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartFile.getOriginalFilename());
			fileVO.setNum(boardVO.getNum());
		
			result = noticeMapper.setInsertFile(fileVO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		return noticeMapper.getOne(boardVO); 
	}

	@Override
	public FileVO getFile(FileVO fileVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getFile(fileVO);
	}

	

	
}

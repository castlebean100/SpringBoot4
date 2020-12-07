package com.iu.sb4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.Pager;

@Controller
@RequestMapping("notice/**") // notice관련된 것은 모두 다 처리할 것임
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@Value("${board.notice.filePath}")
	private String filePath;
	
	 @GetMapping("noticeFileDown") public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception {
		 ModelAndView mv = new ModelAndView();
		 fileVO = noticeService.getFile(fileVO);

		 mv.addObject("fileVO", fileVO);
	//	 mv.addObject("filePath","upload/notice");
		 mv.addObject("filePath", filePath);
		 mv.setViewName("fileDown");
		 return mv;
	}
	 

	@GetMapping
	public ModelAndView getOne(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getOne(boardVO);

		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");

		return mv;
	}

	@GetMapping("noticeList") // noticeList라는 주소가 들어오면
	public String getList(Pager pager, Model model) throws Exception {

		List<BoardVO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/boardList";
	}

	@GetMapping("noticeWrite")
	public String setInsert() throws Exception {
		return "board/boardWrite";
	}

	@PostMapping("noticeWrite")
	public String setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		int result = noticeService.setInsert(boardVO, files);
		return "redirect:./noticeList";
	}
}

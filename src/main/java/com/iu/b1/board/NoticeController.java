package com.iu.b1.board;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.NodeList;

import com.iu.b1.member.MemberService;
import com.iu.b1.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
	}
	
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
	 List<NoticeVO> ar =noticeService.boardList(pager);
	 mv.addObject("list", ar);
	 mv.addObject("pager", pager);
	 mv.setViewName("board/boardList");
		return mv;
	}
	
	
	
	
	//notice Form
	//@GetMapping("noticeWrite")
	//public String noticeWrite(Model model, @ModelAttribute(name = "boardVO") NoticeVO noticeVO)throws Exception{
		/* model.addAttribute("boardVO", new NoticeVO()); */
		/*
		 * ModelAndView mv = new ModelAndView(); 
		 * mv.addObject("boardVO", new NoticeVO());
		 */
		
		
		//return "board/boardWrite";
	//}
	
	
	
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO=noticeService.noticeSelect(noticeVO);
		mv.addObject("files", noticeService.noticeFilesSelect(noticeVO));
		mv.addObject("vo",noticeVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	
	
	
	//notice Form
		@GetMapping("noticeWrite")
		public String noticeWrite()throws Exception{

			return "board/boardWrite";
		}
	
	

	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile [] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/boardWrite");
		}else {
		
		int result = noticeService.noticeWrite(noticeVO, files);
		
		String message = "Write Fail";
		String path = "./noticeList";
		if (result > 0) {
			message = "Write Success";

		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		}
		
		return mv;
		
	}
	
	
	
	
	

}

package com.iu.b1.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.member.MemberFilesVO;
import com.iu.b1.util.FIlePathGenerator;
import com.iu.b1.util.FileSaver;
import com.iu.b1.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService {
	
	@Autowired
	private FIlePathGenerator fIlePathGenerator;	
	@Autowired
	private FileSaver fileSaver;
	@Autowired
	private NoticeFilesMapper noticeFilesMapper;
	
	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	
	
	public List<NoticeVO> boardList(Pager pager)throws Exception{
		pager.makeRow();
		pager.makePage(noticeMapper.noticeCount(pager));
		return noticeMapper.boardList(pager);
	}
	
	public NoticeVO noticeSelect(NoticeVO noticeVO)throws Exception{
		return noticeMapper.noticeSelect(noticeVO);
	}
	
	
	
	
	public int noticeWrite(NoticeVO noticeVO,MultipartFile [] files)throws Exception{
		int result = noticeMapper.boardWrite(noticeVO);
		
		File file = fIlePathGenerator.getUseClassPathResource("notice");
		
		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		for(int i=1;i<files.length;i++) {
			String fileName = fileSaver.save(file, files[i]);
			System.out.println("fileName: "+fileName);
			
			NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
			noticeFilesVO.setNum(noticeVO.getNum());	
			noticeFilesVO.setFname(fileName);
			noticeFilesVO.setOname(files[i].getOriginalFilename());
			//noticeFilesMapper.noticeFilesInsert(noticeFilesVO);
			noticeFilesVOs.add(noticeFilesVO);
		
		}
		noticeFilesMapper.noticeFilesInsert(noticeFilesVOs);
				
	return result;
	
	}
	
	
	public List<NoticeFilesVO> noticeFilesSelect(NoticeVO noticeVO)throws Exception{
		return noticeFilesMapper.noticeFilesSelect(noticeVO);
	}
	
	
	

}

package com.iu.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FIlePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private FIlePathGenerator fIlePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private MemberFilesMapper memberFilesMapper;
	
	
	public boolean memberJoinValidate(MemberVO memberVO,BindingResult bindingResult)throws Exception{
		boolean check =false; //true면 에러 , false면 ok
		//annotation 검증결과
		if(bindingResult.hasErrors()) {
			check=true;
		}
		
		//pw가 일치하는지 검증
		
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check=true;				//form의 path명, properties의 키 
			bindingResult.rejectValue("pw2", "memberVO.pw.notEqual");
		}
		
		memberVO = memberMapper.memberCheckId(memberVO);
		if(memberVO!=null) {
			check=true;
			bindingResult.rejectValue("id", "memberVO.id.notnull");
		}
			
		return check;
	}	
	
	
	
	public MemberFilesVO memberFilesSelect(MemberFilesVO memberFilesVO)throws Exception{
		return memberFilesMapper.memberFilesSelect(memberFilesVO);
	}
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		return memberMapper.memberLogin(memberVO);
	}
	
	
	public int memberJoin(MemberVO memberVO,MultipartFile files)throws Exception{
		//파일을 저장할 폴더 
		File file = fIlePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		int result = memberMapper.memberJoin(memberVO);
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		result= memberFilesMapper.memberFilesInsert(memberFilesVO);
		return result;
	}
	

	
	
	
}

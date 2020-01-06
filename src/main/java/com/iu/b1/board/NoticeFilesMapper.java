package com.iu.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.iu.b1.member.MemberFilesVO;

@Repository
@Mapper
public interface NoticeFilesMapper {

	/*
	 * public int noticeFilesInsert(NoticeFilesVO noticeFilesVO) throws Exception;
	 */
	
	public int noticeFilesInsert(List<NoticeFilesVO> noticeFilesVOs) throws Exception;
	
	public List<NoticeFilesVO> noticeFilesSelect(NoticeVO noticeVO)throws Exception;
}

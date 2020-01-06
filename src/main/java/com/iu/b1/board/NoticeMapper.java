package com.iu.b1.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.iu.b1.util.Pager;

@Repository
@Mapper
public interface NoticeMapper {

	public int boardWrite(NoticeVO noticeVO)throws Exception;
	
	public List<NoticeVO> boardList(Pager pager)throws Exception;
	
	public int noticeCount(Pager pager)throws Exception;
	
	public NoticeVO noticeSelect(NoticeVO noticeVO)throws Exception;
	
}

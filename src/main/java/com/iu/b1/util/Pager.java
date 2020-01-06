package com.iu.b1.util;

public class Pager {
	
	
	//DB
	private Integer curPage;//현재 페이지
	private Integer perPage; //페이지당 글갯수
	private String kind;
	private String search; 
	private Integer startRow; 
	private Integer lastRow;
	
	
	public Integer getCurPage() {
		if(curPage == null || curPage == 0) {
			this.curPage = 1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(perPage == null || perPage == 0) {
			this.perPage = 10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) {
			search="";
		}
		
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getLastRow() {
		return lastRow;
	}
	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	} 
	
	
	
	//View(Jsp)
	
	private Integer startNum; 
	private Integer lastNum; 
	private Integer curBlock;
	private Integer totalBlock; 
	
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow= this.getCurPage()*this.getPerPage();
		
	}

	public void makePage(int totalCount) {
		int totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;

		}
	
	int perBlock =3;
	totalBlock = totalPage/perBlock;
	if(totalPage%perBlock !=0) {
		totalBlock++;
	}
	
	curBlock = this.getCurPage()/perBlock;
	if(this.getCurPage()%perBlock !=0) {
		curBlock++;
	}
	
	startNum = (curBlock-1)*perBlock+1;
	lastNum = curBlock*perBlock;
	if(curBlock==totalBlock) {
		lastNum = totalPage;
	}
	
	}
	
	
	
	
	
	

}

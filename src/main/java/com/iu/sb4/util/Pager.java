package com.iu.sb4.util;

import lombok.Data;

@Data
public class Pager {

	private String kind;
	private String search;

	private long curPage; // 현재 페이지 번호
	private long perPage; // 한 페이지에 보여줄 글의 개수

	private long startRow;

	private long startNum;
	private long lastNum;
	private boolean	isBefore;
	private boolean	isAfter;



	public Pager() {	
		this.perPage=10;	//한 페이지에 보여줄 글의 개수
	}

	public void setCurPage(long curPage) {
		if(curPage==0) {
			this.curPage=1;
		}else {
			this.curPage=curPage;
		}
	}

	public long getCurPage() {
		if(this.curPage==0) {
			this.curPage=1;
		}
		return this.curPage;
	}

	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return this.search;
	}

	public void makeRow() {
		// startRow를 계산하는 메서드
		this.startRow = (this.getCurPage()-1)*perPage;
	}

	public void makePage(long totalCount) {
		// 전체글의 개수 조회 후 가져오기 > 매개변수로 받기 (long totalCount)
		long totalPage = totalCount / this.getPerPage();
		if(totalCount%this.getPerPage() !=0 ) {
			totalPage++;
		}

		// 전체 블럭 수 구하기
		long perBlock = 5;
		long totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0 ) {
			totalBlock++;
		}

		// curPage를 이용해서 curBlock을 구하기
		long curBlock = this.getCurPage() / perBlock;
		if(this.getCurPage() % perBlock !=0) {
			curBlock++;
		}

		// curBlock을 이용해서 startNum, lastNum 구하기
		this.startNum = (curBlock -1)*perBlock +1; // 0이 나올 수 있으므로+1
		this.lastNum = curBlock*perBlock;


		// 6. curBlock(현재블럭)이 마지막블럭(totalBlock) 이라면 lastNum 변경
		if (curBlock == totalBlock) {
			this.lastNum = totalBlock;
		}
		
		if(curBlock > 1) {
			this.isBefore=true;
		}
		
		if(curBlock < totalBlock) {
			this.isAfter=true;
		}

		System.out.println("startNum : " +this.getStartNum());
		System.out.println("lastNum : " +this.getLastNum());
		System.out.println("isBefore : " +this.isBefore);	// getter임 boolean타입은 is
		System.out.println("isAfter : " +this.isAfter);
	
	
	}
}

package com.qst.model;

//分页
public class Page {
	//当前页数
	int currentPage;
	//总记录数
	int sumNumPage;
	//每页限制的条数
	int  limitPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getSumNumPage() {
		return sumNumPage;
	}
	public void setSumNumPage(int sumNumPage) {
		this.sumNumPage = sumNumPage;
	}
	public int getLimitPage() {
		return limitPage;
	}
	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}
	
}

package com.demos.core.web;

import java.util.ArrayList;
import java.util.List;

public class PageInfo {
	private int pageIndex;
	private int pageSize;
	private int recordCount;
	private int pageCount;
	private int showCount;
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.pageCount = recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;		
		this.pageCount = recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1;
	}
	public int getPageCount() {
		return pageCount;
	}	
	
	public Object[] getCurrentPages(){
		int startIndex = (pageIndex-1)%showCount*showCount+1;
		List<Integer> list = new ArrayList<Integer>();		
		for(int i=0;i<showCount;i++){
			if(startIndex+i<pageCount){
				list.add(startIndex+i);
			}
		}
		
		return list.toArray();
	}
	
	public int getShowCount() {
		return showCount;
	}
	
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
}

/**
 * ������PaginationSupport.java
 *
 * ��𣺹�����
 * ���ܣ���ҳ֧��
 * 
 *   Ver     �����               ����            ������        �������
 * ��������������������������������������������������������������������������������������������
 *   V1.00  2010-9-24  CFIT-PM   ��ʤ��         ����
 *
 * Copyright (c) 2010 CFIT-Weifang Company All Rights Reserved.
 */

package com.bip.common.util;

import java.util.List;

public class PaginationSupport {
	public final static int PAGESIZE = UniContant.pageSize;

	private int pageSize = PAGESIZE;// ÿҳ����

	private int totalCount;// �ܼ�¼��

	private List items = null;

	private int startIndex;// ��ʼ��

	private int nextIndex;// ��һҳ��ʼ��
	
	private int previousIndex;// ��һҳ��ʼ��

	private int lastIndex;// ���ҳ��ʼ��

	private int pageCount;// ��ҳ��

	private int currentPage;// ��ǰҳ

	private int prePage;// ��һҳ

	private int nextPage;// ��һҳ

	private Boolean viewPrevious;// ����һҳ

	private Boolean viewNext;// ����һҳ
	
	private String pagefooter = "";
	
	private String pagefooter_T = "";

	public PaginationSupport(int pageSize, int startIndex) {
		setPageSize(pageSize);
		setStartIndex(startIndex);

	}

	public PaginationSupport(List items, int totalCount) {
		setPageSize(PAGESIZE);
		setItems(items);
		setTotalCount(totalCount);
		setStartIndex(0);

	}

	public PaginationSupport(List items, int totalCount, int startIndex) {
		setPageSize(PAGESIZE);
		setItems(items);
		setTotalCount(totalCount);
		setStartIndex(startIndex);

	}

	public PaginationSupport(List items, int totalCount, int pageSize,
			int startIndex) {
		setPageSize(pageSize);
		setItems(items);
		setTotalCount(totalCount);
		setStartIndex(startIndex);
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageCount() {
		// int count = totalCount / pageSize;
		// if (totalCount % pageSize > 0)
		// count++;
		// return count;
		//		
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		return totalPage;
	}

	public int getCurrentPage() {
		return getStartIndex() / pageSize + 1;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getPrePage() {
		if (getCurrentPage() > 1)
			return getCurrentPage() - 1;
		else
			return 1;
	}

	public int getNextPage() {
		if (getCurrentPage() < getPageCount())
			return getCurrentPage() + 1;
		else
			return getPageCount();
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public void setViewPrevious(Boolean viewPrevious) {
		this.viewPrevious = viewPrevious;
	}

	public Boolean getViewPrevious() {
		if (getCurrentPage() == getPrePage()||getPageCount()==0)
			return false;
		else
			return true;
	}

	public void setViewNext(Boolean viewNext) {
		this.viewNext = viewNext;
	}

	public Boolean getViewNext() {
		if (getCurrentPage() == getNextPage()||getNextPage()==0)
			return false;
		else
			return true;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public List getItems() {
		return items;
	}

	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}

	public int getNextIndex() {
		int nextIndex = getStartIndex() + getPageSize();
		if (nextIndex >= getTotalCount())
			return getStartIndex();
		else
			return nextIndex;
	}

	public void setPreviousIndex(int previousIndex) {
		this.previousIndex = previousIndex;
	}

	public int getPreviousIndex() {
		int previousIndex = getStartIndex() - getPageSize();
		if (previousIndex < 0)
			return 0;
		else
			return previousIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getLastIndex() {
		int lastIndex= getPageCount() * getPageSize() + 1;
		if (lastIndex >= getTotalCount())
			return lastIndex-getPageSize();
		else
			return nextIndex;
	}



	public void setPagefooter(String pagefooter) {
		this.pagefooter = pagefooter;
	}

	
	/**
	 * ��ҳ������ ���豻������ĳ��Form֮��
	 * @return String �����ַ���
	 */
	
		
	public String getPagefooter_T() {
		StringBuilder str = new StringBuilder();
		if (this.getViewPrevious()) {
			str.append(
				"<INPUT  type=submit value=��ҳ name=firs onclick=\"this.form.currentPage.value=1\"  >");
		} else {
			str.append("<INPUT   type=submit value=��ҳ name=firs  disabled>");
		}
		if (this.getViewPrevious()) {
			str.append(
				"<INPUT  type=submit value=��ҳ name=prev onclick=\"this.form.currentPage.value='");
			str.append(this.getPreviousIndex()+1);
		  str.append("'\" >");
		} else {
			str.append("<INPUT   type=submit value=��ҳ name=prev  disabled>");
		}
		
		if (this.getPageCount() > 1 && this.getViewNext()) {
			str.append(
				"<INPUT  type=submit value=��ҳ name=next onclick=\"this.form.currentPage.value='");
			 str.append(this.getNextIndex()+1);
			 str.append("'\" >");
		} else {
			str.append("<INPUT   type=submit value=��ҳ name=next  disabled>");
		}
		if (this.getPageCount() > 1 && this.getViewNext()) {
			str.append(
				"<INPUT   type=submit value=ĩҳ name=last onclick=\"this.form.currentPage.value='");
			str.append(this.getPageCount());
			str.append("'\" >");
		} else {
			str.append("<INPUT type=submit value=ĩҳ name=last    disabled>");
		}
		str.append(" ��").append(this.getTotalCount()).append( "����¼");

		str.append("  ÿҳ").append(this.getPageSize());
	
		str.append("�� ��").append( this.getPageCount()).append("ҳ��ʾ ת��");
	
		str.append(
			"<SELECT size=1 name=Pagelist onchange='this.form.currentPage.value=this.value;this.form.submit();this.disabled=true;'>");
		for (int i = 1; i < this.getPageCount()+1 ; i++) {
			if (i ==this.getCurrentPage()) {
				str.append("<OPTION value=" ).append(i).append( " selected>" ).append(i).append("</OPTION>");
			} else {
				str.append("<OPTION value=" ).append((i-1)*this.getPageSize()+1).append(">" ).append(i).append("</OPTION>");
			}
		}
		str.append("</SELECT>ҳ");
		str.append(
			"<INPUT type=hidden  value=").append(this.getCurrentPage()).append(" name=\"currentPage\" id=\"currentPage\"> ");
		str.append(
			"<INPUT type=hidden  value=").append(this.getPageSize()).append(" name=\"pageSize\" id=\"pageSize\"> ");

		return str.toString();
	}


	
	/**
	 * ��ҳ������ ���豻������ĳ��Form֮��
	 * @return String �����ַ���
	 */

	public String getPagefooter() {
		StringBuilder str = new StringBuilder("");
		if(this.getPageCount()>=1){
		
		if(this.getViewPrevious()){
			str.append("<a onclick=\"formlist.currentPage.value=1\"  href=\"javascript:formlist.submit();\">�� ҳ</a>");
			str.append("&nbsp;<a href=\"javascript:formlist.submit();\"  onclick=\"formlist.currentPage.value='").append(this.getCurrentPage()-1).append("'\" >��һҳ</a>");
		}else{
			str.append("�� ҳ  ��һҳ ");
		}
		if(this.getViewNext()){
			str.append("&nbsp;<a    onclick=\"formlist.currentPage.value=").append(this.getCurrentPage()+1).append("\"   href=\"javascript:formlist.submit();\">��һҳ</a> ");
			str.append("&nbsp;<a  onclick=\"formlist.currentPage.value='").append(this.getPageCount()).append("'\"  href=\"javascript:formlist.submit();\">ĩ ҳ</a>");
		}else{
			str.append(" ��һҳ  ĩ ҳ");
		}
		str.append(" ת��");
	
		str.append(
			"<SELECT size=1 name=Pagelist onchange='this.form.currentPage.value=this.value;this.form.submit();this.disabled=true;'>");
		for (int i = 1; i < this.getPageCount()+1 ; i++) {
			if (i ==this.getCurrentPage()) {
				str.append("<OPTION value=" ).append(i).append( " selected>" ).append(i).append("</OPTION>");
			} else {
				str.append("<OPTION value=" ).append(i).append(">" ).append(i).append("</OPTION>");
			}
		}
		str.append("</SELECT>ҳ");
		
		str.append("����<span>").append(this.getCurrentPage()).append(" </span>ҳ , ��<span>");
		str.append(this.getPageCount()).append(" </span>ҳ ����<span>").append(this.getPageSize()).append("</span>��/ҳ , ��<span>").append(this.getTotalCount()).append("</span>����¼��");
		str.append(
		"<INPUT type=hidden  value=").append(this.getCurrentPage()).append(" name=\"currentPage\" id=\"currentPage\"> ");
		}
		return str.toString();

	}

	public void setPagefooter_T(String pagefooter_T) {
		this.pagefooter_T = pagefooter_T;
	}

	
	
	
}

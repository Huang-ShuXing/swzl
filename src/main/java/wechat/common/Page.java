package wechat.common;

import java.util.List;
import java.util.Properties;

import wechat.util.PropertiesUtil;

public class Page<T> {
	
	private static int PAGE_PAGESIZE = 10;
	static{
		String pathUrl = "/page.properties";
		Properties pro = PropertiesUtil.getProperties(pathUrl);
		Page.PAGE_PAGESIZE = Integer.parseInt( pro.get("pageSize").toString());
	}
	
    private int curPage = 1; // 当前页
    private int pageSize = PAGE_PAGESIZE; // 每页多少行
    private int totalRow; // 共多少行
    private int start;// 当前页起始行
    private int end;// 结束行
    private int totalPage; // 共多少页

    private List<T> dateList ;
    
    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        if (curPage < 1) {
            curPage = 1;
        } else {
            start = pageSize * (curPage - 1);
        }
        end = start + pageSize > totalRow ? totalRow : start + pageSize;
        this.curPage = curPage;
    }

    public int getStart() {
        // start=curPage*pageSize;
        return start;
    }

    public int getEnd() {

        return end;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        totalPage = (totalRow + pageSize - 1) / pageSize;
        this.totalRow = totalRow;
        if (totalPage < curPage) {
            curPage = totalPage;
            start = pageSize * (curPage - 1);
            end = totalRow;
        }
        end = start + pageSize > totalRow ? totalRow : start + pageSize;
    }

    public int getTotalPage() {

        return this.totalPage;
    }

	public List<T> getDateList() {
		return dateList;
	}

	public void setDateList(List<T> dateList) {
		this.dateList = dateList;
	}
    
	public static int getStartIndex(Page page){
		return (page.getCurPage()-1)*page.getPageSize();
	}
	

}
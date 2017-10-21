package cn.jzteam.deep.dao.base;


/**
 * 分页查询的基类。
 */
public class PageQuery {

    /**
     * 是否查询记录总数。
     */
    private int queryTotal = PageQueryConst.QUERY_TOTAL_NO;

    /**
     * 是否只获取记录数。0: 会同时获取记录数据；1： 只获取总数，不读取数据。
     */
    private int totalOnly = PageQueryConst.QUERY_TOTAL_ONLY_NO;

    // 当前页码，默认为第一页。
    private int currentPage = 1;

    // 每页记录数，默认20。
    private int pageSize = 20;

    // 希望获取的字段，以逗号分隔。
    private String queryStr;

    // 排序字段。需要包含排序方式。e.g.: " out_nation ASC, in_nation DESC "
    private String orderStr;
    
    // limit起始索引
    private long startIndex = -1;

    public int getQueryTotal() {
        return queryTotal;
    }

    public void setQueryTotal(int queryTotal) {
        this.queryTotal = queryTotal;
    }

    public int getTotalOnly() {
        return totalOnly;
    }

    public void setTotalOnly(int totalOnly) {
        this.totalOnly = totalOnly;
    }

    public int getCurrentPage() {
        return currentPage;
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

    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    /**
     * 返回当前页的初始记录序号。
     *
     * @return
     */
    public long getStartIndex() {
    	// 如果已经设置了startIndex，就使用这个设置的值，如果没有设置，就通过计算
    	if(startIndex != -1){
    		return startIndex;
    	}
    	
        if (this.currentPage <= 1) {
            return 0;
        }
        return (this.currentPage - 1) * this.pageSize;
    }

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

}

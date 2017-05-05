package org.ljy.common;

/**
 * Created by ljy56 on 2017/4/24.
 */
public class Page {
    private int currentPage = 1; // 当前页

    private int pageSize = 15; // 每页显示记录的条数

    private int totalCount; // 总记录条数

    private int totalPageCount; // 总页数

    private int startPos; // 开始位置，从0开始

    public Page() {
    }

    /**
     * 通过构造函数 传入  总记录数  和  当前页
     * @param totalCount 总记录条数
     * @param pageNow 当前页
     */
    public Page(int totalCount, int pageNow) {
        this.totalCount = totalCount;
        this.currentPage = pageNow;
    }

    /**
     * 取得总页数，总页数=总记录数/总页数
     * @return 总页数
     */
    public int getTotalPageCount() {
        totalPageCount = getTotalCount() / getPageSize();
        return (totalCount % pageSize == 0) ? totalPageCount: totalPageCount + 1;
    }

    /**
     * 是否是第一页
     * @return 是第一页则返回true，否则返回false
     */
    private boolean isFirstPage() {
        return currentPage == 1;
    }

    /**
     * 是否有首页
     * @return 有则返回true，否则返回false
     */
    public boolean isHasPre() {
        // 如果有首页就有前一页，因为有首页就不是第一页
        return isFirstPage();
    }
    /**
     * 是否有下一页
     * @return 有则返回true，否则返回false
     */
    public boolean isHasNext() {
        // 如果有尾页就有下一页，因为有尾页表明不是最后一页
        return isHasLast();
    }

    /**
     * 是否有尾页
     * @return 有则返回true，否则返回false
     */
    private boolean isHasLast() {
        return currentPage != getTotalCount();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

}

package software2001.entity;

public class Page {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalCounts;
    private Integer totalPages;
    private Integer startRow;

    public Page(Integer pageIndex) {
        this(pageIndex,5);
    }

    public Page(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.setStartRow((pageIndex-1)*pageSize);
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
        this.setTotalPages(this.totalCounts%this.pageSize==0?this.totalCounts/this.pageSize:this.totalCounts/this.pageSize+1);
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}

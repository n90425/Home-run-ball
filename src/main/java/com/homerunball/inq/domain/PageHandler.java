package com.homerunball.inq.domain;


import com.homerunball.admin.stock.domain.SearchCondition;
import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
   private int totalCnt; // 게시물의 총 갯수
   private int pageSize;
   private int naviSize = 10; // 한 페이지당 게시물 갯수
   private int totalPage;
   private int page;
   private int beginPage;
   private int endPage;
   private boolean showePrev;
   private boolean showNext;


    public PageHandler(int totalCnt, int page) {
        this(totalCnt, page,10);
    }

    public PageHandler(int totalCnt, int page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);
        beginPage = page / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize -1, totalPage);
        showePrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowePrev() {
        return showePrev;
    }

    public void setShowePrev(boolean showePrev) {
        this.showePrev = showePrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    void print(){
        System.out.println("page = " + page);
        System.out.print(showePrev ? "[PREV]" : "");
        for( int i = beginPage; i <= endPage; i++){
            System.out.print(i + " ");
        }
        System.out.println(showNext ? "[NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showePrev=" + showePrev +
                ", showNext=" + showNext +
                '}';
    }
}
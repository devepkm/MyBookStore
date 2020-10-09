package com.devepkm.bean;

import java.util.List;

/**
 * @Auther: dev
 * @Date: 8/10/2020 22:46
 * @Description:
 */
public class Page<T> {


    public static final int PAGE_SIZE = 4;
    private int pageNo;
    private int totalPageNo;
    private int pageSize = PAGE_SIZE;
    private int totalRecord;
    private List<T> records;

    public Page() {
    }

    public Page(int pageNo, int totalPageNo, int pageSize, int totalRecord, List<T> records) {
        this.pageNo = pageNo;
        this.totalPageNo = totalPageNo;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.records = records;
    }

    public int getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(int totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", totalPageNo=" + totalPageNo +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", records=" + records +
                '}';
    }
}

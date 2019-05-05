package javax.core.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象，包含当前页数据及分页信息如总记录数
 * 能够支持Jquery EasyUI直接对接，能够支持和BootStrap Table直接对接
 * @author yekai
 */
public class Page<T> implements Serializable {

    private static final int DEFALT_PAGE_SIZE = 20;

    /**
     * 每页的记录数
     */
    private int pageSize = DEFALT_PAGE_SIZE;

    /**
     * 当前页第一条数据的位置，从0开始
     */
    private long start;

    /**
     * 当前页中存放的记录，类型一般为List
     */
    private List<T> rows;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 默认构造方法
     * @param pageSize 每页条数
     * @param start 起始位置
     * @param rows  本页数据
     * @param total  总条数
     */
    public Page(int pageSize, long start, List<T> rows, long total) {
        this.pageSize = pageSize;
        this.start = start;
        this.rows = rows;
        this.total = total;
    }

    /**
     * 构造方法，只构造空页
     */
    public Page(){
        this(DEFALT_PAGE_SIZE, 0, new ArrayList<T>(),0);
    }

    /**
     * 获取总记录数
     * @return
     */
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 获取总页数
     * @return
     */
    public long getTotalPageCount(){
        //例：total = 101时，total /20 +1  = 6，getTotalPageCount() = 6
        if (total % pageSize == 0){
            return total /pageSize;
        }
        return total /pageSize + 1;
    }

    /**
     * 获取每页条数
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 获取当前页数据
     * @return
     */
    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * 获取该页当前页码，页码从1开始
     * @return
     */
    public long getPageNumber(){
        //例：start = 0时，start / 20 = 0,页码为0+1
        //例：start = 60时，start /20 = 3,页码为3+1
        return start / pageSize +1;
    }

    /**
     * 该页是否有下一页
     * @return
     */
    public boolean hasNextPage(){
        //start = 60，(60-79),getPageNumber() = 4,getTotalPageCount() -1 = 5
        //start = 80，(80-99),getPageNumber() = 5,getTotalPageCount() -1 = 5
        //TODO ? getTotalPageCount()需要-1？？？
        return getPageNumber() < getTotalPageCount();
    }

    /**
     * 该页是否有上一页
     * @return
     */
    public boolean hasPreviousPage(){
        return getPageNumber() > 1;
    }

    /**
     * 获取任一页第一条数据的位置,每页条数使用默认值
     * @param pageNumber
     * @return
     */
    public static int getStartOfPage(int pageNumber){
        return getStartOfPage(pageNumber, DEFALT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据的位置
     * @param pageNumber 从1开始的页码
     * @param pageSize 每页记录数
     * @return
     */
    public static int getStartOfPage(int pageNumber, int pageSize){
        return (pageNumber - 1) * pageSize;
    }


}

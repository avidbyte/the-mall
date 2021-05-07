package com.inst.cloud.mall.common.result;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据封装类
 *
 * @author aaron
 * @since 2020-09-22
 */
public class CommonPage<T> implements Serializable {
    private static final long serialVersionUID = 7221714582894207634L;
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;


    /**
     * mybatis plus page 分页
     *
     * @param pageInfo 对象
     * @param <T>      泛型
     * @return <T>
     */
    public static <T> CommonPage<T> restPage(com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage((int) pageInfo.getPages());
        result.setPageNum((int) pageInfo.getCurrent());
        result.setPageSize((int) pageInfo.getSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getRecords());
        return result;
    }

    /**
     * 将PageHelper分页后的list转为分页信息
     * @param list 数据
     * @param <T> 泛型
     * @return <T>
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }


    /**
     * 将SpringData分页后的list转为分页信息
     * @param pageInfo 分页参数
     * @param <T> 泛型
     * @return <T>
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
        return result;
    }

    /**
     * 将es中查询的数据List转为分页信息
     * @param list
     * @param totalCount
     * @param pageNum
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restEsPage(List<T> list, long totalCount, Integer pageNum, Integer pageSize) {
        CommonPage<T> result = new CommonPage<T>();
        if (totalCount % pageSize > 0) {
            result.setTotalPage((int) (totalCount / pageSize) + 1);
        } else {
            result.setTotalPage((int) (totalCount / pageSize));
        }
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotal(totalCount);
        result.setList(list);
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

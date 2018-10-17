package com.flf.entity.policyManagement;

import com.flf.entity.Page;

/**
 * @ClassName: RegionalDataMaintenance
 * @Description: //TODO  区域数据维护管理的实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/7 9:41
 * @Version: 1.0
 */
public class RegionalDataMaintenance {
    private Integer id;//主键序号
    private String name;//区域名称
    private Integer sorting;//排序值
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }
}

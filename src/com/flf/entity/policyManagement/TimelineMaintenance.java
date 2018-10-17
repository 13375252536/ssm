package com.flf.entity.policyManagement;

import com.flf.entity.Page;

/**
 * @ClassName: TimelineMaintenance
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/17 11:55
 * @Version: 1.0
 */
public class TimelineMaintenance {
    private Integer id;
    private String name;
    private Page page;

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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "TimelineMaintenance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}

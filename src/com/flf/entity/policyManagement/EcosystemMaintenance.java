package com.flf.entity.policyManagement;

import com.flf.entity.Page;

/**
 * @ClassName: EcosystemMaintenance
 * @Description: //TODO  生态圈维护信息的实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/17 10:28
 * @Version: 1.0
 */
public class EcosystemMaintenance {
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
        return "EcosystemMaintenance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}

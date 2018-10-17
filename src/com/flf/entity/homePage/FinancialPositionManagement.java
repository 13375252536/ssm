package com.flf.entity.homePage;

import com.flf.entity.Page;

/**
 * @ClassName: FinancialPositionManagement
 * @Description: //TODO  金融宣传位管理的实体类
 * @Author: Mr.Chan
 * @Data: 2018/8/31 16:07
 * @Version: 1.0
 */
public class FinancialPositionManagement {
    private Integer id;//主键序号
    private String name;//名称
    private String link;//链接
    private String describe;//描述
    private Integer sorting;//排序
    private String type;//类别
    private String placedTop;//置顶
    private Page page;//页数

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlacedTop() {
        return placedTop;
    }

    public void setPlacedTop(String placedTop) {
        this.placedTop = placedTop;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "FinancialPositionManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", describe='" + describe + '\'' +
                ", sorting=" + sorting +
                ", type='" + type + '\'' +
                ", placedTop='" + placedTop + '\'' +
                ", page=" + page +
                '}';
    }
}

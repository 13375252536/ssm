package com.flf.entity.policyManagement;

import com.flf.entity.Page;

/**
 * @ClassName: IndustrialParkRecommendation
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/17 16:31
 * @Version: 1.0
 */
public class IndustrialParkRecommendation {
    private Integer id;
    private String name;
    private Integer sorting;
    private Integer placedTop;
    private String fileURL;
    private String link;
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

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    public Integer getPlacedTop() {
        return placedTop;
    }

    public void setPlacedTop(Integer placedTop) {
        this.placedTop = placedTop;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

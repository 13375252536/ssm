package com.flf.entity.homePage;

import com.flf.entity.Page;

/**
 * @ClassName: SiteInstitutionManagement
 * @Description: //TODO  技术机构管理信息的实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/5 11:16
 * @Version: 1.0
 */
public class TechnicalInstitutionManagement {
    private Integer id;//主键序号
    private String name;//名称
    private String link;//链接
    private String fileURL;//路径
    private Integer sorting;//排序
    private String type;//类别
    private Integer placedTop;//置顶
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

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
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

    public Integer getPlacedTop() {
        return placedTop;
    }

    public void setPlacedTop(Integer placedTop) {
        this.placedTop = placedTop;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

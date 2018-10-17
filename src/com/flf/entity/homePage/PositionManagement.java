package com.flf.entity.homePage;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: PositionManagement
 * @Description: //TODO  首页宣传位管理的实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/5 16:54
 * @Version: 1.0
 */
public class PositionManagement {
    private Integer id;//主键序号
    private String name;//名称
    private String link;//链接
    private String fileURL;//路径
    private String releasePeople;//发布人
    private Date releaseTime;//发布时间
    private String modifier;//更新人
    private Date modifyTime;//更新时间
    private Integer sorting;//排序
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

    public String getReleasePeople() {
        return releasePeople;
    }

    public void setReleasePeople(String releasePeople) {
        this.releasePeople = releasePeople;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

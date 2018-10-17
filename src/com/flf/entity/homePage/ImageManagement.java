package com.flf.entity.homePage;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: ImageManagement
 * @Description: //TODO  banner图片管理的实体类
 * @Author: Mr.Chan
 * @Data: 2018/8/29 9:21
 * @Version: 1.0
 */
public class ImageManagement {
    private Integer id;//主键序号
    private String name;//名称
    private String type;//类型
    private String link;//链接
    private String releasePeople;//发布人
    private Date releaseTime;//发布时间
    private String modifier;//修改人
    private Date modifyTime;//修改时间
    private String sorting;//排序
    private Integer placedTop;//置顶
    private Page page;//页数
    private String fileURL;//上传图片的url地址
    private Integer pageViews;//页面浏览量

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getReleasePeople() {
        return releasePeople;
    }

    public void setReleasePeople(String releasePeople) {
        this.releasePeople = releasePeople;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
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

    @Override
    public String toString() {
        return "ImageManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", link='" + link + '\'' +
                ", releasePeople='" + releasePeople + '\'' +
                ", releaseTime=" + releaseTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", sorting='" + sorting + '\'' +
                ", placedTop=" + placedTop +
                ", page=" + page +
                ", fileURL='" + fileURL + '\'' +
                '}';
    }
}

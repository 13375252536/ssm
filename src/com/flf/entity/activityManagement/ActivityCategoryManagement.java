package com.flf.entity.activityManagement;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: ActivityCategoryManagement
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/13 11:57
 * @Version: 1.0
 */
public class ActivityCategoryManagement {
    private Integer id;
    private String name;
    private String type;
    private String introduction;
    private String reportPeople;
    private Date reportTime;
    private String modifier;
    private Date modifyTime;
    private Integer initiateMode;
    private Integer area;
    private String areaName;
    private String link;
    private String activityPhotosURL;
    private String bannerPhotosURL;
    private Integer pageViews;
    private Page page;
    private String source;
    private Integer pageSize;
    private Integer start;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getReportPeople() {
        return reportPeople;
    }

    public void setReportPeople(String reportPeople) {
        this.reportPeople = reportPeople;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
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

    public Integer getInitiateMode() {
        return initiateMode;
    }

    public void setInitiateMode(Integer initiateMode) {
        this.initiateMode = initiateMode;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getActivityPhotosURL() {
        return activityPhotosURL;
    }

    public void setActivityPhotosURL(String activityPhotosURL) {
        this.activityPhotosURL = activityPhotosURL;
    }

    public String getBannerPhotosURL() {
        return bannerPhotosURL;
    }

    public void setBannerPhotosURL(String bannerPhotosURL) {
        this.bannerPhotosURL = bannerPhotosURL;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ActivityCategoryManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", introduction='" + introduction + '\'' +
                ", reportPeople='" + reportPeople + '\'' +
                ", reportTime=" + reportTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", initiateMode=" + initiateMode +
                ", area=" + area +
                ", areaName='" + areaName + '\'' +
                ", link='" + link + '\'' +
                ", activityPhotosURL='" + activityPhotosURL + '\'' +
                ", bannerPhotosURL='" + bannerPhotosURL + '\'' +
                ", pageViews=" + pageViews +
                ", page=" + page +
                ", source='" + source + '\'' +
                '}';
    }
}

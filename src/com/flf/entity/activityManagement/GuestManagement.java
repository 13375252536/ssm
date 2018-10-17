package com.flf.entity.activityManagement;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: GuestManagement
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/13 16:53
 * @Version: 1.0
 */
public class GuestManagement {
    private Integer id;
    private String name;
    private Integer activityCategory;
    private String reportPeople;
    private Date reportDate;
    private Date releaseTime;
    private String modifier;
    private Date modifyTime;
    private Integer sorting;
    private Integer placedTop;
    private Integer reportMarks;
    private String fileURL;
    private Page page;
    private String activityCategoryName;

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

    public Integer getActivityCategory() {
        return activityCategory;
    }

    public void setActivityCategory(Integer activityCategory) {
        this.activityCategory = activityCategory;
    }

    public String getReportPeople() {
        return reportPeople;
    }

    public void setReportPeople(String reportPeople) {
        this.reportPeople = reportPeople;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
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

    public Integer getReportMarks() {
        return reportMarks;
    }

    public void setReportMarks(Integer reportMarks) {
        this.reportMarks = reportMarks;
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

    public String getActivityCategoryName() {
        return activityCategoryName;
    }

    public void setActivityCategoryName(String activityCategoryName) {
        this.activityCategoryName = activityCategoryName;
    }

    @Override
    public String toString() {
        return "GuestManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activityCategory=" + activityCategory +
                ", reportPeople='" + reportPeople + '\'' +
                ", reportDate=" + reportDate +
                ", releaseTime=" + releaseTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", sorting=" + sorting +
                ", placedTop=" + placedTop +
                ", reportMarks=" + reportMarks +
                ", fileURL='" + fileURL + '\'' +
                ", page=" + page +
                ", activityCategoryName='" + activityCategoryName + '\'' +
                '}';
    }
}

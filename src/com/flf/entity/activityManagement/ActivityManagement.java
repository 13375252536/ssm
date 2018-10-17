package com.flf.entity.activityManagement;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: ActivityManagement
 * @Description: //TODO  活动管理信息实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/11 10:51
 * @Version: 1.0
 */
public class ActivityManagement {
    private Integer id;
    private String name;
    private String type;
    private Integer area;
    private String introduction;
    private Integer reportUnit;
    private Date reportDate;
    private String source;
    private Date releaseTime;
    private String modifier;
    private Date modifyTime;
    private Integer sorting;
    private Integer placedTop;
    private Integer reportMarks;
    private String fileURL;
    private String content;
    private String reportPeople;
    private String areaName;
    private String reportUnitName;
    private Page page;


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getReportUnitName() {
        return reportUnitName;
    }

    public void setReportUnitName(String reportUnitName) {
        this.reportUnitName = reportUnitName;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(Integer reportUnit) {
        this.reportUnit = reportUnit;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReportPeople() {
        return reportPeople;
    }

    public void setReportPeople(String reportPeople) {
        this.reportPeople = reportPeople;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ActivityManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", area=" + area +
                ", introduction='" + introduction + '\'' +
                ", reportUnit=" + reportUnit +
                ", reportDate=" + reportDate +
                ", source='" + source + '\'' +
                ", releaseTime=" + releaseTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", sorting=" + sorting +
                ", placedTop=" + placedTop +
                ", reportMarks=" + reportMarks +
                ", fileURL='" + fileURL + '\'' +
                ", content='" + content + '\'' +
                ", reportPeople='" + reportPeople + '\'' +
                ", page=" + page +
                '}';
    }
}

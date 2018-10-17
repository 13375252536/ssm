package com.flf.entity.importantEmergingIndustries;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: EmergingIndustryManagement
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/14 17:22
 * @Version: 1.0
 */
public class EmergingIndustryManagement {
    private Integer id;
    private String name;
    private String introduction;
    private Date reportDate;
    private Date releaseTime;
    private Date modifyTime;
    private Integer sorting;
    private Integer placedTop;
    private Integer reportMarks;
    private String source;
    private String content;
    private String type;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "EmergingIndustryManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", reportDate=" + reportDate +
                ", releaseTime=" + releaseTime +
                ", modifyTime=" + modifyTime +
                ", sorting=" + sorting +
                ", placedTop=" + placedTop +
                ", reportMarks=" + reportMarks +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", page=" + page +
                '}';
    }
}

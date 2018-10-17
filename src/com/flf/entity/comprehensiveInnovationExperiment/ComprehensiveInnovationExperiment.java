package com.flf.entity.comprehensiveInnovationExperiment;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: LocalReports
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/14 11:13
 * @Version: 1.0
 */
public class ComprehensiveInnovationExperiment {
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
    private Integer type;
    private Page page;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "LocalReports{" +
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
                ", page=" + page +
                '}';
    }
}

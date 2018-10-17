package com.flf.entity.serviceDevelopment;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: GuideManagement
 * @Description: //TODO  服务拓展实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/23 19:39
 * @Version: 1.0
 */
public class GuideManagement {
    private Page page;
    private Integer id;
    private String name;
    private String introduction;
    private String source;
    private Integer type;
    private Date reportDate;
    private Date releaseTime;
    private String releasePeople;
    private Date modifyTime;
    private String modifier;
    private Integer reportMarks;
    private String content;

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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getReleasePeople() {
        return releasePeople;
    }

    public void setReleasePeople(String releasePeople) {
        this.releasePeople = releasePeople;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Integer getReportMarks() {
        return reportMarks;
    }

    public void setReportMarks(Integer reportMarks) {
        this.reportMarks = reportMarks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "GuideManagement{" +
                "page=" + page +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", source='" + source + '\'' +
                ", type=" + type +
                ", reportDate=" + reportDate +
                ", releaseTime=" + releaseTime +
                ", releasePeople='" + releasePeople + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifier='" + modifier + '\'' +
                ", reportMarks=" + reportMarks +
                ", content='" + content + '\'' +
                '}';
    }
}

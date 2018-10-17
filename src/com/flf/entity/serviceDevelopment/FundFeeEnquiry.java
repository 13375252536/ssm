package com.flf.entity.serviceDevelopment;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: FundFeeEnquiry
 * @Description: //TODO  政府性基金和行政事业型收费查询实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/25 10:41
 * @Version: 1.0
 */
public class FundFeeEnquiry {
    private Integer id;
    private String name;
    private Integer type;
    private String reportPeople;
    private Date reportTime;
    private String modifier;
    private Date modifyTime;
    private Integer reportMarks;
    private Page page;
    private String fileURL;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getReportMarks() {
        return reportMarks;
    }

    public void setReportMarks(Integer reportMarks) {
        this.reportMarks = reportMarks;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    @Override
    public String toString() {
        return "FundFeeEnquiry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", reportPeople='" + reportPeople + '\'' +
                ", reportTime=" + reportTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", reportMarks=" + reportMarks +
                ", page=" + page +
                ", fileURL='" + fileURL + '\'' +
                '}';
    }
}

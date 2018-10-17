package com.flf.entity.serviceDevelopment;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: TaxPreferenceEnquiry
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/25 13:19
 * @Version: 1.0
 */
public class TaxPreferenceEnquiry {
    private String name;
    private Integer id;
    private Integer phase;
    private Integer type;
    private String firstTitle;
    private String firstContent;
    private String secondTitle;
    private String secondContent;
    private String thirdTitle;
    private String thirdContent;
    private String fourthTitle;
    private String fourthContent;
    private String fifthTitle;
    private String fifthContent;
    private Page page;
    private String reportPeople;
    private Date reportTime;
    private String modifier;
    private Date modifyTime;
    private Integer reportMarks;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    public String getFirstContent() {
        return firstContent;
    }

    public void setFirstContent(String firstContent) {
        this.firstContent = firstContent;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public String getSecondContent() {
        return secondContent;
    }

    public void setSecondContent(String secondContent) {
        this.secondContent = secondContent;
    }

    public String getThirdTitle() {
        return thirdTitle;
    }

    public void setThirdTitle(String thirdTitle) {
        this.thirdTitle = thirdTitle;
    }

    public String getThirdContent() {
        return thirdContent;
    }

    public void setThirdContent(String thirdContent) {
        this.thirdContent = thirdContent;
    }

    public String getFourthTitle() {
        return fourthTitle;
    }

    public void setFourthTitle(String fourthTitle) {
        this.fourthTitle = fourthTitle;
    }

    public String getFourthContent() {
        return fourthContent;
    }

    public void setFourthContent(String fourthContent) {
        this.fourthContent = fourthContent;
    }

    public String getFifthTitle() {
        return fifthTitle;
    }

    public void setFifthTitle(String fifthTitle) {
        this.fifthTitle = fifthTitle;
    }

    public String getFifthContent() {
        return fifthContent;
    }

    public void setFifthContent(String fifthContent) {
        this.fifthContent = fifthContent;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "TaxPreferenceEnquiry{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", phase=" + phase +
                ", type=" + type +
                ", firstTitle='" + firstTitle + '\'' +
                ", firstContent='" + firstContent + '\'' +
                ", secondTitle='" + secondTitle + '\'' +
                ", secondContent='" + secondContent + '\'' +
                ", thirdTitle='" + thirdTitle + '\'' +
                ", thirdContent='" + thirdContent + '\'' +
                ", fourthTitle='" + fourthTitle + '\'' +
                ", fourthContent='" + fourthContent + '\'' +
                ", fifthTitle='" + fifthTitle + '\'' +
                ", fifthContent='" + fifthContent + '\'' +
                ", page=" + page +
                ", reportPeople='" + reportPeople + '\'' +
                ", reportTime=" + reportTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", reportMarks=" + reportMarks +
                '}';
    }
}


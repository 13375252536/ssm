package com.flf.entity.policyManagement;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: PolicyIssued
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/26 18:59
 * @Version: 1.0
 */
public class PolicyIssued {
    private Integer id;
    private String name;//标题
    private String postShopName;//发文字号
    private String reportUnit;//发布机构
    private String reportPeople;//发布人
    private Date reportDate;//发布日期
    private Date modifyTime;//更新时间
    private String policyTheme;//政策主题
    private String ecosphereKeyword;//生态圈关键字
    private String timelinePhase;//时间轴阶段
    private  Integer policyIs;//政策隶属
    private String region;//区域
    private String businessPeople;//创业人员
    private String innovationService;//创业服务
    private String industry;//产业
    private Integer sorting;//排序
    private Integer placedTop;//置顶
    private Integer reportMarks;//发布标识
    private String content;//政策内容
    private String fileURL;//附件路径地址
    private String policyIntroduction;//政策简介
    private String interviewVideoFileURL;//访谈视频地址
    private String interviewGuest;//访谈嘉宾
    private Date interviewDate;//访谈日期
    private String interviewIntroduction;//访谈简介
    private Integer pageView;//页面访问量
    private String policyClassification;//政策分类
    private Page page;
    private Date reportDateStart;
    private Date reportDateEnd;
    private Integer start;
    private Integer pageSize;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPolicyClassification() {
        return policyClassification;
    }

    public void setPolicyClassification(String policyClassification) {
        this.policyClassification = policyClassification;
    }

    public Date getReportDateEnd() {
        return reportDateEnd;
    }

    public void setReportDateEnd(Date reportDateEnd) {
        this.reportDateEnd = reportDateEnd;
    }

    public Date getReportDateStart() {
        return reportDateStart;
    }

    public void setReportDateStart(Date reportDateStart) {
        this.reportDateStart = reportDateStart;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
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

    public String getPostShopName() {
        return postShopName;
    }

    public void setPostShopName(String postShopName) {
        this.postShopName = postShopName;
    }

    public String getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(String reportUnit) {
        this.reportUnit = reportUnit;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPolicyTheme() {
        return policyTheme;
    }

    public void setPolicyTheme(String policyTheme) {
        this.policyTheme = policyTheme;
    }

    public String getEcosphereKeyword() {
        return ecosphereKeyword;
    }

    public void setEcosphereKeyword(String ecosphereKeyword) {
        this.ecosphereKeyword = ecosphereKeyword;
    }

    public String getTimelinePhase() {
        return timelinePhase;
    }

    public void setTimelinePhase(String timelinePhase) {
        this.timelinePhase = timelinePhase;
    }

    public Integer getPolicyIs() {
        return policyIs;
    }

    public void setPolicyIs(Integer policyIs) {
        this.policyIs = policyIs;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBusinessPeople() {
        return businessPeople;
    }

    public void setBusinessPeople(String businessPeople) {
        this.businessPeople = businessPeople;
    }


    public String getInnovationService() {
        return innovationService;
    }

    public void setInnovationService(String innovationService) {
        this.innovationService = innovationService;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getPolicyIntroduction() {
        return policyIntroduction;
    }

    public void setPolicyIntroduction(String policyIntroduction) {
        this.policyIntroduction = policyIntroduction;
    }

    public String getInterviewVideoFileURL() {
        return interviewVideoFileURL;
    }

    public void setInterviewVideoFileURL(String interviewVideoFileURL) {
        this.interviewVideoFileURL = interviewVideoFileURL;
    }

    public String getInterviewGuest() {
        return interviewGuest;
    }

    public void setInterviewGuest(String interviewGuest) {
        this.interviewGuest = interviewGuest;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewIntroduction() {
        return interviewIntroduction;
    }

    public void setInterviewIntroduction(String interviewIntroduction) {
        this.interviewIntroduction = interviewIntroduction;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PolicyIssued{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postShopName='" + postShopName + '\'' +
                ", reportUnit='" + reportUnit + '\'' +
                ", reportPeople='" + reportPeople + '\'' +
                ", reportDate=" + reportDate +
                ", modifyTime=" + modifyTime +
                ", policyTheme='" + policyTheme + '\'' +
                ", ecosphereKeyword='" + ecosphereKeyword + '\'' +
                ", timelinePhase='" + timelinePhase + '\'' +
                ", policyIs=" + policyIs +
                ", region='" + region + '\'' +
                ", businessPeople='" + businessPeople + '\'' +
                ", innovationService='" + innovationService + '\'' +
                ", industry='" + industry + '\'' +
                ", sorting=" + sorting +
                ", placedTop=" + placedTop +
                ", reportMarks=" + reportMarks +
                ", content='" + content + '\'' +
                ", fileURL='" + fileURL + '\'' +
                ", policyIntroduction='" + policyIntroduction + '\'' +
                ", interviewVideoFileURL='" + interviewVideoFileURL + '\'' +
                ", interviewGuest='" + interviewGuest + '\'' +
                ", interviewDate=" + interviewDate +
                ", interviewIntroduction='" + interviewIntroduction + '\'' +
                ", pageView=" + pageView +
                ", policyClassification='" + policyClassification + '\'' +
                ", page=" + page +
                ", reportDateStart=" + reportDateStart +
                ", reportDateEnd=" + reportDateEnd +
                '}';
    }
}

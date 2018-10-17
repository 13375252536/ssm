package com.flf.entity.homePage;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: DynamicManagement
 * @Description: //TODO  动态管理的实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/5 16:59
 * @Version: 1.0
 */
public class DynamicManagement {
    private Integer id;//主键序号
    private String name;//名称
    private String introduction;//简介
    private Integer releaseUnit;//发布单位
    private Date reportDate;//发布日期
    private Date releaseTime;//创建时间
    private Integer sorting;//排序
    private Integer releaseMarks;//发布标识
    private Integer placedTop;//置顶
    private String leadershipTag;//领导标记
    private String fileURL;//图片路径
    private String content;//正文内容
    private Date reportTime;//发布时间
    private String source;//来源
    private String dynamicClassification;//动态分类
    private Integer base;//所属基地
    private Integer region;//所属地区
    private String socialGroups;//所属社会团体
    private Date releaseTimeStart;
    private Date releaseTimeEnd;
    private String baseName;
    private String regionName;
    private String releaseUnitName;
    private Page page;
    private String date;
    private Integer pageViews;
    private String baseBatch;
    private String baseType;
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

    public String getBaseBatch() {
        return baseBatch;
    }

    public void setBaseBatch(String baseBatch) {
        this.baseBatch = baseBatch;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getReleaseUnitName() {
        return releaseUnitName;
    }

    public void setReleaseUnitName(String releaseUnitName) {
        this.releaseUnitName = releaseUnitName;
    }

    public Date getReleaseTimeStart() {
        return releaseTimeStart;
    }

    public void setReleaseTimeStart(Date releaseTimeStart) {
        this.releaseTimeStart = releaseTimeStart;
    }

    public Date getReleaseTimeEnd() {
        return releaseTimeEnd;
    }

    public void setReleaseTimeEnd(Date releaseTimeEnd) {
        this.releaseTimeEnd = releaseTimeEnd;
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


    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    public Integer getReleaseMarks() {
        return releaseMarks;
    }

    public void setReleaseMarks(Integer releaseMarks) {
        this.releaseMarks = releaseMarks;
    }

    public Integer getPlacedTop() {
        return placedTop;
    }

    public void setPlacedTop(Integer placedTop) {
        this.placedTop = placedTop;
    }

    public String getLeadershipTag() {
        return leadershipTag;
    }

    public void setLeadershipTag(String leadershipTag) {
        this.leadershipTag = leadershipTag;
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

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDynamicClassification() {
        return dynamicClassification;
    }

    public void setDynamicClassification(String dynamicClassification) {
        this.dynamicClassification = dynamicClassification;
    }

    public Integer getReleaseUnit() {
        return releaseUnit;
    }

    public void setReleaseUnit(Integer releaseUnit) {
        this.releaseUnit = releaseUnit;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getSocialGroups() {
        return socialGroups;
    }

    public void setSocialGroups(String socialGroups) {
        this.socialGroups = socialGroups;
    }

    @Override
    public String toString() {
        return "DynamicManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", releaseUnit=" + releaseUnit +
                ", reportDate=" + reportDate +
                ", releaseTime=" + releaseTime +
                ", sorting=" + sorting +
                ", releaseMarks=" + releaseMarks +
                ", placedTop=" + placedTop +
                ", leadershipTag='" + leadershipTag + '\'' +
                ", fileURL='" + fileURL + '\'' +
                ", content='" + content + '\'' +
                ", reportTime=" + reportTime +
                ", source='" + source + '\'' +
                ", dynamicClassification='" + dynamicClassification + '\'' +
                ", base=" + base +
                ", region=" + region +
                ", socialGroups='" + socialGroups + '\'' +
                ", releaseTimeStart=" + releaseTimeStart +
                ", releaseTimeEnd=" + releaseTimeEnd +
                ", baseName='" + baseName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", releaseUnitName='" + releaseUnitName + '\'' +
                ", page=" + page +
                ", date='" + date + '\'' +
                ", pageViews=" + pageViews +
                ", baseBatch='" + baseBatch + '\'' +
                ", baseType='" + baseType + '\'' +
                '}';
    }
}

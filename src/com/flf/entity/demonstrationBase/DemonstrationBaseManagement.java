package com.flf.entity.demonstrationBase;

import com.flf.entity.Page;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: DemonstrationBaseManagement
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/18 9:58
 * @Version: 1.0
 */
public class DemonstrationBaseManagement {
    private Integer id;
    private String name;
    private String type;
    private String batch;
    private Integer area;
    private Integer reportUnit;
    private String releasePeople;
    private Date releaseTime;
    private String modifier;
    private Date modifyTime;
    private Integer sorting;
    private Integer placedTop;
    private String fileURL;
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
    private String sixthTitle;
    private String sixthContent;
    private String seventhTitle;
    private String seventhContent;
    private String eighthTitle;
    private String ninthTitle;
    private String areaName;
    private String reportUnitName;
    private Page page;
    private Integer pageSize;
    private Integer start;
    private List<Integer> baseIds;

    public List<Integer> getBaseIds() {
        return baseIds;
    }

    public void setBaseIds(List<Integer> baseIds) {
        this.baseIds = baseIds;
    }

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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getReleasePeople() {
        return releasePeople;
    }

    public void setReleasePeople(String releasePeople) {
        this.releasePeople = releasePeople;
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

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
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

    public String getSixthTitle() {
        return sixthTitle;
    }

    public void setSixthTitle(String sixthTitle) {
        this.sixthTitle = sixthTitle;
    }

    public String getSixthContent() {
        return sixthContent;
    }

    public void setSixthContent(String sixthContent) {
        this.sixthContent = sixthContent;
    }

    public String getSeventhTitle() {
        return seventhTitle;
    }

    public void setSeventhTitle(String seventhTitle) {
        this.seventhTitle = seventhTitle;
    }

    public String getSeventhContent() {
        return seventhContent;
    }

    public void setSeventhContent(String seventhContent) {
        this.seventhContent = seventhContent;
    }

    public String getEighthTitle() {
        return eighthTitle;
    }

    public void setEighthTitle(String eighthTitle) {
        this.eighthTitle = eighthTitle;
    }

    public String getNinthTitle() {
        return ninthTitle;
    }

    public void setNinthTitle(String ninthTitle) {
        this.ninthTitle = ninthTitle;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(Integer reportUnit) {
        this.reportUnit = reportUnit;
    }

    public String getReportUnitName() {
        return reportUnitName;
    }

    public void setReportUnitName(String reportUnitName) {
        this.reportUnitName = reportUnitName;
    }

    @Override
    public String toString() {
        return "DemonstrationBaseManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", batch='" + batch + '\'' +
                ", area=" + area +
                ", reportUnit=" + reportUnit +
                ", releasePeople='" + releasePeople + '\'' +
                ", releaseTime=" + releaseTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", sorting=" + sorting +
                ", placedTop=" + placedTop +
                ", fileURL='" + fileURL + '\'' +
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
                ", sixthTitle='" + sixthTitle + '\'' +
                ", sixthContent='" + sixthContent + '\'' +
                ", seventhTitle='" + seventhTitle + '\'' +
                ", seventhContent='" + seventhContent + '\'' +
                ", eighthTitle='" + eighthTitle + '\'' +
                ", ninthTitle='" + ninthTitle + '\'' +
                ", areaName='" + areaName + '\'' +
                ", reportUnitName='" + reportUnitName + '\'' +
                ", page=" + page +
                '}';
    }
}

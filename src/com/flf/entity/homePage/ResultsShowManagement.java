package com.flf.entity.homePage;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: ResultsShowManagement
 * @Description: //TODO  成果展示管理的实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/5 17:12
 * @Version: 1.0
 */
public class ResultsShowManagement {
    private Integer id;//主键序号
    private String name;//名称
    private Date reportTime;//发布时间
    private Date releaseTime;//插入时间
    private Integer sorting;//排序
    private Integer releaseMarks;//发布标识
    private Integer placedTop;//置顶
    private String content;//正文内容
    private Page page;//页数
    private String releaseMarksId;//发布标识转换为integer类型的中间变量
    private String placedTopId;//置顶转换为integer类型的中间变量

    public String getReleaseMarksId() {
        return releaseMarksId;
    }

    public void setReleaseMarksId(String releaseMarksId) {
        this.releaseMarksId = releaseMarksId;
    }

    public String getPlacedTopId() {
        return placedTopId;
    }

    public void setPlacedTopId(String placedTopId) {
        this.placedTopId = placedTopId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ResultsShowManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reportTime=" + reportTime +
                ", releaseTime=" + releaseTime +
                ", sorting=" + sorting +
                ", releaseMarks=" + releaseMarks +
                ", placedTop=" + placedTop +
                ", content='" + content + '\'' +
                ", page=" + page +
                ", releaseMarksId='" + releaseMarksId + '\'' +
                ", placedTopId='" + placedTopId + '\'' +
                '}';
    }
}

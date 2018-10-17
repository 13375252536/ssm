package com.flf.entity.homePage;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: entrepreneurshipGroupMaintenance
 * @Description: //TODO  创业群体维护的实体类
 * @Author: Mr.Chan
 * @Data: 2018/8/30 15:28
 * @Version: 1.0
 */
public class EntrepreneurshipGroupMaintenance {
    private Integer id;//主键序号
    private String name;//创业群体名称
    private String releasePeople;//添加人
    private Date releaseTime;//添加时间
    private String modifier;//修改人
    private Date modifyTime;//修改时间
    private Integer sorting;//排序
    private Integer placedTop;//置顶
    private String fileURL;//创业群体维护文件url地址
    private Page page;//页数

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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "entrepreneurshipGroupMaintenance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releasePeople='" + releasePeople + '\'' +
                ", releaseTime=" + releaseTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", sorting=" + sorting +
                ", placedTop=" + placedTop +
                ", fileURL='" + fileURL + '\'' +
                ", page=" + page +
                '}';
    }
}

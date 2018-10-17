package com.flf.entity.advisesManagement;

import com.flf.entity.Page;

import java.util.Date;

/**
 * @ClassName: MakeRecommendations
 * @Description: //TODO  建言献策实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/22 17:24
 * @Version: 1.0
 */
public class MakeRecommendations {

    private Page page;//页数
    private Integer id;//主键序号
    private String name;//姓名
    private String unit;//单位
    private String telNum;//电话号码
    private String email;//邮箱号
    private String title;//标题
    private Date time;//提交时间
    private Integer state;//状态
    private String content;//内容

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MakeRecommendations{" +
                "page=" + page +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", telNum='" + telNum + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

package com.flf.entity;

/**
 * @ClassName: Student
 * @Description: //TODO  学生管理系统的实体类
 * @Author: Mr.Chan
 * @Data: 2018/8/22 14:45
 * @Version: 1.0
 */
public class Student {
    private Integer id;//学生表数据库序号
    private String sno;//学生学号
    private String portrait;//学生照片的相对路径地址
    private String name;//学生姓名
    private Integer age;//学生年龄
    private String gender;//学生性别
    private String grade;//学生年级
    private String idNum;//学生身份证号
    private Page page;//页数


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Page getPage() {
        if(page==null)
            page = new Page();
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", portrait='" + portrait + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", idNum='" + idNum + '\'' +
                '}';
    }
}

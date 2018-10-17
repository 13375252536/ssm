package com.flf.entity;

/**
 * @ClassName: OrganizationManagement
 * @Description: //TODO  机构管理的实体类
 * @Author: Mr.Chan
 * @Data: 2018/9/7 15:06
 * @Version: 1.0
 */
public class OrganizationManagement {
    private Integer id;
    private String organizationNum;
    private String contactNum;
    private String organizationName;
    private String organizationAbbreviation;
    private String organizationAdderess;
    private String organizationEmail;
    private String organizationWebsite;
    private String organizationDescriptions;
    private String superiorOrganizationName;
    private Page page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(String organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAbbreviation() {
        return organizationAbbreviation;
    }

    public void setOrganizationAbbreviation(String organizationAbbreviation) {
        this.organizationAbbreviation = organizationAbbreviation;
    }

    public String getOrganizationAdderess() {
        return organizationAdderess;
    }

    public void setOrganizationAdderess(String organizationAdderess) {
        this.organizationAdderess = organizationAdderess;
    }

    public String getOrganizationEmail() {
        return organizationEmail;
    }

    public void setOrganizationEmail(String organizationEmail) {
        this.organizationEmail = organizationEmail;
    }

    public String getOrganizationWebsite() {
        return organizationWebsite;
    }

    public void setOrganizationWebsite(String organizationWebsite) {
        this.organizationWebsite = organizationWebsite;
    }

    public String getOrganizationDescriptions() {
        return organizationDescriptions;
    }

    public void setOrganizationDescriptions(String organizationDescriptions) {
        this.organizationDescriptions = organizationDescriptions;
    }

    public String getSuperiorOrganizationName() {
        return superiorOrganizationName;
    }

    public void setSuperiorOrganizationName(String superiorOrganizationName) {
        this.superiorOrganizationName = superiorOrganizationName;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

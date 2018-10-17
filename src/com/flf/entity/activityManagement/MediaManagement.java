package com.flf.entity.activityManagement;

import com.flf.entity.Page;

/**
 * @ClassName: MediaManagement
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/10 14:43
 * @Version: 1.0
 */
public class MediaManagement {
    private Integer id;
    private String name;
    private String businessTypes;
    private String mediaType;
    private String link;
    private Integer sorting;
    private Integer placedTop;
    private String fileURL;

    private Page page;

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
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

    public String getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(String businessTypes) {
        this.businessTypes = businessTypes;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}

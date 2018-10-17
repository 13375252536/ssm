package com.flf.entity.advisesManagement;

import com.flf.entity.Page;

/**
 * @ClassName: SuggestionsAndGuidelines
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/22 20:14
 * @Version: 1.0
 */
public class SuggestionsAndGuidelines {

    private Integer id;
    private String content;
    private Page page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}

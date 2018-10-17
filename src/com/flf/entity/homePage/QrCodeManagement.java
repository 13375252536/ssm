package com.flf.entity.homePage;

/**
 * @ClassName: QrCodeManagement
 * @Description: //TODO  微信微博二维码管理实体类
 * @Author: Mr.Chan
 * @Data: 2018/8/28 11:20
 * @Version: 1.0
 */
public class QrCodeManagement {
    private Integer id;//数据库主键
    private String category;//类别: 微信 微博
    private String qrCodeURL;//二维码的相对路径地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQrCodeURL() {
        return qrCodeURL;
    }

    public void setQrCodeURL(String qrCodeURL) {
        this.qrCodeURL = qrCodeURL;
    }
}

package com.flf.service;

import com.flf.entity.serviceDevelopment.FundFeeEnquiry;
import com.flf.entity.serviceDevelopment.GuideManagement;
import com.flf.entity.serviceDevelopment.TaxPreferenceEnquiry;

import java.util.List;

/**
 * @ClassName: ServiceDevelopmentService
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/23 19:38
 * @Version: 1.0
 */
public interface ServiceDevelopmentService {
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历办事指南管理信息
     * @Date 2018/9/25 9:09
     * @Param [guideManagement]
     * @return java.util.List<com.flf.entity.serviceDevelopment.GuideManagement>
     */
    List<GuideManagement> listPageGuideManagement(GuideManagement guideManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除办事指南管理信息
     * @Date 2018/9/25 9:15
     * @Param [chk_value]
     * @return void
     */
    void deleteGuideManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  办事指南管理信息发布
     * @Date 2018/9/25 9:15
     * @Param [chk_value]
     * @return void
     */
    void updateGuideManagementReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  办事指南管理信息撤销发布
     * @Date 2018/9/25 9:16
     * @Param [chk_value]
     * @return void
     */
    void updateGuideManagementCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加办事指南管理信息
     * @Date 2018/9/25 9:16
     * @Param [guideManagement]
     * @return void
     */
    void insertGuideManagement(GuideManagement guideManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改办事指南管理信息
     * @Date 2018/9/25 9:16
     * @Param [guideManagement]
     * @return void
     */
    void updateGuideManagement(GuideManagement guideManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询办事指南管理信息
     * @Date 2018/9/25 9:16
     * @Param [id]
     * @return com.flf.entity.serviceDevelopment.GuideManagement
     */
    GuideManagement selectGuideManagementById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过办事指南name查询办事指南id
     * @Date 2018/10/10 11:26
     * @Param [name]
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> selectGuideManagementIdByName(String name);
    /**
     * @Author Mr.Chan
     * @Description //TODO   遍历政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:13
     * @Param [fundFeeEnquiry]
     * @return java.util.List<com.flf.entity.serviceDevelopment.FundFeeEnquiry>
     */
    List<FundFeeEnquiry> listPageFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry);
    /**
     * @Author Mr.Chan
     * @Description //TODO   删除政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:13
     * @Param [chk_value]
     * @return void
     */
    void deleteFundFeeEnquiry(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  政府性基金和行政事业型收费查询信息撤回发布
     * @Date 2018/9/25 11:14
     * @Param [chk_value]
     * @return void
     */
    void updateFundFeeEnquiryCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO   修改政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:14
     * @Param [fundFeeEnquiry]
     * @return void
     */
    void updateFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry);
    /**
     * @Author Mr.Chan
     * @Description //TODO   添加政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:14
     * @Param [fundFeeEnquiry]
     * @return void
     */
    void insertFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry);
    /**
     * @Author Mr.Chan
     * @Description //TODO   通过id查询政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:14
     * @Param [id]
     * @return com.flf.entity.serviceDevelopment.FundFeeEnquiry
     */
    FundFeeEnquiry selectFundFeeEnquiryById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   遍历双创税收优惠政策查询信息
     * @Date 2018/9/25 14:05
     * @Param [taxPreferenceEnquiry]
     * @return java.util.List<com.flf.entity.serviceDevelopment.TaxPreferenceEnquiry>
     */
    List<TaxPreferenceEnquiry> listPageTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除双创税收优惠政策查询信息
     * @Date 2018/9/25 14:05
     * @Param [chk_value]
     * @return void
     */
    void deleteTaxPreferenceEnquiry(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  双创税收优惠政策查询信息撤销发布
     * @Date 2018/9/25 14:06
     * @Param [chk_value]
     * @return void
     */
    void updateTaxPreferenceEnquiryCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加双创税收优惠政策查询信息
     * @Date 2018/9/25 14:06
     * @Param [taxPreferenceEnquiry]
     * @return void
     */
    void insertTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改双创税收优惠政策查询信息
     * @Date 2018/9/25 14:06
     * @Param [taxPreferenceEnquiry]
     * @return void
     */
    void updateTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询双创税收优惠政策查询信息
     * @Date 2018/9/25 14:06
     * @Param [id]
     * @return com.flf.entity.serviceDevelopment.TaxPreferenceEnquiry
     */
    TaxPreferenceEnquiry selectTaxPreferenceEnquiryById(Integer id);

}

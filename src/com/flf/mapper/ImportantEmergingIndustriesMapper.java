package com.flf.mapper;

import com.flf.entity.importantEmergingIndustries.*;

import java.util.List;

/**
 * @ClassName: ImportantEmergingIndustriesMapper
 * @Description: //TODO   战略性新兴产业mapper层
 * @Author: Mr.Chan
 * @Data: 2018/9/14 16:22
 * @Version: 1.0
 */
public interface ImportantEmergingIndustriesMapper {

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历战略性新兴产业
     * @Date 2018/9/14 11:55
     * @Param [importantEmergingIndustries]
     * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
     */
    List<ImportantEmergingIndustries> listPageImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除战略性新兴产业
     * @Date 2018/9/14 11:55
     * @Param [chk_value]
     * @return void
     */
    void deleteImportantEmergingIndustries(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  战略性新兴产业置顶
     * @Date 2018/9/14 11:55
     * @Param [chk_value]
     * @return void
     */
    void updateImportantEmergingIndustriesPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO   战略性新兴产业取消置顶
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateImportantEmergingIndustriesCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  发布战略性新兴产业
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateImportantEmergingIndustriesReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  战略性新兴产业撤销发布
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateImportantEmergingIndustriesCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加战略性新兴产业
     * @Date 2018/9/14 11:56
     * @Param [importantEmergingIndustries]
     * @return void
     */
    void insertImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改战略性新兴产业
     * @Date 2018/9/14 11:57
     * @Param [importantEmergingIndustries]
     * @return void
     */
    void updateImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询战略性新兴产业
     * @Date 2018/9/14 11:57
     * @Param [id]
     * @return com.flf.entity.importantEmergingIndustries.LocalReports
     */
    ImportantEmergingIndustries selectImportantEmergingIndustriesById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过name查询战略性新兴产业
     * @Date 2018/9/14 11:57
     * @Param [name]
     * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
     */
    List<ImportantEmergingIndustries> selectImportantEmergingIndustriesByName(ImportantEmergingIndustries importantEmergingIndustries);

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历新兴产业管理信息
     * @Date 2018/9/14 11:55
     * @Param [emergingIndustryManagement]
     * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
     */
    List<EmergingIndustryManagement> listPageEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除新兴产业管理信息
     * @Date 2018/9/14 11:55
     * @Param [chk_value]
     * @return void
     */
    void deleteEmergingIndustryManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  新兴产业管理信息置顶
     * @Date 2018/9/14 11:55
     * @Param [chk_value]
     * @return void
     */
    void updateEmergingIndustryManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO   新兴产业管理信息取消置顶
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateEmergingIndustryManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  发布新兴产业管理信息
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateEmergingIndustryManagementReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  新兴产业管理信息撤销发布
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateEmergingIndustryManagementCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加新兴产业管理信息
     * @Date 2018/9/14 11:56
     * @Param [emergingIndustryManagement]
     * @return void
     */
    void insertEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改新兴产业管理信息
     * @Date 2018/9/14 11:57
     * @Param [emergingIndustryManagement]
     * @return void
     */
    void updateEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询新兴产业管理信息
     * @Date 2018/9/14 11:57
     * @Param [id]
     * @return com.flf.entity.importantEmergingIndustries.LocalReports
     */
    EmergingIndustryManagement selectEmergingIndustryManagementById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过name查询新兴产业管理信息
     * @Date 2018/9/14 11:57
     * @Param [name]
     * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
     */
    List<EmergingIndustryManagement> selectEmergingIndustryManagementByName(String name);

}

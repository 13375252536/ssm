package com.flf.service;

import com.flf.entity.importantEmergingIndustries.*;

import java.util.List;

/**
 * @ClassName: ImportantEmergingIndustriesService
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/14 16:32
 * @Version: 1.0
 */
public interface ImportantEmergingIndustriesService {

        /**
         * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
         * @Author Mr.Chan
         * @Description //TODO  遍历战略性新兴产业
         * @Date 2018/9/14 11:55
         * @Param [importantEmergingIndustries]
         */
        List<ImportantEmergingIndustries> listPageImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  删除战略性新兴产业
         * @Date 2018/9/14 11:55
         * @Param [chk_value]
         */
        void deleteImportantEmergingIndustries(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  战略性新兴产业置顶
         * @Date 2018/9/14 11:55
         * @Param [chk_value]
         */
        void updateImportantEmergingIndustriesPlacedTop(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO   战略性新兴产业取消置顶
         * @Date 2018/9/14 11:56
         * @Param [chk_value]
         */
        void updateImportantEmergingIndustriesCancelPlacedTop(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  发布战略性新兴产业
         * @Date 2018/9/14 11:56
         * @Param [chk_value]
         */
        void updateImportantEmergingIndustriesReportMarks(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  战略性新兴产业撤销发布
         * @Date 2018/9/14 11:56
         * @Param [chk_value]
         */
        void updateImportantEmergingIndustriesCancelReportMarks(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  添加战略性新兴产业
         * @Date 2018/9/14 11:56
         * @Param [importantEmergingIndustries]
         */
        void insertImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  修改战略性新兴产业
         * @Date 2018/9/14 11:57
         * @Param [importantEmergingIndustries]
         */
        void updateImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries);

        /**
         * @return com.flf.entity.importantEmergingIndustries.LocalReports
         * @Author Mr.Chan
         * @Description //TODO  通过id查询战略性新兴产业
         * @Date 2018/9/14 11:57
         * @Param [id]
         */
        ImportantEmergingIndustries selectImportantEmergingIndustriesById(Integer id);

        /**
         * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
         * @Author Mr.Chan
         * @Description //TODO  通过name查询战略性新兴产业
         * @Date 2018/9/14 11:57
         * @Param [name]
         */
        List<ImportantEmergingIndustries> selectImportantEmergingIndustriesByName(ImportantEmergingIndustries importantEmergingIndustries);

        /**
         * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
         * @Author Mr.Chan
         * @Description //TODO  遍历新兴产业管理信息
         * @Date 2018/9/14 11:55
         * @Param [emergingIndustryManagement]
         */
        List<EmergingIndustryManagement> listPageEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  删除新兴产业管理信息
         * @Date 2018/9/14 11:55
         * @Param [chk_value]
         */
        void deleteEmergingIndustryManagement(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  新兴产业管理信息置顶
         * @Date 2018/9/14 11:55
         * @Param [chk_value]
         */
        void updateEmergingIndustryManagementPlacedTop(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO   新兴产业管理信息取消置顶
         * @Date 2018/9/14 11:56
         * @Param [chk_value]
         */
        void updateEmergingIndustryManagementCancelPlacedTop(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  发布新兴产业管理信息
         * @Date 2018/9/14 11:56
         * @Param [chk_value]
         */
        void updateEmergingIndustryManagementReportMarks(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  新兴产业管理信息撤销发布
         * @Date 2018/9/14 11:56
         * @Param [chk_value]
         */
        void updateEmergingIndustryManagementCancelReportMarks(Integer[] chk_value);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  添加新兴产业管理信息
         * @Date 2018/9/14 11:56
         * @Param [emergingIndustryManagement]
         */
        void insertEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement);

        /**
         * @return void
         * @Author Mr.Chan
         * @Description //TODO  修改新兴产业管理信息
         * @Date 2018/9/14 11:57
         * @Param [emergingIndustryManagement]
         */
        void updateEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement);

        /**
         * @return com.flf.entity.importantEmergingIndustries.LocalReports
         * @Author Mr.Chan
         * @Description //TODO  通过id查询新兴产业管理信息
         * @Date 2018/9/14 11:57
         * @Param [id]
         */
        EmergingIndustryManagement selectEmergingIndustryManagementById(Integer id);

        /**
         * @return java.util.List<com.flf.entity.importantEmergingIndustries.LocalReports>
         * @Author Mr.Chan
         * @Description //TODO  通过name查询新兴产业管理信息
         * @Date 2018/9/14 11:57
         * @Param [name]
         */
        List<EmergingIndustryManagement> selectEmergingIndustryManagementByName(String name);

}

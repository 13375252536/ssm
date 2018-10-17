package com.flf.service;

import com.flf.entity.comprehensiveInnovationExperiment.*;

import java.util.List;

/**
 * @ClassName: ComprehensiveInnovationExperimentService
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/14 11:10
 * @Version: 1.0
 */
public interface ComprehensiveInnovationExperimentService {
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历全面创新实验信息
     * @Date 2018/9/14 11:55
     * @Param [comprehensiveInnovationExperiment]
     * @return java.util.List<com.flf.entity.comprehensiveInnovationExperiment.LocalReports>
     */
    List<ComprehensiveInnovationExperiment> listPageComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除全面创新实验信息
     * @Date 2018/9/14 11:55
     * @Param [chk_value]
     * @return void
     */
    void deleteComprehensiveInnovationExperiment(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  全面创新实验信息置顶
     * @Date 2018/9/14 11:55
     * @Param [chk_value]
     * @return void
     */
    void updateComprehensiveInnovationExperimentPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO   全面创新实验信息取消置顶
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateComprehensiveInnovationExperimentCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  发布全面创新实验信息
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateComprehensiveInnovationExperimentReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  全面创新实验信息撤销发布
     * @Date 2018/9/14 11:56
     * @Param [chk_value]
     * @return void
     */
    void updateComprehensiveInnovationExperimentCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加全面创新实验信息
     * @Date 2018/9/14 11:56
     * @Param [comprehensiveInnovationExperiment]
     * @return void
     */
    void insertComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改全面创新实验信息
     * @Date 2018/9/14 11:57
     * @Param [comprehensiveInnovationExperiment]
     * @return void
     */
    void updateComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询全面创新实验信息
     * @Date 2018/9/14 11:57
     * @Param [id]
     * @return com.flf.entity.comprehensiveInnovationExperiment.LocalReports
     */
    ComprehensiveInnovationExperiment selectComprehensiveInnovationExperimentById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过name查询全面创新实验信息
     * @Date 2018/9/14 11:57
     * @Param [name]
     * @return java.util.List<com.flf.entity.comprehensiveInnovationExperiment.LocalReports>
     */
    List<ComprehensiveInnovationExperiment> selectComprehensiveInnovationExperimentByName(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment);
}

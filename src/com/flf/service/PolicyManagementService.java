package com.flf.service;

import com.flf.entity.OrganizationManagement;
import com.flf.entity.homePage.EntrepreneurshipGroupMaintenance;
import com.flf.entity.policyManagement.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: PolicyManagementService
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/10 11:05
 * @Version: 1.0
 */
public interface PolicyManagementService {
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历生态圈维护信息
     * @Date 2018/9/10 11:02
     * @Param [ecosystemMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.EcosystemMaintenance>
     */
    List<EcosystemMaintenance> listPageEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除生态圈维护信息
     * @Date 2018/9/10 11:03
     * @Param [chk_value]
     * @return void
     */
    void deleteEcosystemMaintenance(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加生态圈维护信息
     * @Date 2018/9/10 11:03
     * @Param [ecosystemMaintenance]
     * @return void
     */
    void insertEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改生态圈维护信息
     * @Date 2018/9/10 11:03
     * @Param [ecosystemMaintenance]
     * @return void
     */
    void updateEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询生态圈维护信息
     * @Date 2018/9/10 11:03
     * @Param [id]
     * @return com.flf.entity.policyManagement.EcosystemMaintenance
     */
    EcosystemMaintenance selectEcosystemMaintenanceById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询生态圈名称是否重复
     * @Date 2018/9/11 15:57
     * @Param [ecosystemMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.EcosystemMaintenance>
     */
    List<EcosystemMaintenance> selectEcosystemMaintenanceByName(EcosystemMaintenance ecosystemMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历时间轴维护信息
     * @Date 2018/9/10 11:02
     * @Param [timelineMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.TimelineMaintenance>
     */
    List<TimelineMaintenance> listPageTimelineMaintenance(TimelineMaintenance timelineMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除时间轴维护信息
     * @Date 2018/9/10 11:03
     * @Param [chk_value]
     * @return void
     */
    void deleteTimelineMaintenance(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加时间轴维护信息
     * @Date 2018/9/10 11:03
     * @Param [timelineMaintenance]
     * @return void
     */
    void insertTimelineMaintenance(TimelineMaintenance timelineMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改时间轴维护信息
     * @Date 2018/9/10 11:03
     * @Param [timelineMaintenance]
     * @return void
     */
    void updateTimelineMaintenance(TimelineMaintenance timelineMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询时间轴维护信息
     * @Date 2018/9/10 11:03
     * @Param [id]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    TimelineMaintenance selectTimelineMaintenanceById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询时间轴名称是否重复
     * @Date 2018/9/11 15:57
     * @Param [timelineMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.TimelineMaintenance>
     */
    List<TimelineMaintenance> selectTimelineMaintenanceByName(TimelineMaintenance timelineMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历行业数据维护信息
     * @Date 2018/9/10 11:02
     * @Param [industryDataMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.industryDataMaintenance>
     */
    List<IndustryDataMaintenance> listPageIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除行业数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [chk_value]
     * @return void
     */
    void deleteIndustryDataMaintenance(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加行业数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [industryDataMaintenance]
     * @return void
     */
    void insertIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改行业数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [industryDataMaintenance]
     * @return void
     */
    void updateIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询行业数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [id]
     * @return com.flf.entity.policyManagement.IndustryDataMaintenance
     */
    IndustryDataMaintenance selectIndustryDataMaintenanceById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询行业数据名称是否重复
     * @Date 2018/9/11 15:57
     * @Param [industryDataMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.IndustryDataMaintenance>
     */
    List<IndustryDataMaintenance> selectIndustryDataMaintenanceByName(IndustryDataMaintenance industryDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历区域数据维护信息
     * @Date 2018/9/10 11:02
     * @Param [regionalDataMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.RegionalDataMaintenance>
     */
    List<RegionalDataMaintenance> listPageRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除区域数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [chk_value]
     * @return void
     */
    void deleteRegionalDataMaintenance(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加区域数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [regionalDataMaintenance]
     * @return void
     */
    void insertRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改区域数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [regionalDataMaintenance]
     * @return void
     */
    void updateRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询区域数据维护信息
     * @Date 2018/9/10 11:03
     * @Param [id]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> selectRegionalDataMaintenanceById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询某区域名称是否重复
     * @Date 2018/9/11 15:57
     * @Param [regionalDataMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.RegionalDataMaintenance>
     */
    List<RegionalDataMaintenance> selectNameCheckInfo(RegionalDataMaintenance regionalDataMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历主题分类维护信息
     * @Date 2018/9/10 11:02
     * @Param [subjectClassificationMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.subjectClassificationMaintenance>
     */
    List<SubjectClassificationMaintenance> listPageSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除主题分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [chk_value]
     * @return void
     */
    void deleteSubjectClassificationMaintenance(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加主题分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [subjectClassificationMaintenance]
     * @return void
     */
    void insertSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改主题分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [subjectClassificationMaintenance]
     * @return void
     */
    void updateSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询主题分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [id]
     * @return com.flf.entity.policyManagement.SubjectClassificationMaintenance
     */
    SubjectClassificationMaintenance selectSubjectClassificationMaintenanceById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询主题分类名称是否重复
     * @Date 2018/9/11 15:57
     * @Param [subjectClassificationMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.SubjectClassificationMaintenance>
     */
    List<SubjectClassificationMaintenance> selectSubjectClassificationMaintenanceByName(SubjectClassificationMaintenance subjectClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历政策分类维护信息
     * @Date 2018/9/10 11:02
     * @Param [policyClassificationMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.policyClassificationMaintenance>
     */
    List<PolicyClassificationMaintenance> listPagePolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除政策分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [chk_value]
     * @return void
     */
    void deletePolicyClassificationMaintenance(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加政策分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [policyClassificationMaintenance]
     * @return void
     */
    void insertPolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改政策分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [policyClassificationMaintenance]
     * @return void
     */
    void updatePolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询政策分类维护信息
     * @Date 2018/9/10 11:03
     * @Param [id]
     * @return com.flf.entity.policyManagement.PolicyClassificationMaintenance
     */
    PolicyClassificationMaintenance selectPolicyClassificationMaintenanceById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询政策分类名称是否重复
     * @Date 2018/9/11 15:57
     * @Param [policyClassificationMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.PolicyClassificationMaintenance>
     */
    List<PolicyClassificationMaintenance> selectPolicyClassificationMaintenanceByName(PolicyClassificationMaintenance policyClassificationMaintenance);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历产业园推荐信息
     * @Date 2018/9/10 11:02
     * @Param [industrialParkRecommendation]
     * @return java.util.List<com.flf.entity.policyManagement.industrialParkRecommendation>
     */
    List<IndustrialParkRecommendation> listPageIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除产业园推荐信息
     * @Date 2018/9/10 11:03
     * @Param [chk_value]
     * @return void
     */
    void deleteIndustrialParkRecommendation(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  产业园推荐信息置顶
     * @Date 2018/9/17 16:52
     * @Param [chk_value]
     * @return void
     */
    void updateIndustrialParkRecommendationPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  产业园推荐信息取消置顶
     * @Date 2018/9/17 16:53
     * @Param [chk_value]
     * @return void
     */
    void updateIndustrialParkRecommendationCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加产业园推荐信息
     * @Date 2018/9/10 11:03
     * @Param [industrialParkRecommendation]
     * @return void
     */
    void insertIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改产业园推荐信息
     * @Date 2018/9/10 11:03
     * @Param [industrialParkRecommendation]
     * @return void
     */
    void updateIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询产业园推荐信息
     * @Date 2018/9/10 11:03
     * @Param [id]
     * @return com.flf.entity.policyManagement.IndustrialParkRecommendation
     */
    IndustrialParkRecommendation selectIndustrialParkRecommendationById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询产业园推荐名称是否重复
     * @Date 2018/9/11 15:57
     * @Param [industrialParkRecommendation]
     * @return java.util.List<com.flf.entity.policyManagement.IndustrialParkRecommendation>
     */
    List<IndustrialParkRecommendation> selectIndustrialParkRecommendationByName(IndustrialParkRecommendation industrialParkRecommendation);

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历政策发布信息
     * @Date 2018/9/26 21:11
     * @Param [policyIssued]
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> listPagePolicyIssued(PolicyIssued policyIssued);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除政策发布信息
     * @Date 2018/9/26 21:11
     * @Param [chk_value]
     * @return void
     */
    void deletePolicyIssued(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  政策发布信息置顶
     * @Date 2018/9/26 21:11
     * @Param [chk_value]
     * @return void
     */
    void updatePolicyIssuedPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  政策发布信息取消置顶
     * @Date 2018/9/26 21:11
     * @Param [chk_value]
     * @return void
     */
    void updatePolicyIssuedCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  政策发布信息撤销发布
     * @Date 2018/9/26 21:11
     * @Param [chk_value]
     * @return void
     */
    void updatePolicyIssuedCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加政策发布信息
     * @Date 2018/9/26 21:11
     * @Param [policyIssued]
     * @return void
     */
    void insertPolicyIssued(PolicyIssued policyIssued);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改政策发布信息
     * @Date 2018/9/26 21:12
     * @Param [policyIssued]
     * @return void
     */
    void updatePolicyIssued(PolicyIssued policyIssued);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询政策发布信息
     * @Date 2018/9/26 21:12
     * @Param [id]
     * @return com.flf.entity.policyManagement.PolicyIssued
     */
    PolicyIssued selectPolicyIssuedById(int id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有机构信息
     * @Date 2018/9/26 21:33
     * @Param []
     * @return java.util.List<com.flf.entity.OrganizationManagement>
     */
    List<OrganizationManagement> selectReportUnit();
    /**
     * @Author Mr.Chan
     * @Description //TODO   查询所有区域信息
     * @Date 2018/9/26 21:33
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.RegionalDataMaintenance>
     */
    List<RegionalDataMaintenance> selectRegion();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有生态圈信息
     * @Date 2018/9/26 21:33
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.EcosystemMaintenance>
     */
    List<EcosystemMaintenance> selectEcosphereKeyword();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有政策主题信息
     * @Date 2018/9/26 21:34
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.SubjectClassificationMaintenance>
     */
    List<SubjectClassificationMaintenance> selectPolicyTheme();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有时间轴信息
     * @Date 2018/9/26 21:34
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.TimelineMaintenance>
     */
    List<TimelineMaintenance> selectTimelinePhase();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有创业人群信息
     * @Date 2018/9/26 21:34
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.EntrepreneurshipGroupMaintenance>
     */
    List<EntrepreneurshipGroupMaintenance> selectBusinessPeople();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有政策分类
     * @Date 2018/9/26 21:35
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyClassificationMaintenance>
     */
    List<PolicyClassificationMaintenance> selectPolicyClassification();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有行业信息
     * @Date 2018/9/26 21:35
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.IndustryDataMaintenance>
     */
    List<IndustryDataMaintenance> selectIndustry();
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过政策管理name查询政策管理id
     * @Date 2018/10/10 11:05
     * @Param [name]
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> selectPolicyIssuedIdByName(String name);
}

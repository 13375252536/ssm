package com.flf.mapper;

import com.flf.entity.activityManagement.ActivityCategoryManagement;
import com.flf.entity.activityManagement.ActivityManagement;
import com.flf.entity.activityManagement.MediaManagement;
import com.flf.entity.advisesManagement.MakeRecommendations;
import com.flf.entity.advisesManagement.SuggestionsAndGuidelines;
import com.flf.entity.comprehensiveInnovationExperiment.ComprehensiveInnovationExperiment;
import com.flf.entity.demonstrationBase.DemonstrationBaseManagement;
import com.flf.entity.homePage.DynamicManagement;
import com.flf.entity.homePage.EntrepreneurshipGroupMaintenance;
import com.flf.entity.homePage.ImageManagement;
import com.flf.entity.importantEmergingIndustries.EmergingIndustryManagement;
import com.flf.entity.policyManagement.*;
import com.flf.entity.serviceDevelopment.GuideManagement;

import java.util.List;

/**
 * @ClassName: IndexMapper
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/19 14:47
 * @Version: 1.0
 */
public interface IndexMapper {
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询动态管理信息 限制4条
     * @Date 2018/9/19 15:26
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectDynamicManagement();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询微信二维码路径
     * @Date 2018/9/19 20:20
     * @Param []
     * @return java.lang.String
     */
    String selectQrCodeWeiXin();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询微博二维码路径
     * @Date 2018/9/19 20:20
     * @Param []
     * @return java.lang.String
     */
    String selectQrCodeWeiBo();
    /**
     * @Author Mr.Chan
     * @Description //TODO  部委信息查询
     * @Date 2018/9/20 13:47
     * @Param []
     * @return java.lang.String
     */
    List<DynamicManagement> selectBuWei();
    /**
     * @Author Mr.Chan
     * @Description //TODO  热门信息
     * @Date 2018/9/20 18:14
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<ImageManagement> selectShouLu();
    /**
     * @Author Mr.Chan
     * @Description //TODO  地方信息
     * @Date 2018/9/21 10:18
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectDiFang();
    /**
     * @Author Mr.Chan
     * @Description //TODO  社会团体信息
     * @Date 2018/9/21 10:19
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectTuanTi();
    /**
     * @Author Mr.Chan
     * @Description //TODO  基地信息
     * @Date 2018/9/21 10:19
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectJiDi();
    /**
     * @Author Mr.Chan
     * @Description //TODO  全面创新实验信息 专题专栏
     * @Date 2018/9/21 16:56
     * @Param []
     * @return java.util.List<com.flf.entity.comprehensiveInnovationExperiment.ComprehensiveInnovationExperiment>
     */
    List<ComprehensiveInnovationExperiment> selectChuangXinShiYan();
    /**
     * @Author Mr.Chan
     * @Description //TODO  战略性新兴产业 专题专栏
     * @Date 2018/9/21 17:11
     * @Param []
     * @return java.util.List<com.flf.entity.importantEmergingIndustries.EmergingIndustryManagement>
     */
    List<EmergingIndustryManagement> selectXinXingChanYe();
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历活动跟踪的信息
     * @Date 2018/9/25 16:03
     * @Param [type]
     * @return java.util.List<com.flf.entity.activityManagement.MediaManagement>
     */
    List<MediaManagement>selectHuoDongGengZong(String type);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询示范基地轮播图
     * @Date 2018/9/26 10:54
     * @Param []
     * @return java.util.List<com.flf.entity.demonstrationBase.DemonstrationBaseManagement>
     */
    List<DemonstrationBaseManagement> selectJiDiLunBoTu();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询最新基地动态信息
     * @Date 2018/9/26 15:58
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectJiDiDongTaiXingXi(DynamicManagement dynamicManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查出页面可以显示的总数
     * @Date 2018/9/27 15:49
     * @Param []
     * @return java.lang.Integer
     */
    Integer selectJiDiDongTaiXingXiCount(DynamicManagement dynamicManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询建言须知信息
     * @Date 2018/9/27 14:30
     * @Param [suggestionsAndGuidelines]
     * @return java.util.List<com.flf.entity.advisesManagement.SuggestionsAndGuidelines>
     */
    List<SuggestionsAndGuidelines> listPageSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines);

    /**
     * @Author Mr.Chan
     * @Description //TODO  添加建言献策信息
     * @Date 2018/9/27 11:50
     * @Param []
     * @return void
     */
    void insertMakeRecommendations(MakeRecommendations makeRecommendations);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询前端需要的符合条件的
     * @Date 2018/9/28 11:03
     * @Param [demonstrationBaseManagement]
     * @return java.util.List<com.flf.entity.demonstrationBase.DemonstrationBaseManagement>
     */
    List<DemonstrationBaseManagement> selectJiDiKuXingXi(DemonstrationBaseManagement demonstrationBaseManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过基地id查询动态管理信息
     * @Date 2018/9/28 11:07
     * @Param [baseId]
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectDongTaiXingXiByBaseId(Integer baseId);
    /**
     * @Author Mr.Chan
     * @Description //TODO  基地库动态信息数量
     * @Date 2018/9/28 11:46
     * @Param [demonstrationBaseManagement]
     * @return java.lang.Integer
     */
    Integer selectJiDiKuDongTaiXingXiCount(DemonstrationBaseManagement demonstrationBaseManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有时间轴的信息
     * @Date 2018/9/28 14:30
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.TimelineMaintenance>
     */
    List<TimelineMaintenance> selectTimeLineInfo();
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过type查询办事指南信息
     * @Date 2018/9/28 15:25
     * @Param [typeId]
     * @return java.util.List<com.flf.entity.serviceDevelopment.GuideManagement>
     */
    List<GuideManagement> selectGuideManagementInfo(Integer typeId);
    /**
     * @Author Mr.Chan
     * @Description //TODO  首页政策发布中的部委
     * @Date 2018/9/28 20:55
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> selectPolicyIssuedByReportUnit();
    /**
     * @Author Mr.Chan
     * @Description //TODO  首页政策发布中的地方
     * @Date 2018/9/28 20:55
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> selectPolicyIssuedByRegion();
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过页面点击量降序查询政策发布信息
     * @Date 2018/9/28 21:13
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> selectPolicyIssuedByPageView();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询活动跟踪创响中国信息
     * @Date 2018/9/29 11:03
     * @Param []
     * @return java.util.List<com.flf.entity.activityManagement.ActivityManagement>
     */
    List<ActivityManagement> selectHuoDongGengZongCXZG();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询活动跟踪双创周信息
     * @Date 2018/9/29 11:04
     * @Param []
     * @return java.util.List<com.flf.entity.activityManagement.ActivityManagement>
     */
    List<ActivityManagement> selectHuoDongGengZongSCZ();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询活动跟踪banner图片信息
     * @Date 2018/9/29 11:35
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.ImageManagement>
     */
    List<ImageManagement>selectHuoDongGenZongBanner();
    /**
     * @Author Mr.Chan
     * @Description //TODO   通过type查询活动类别的信息
     * @Date 2018/9/29 11:56
     * @Param [activityCategoryManagement]
     * @return java.util.List<com.flf.entity.activityManagement.ActivityCategoryManagement>
     */
    List<ActivityCategoryManagement> selectActivityCategoryManagementByType(ActivityCategoryManagement activityCategoryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO   通过type查询活动类别的数量
     * @Date 2018/9/29 11:57
     * @Param [activityCategoryManagement]
     * @return java.lang.Integer
     */
   Integer selectActivityCategoryManagementByTypeCount(ActivityCategoryManagement activityCategoryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过type查询动态管理中的动态政策信息
     * @Date 2018/10/2 10:46
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectDynamicManagementByTypeZCDT();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有地区内容
     * @Date 2018/10/2 11:18
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.RegionalDataMaintenance>
     */
    List<RegionalDataMaintenance> selectAllRegionList();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询查询动态管理信息通过政策动态内的动态点击信息
     * @Date 2018/10/2 11:54
     * @Param [dynamicManagement]
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> selectDynamicManagementByZCDTClick(DynamicManagement dynamicManagement);
   /**
    * @Author Mr.Chan
    * @Description //TODO  查询动态管理信息通过政策动态内的动态点击信息的总数
    * @Date 2018/10/2 11:55
    * @Param [dynamicManagement]
    * @return java.lang.Integer
    */
    Integer selectDynamicManagementByZCDTClickCounts(DynamicManagement dynamicManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过基地名称查询基地信息的id
     * @Date 2018/10/2 19:15
     * @Param [name]
     * @return java.lang.Integer
     */
    List<Integer> selectDemonstrationBaseManagementByBaseName(String name);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有行业数据信息
     * @Date 2018/10/2 22:09
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.IndustryDataMaintenance>
     */
    List<IndustryDataMaintenance> selectAllIndustryList();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有创业人群信息
     * @Date 2018/10/2 22:10
     * @Param []
     * @return java.util.List<com.flf.entity.homePage.EntrepreneurshipGroupMaintenance>
     */
    List<EntrepreneurshipGroupMaintenance> selectAllEntrepreneurshipGroupMaintenanceList();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有政策分类信息
     * @Date 2018/10/2 22:10
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyClassificationMaintenance>
     */
    List<PolicyClassificationMaintenance> selectAllPolicyClassificationMaintenance();
   /**
    * @Author Mr.Chan
    * @Description //TODO  通过前端查询条件查询政策发布信息
    * @Date 2018/10/3 18:14
    * @Param [policyIssued]
    * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
    */
    List<PolicyIssued> selectPolicyIssuedByZCCXClick(PolicyIssued policyIssued);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过前端查询条件查询政策发布信息的总数
     * @Date 2018/10/3 18:14
     * @Param [policyIssued]
     * @return java.lang.Integer
     */
    Integer selectPolicyIssuedByZCCXClickCounts(PolicyIssued policyIssued);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过区域id查询区域name
     * @Date 2018/10/3 20:46
     * @Param [id]
     * @return java.lang.String
     */
    String selectRegionNameById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过政策分类id查询政策分类name
     * @Date 2018/10/3 20:46
     * @Param [id]
     * @return java.lang.String
     */
    String selectPolicyClassificationById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过创业人群id查询创业人群name
     * @Date 2018/10/3 20:47
     * @Param [id]
     * @return java.lang.String
     */
    String selectBusinessPeopleById(Integer id);
   /**
    * @Author Mr.Chan
    * @Description //TODO  通过行业id查询行业name
    * @Date 2018/10/3 20:47
    * @Param [id]
    * @return java.lang.String
    */
    String selectIndustryById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询政策发布按周度点击量排序
     * @Date 2018/10/5 13:41
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> selectPolicyIssuedByWeeklyPageView();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询政策发布按余额度点击量排序
     * @Date 2018/10/5 13:41
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> selectPolicyIssuedByMonthlyPageView();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询政策发布按季度点击量排序
     * @Date 2018/10/5 13:42
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> selectPolicyIssuedByQuarterPageView();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询政策发布按年度点击量排序
     * @Date 2018/10/5 13:42
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> selectPolicyIssuedByAnnualPageView();
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询动态详情
     * @Date 2018/10/6 11:37
     * @Param [id]
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> getDynamicManagementInfoById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询该动态的页面点击量
     * @Date 2018/10/6 20:44
     * @Param [id]
     * @return java.lang.Integer
     */
    Integer getDynamicManagementPageViewsById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id修改动态的页面点击量
     * @Date 2018/10/6 20:44
     * @Param [dynamicManagement]
     * @return void
     */
    void updateDynamicManagementPageViewsById(DynamicManagement dynamicManagement);


    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询政策详情
     * @Date 2018/10/6 11:37
     * @Param [id]
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> getPolicyIssuedInfoById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询该政策的页面点击量
     * @Date 2018/10/6 20:45
     * @Param [id]
     * @return java.lang.Integer
     */
    Integer getPolicyIssuedPageViewsById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id修改政策的页面点击量
     * @Date 2018/10/6 20:45
     * @Param [policyIssued]
     * @return void
     */
    void updatePolicyIssuedPageViewsById(PolicyIssued policyIssued);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有政策信息
     * @Date 2018/10/8 16:19
     * @Param []
     * @return java.util.List<com.flf.entity.policyManagement.PolicyIssued>
     */
    List<PolicyIssued> getAllPolicyIssuedInfo();
    /**
     * @Author Mr.Chan
     * @Description //TODO  将周浏览量清零
     * @Date 2018/10/8 16:33
     * @Param [id]
     * @return void
     */
    void updatePolicyIssuedWeeklyPageView(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  将月浏览量清零
     * @Date 2018/10/8 16:33
     * @Param [id]
     * @return void
     */
    void updatePolicyIssuedMonthlyPageView(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  将季度浏览量清零
     * @Date 2018/10/8 16:33
     * @Param [id]
     * @return void
     */
    void updatePolicyIssuedQuarterPageView(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  将年浏览量清零
     * @Date 2018/10/8 16:33
     * @Param [id]
     * @return void
     */
    void updatePolicyIssuedAnnualPageView(Integer id);
}

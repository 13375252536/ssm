package com.flf.service.impl;

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
import com.flf.mapper.IndexMapper;
import com.flf.service.IndexService;

import java.util.List;

/**
 * @ClassName: IndexServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/19 14:48
 * @Version: 1.0
 */
public class IndexServiceImpl implements IndexService {
    private IndexMapper indexMapper;

    public IndexMapper getIndexMapper() {
        return indexMapper;
    }

    public void setIndexMapper(IndexMapper indexMapper) {
        this.indexMapper = indexMapper;
    }

    @Override
    public List<DynamicManagement> selectDynamicManagement() {
        return indexMapper.selectDynamicManagement();
    }

    @Override
    public String selectQrCodeWeiXin() {
        return indexMapper.selectQrCodeWeiXin();
    }

    @Override
    public String selectQrCodeWeiBo() {
        return indexMapper.selectQrCodeWeiBo();
    }

    @Override
    public List<DynamicManagement> selectBuWei() {
        return indexMapper.selectBuWei();
    }

    @Override
    public List<ImageManagement> selectShouLu() {
        return indexMapper.selectShouLu();
    }

    @Override
    public List<DynamicManagement> selectDiFang() {
        return indexMapper.selectDiFang();
    }

    @Override
    public List<DynamicManagement> selectTuanTi() {
        return indexMapper.selectTuanTi();
    }

    @Override
    public List<DynamicManagement> selectJiDi() {
        return indexMapper.selectJiDi();
    }

    @Override
    public List<ComprehensiveInnovationExperiment> selectChuangXinShiYan() {
        return indexMapper.selectChuangXinShiYan();
    }

    @Override
    public List<EmergingIndustryManagement> selectXinXingChanYe() {
        return indexMapper.selectXinXingChanYe();
    }

    @Override
    public List<MediaManagement> selectHuoDongGengZong(String type) {
        return indexMapper.selectHuoDongGengZong(type);
    }

    @Override
    public List<DemonstrationBaseManagement> selectJiDiLunBoTu() {
        return indexMapper.selectJiDiLunBoTu();
    }

    @Override
    public List<DynamicManagement> selectJiDiDongTaiXingXi(DynamicManagement dynamicManagement) {
        return indexMapper.selectJiDiDongTaiXingXi(dynamicManagement);
    }

    @Override
    public Integer selectJiDiDongTaiXingXiCount(DynamicManagement dynamicManagement) {
        return indexMapper.selectJiDiDongTaiXingXiCount(dynamicManagement);
    }

    @Override
    public List<SuggestionsAndGuidelines> listPageSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines) {
        return indexMapper.listPageSuggestionsAndGuidelines(suggestionsAndGuidelines);
    }

    @Override
    public void insertMakeRecommendations(MakeRecommendations makeRecommendations) {
        indexMapper.insertMakeRecommendations(makeRecommendations);
    }

    @Override
    public List<DemonstrationBaseManagement> selectJiDiKuXingXi(DemonstrationBaseManagement demonstrationBaseManagement) {
        return indexMapper.selectJiDiKuXingXi(demonstrationBaseManagement);
    }

    @Override
    public List<DynamicManagement> selectDongTaiXingXiByBaseId(Integer baseId) {
        return indexMapper.selectDongTaiXingXiByBaseId(baseId);
    }

    @Override
    public Integer selectJiDiKuDongTaiXingXiCount(DemonstrationBaseManagement demonstrationBaseManagement) {
        return indexMapper.selectJiDiKuDongTaiXingXiCount(demonstrationBaseManagement);
    }

    @Override
    public List<TimelineMaintenance> selectTimeLineInfo() {
        return indexMapper.selectTimeLineInfo();
    }

    @Override
    public List<GuideManagement> selectGuideManagementInfo(Integer typeId) {
        return indexMapper.selectGuideManagementInfo(typeId);
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByReportUnit() {
        return indexMapper.selectPolicyIssuedByReportUnit();
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByRegion() {
        return indexMapper.selectPolicyIssuedByRegion();
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByPageView() {
        return indexMapper.selectPolicyIssuedByPageView();
    }

    @Override
    public List<ActivityManagement> selectHuoDongGengZongCXZG() {
        return indexMapper.selectHuoDongGengZongCXZG();
    }

    @Override
    public List<ActivityManagement> selectHuoDongGengZongSCZ() {
        return indexMapper.selectHuoDongGengZongSCZ();
    }

    @Override
    public List<ImageManagement> selectHuoDongGenZongBanner() {
        return indexMapper.selectHuoDongGenZongBanner();
    }

    @Override
    public List<ActivityCategoryManagement> selectActivityCategoryManagementByType(ActivityCategoryManagement activityCategoryManagement) {
        return indexMapper.selectActivityCategoryManagementByType(activityCategoryManagement);
    }

    @Override
    public Integer selectActivityCategoryManagementByTypeCount(ActivityCategoryManagement activityCategoryManagement) {
        return indexMapper.selectActivityCategoryManagementByTypeCount(activityCategoryManagement);
    }

    @Override
    public List<DynamicManagement> selectDynamicManagementByTypeZCDT() {
        return indexMapper.selectDynamicManagementByTypeZCDT();
    }

    @Override
    public List<RegionalDataMaintenance> selectAllRegionList() {
        return indexMapper.selectAllRegionList();
    }

    @Override
    public List<DynamicManagement> selectDynamicManagementByZCDTClick(DynamicManagement dynamicManagement) {
        return indexMapper.selectDynamicManagementByZCDTClick(dynamicManagement);
    }

    @Override
    public Integer selectDynamicManagementByZCDTClickCounts(DynamicManagement dynamicManagement) {
        return indexMapper.selectDynamicManagementByZCDTClickCounts(dynamicManagement);
    }

    @Override
    public List<Integer> selectDemonstrationBaseManagementByBaseName(String name){
        return indexMapper.selectDemonstrationBaseManagementByBaseName(name);
    }

    @Override
    public List<IndustryDataMaintenance> selectAllIndustryList() {
        return indexMapper.selectAllIndustryList();
    }

    @Override
    public List<EntrepreneurshipGroupMaintenance> selectAllEntrepreneurshipGroupMaintenanceList() {
        return indexMapper.selectAllEntrepreneurshipGroupMaintenanceList();
    }

    @Override
    public List<PolicyClassificationMaintenance> selectAllPolicyClassificationMaintenance() {
        return indexMapper.selectAllPolicyClassificationMaintenance();
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByZCCXClick(PolicyIssued policyIssued) {
        return indexMapper.selectPolicyIssuedByZCCXClick(policyIssued);
    }

    @Override
    public Integer selectPolicyIssuedByZCCXClickCounts(PolicyIssued policyIssued) {
        return indexMapper.selectPolicyIssuedByZCCXClickCounts(policyIssued);
    }

    @Override
    public String selectRegionNameById(Integer id) {
        return indexMapper.selectRegionNameById(id);
    }

    @Override
    public String selectPolicyClassificationById(Integer id) {
        return indexMapper.selectPolicyClassificationById(id);
    }

    @Override
    public String selectBusinessPeopleById(Integer id) {
        return indexMapper.selectBusinessPeopleById(id);
    }

    @Override
    public String selectIndustryById(Integer id) {
        return indexMapper.selectIndustryById(id);
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByWeeklyPageView() {
        return indexMapper.selectPolicyIssuedByWeeklyPageView();
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByMonthlyPageView() {
        return indexMapper.selectPolicyIssuedByMonthlyPageView();
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByQuarterPageView() {
        return indexMapper.selectPolicyIssuedByQuarterPageView();
    }

    @Override
    public List<PolicyIssued> selectPolicyIssuedByAnnualPageView() {
        return indexMapper.selectPolicyIssuedByAnnualPageView();
    }

    @Override
    public List<DynamicManagement> getDynamicManagementInfoById(Integer id) {
        return indexMapper.getDynamicManagementInfoById(id);
    }

    @Override
    public List<PolicyIssued> getPolicyIssuedInfoById(Integer id) {
        return indexMapper.getPolicyIssuedInfoById(id);
    }

    @Override
    public Integer getDynamicManagementPageViewsById(Integer id) {
        return indexMapper.getDynamicManagementPageViewsById(id);
    }

    @Override
    public void updateDynamicManagementPageViewsById(DynamicManagement dynamicManagement) {
        indexMapper.updateDynamicManagementPageViewsById(dynamicManagement);
    }

    @Override
    public Integer getPolicyIssuedPageViewsById(Integer id) {
        return indexMapper.getPolicyIssuedPageViewsById(id);
    }

    @Override
    public void updatePolicyIssuedPageViewsById(PolicyIssued policyIssued) {
        indexMapper.updatePolicyIssuedPageViewsById(policyIssued);
    }

    @Override
    public List<PolicyIssued> getAllPolicyIssuedInfo() {
        return indexMapper.getAllPolicyIssuedInfo();
    }

    @Override
    public void updatePolicyIssuedWeeklyPageView(Integer id) {
        indexMapper.updatePolicyIssuedWeeklyPageView(id);
    }

    @Override
    public void updatePolicyIssuedMonthlyPageView(Integer id) {
        indexMapper.updatePolicyIssuedMonthlyPageView(id);
    }

    @Override
    public void updatePolicyIssuedQuarterPageView(Integer id) {
        indexMapper.updatePolicyIssuedQuarterPageView(id);
    }

    @Override
    public void updatePolicyIssuedAnnualPageView(Integer id) {
        indexMapper.updatePolicyIssuedAnnualPageView(id);
    }
}

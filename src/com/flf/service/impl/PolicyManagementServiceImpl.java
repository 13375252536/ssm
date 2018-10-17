package com.flf.service.impl;

import com.flf.entity.OrganizationManagement;
import com.flf.entity.homePage.EntrepreneurshipGroupMaintenance;
import com.flf.entity.policyManagement.*;
import com.flf.mapper.PolicyManagementMapper;
import com.flf.service.PolicyManagementService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: PolicyManagementServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/10 11:05
 * @Version: 1.0
 */
public class PolicyManagementServiceImpl implements PolicyManagementService {
    private PolicyManagementMapper policyManagementMapper;

    public PolicyManagementMapper getPolicyManagementMapper() {
        return policyManagementMapper;
    }

    public void setPolicyManagementMapper(PolicyManagementMapper policyManagementMapper) {
        this.policyManagementMapper = policyManagementMapper;
    }

    @Override
    public List<EcosystemMaintenance> listPageEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance) {
        return policyManagementMapper.listPageEcosystemMaintenance(ecosystemMaintenance);
    }

    @Override
    public void deleteEcosystemMaintenance(Integer[] chk_value) {
        policyManagementMapper.deleteEcosystemMaintenance(chk_value);
    }

    @Override
    public void insertEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance) {
        policyManagementMapper.insertEcosystemMaintenance(ecosystemMaintenance);
    }

    @Override
    public void updateEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance) {
        policyManagementMapper.updateEcosystemMaintenance(ecosystemMaintenance);
    }

    @Override
    public EcosystemMaintenance selectEcosystemMaintenanceById(int id) {
        return policyManagementMapper.selectEcosystemMaintenanceById(id);
    }

    @Override
    public List<EcosystemMaintenance> selectEcosystemMaintenanceByName(EcosystemMaintenance ecosystemMaintenance) {
        return policyManagementMapper.selectEcosystemMaintenanceByName(ecosystemMaintenance);
    }

    @Override
    public List<TimelineMaintenance> listPageTimelineMaintenance(TimelineMaintenance timelineMaintenance) {
        return policyManagementMapper.listPageTimelineMaintenance(timelineMaintenance);
    }

    @Override
    public void deleteTimelineMaintenance(Integer[] chk_value) {
        policyManagementMapper.deleteTimelineMaintenance(chk_value);
    }

    @Override
    public void insertTimelineMaintenance(TimelineMaintenance timelineMaintenance) {
        policyManagementMapper.insertTimelineMaintenance(timelineMaintenance);
    }

    @Override
    public void updateTimelineMaintenance(TimelineMaintenance timelineMaintenance) {
        policyManagementMapper.updateTimelineMaintenance(timelineMaintenance);
    }

    @Override
    public TimelineMaintenance selectTimelineMaintenanceById(int id) {
        return policyManagementMapper.selectTimelineMaintenanceById(id);
    }

    @Override
    public List<TimelineMaintenance> selectTimelineMaintenanceByName(TimelineMaintenance timelineMaintenance) {
        return policyManagementMapper.selectTimelineMaintenanceByName(timelineMaintenance);
    }

    @Override
    public List<IndustryDataMaintenance> listPageIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance) {
        return policyManagementMapper.listPageIndustryDataMaintenance(industryDataMaintenance);
    }

    @Override
    public void deleteIndustryDataMaintenance(Integer[] chk_value) {
        policyManagementMapper.deleteIndustryDataMaintenance(chk_value);
    }

    @Override
    public void insertIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance) {
        policyManagementMapper.insertIndustryDataMaintenance(industryDataMaintenance);
    }

    @Override
    public void updateIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance) {
        policyManagementMapper.updateIndustryDataMaintenance(industryDataMaintenance);
    }

    @Override
    public IndustryDataMaintenance selectIndustryDataMaintenanceById(int id) {
        return policyManagementMapper.selectIndustryDataMaintenanceById(id);
    }

    @Override
    public List<IndustryDataMaintenance> selectIndustryDataMaintenanceByName(IndustryDataMaintenance industryDataMaintenance) {
        return policyManagementMapper.selectIndustryDataMaintenanceByName(industryDataMaintenance);
    }

    @Override
    public List<RegionalDataMaintenance> listPageRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance) {
        return policyManagementMapper.listPageRegionalDataMaintenance(regionalDataMaintenance);
    }

    @Override
    public void deleteRegionalDataMaintenance(Integer[] chk_value) {
        policyManagementMapper.deleteRegionalDataMaintenance(chk_value);
    }

    @Override
    public void insertRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance) {
        policyManagementMapper.insertRegionalDataMaintenance(regionalDataMaintenance);
    }

    @Override
    public void updateRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance) {
        policyManagementMapper.updateRegionalDataMaintenance(regionalDataMaintenance);
    }

    @Override
    public List<Map<String, Object>> selectRegionalDataMaintenanceById(int id) {
        return policyManagementMapper.selectRegionalDataMaintenanceById(id);
    }

    @Override
    public List<RegionalDataMaintenance> selectNameCheckInfo(RegionalDataMaintenance regionalDataMaintenance) {
        return policyManagementMapper.selectNameCheckInfo(regionalDataMaintenance);
    }

    @Override
    public List<SubjectClassificationMaintenance> listPageSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance) {
        return policyManagementMapper.listPageSubjectClassificationMaintenance(subjectClassificationMaintenance);
    }

    @Override
    public void deleteSubjectClassificationMaintenance(Integer[] chk_value) {
        policyManagementMapper.deleteSubjectClassificationMaintenance(chk_value);
    }

    @Override
    public void insertSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance) {
        policyManagementMapper.insertSubjectClassificationMaintenance(subjectClassificationMaintenance);
    }

    @Override
    public void updateSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance) {
        policyManagementMapper.updateSubjectClassificationMaintenance(subjectClassificationMaintenance);
    }

    @Override
    public SubjectClassificationMaintenance selectSubjectClassificationMaintenanceById(int id) {
        return policyManagementMapper.selectSubjectClassificationMaintenanceById(id);
    }

    @Override
    public List<SubjectClassificationMaintenance> selectSubjectClassificationMaintenanceByName(SubjectClassificationMaintenance subjectClassificationMaintenance) {
        return policyManagementMapper.selectSubjectClassificationMaintenanceByName(subjectClassificationMaintenance);
    }

    @Override
    public List<PolicyClassificationMaintenance> listPagePolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance) {
        return policyManagementMapper.listPagePolicyClassificationMaintenance(policyClassificationMaintenance);
    }

    @Override
    public void deletePolicyClassificationMaintenance(Integer[] chk_value) {
        policyManagementMapper.deletePolicyClassificationMaintenance(chk_value);
    }

    @Override
    public void insertPolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance) {
        policyManagementMapper.insertPolicyClassificationMaintenance(policyClassificationMaintenance);
    }

    @Override
    public void updatePolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance) {
        policyManagementMapper.updatePolicyClassificationMaintenance(policyClassificationMaintenance);
    }

    @Override
    public PolicyClassificationMaintenance selectPolicyClassificationMaintenanceById(int id) {
        return policyManagementMapper.selectPolicyClassificationMaintenanceById(id);
    }

    @Override
    public List<PolicyClassificationMaintenance> selectPolicyClassificationMaintenanceByName(PolicyClassificationMaintenance policyClassificationMaintenance) {
        return policyManagementMapper.selectPolicyClassificationMaintenanceByName(policyClassificationMaintenance);
    }

    @Override
    public List<IndustrialParkRecommendation> listPageIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation) {
        return policyManagementMapper.listPageIndustrialParkRecommendation(industrialParkRecommendation);
    }

    @Override
    public void deleteIndustrialParkRecommendation(Integer[] chk_value) {
        policyManagementMapper.deleteIndustrialParkRecommendation(chk_value);
    }

    @Override
    public void updateIndustrialParkRecommendationPlacedTop(Integer[] chk_value) {
        policyManagementMapper.updateIndustrialParkRecommendationPlacedTop(chk_value);
    }

    @Override
    public void updateIndustrialParkRecommendationCancelPlacedTop(Integer[] chk_value) {
        policyManagementMapper.updateIndustrialParkRecommendationCancelPlacedTop(chk_value);
    }

    @Override
    public void insertIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation) {
        policyManagementMapper.insertIndustrialParkRecommendation(industrialParkRecommendation);
    }

    @Override
    public void updateIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation) {
        policyManagementMapper.updateIndustrialParkRecommendation(industrialParkRecommendation);
    }

    @Override
    public IndustrialParkRecommendation selectIndustrialParkRecommendationById(Integer id) {
        return policyManagementMapper.selectIndustrialParkRecommendationById(id);
    }

    @Override
    public List<IndustrialParkRecommendation> selectIndustrialParkRecommendationByName(IndustrialParkRecommendation industrialParkRecommendation) {
        return policyManagementMapper.selectIndustrialParkRecommendationByName(industrialParkRecommendation);
    }

    @Override
    public List<PolicyIssued> listPagePolicyIssued(PolicyIssued policyIssued) {
        return policyManagementMapper.listPagePolicyIssued(policyIssued);
    }

    @Override
    public void deletePolicyIssued(Integer[] chk_value) {
        policyManagementMapper.deletePolicyIssued(chk_value);
    }

    @Override
    public void updatePolicyIssuedPlacedTop(Integer[] chk_value) {
        policyManagementMapper.updatePolicyIssuedPlacedTop(chk_value);
    }

    @Override
    public void updatePolicyIssuedCancelPlacedTop(Integer[] chk_value) {
        policyManagementMapper.updatePolicyIssuedCancelPlacedTop(chk_value);
    }

    @Override
    public void updatePolicyIssuedCancelReportMarks(Integer[] chk_value) {
        policyManagementMapper.updatePolicyIssuedCancelReportMarks(chk_value);
    }

    @Override
    public void insertPolicyIssued(PolicyIssued policyIssued) {
        policyManagementMapper.insertPolicyIssued(policyIssued);
    }

    @Override
    public void updatePolicyIssued(PolicyIssued policyIssued) {
        policyManagementMapper.updatePolicyIssued(policyIssued);
    }

    @Override
    public PolicyIssued selectPolicyIssuedById(int id) {
        return policyManagementMapper.selectPolicyIssuedById(id);
    }

    @Override
    public List<OrganizationManagement> selectReportUnit() {
        return policyManagementMapper.selectReportUnit();
    }

    @Override
    public List<RegionalDataMaintenance> selectRegion() {
        return policyManagementMapper.selectRegion();
    }

    @Override
    public List<EcosystemMaintenance> selectEcosphereKeyword() {
        return policyManagementMapper.selectEcosphereKeyword();
    }

    @Override
    public List<SubjectClassificationMaintenance> selectPolicyTheme() {
        return policyManagementMapper.selectPolicyTheme();
    }

    @Override
    public List<TimelineMaintenance> selectTimelinePhase() {
        return policyManagementMapper.selectTimelinePhase();
    }

    @Override
    public List<EntrepreneurshipGroupMaintenance> selectBusinessPeople() {
        return policyManagementMapper.selectBusinessPeople();
    }

    @Override
    public List<PolicyClassificationMaintenance> selectPolicyClassification() {
        return policyManagementMapper.selectPolicyClassification();
    }

    @Override
    public List<IndustryDataMaintenance> selectIndustry() {
        return policyManagementMapper.selectIndustry();
    }

    @Override
    public List<Integer> selectPolicyIssuedIdByName(String name) {
        return policyManagementMapper.selectPolicyIssuedIdByName(name);
    }
}

package com.flf.service.impl;

import com.flf.entity.*;
import com.flf.entity.demonstrationBase.DemonstrationBaseManagement;
import com.flf.entity.homePage.*;
import com.flf.entity.policyManagement.RegionalDataMaintenance;
import com.flf.mapper.HomePageMapper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: HomePageMapper
 * @Description: //TODO  首页的service层
 * @Author: Mr.Chan
 * @Data: 2018/8/28 11:51
 * @Version: 1.0
 */
public class HomePageServiceImpl implements com.flf.service.HomePageService {

    private HomePageMapper homePageMapper;

    public HomePageMapper getHomePageMapper() {
        return homePageMapper;
    }

    public void setHomePageMapper(HomePageMapper homePageMapper) {
        this.homePageMapper = homePageMapper;
    }

    @Override
    public void updateQrCodeManagement(QrCodeManagement qrCodeManagement) {
        homePageMapper.updateQrCodeManagement(qrCodeManagement);
    }

    @Override
    public Map<String, String> uploadFile(MultipartFile file, HttpServletRequest req) {
        String path = "D:\\Subversion\\ssm\\WebRoot\\uploadFiles\\uploadImgs";
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID() + "_" + fileName;
        File newFile = new File(path, fileName);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("fileUrl", fileName);
        return map;
    }

    @Override
    public String selectURLByWeiBo() {
        return homePageMapper.selectURLByWeiBo();
    }

    @Override
    public String selectURLByWeiXin() {
        return homePageMapper.selectURLByWeiXin();
    }

    @Override
    public List<ImageManagement> listPageImageManagement(ImageManagement imageManagement) {
        return homePageMapper.listPageImageManagement(imageManagement);
    }

    @Override
    public void deleteImageManagement(Integer[] chk_value) {
        homePageMapper.deleteImageManagement(chk_value);
    }

    @Override
    public void insertImageManagement(ImageManagement imageManagement) {
        homePageMapper.insertImageManagement(imageManagement);
    }

    @Override
    public void updateImageManagement(ImageManagement imageManagement) {
        homePageMapper.updateImageManagement(imageManagement);
    }

    @Override
    public List<Map<String, Object>> selectImageManagementById(Integer id) {
        List<Map<String, Object>> mapList = homePageMapper.selectImageManagementById(id);
        return mapList;
    }

    @Override
    public void updateImageManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateImageManagementPlacedTop(chk_value);
    }

    @Override
    public void updateImageManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateImageManagementCancelPlacedTop(chk_value);
    }

    @Override
    public List<EntrepreneurshipGroupMaintenance> listPageEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance) {
        List<EntrepreneurshipGroupMaintenance> list = homePageMapper.listPageEntrepreneurshipGroupMaintenance(entrepreneurshipGroupMaintenance);
        return list;
    }

    @Override
    public void deleteEntrepreneurshipGroupMaintenance(Integer[] chk_value) {
        homePageMapper.deleteEntrepreneurshipGroupMaintenance(chk_value);
    }

    @Override
    public void updateEntrepreneurshipGroupMaintenancePlacedTop(Integer[] chk_value) {
        homePageMapper.updateEntrepreneurshipGroupMaintenancePlacedTop(chk_value);
    }

    @Override
    public void updateEntrepreneurshipGroupMaintenanceCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateEntrepreneurshipGroupMaintenanceCancelPlacedTop(chk_value);
    }

    @Override
    public void insertEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance) {
        homePageMapper.insertEntrepreneurshipGroupMaintenance(entrepreneurshipGroupMaintenance);
    }

    @Override
    public void updateEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance) {
        homePageMapper.updateEntrepreneurshipGroupMaintenance(entrepreneurshipGroupMaintenance);
    }

    @Override
    public List<Map<String, Object>> selectEntrepreneurshipGroupMaintenanceById(Integer id) {
        List<Map<String, Object>> mapList = homePageMapper.selectEntrepreneurshipGroupMaintenanceById(id);
        return mapList;
    }

    @Override
    public List<EntrepreneurshipGroupMaintenance> selectEntrepreneurshipGroupMaintenanceByName(String name) {
        return homePageMapper.selectEntrepreneurshipGroupMaintenanceByName(name);
    }

    @Override
    public List<FinancialPositionManagement> listPageFinancialPositionManagement(FinancialPositionManagement financialPositionManagement) {
        return homePageMapper.listPageFinancialPositionManagement(financialPositionManagement);
    }

    @Override
    public void deleteFinancialPositionManagement(Integer[] chk_value) {
        homePageMapper.deleteFinancialPositionManagement(chk_value);
    }

    @Override
    public void updateFinancialPositionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateFinancialPositionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateFinancialPositionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateFinancialPositionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public List<Map<String, Object>> selectFinancialPositionManagementById(Integer id) {
        List<Map<String, Object>> mapList = homePageMapper.selectFinancialPositionManagementById(id);
        return mapList;
    }

    @Override
    public void insertFinancialPositionManagement(FinancialPositionManagement financialPositionManagement) {
        homePageMapper.insertFinancialPositionManagement(financialPositionManagement);
    }

    @Override
    public void updateFinancialPositionManagement(FinancialPositionManagement financialPositionManagement) {
        homePageMapper.updateFinancialPositionManagement(financialPositionManagement);
    }

    @Override
    public List<FinancialAdvisoryManagement> listPageFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement) {
        return homePageMapper.listPageFinancialAdvisoryManagement(financialAdvisoryManagement);
    }

    @Override
    public void deleteFinancialAdvisoryManagement(Integer[] chk_value) {
        homePageMapper.deleteFinancialAdvisoryManagement(chk_value);
    }

    @Override
    public void updateFinancialAdvisoryManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateFinancialAdvisoryManagementPlacedTop(chk_value);
    }

    @Override
    public void updateFinancialAdvisoryManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateFinancialAdvisoryManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement) {
        homePageMapper.insertFinancialAdvisoryManagement(financialAdvisoryManagement);
    }

    @Override
    public void updateFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement) {
        homePageMapper.updateFinancialAdvisoryManagement(financialAdvisoryManagement);
    }

    @Override
    public List<Map<String, Object>> selectFinancialAdvisoryManagementById(Integer id) {
        List<Map<String, Object>> mapList = homePageMapper.selectFinancialAdvisoryManagementById(id);
        return mapList;
    }

    @Override
    public List<FinancialInstitutionManagement> listPageFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement) {
        List<FinancialInstitutionManagement> listPageFinancialInstitutionManagement = homePageMapper.listPageFinancialInstitutionManagement(financialInstitutionManagement);
        return listPageFinancialInstitutionManagement;
    }

    @Override
    public void deleteFinancialInstitutionManagement(Integer[] chk_value) {
        homePageMapper.deleteFinancialInstitutionManagement(chk_value);
    }

    @Override
    public void updateFinancialInstitutionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateFinancialInstitutionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateFinancialInstitutionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateFinancialInstitutionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement) {
        homePageMapper.insertFinancialInstitutionManagement(financialInstitutionManagement);
    }

    @Override
    public void updateFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement) {
        homePageMapper.updateFinancialInstitutionManagement(financialInstitutionManagement);
    }

    @Override
    public List<Map<String, Object>> selectFinancialInstitutionManagementById(Integer id) {
        return homePageMapper.selectFinancialInstitutionManagementById(id);
    }

    @Override
    public List<TechnicalPositionManagement> listPageTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement) {
        return homePageMapper.listPageTechnicalPositionManagement(technicalPositionManagement);
    }

    @Override
    public void deleteTechnicalPositionManagement(Integer[] chk_value) {
        homePageMapper.deleteTechnicalPositionManagement(chk_value);
    }

    @Override
    public void updateTechnicalPositionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTechnicalPositionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateTechnicalPositionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTechnicalPositionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public List<Map<String, Object>> selectTechnicalPositionManagementById(Integer id) {
        return homePageMapper.selectTechnicalPositionManagementById(id);
    }

    @Override
    public void insertTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement) {
        homePageMapper.insertTechnicalPositionManagement(technicalPositionManagement);
    }

    @Override
    public void updateTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement) {
        homePageMapper.updateTechnicalPositionManagement(technicalPositionManagement);
    }

    @Override
    public List<TechnicalAdvisoryManagement> listPageTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement) {
        return homePageMapper.listPageTechnicalAdvisoryManagement(technicalAdvisoryManagement);
    }

    @Override
    public void deleteTechnicalAdvisoryManagement(Integer[] chk_value) {
        homePageMapper.deleteTechnicalAdvisoryManagement(chk_value);
    }

    @Override
    public void updateTechnicalAdvisoryManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTechnicalAdvisoryManagementPlacedTop(chk_value);
    }

    @Override
    public void updateTechnicalAdvisoryManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTechnicalAdvisoryManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement) {
        homePageMapper.insertTechnicalAdvisoryManagement(technicalAdvisoryManagement);
    }

    @Override
    public void updateTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement) {
        homePageMapper.updateTechnicalAdvisoryManagement(technicalAdvisoryManagement);
    }

    @Override
    public List<Map<String, Object>> selectTechnicalAdvisoryManagementById(Integer id) {
        return homePageMapper.selectTechnicalAdvisoryManagementById(id);
    }

    //    _______________________________________
    @Override
    public List<TechnicalInstitutionManagement> listPageTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement) {

        return homePageMapper.listPageTechnicalInstitutionManagement(technicalInstitutionManagement);
    }

    @Override
    public void deleteTechnicalInstitutionManagement(Integer[] chk_value) {
        homePageMapper.deleteTechnicalInstitutionManagement(chk_value);
    }

    @Override
    public void updateTechnicalInstitutionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTechnicalInstitutionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateTechnicalInstitutionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTechnicalInstitutionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement) {
        homePageMapper.insertTechnicalInstitutionManagement(technicalInstitutionManagement);
    }

    @Override
    public void updateTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement) {
        homePageMapper.updateTechnicalInstitutionManagement(technicalInstitutionManagement);
    }

    @Override
    public List<Map<String, Object>> selectTechnicalInstitutionManagementById(Integer id) {
        return homePageMapper.selectTechnicalInstitutionManagementById(id);
    }

//    _________________________________


    @Override
    public List<TalentPositionManagement> listPageTalentPositionManagement(TalentPositionManagement talentPositionManagement) {
        return homePageMapper.listPageTalentPositionManagement(talentPositionManagement);
    }

    @Override
    public void deleteTalentPositionManagement(Integer[] chk_value) {
        homePageMapper.deleteTalentPositionManagement(chk_value);
    }

    @Override
    public void updateTalentPositionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTalentPositionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateTalentPositionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTalentPositionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public List<Map<String, Object>> selectTalentPositionManagementById(Integer id) {
        return homePageMapper.selectTalentPositionManagementById(id);
    }

    @Override
    public void insertTalentPositionManagement(TalentPositionManagement talentPositionManagement) {
        homePageMapper.insertTalentPositionManagement(talentPositionManagement);
    }

    @Override
    public void updateTalentPositionManagement(TalentPositionManagement talentPositionManagement) {
        homePageMapper.updateTalentPositionManagement(talentPositionManagement);
    }

    @Override
    public List<TalentAdvisoryManagement> listPageTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement) {
        return homePageMapper.listPageTalentAdvisoryManagement(talentAdvisoryManagement);
    }

    @Override
    public void deleteTalentAdvisoryManagement(Integer[] chk_value) {
        homePageMapper.deleteTalentAdvisoryManagement(chk_value);
    }

    @Override
    public void updateTalentAdvisoryManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTalentAdvisoryManagementPlacedTop(chk_value);
    }

    @Override
    public void updateTalentAdvisoryManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTalentAdvisoryManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement) {
        homePageMapper.insertTalentAdvisoryManagement(talentAdvisoryManagement);
    }

    @Override
    public void updateTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement) {
        homePageMapper.updateTalentAdvisoryManagement(talentAdvisoryManagement);
    }

    @Override
    public List<Map<String, Object>> selectTalentAdvisoryManagementById(Integer id) {
        return homePageMapper.selectTalentAdvisoryManagementById(id);
    }

    //    _______________________________________
    @Override
    public List<TalentInstitutionManagement> listPageTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement) {

        return homePageMapper.listPageTalentInstitutionManagement(talentInstitutionManagement);
    }

    @Override
    public void deleteTalentInstitutionManagement(Integer[] chk_value) {
        homePageMapper.deleteTalentInstitutionManagement(chk_value);
    }

    @Override
    public void updateTalentInstitutionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTalentInstitutionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateTalentInstitutionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateTalentInstitutionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement) {
        homePageMapper.insertTalentInstitutionManagement(talentInstitutionManagement);
    }

    @Override
    public void updateTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement) {
        homePageMapper.updateTalentInstitutionManagement(talentInstitutionManagement);
    }

    @Override
    public List<Map<String, Object>> selectTalentInstitutionManagementById(Integer id) {
        return homePageMapper.selectTalentInstitutionManagementById(id);
    }


//    ____________________123_____________________


    @Override
    public List<SitePositionManagement> listPageSitePositionManagement(SitePositionManagement sitePositionManagement) {
        return homePageMapper.listPageSitePositionManagement(sitePositionManagement);
    }

    @Override
    public void deleteSitePositionManagement(Integer[] chk_value) {
        homePageMapper.deleteSitePositionManagement(chk_value);
    }

    @Override
    public void updateSitePositionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateSitePositionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateSitePositionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateSitePositionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public List<Map<String, Object>> selectSitePositionManagementById(Integer id) {
        return homePageMapper.selectSitePositionManagementById(id);
    }

    @Override
    public void insertSitePositionManagement(SitePositionManagement sitePositionManagement) {
        homePageMapper.insertSitePositionManagement(sitePositionManagement);
    }

    @Override
    public void updateSitePositionManagement(SitePositionManagement sitePositionManagement) {
        homePageMapper.updateSitePositionManagement(sitePositionManagement);
    }

    @Override
    public List<SiteAdvisoryManagement> listPageSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement) {
        return homePageMapper.listPageSiteAdvisoryManagement(siteAdvisoryManagement);
    }

    @Override
    public void deleteSiteAdvisoryManagement(Integer[] chk_value) {
        homePageMapper.deleteSiteAdvisoryManagement(chk_value);
    }

    @Override
    public void updateSiteAdvisoryManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateSiteAdvisoryManagementPlacedTop(chk_value);
    }

    @Override
    public void updateSiteAdvisoryManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateSiteAdvisoryManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement) {
        homePageMapper.insertSiteAdvisoryManagement(siteAdvisoryManagement);
    }

    @Override
    public void updateSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement) {
        homePageMapper.updateSiteAdvisoryManagement(siteAdvisoryManagement);
    }

    @Override
    public List<Map<String, Object>> selectSiteAdvisoryManagementById(Integer id) {
        return homePageMapper.selectSiteAdvisoryManagementById(id);
    }

    //    _______________________________________
    @Override
    public List<SiteInstitutionManagement> listPageSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement) {

        return homePageMapper.listPageSiteInstitutionManagement(siteInstitutionManagement);
    }

    @Override
    public void deleteSiteInstitutionManagement(Integer[] chk_value) {
        homePageMapper.deleteSiteInstitutionManagement(chk_value);
    }

    @Override
    public void updateSiteInstitutionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateSiteInstitutionManagementPlacedTop(chk_value);
    }

    @Override
    public void updateSiteInstitutionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateSiteInstitutionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement) {
        homePageMapper.insertSiteInstitutionManagement(siteInstitutionManagement);
    }

    @Override
    public void updateSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement) {
        homePageMapper.updateSiteInstitutionManagement(siteInstitutionManagement);
    }

    @Override
    public List<Map<String, Object>> selectSiteInstitutionManagementById(Integer id) {
        return homePageMapper.selectSiteInstitutionManagementById(id);
    }


    @Override
    public List<PositionManagement> listPagePositionManagement(PositionManagement positionManagement) {
        return homePageMapper.listPagePositionManagement(positionManagement);
    }

    @Override
    public void deletePositionManagement(Integer[] chk_value) {
        homePageMapper.deletePositionManagement(chk_value);
    }

    @Override
    public void updatePositionManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updatePositionManagementPlacedTop(chk_value);
    }

    @Override
    public void updatePositionManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updatePositionManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertPositionManagement(PositionManagement positionManagement) {
        homePageMapper.insertPositionManagement(positionManagement);
    }

    @Override
    public void updatePositionManagement(PositionManagement positionManagement) {
        homePageMapper.updatePositionManagement(positionManagement);
    }

    @Override
    public List<Map<String, Object>> selectPositionManagementById(Integer id) {
        return homePageMapper.selectPositionManagementById(id);
    }

    @Override
    public List<ResultsShowManagement> listPageResultsShowManagement(ResultsShowManagement resultsShowManagement) {
        return homePageMapper.listPageResultsShowManagement(resultsShowManagement);
    }

    @Override
    public void deleteResultsShowManagement(Integer[] chk_value) {
        homePageMapper.deleteResultsShowManagement(chk_value);
    }

    @Override
    public void updateResultsShowManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateResultsShowManagementPlacedTop(chk_value);
    }

    @Override
    public void updateResultsShowManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateResultsShowManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void updateResultsShowManagementReleaseMarks(Integer[] chk_value) {
        homePageMapper.updateResultsShowManagementReleaseMarks(chk_value);
    }

    @Override
    public void updateResultsShowManagementCancelReleaseMarks(Integer[] chk_value) {
        homePageMapper.updateResultsShowManagementCancelReleaseMarks(chk_value);
    }

    @Override
    public void insertResultsShowManagement(ResultsShowManagement resultsShowManagement) {
        homePageMapper.insertResultsShowManagement(resultsShowManagement);
    }

    @Override
    public void updateResultsShowManagement(ResultsShowManagement resultsShowManagement) {
        homePageMapper.updateResultsShowManagement(resultsShowManagement);
    }

    @Override
    public List<Map<String, Object>> selectResultsShowManagementById(Integer id) {
        return homePageMapper.selectResultsShowManagementById(id);
    }


    @Override
    public List<DynamicManagement> listPageDynamicManagement(DynamicManagement dynamicManagement) {
        return homePageMapper.listPageDynamicManagement(dynamicManagement);
    }

    @Override
    public void deleteDynamicManagement(Integer[] chk_value) {
        homePageMapper.deleteDynamicManagement(chk_value);
    }

    @Override
    public void updateDynamicManagementPlacedTop(Integer[] chk_value) {
        homePageMapper.updateDynamicManagementPlacedTop(chk_value);
    }

    @Override
    public void updateDynamicManagementCancelPlacedTop(Integer[] chk_value) {
        homePageMapper.updateDynamicManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void updateDynamicManagementReleaseMarks(Integer[] chk_value) {
        homePageMapper.updateDynamicManagementReleaseMarks(chk_value);
    }

    @Override
    public void updateDynamicManagementCancelReleaseMarks(Integer[] chk_value) {
        homePageMapper.updateDynamicManagementCancelReleaseMarks(chk_value);
    }

    @Override
    public void insertDynamicManagement(DynamicManagement dynamicManagement) {
        homePageMapper.insertDynamicManagement(dynamicManagement);
    }

    @Override
    public void updateDynamicManagement(DynamicManagement dynamicManagement) {
        homePageMapper.updateDynamicManagement(dynamicManagement);
    }

    @Override
    public DynamicManagement selectDynamicManagementById(Integer id) {
        return homePageMapper.selectDynamicManagementById(id);
    }

    @Override
    public List<OrganizationManagement> selectOrganizationInfo() {
        return homePageMapper.selectOrganizationInfo();
    }

    @Override
    public List<DemonstrationBaseManagement> selectBaseInfo() {
        return homePageMapper.selectBaseInfo();
    }

    @Override
    public List<DemonstrationBaseManagement> selectBaseIdByRegionId(Integer region) {
        return homePageMapper.selectBaseIdByRegionId(region);
    }

    @Override
    public RegionalDataMaintenance selectRegionIdByBaseId(Integer base) {
        return homePageMapper.selectRegionIdByBaseId(base);
    }

    @Override
    public List<Integer> selectDynamicManagementIdByName(String name) {
        return homePageMapper.selectDynamicManagementIdByName(name);
    }
}

package com.flf.service;

import com.flf.entity.*;
import com.flf.entity.demonstrationBase.DemonstrationBaseManagement;
import com.flf.entity.homePage.*;
import com.flf.entity.policyManagement.RegionalDataMaintenance;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HomePageMapper
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/8/28 11:50
 * @Version: 1.0
 */
public interface HomePageService {
    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改二维码信息
     * @Date 2018/8/28 11:53
     * @Param [qrCodeManagement]
     */
    void updateQrCodeManagement(QrCodeManagement qrCodeManagement);

    /**
     * @return java.util.Map<java.lang.String       ,       java.lang.String>
     * @Author Mr.Chan
     * @Description //TODO  上传图片的方法 返回该文件文件名的Map集
     * @Date 2018/8/28 18:57
     * @Param [file, req]
     */
    Map<String, String> uploadFile(MultipartFile file, HttpServletRequest req);

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  通过"微博"查询url地址
     * @Date 2018/8/28 18:59
     * @Param []
     */
    String selectURLByWeiBo();

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  通过"微信"查询url地址
     * @Date 2018/8/28 18:59
     * @Param []
     */
    String selectURLByWeiXin();

    /**
     * @return java.util.List<com.flf.entity.homePage.ImageManagement>
     * @Author Mr.Chan
     * @Description //TODO  图片管理中查询
     * @Date 2018/8/29 11:39
     * @Param []
     */
    List<ImageManagement> listPageImageManagement(ImageManagement imageManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   通过id删除图片管理中的记录
     * @Date 2018/8/29 12:56
     * @Param [id]
     */
    void deleteImageManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   添加图片管理信息
     * @Date 2018/8/29 13:15
     * @Param [imageManagement]
     */
    void insertImageManagement(ImageManagement imageManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改图片管理信息
     * @Date 2018/8/30 10:07
     * @Param [imageManagement]
     */
    void updateImageManagement(ImageManagement imageManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询图片管理的全部信息
     * @Date 2018/8/30 15:25
     * @Param [id]
     */
    List<Map<String, Object>> selectImageManagementById(Integer id);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  批量置顶
     * @Date 2018/8/30 15:25
     * @Param [chk_value]
     */
    void updateImageManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  批量取消置顶
     * @Date 2018/8/30 15:26
     * @Param [chk_value]
     */
    void updateImageManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return java.util.List<com.flf.entity.homePage.EntrepreneurshipGroupMaintenance>
     * @Author Mr.Chan
     * @Description //TODO  遍历出创业群体维护的信息
     * @Date 2018/8/30 15:52
     * @Param [entrepreneurshipGroupMaintenance]
     */
    List<EntrepreneurshipGroupMaintenance> listPageEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除创业群体维护的信息
     * @Date 2018/9/4 9:44
     * @Param [chk_value]
     */
    void deleteEntrepreneurshipGroupMaintenance(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  创业群体维护的信息置顶
     * @Date 2018/9/4 9:45
     * @Param [chk_value]
     */
    void updateEntrepreneurshipGroupMaintenancePlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  创业群体维护的信息取消置顶
     * @Date 2018/9/4 9:45
     * @Param [chk_value]
     */
    void updateEntrepreneurshipGroupMaintenanceCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加创业群体维护的信息
     * @Date 2018/9/4 9:45
     * @Param [entrepreneurshipGroupMaintenance]
     */
    void insertEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   修改创业群体维护的信息
     * @Date 2018/9/4 9:45
     * @Param [entrepreneurshipGroupMaintenance]
     */
    void updateEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询创业群体维护的信息
     * @Date 2018/9/4 9:46
     * @Param [id]
     */
    List<Map<String, Object>> selectEntrepreneurshipGroupMaintenanceById(Integer id);

    /**
     * @Author Mr.Chan
     * @Description //TODO  通过name查询创业群体维护信息
     * @Date 2018/9/14 9:16
     * @Param [name]
     * @return java.util.List<com.flf.entity.homePage.EntrepreneurshipGroupMaintenance>
     */
    List<EntrepreneurshipGroupMaintenance> selectEntrepreneurshipGroupMaintenanceByName(String name);



    /**
     * @return java.util.List<com.flf.entity.homePage.FinancialPositionManagement>
     * @Author Mr.Chan
     * @Description //TODO   遍历金融宣传位管理信息
     * @Date 2018/9/4 9:46
     * @Param [financialPositionManagement]
     */
    List<FinancialPositionManagement> listPageFinancialPositionManagement(FinancialPositionManagement financialPositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除金融宣传位管理信息
     * @Date 2018/9/4 9:48
     * @Param [chk_value]
     */
    void deleteFinancialPositionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融宣传位管理信息置顶
     * @Date 2018/9/4 9:48
     * @Param [chk_value]
     */
    void updateFinancialPositionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融宣传位管理信息取消置顶
     * @Date 2018/9/4 9:48
     * @Param [chk_value]
     */
    void updateFinancialPositionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO   通过id查询金融宣传位管理信息
     * @Date 2018/9/4 9:48
     * @Param [id]
     */
    List<Map<String, Object>> selectFinancialPositionManagementById(Integer id);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加金融宣传位管理信息
     * @Date 2018/9/4 9:48
     * @Param [financialPositionManagement]
     */
    void insertFinancialPositionManagement(FinancialPositionManagement financialPositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   修改金融宣传位管理信息
     * @Date 2018/9/4 9:49
     * @Param [financialPositionManagement]
     */
    void updateFinancialPositionManagement(FinancialPositionManagement financialPositionManagement);

    /**
     * @return java.util.List<com.flf.entity.homePage.FinancialAdvisoryManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历金融咨询管理信息
     * @Date 2018/9/4 9:49
     * @Param [financialAdvisoryManagement]
     */
    List<FinancialAdvisoryManagement> listPageFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除金融咨询管理信息
     * @Date 2018/9/4 9:49
     * @Param [chk_value]
     */
    void deleteFinancialAdvisoryManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融咨询管理信息置顶
     * @Date 2018/9/4 9:49
     * @Param [chk_value]
     */
    void updateFinancialAdvisoryManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融咨询管理信息取消置顶
     * @Date 2018/9/4 9:50
     * @Param [chk_value]
     */
    void updateFinancialAdvisoryManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加金融咨询管理信息
     * @Date 2018/9/4 9:50
     * @Param [financialAdvisoryManagement]
     */
    void insertFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改金融咨询管理信息
     * @Date 2018/9/4 9:50
     * @Param [financialAdvisoryManagement]
     */
    void updateFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询金融咨询管理信息
     * @Date 2018/9/4 9:50
     * @Param [id]
     */
    List<Map<String, Object>> selectFinancialAdvisoryManagementById(Integer id);

    /**
     * @return java.util.List<com.flf.entity.homePage.FinancialInstitutionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历金融机构管理信息
     * @Date 2018/9/4 9:50
     * @Param [financialInstitutionManagement]
     */
    List<FinancialInstitutionManagement> listPageFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除金融机构管理信息
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void deleteFinancialInstitutionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融机构管理信息置顶
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void updateFinancialInstitutionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO 金融机构管理信息取消置顶
     * @Date 2018/9/4 9:57
     * @Param [chk_value]
     */
    void updateFinancialInstitutionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   添加金融机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [financialInstitutionManagement]
     */
    void insertFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改金融机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [financialInstitutionManagement]
     */
    void updateFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询金融机构管理信息
     * @Date 2018/9/4 10:24
     * @Param [id]
     */
    List<Map<String, Object>> selectFinancialInstitutionManagementById(Integer id);


    /**
     * @return java.util.List<com.flf.entity.homePage.SitePositionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历技术宣传位管理信息
     * @Date 2018/9/4 15:42
     * @Param [technicalPositionManagement]
     */
    List<TechnicalPositionManagement> listPageTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除技术宣传位管理信息
     * @Date 2018/9/4 15:42
     * @Param [chk_value]
     */
    void deleteTechnicalPositionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   技术宣传位管理信息置顶
     * @Date 2018/9/4 15:42
     * @Param [chk_value]
     */
    void updateTechnicalPositionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  技术宣传位管理信息取消置顶
     * @Date 2018/9/4 15:43
     * @Param [chk_value]
     */
    void updateTechnicalPositionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO   通过id查询技术宣传位管理信息
     * @Date 2018/9/4 15:45
     * @Param [id]
     */
    List<Map<String, Object>> selectTechnicalPositionManagementById(Integer id);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加技术宣传位管理信息
     * @Date 2018/9/4 15:46
     * @Param [technicalPositionManagement]
     */
    void insertTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改技术宣传位管理信息
     * @Date 2018/9/4 15:46
     * @Param [technicalPositionManagement]
     */
    void updateTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement);

    /**
     * @return java.util.List<com.flf.entity.homePage.SiteAdvisoryManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历技术咨询管理信息
     * @Date 2018/9/5 9:51
     * @Param [technicalAdvisoryManagement]
     */
    List<TechnicalAdvisoryManagement> listPageTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除技术咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void deleteTechnicalAdvisoryManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  技术咨询管理信息置顶
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void updateTechnicalAdvisoryManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  技术咨询管理信息取消置顶
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void updateTechnicalAdvisoryManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加技术咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [technicalAdvisoryManagement]
     */
    void insertTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改技术咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [technicalAdvisoryManagement]
     */
    void updateTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询技术咨询管理信息
     * @Date 2018/9/5 9:53
     * @Param [id]
     */
    List<Map<String, Object>> selectTechnicalAdvisoryManagementById(Integer id);
//----------------------------------

    /**
     * @return java.util.List<com.flf.entity.technicalInstitutionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历技术机构管理信息
     * @Date 2018/9/4 9:43
     * @Param [technicalInstitutionManagement]
     */
    List<TechnicalInstitutionManagement> listPageTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除技术机构管理信息
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void deleteTechnicalInstitutionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  技术机构管理信息置顶
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void updateTechnicalInstitutionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO 技术机构管理信息取消置顶
     * @Date 2018/9/4 9:57
     * @Param [chk_value]
     */
    void updateTechnicalInstitutionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   添加技术机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [technicalInstitutionManagement]
     */
    void insertTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改技术机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [technicalInstitutionManagement]
     */
    void updateTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询技术机构管理信息
     * @Date 2018/9/4 10:24
     * @Param [id]
     */
    List<Map<String, Object>> selectTechnicalInstitutionManagementById(Integer id);


//_____________________________________________


    /**
     * @return java.util.List<com.flf.entity.homePage.SitePositionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历人才宣传位管理信息
     * @Date 2018/9/4 15:42
     * @Param [talentPositionManagement]
     */
    List<TalentPositionManagement> listPageTalentPositionManagement(TalentPositionManagement talentPositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除人才宣传位管理信息
     * @Date 2018/9/4 15:42
     * @Param [chk_value]
     */
    void deleteTalentPositionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   人才宣传位管理信息置顶
     * @Date 2018/9/4 15:42
     * @Param [chk_value]
     */
    void updateTalentPositionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  人才宣传位管理信息取消置顶
     * @Date 2018/9/4 15:43
     * @Param [chk_value]
     */
    void updateTalentPositionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO   通过id查询人才宣传位管理信息
     * @Date 2018/9/4 15:45
     * @Param [id]
     */
    List<Map<String, Object>> selectTalentPositionManagementById(Integer id);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加人才宣传位管理信息
     * @Date 2018/9/4 15:46
     * @Param [talentPositionManagement]
     */
    void insertTalentPositionManagement(TalentPositionManagement talentPositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改人才宣传位管理信息
     * @Date 2018/9/4 15:46
     * @Param [talentPositionManagement]
     */
    void updateTalentPositionManagement(TalentPositionManagement talentPositionManagement);

    /**
     * @return java.util.List<com.flf.entity.homePage.SiteAdvisoryManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历人才咨询管理信息
     * @Date 2018/9/5 9:51
     * @Param [talentAdvisoryManagement]
     */
    List<TalentAdvisoryManagement> listPageTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除人才咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void deleteTalentAdvisoryManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  人才咨询管理信息置顶
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void updateTalentAdvisoryManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  人才咨询管理信息取消置顶
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void updateTalentAdvisoryManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加人才咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [talentAdvisoryManagement]
     */
    void insertTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改人才咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [talentAdvisoryManagement]
     */
    void updateTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询人才咨询管理信息
     * @Date 2018/9/5 9:53
     * @Param [id]
     */
    List<Map<String, Object>> selectTalentAdvisoryManagementById(Integer id);
//----------------------------------

    /**
     * @return java.util.List<com.flf.entity.talentInstitutionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历人才机构管理信息
     * @Date 2018/9/4 9:43
     * @Param [talentInstitutionManagement]
     */
    List<TalentInstitutionManagement> listPageTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除人才机构管理信息
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void deleteTalentInstitutionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  人才机构管理信息置顶
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void updateTalentInstitutionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO 人才机构管理信息取消置顶
     * @Date 2018/9/4 9:57
     * @Param [chk_value]
     */
    void updateTalentInstitutionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   添加人才机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [talentInstitutionManagement]
     */
    void insertTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改人才机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [talentInstitutionManagement]
     */
    void updateTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询人才机构管理信息
     * @Date 2018/9/4 10:24
     * @Param [id]
     */
    List<Map<String, Object>> selectTalentInstitutionManagementById(Integer id);


    /**
     * @return java.util.List<com.flf.entity.homePage.SitePositionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历场地宣传位管理信息
     * @Date 2018/9/4 15:42
     * @Param [sitePositionManagement]
     */
    List<SitePositionManagement> listPageSitePositionManagement(SitePositionManagement sitePositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除场地宣传位管理信息
     * @Date 2018/9/4 15:42
     * @Param [chk_value]
     */
    void deleteSitePositionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   场地宣传位管理信息置顶
     * @Date 2018/9/4 15:42
     * @Param [chk_value]
     */
    void updateSitePositionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  场地宣传位管理信息取消置顶
     * @Date 2018/9/4 15:43
     * @Param [chk_value]
     */
    void updateSitePositionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO   通过id查询场地宣传位管理信息
     * @Date 2018/9/4 15:45
     * @Param [id]
     */
    List<Map<String, Object>> selectSitePositionManagementById(Integer id);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加场地宣传位管理信息
     * @Date 2018/9/4 15:46
     * @Param [sitePositionManagement]
     */
    void insertSitePositionManagement(SitePositionManagement sitePositionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改场地宣传位管理信息
     * @Date 2018/9/4 15:46
     * @Param [sitePositionManagement]
     */
    void updateSitePositionManagement(SitePositionManagement sitePositionManagement);

    /**
     * @return java.util.List<com.flf.entity.homePage.SiteAdvisoryManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历场地咨询管理信息
     * @Date 2018/9/5 9:51
     * @Param [siteAdvisoryManagement]
     */
    List<SiteAdvisoryManagement> listPageSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除场地咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void deleteSiteAdvisoryManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  场地咨询管理信息置顶
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void updateSiteAdvisoryManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  场地咨询管理信息取消置顶
     * @Date 2018/9/5 9:52
     * @Param [chk_value]
     */
    void updateSiteAdvisoryManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加场地咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [siteAdvisoryManagement]
     */
    void insertSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改场地咨询管理信息
     * @Date 2018/9/5 9:52
     * @Param [siteAdvisoryManagement]
     */
    void updateSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询场地咨询管理信息
     * @Date 2018/9/5 9:53
     * @Param [id]
     */
    List<Map<String, Object>> selectSiteAdvisoryManagementById(Integer id);

//    __________________________________________

    /**
     * @return java.util.List<com.flf.entity.siteInstitutionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历场地机构管理信息
     * @Date 2018/9/4 9:43
     * @Param [siteInstitutionManagement]
     */
    List<SiteInstitutionManagement> listPageSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除场地机构管理信息
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void deleteSiteInstitutionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  场地机构管理信息置顶
     * @Date 2018/9/4 9:56
     * @Param [chk_value]
     */
    void updateSiteInstitutionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO 场地机构管理信息取消置顶
     * @Date 2018/9/4 9:57
     * @Param [chk_value]
     */
    void updateSiteInstitutionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   添加场地机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [siteInstitutionManagement]
     */
    void insertSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改场地机构管理信息
     * @Date 2018/9/4 10:20
     * @Param [siteInstitutionManagement]
     */
    void updateSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询场地机构管理信息
     * @Date 2018/9/4 10:24
     * @Param [id]
     */
    List<Map<String, Object>> selectSiteInstitutionManagementById(Integer id);


    /**
     * @return java.util.List<com.flf.entity.homePage.PositionManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历首页宣传位管理信息
     * @Date 2018/9/6 9:42
     * @Param [positionManagement]
     */
    List<PositionManagement> listPagePositionManagement(PositionManagement positionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除首页宣传位管理信息
     * @Date 2018/9/6 9:43
     * @Param [chk_value]
     */
    void deletePositionManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  首页宣传位管理信息置顶
     * @Date 2018/9/6 9:49
     * @Param [chk_value]
     */
    void updatePositionManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  首页宣传位管理信息取消置顶
     * @Date 2018/9/6 9:49
     * @Param [chk_value]
     */
    void updatePositionManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加首页宣传位管理信息
     * @Date 2018/9/6 9:50
     * @Param [positionManagement]
     */
    void insertPositionManagement(PositionManagement positionManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改首页宣传位管理信息
     * @Date 2018/9/6 9:50
     * @Param [positionManagement]
     */
    void updatePositionManagement(PositionManagement positionManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询首页宣传位管理信息
     * @Date 2018/9/6 9:50
     * @Param [id]
     */
    List<Map<String, Object>> selectPositionManagementById(Integer id);

    /**
     * @return java.util.List<com.flf.entity.homePage.ResultsShowManagement>
     * @Author Mr.Chan
     * @Description //TODO  遍历成果展示管理信息
     * @Date 2018/9/6 12:33
     * @Param [resultsShowManagement]
     */
    List<ResultsShowManagement> listPageResultsShowManagement(ResultsShowManagement resultsShowManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除成果展示管理信息
     * @Date 2018/9/6 12:33
     * @Param [chk_value]
     */
    void deleteResultsShowManagement(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息置顶
     * @Date 2018/9/6 12:33
     * @Param [chk_value]
     */
    void updateResultsShowManagementPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息取消置顶
     * @Date 2018/9/6 12:33
     * @Param [chk_value]
     */
    void updateResultsShowManagementCancelPlacedTop(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息发布
     * @Date 2018/9/6 12:34
     * @Param [chk_value]
     */
    void updateResultsShowManagementReleaseMarks(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息撤销发布
     * @Date 2018/9/6 12:34
     * @Param [chk_value]
     */
    void updateResultsShowManagementCancelReleaseMarks(Integer[] chk_value);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  添加成果展示管理信息
     * @Date 2018/9/6 12:34
     * @Param [resultsShowManagement]
     */
    void insertResultsShowManagement(ResultsShowManagement resultsShowManagement);

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  修改成果展示管理信息
     * @Date 2018/9/6 12:34
     * @Param [resultsShowManagement]
     */
    void updateResultsShowManagement(ResultsShowManagement resultsShowManagement);

    /**
     * @return java.util.List<java.util.Map       <       java.lang.String       ,       java.lang.Object>>
     * @Author Mr.Chan
     * @Description //TODO  通过id查询成果展示管理信息
     * @Date 2018/9/6 12:34
     * @Param [id]
     */
    List<Map<String, Object>> selectResultsShowManagementById(Integer id);

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历动态管理信息
     * @Date 2018/9/7 11:01
     * @Param [dynamicManagement]
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    List<DynamicManagement> listPageDynamicManagement(DynamicManagement dynamicManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除动态管理信息
     * @Date 2018/9/7 11:07
     * @Param [chk_value]
     * @return void
     */
    void deleteDynamicManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息置顶
     * @Date 2018/9/7 11:07
     * @Param [chk_value]
     * @return void
     */
    void updateDynamicManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息取消置顶
     * @Date 2018/9/7 11:07
     * @Param [chk_value]
     * @return void
     */
    void updateDynamicManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息发布
     * @Date 2018/9/7 11:07
     * @Param [chk_value]
     * @return void
     */
    void updateDynamicManagementReleaseMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息取消发布
     * @Date 2018/9/7 11:08
     * @Param [chk_value]
     * @return void
     */
    void updateDynamicManagementCancelReleaseMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加动态管理信息
     * @Date 2018/9/7 11:08
     * @Param [dynamicManagement]
     * @return void
     */
    void insertDynamicManagement(DynamicManagement dynamicManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改动态管理信息
     * @Date 2018/9/7 11:08
     * @Param [dynamicManagement]
     * @return void
     */
    void updateDynamicManagement(DynamicManagement dynamicManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询动态管理信息
     * @Date 2018/9/7 11:08
     * @Param [id]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    DynamicManagement selectDynamicManagementById(Integer id);

    /**
     * @Author Mr.Chan
     * @Description //TODO  查询机构管理信息的所有机构名称
     * @Date 2018/9/10 10:04
     * @Param []
     * @return java.util.List<com.flf.entity.OrganizationManagement>
     */
    List<OrganizationManagement> selectOrganizationInfo();
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有基地名称
     * @Date 2018/9/10 10:04
     * @Param []
     * @return java.util.List<com.flf.entity.OrganizationManagement>
     */
    List<DemonstrationBaseManagement> selectBaseInfo();
    /**
     * @Author Mr.Chan
     * @Description //TODO   通过区域id查询基地
     * @Date 2018/9/18 17:16
     * @Param []
     * @return java.util.List<java.lang.Integer>
     */
    List<DemonstrationBaseManagement> selectBaseIdByRegionId(Integer region);
    /**
     * @Author Mr.Chan
     * @Description //TODO   通过基地id查询区域
     * @Date 2018/9/18 17:16
     * @Param []
     * @return java.lang.Integer
     */
    RegionalDataMaintenance selectRegionIdByBaseId(Integer base);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过输入的name获取数据库中的id
     * @Date 2018/10/10 9:57
     * @Param [name]
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> selectDynamicManagementIdByName(String name);
}

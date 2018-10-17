package com.flf.controller;

import com.flf.entity.FileUtil;
import com.flf.entity.OrganizationManagement;
import com.flf.entity.User;
import com.flf.entity.homePage.EntrepreneurshipGroupMaintenance;
import com.flf.entity.policyManagement.*;
import com.flf.service.PolicyManagementService;
import com.flf.util.Const;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * @ClassName: PolicyManagementController
 * @Description: //TODO  政策管理信息的控制层
 * @Author: Mr.Chan
 * @Data: 2018/9/10 11:10
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/policyManagement", produces = "text/html;charset=utf-8")
public class PolicyManagementController {
    @Autowired
    private PolicyManagementService policyManagementService;
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历生态圈数据维护信息
     * @Date 2018/9/10 11:50
     * @Param [ecosystemMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageEcosystemMaintenance")
    public ModelAndView listPageEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/ecosystemMaintenance");
        mv.addObject("listPageEcosystemMaintenance",policyManagementService.listPageEcosystemMaintenance(ecosystemMaintenance));
        mv.addObject("ecosystemMaintenance",ecosystemMaintenance);
        return  mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除生态圈维护信息
     * @Date 2018/9/10 11:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteEcosystemMaintenance")
    public void deleteEcosystemMaintenance(Integer[] chk_value, PrintWriter out){
        policyManagementService.deleteEcosystemMaintenance(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加生态圈维护信息
     * @Date 2018/9/17 13:36
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertEcosystemMaintenance")
    public ModelAndView insertEcosystemMaintenance(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/ecosystemMaintenance_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改生态圈维护信息
     * @Date 2018/9/17 13:36
     * @Param [id, ecosystemMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateEcosystemMaintenance")
    public ModelAndView updateEcosystemMaintenance(Integer id,EcosystemMaintenance ecosystemMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/ecosystemMaintenance_info");
        mv.addObject("ecosystemMaintenance",policyManagementService.selectEcosystemMaintenanceById(id));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存生态圈维护信息
     * @Date 2018/9/17 13:36
     * @Param [ecosystemMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveEcosystemMaintenance")
    public ModelAndView saveEcosystemMaintenance(EcosystemMaintenance ecosystemMaintenance){
        List<EcosystemMaintenance> list = policyManagementService.selectEcosystemMaintenanceByName(ecosystemMaintenance);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (ecosystemMaintenance.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId()!=ecosystemMaintenance.getId()){
                    mv.addObject("msg","failed");
                    return mv;
                }
            }
            policyManagementService.updateEcosystemMaintenance(ecosystemMaintenance);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg","failed");
                return mv;
            }
            policyManagementService.insertEcosystemMaintenance(ecosystemMaintenance);
        }
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历时间轴维护信息
     * @Date 2018/9/10 11:50
     * @Param [timelineMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageTimelineMaintenance")
    public ModelAndView listPageTimelineMaintenance(TimelineMaintenance timelineMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/timelineMaintenance");
        mv.addObject("listPageTimelineMaintenance",policyManagementService.listPageTimelineMaintenance(timelineMaintenance));
        mv.addObject("timelineMaintenance",timelineMaintenance);
        return  mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除时间轴维护信息
     * @Date 2018/9/10 11:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteTimelineMaintenance")
    public void deleteTimelineMaintenance(Integer[] chk_value, PrintWriter out){
        policyManagementService.deleteTimelineMaintenance(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加时间轴维护信息
     * @Date 2018/9/17 13:36
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertTimelineMaintenance")
    public ModelAndView insertTimelineMaintenance(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/timelineMaintenance_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改时间轴维护信息
     * @Date 2018/9/17 13:36
     * @Param [id, timelineMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateTimelineMaintenance")
    public ModelAndView updateTimelineMaintenance(Integer id,TimelineMaintenance timelineMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/timelineMaintenance_info");
        mv.addObject("timelineMaintenance",policyManagementService.selectTimelineMaintenanceById(id));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存时间轴维护信息
     * @Date 2018/9/17 13:36
     * @Param [timelineMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveTimelineMaintenance")
    public ModelAndView saveTimelineMaintenance(TimelineMaintenance timelineMaintenance){
        List<TimelineMaintenance> list = policyManagementService.selectTimelineMaintenanceByName(timelineMaintenance);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (timelineMaintenance.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId()!=timelineMaintenance.getId()){
                    mv.addObject("msg","failed");
                    return mv;
                }
            }
            policyManagementService.updateTimelineMaintenance(timelineMaintenance);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg","failed");
                return mv;
            }
            policyManagementService.insertTimelineMaintenance(timelineMaintenance);
        }
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历行业数据维护信息
     * @Date 2018/9/10 11:50
     * @Param [industryDataMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageIndustryDataMaintenance")
    public ModelAndView listPageIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/industryDataMaintenance");
        mv.addObject("listPageIndustryDataMaintenance",policyManagementService.listPageIndustryDataMaintenance(industryDataMaintenance));
        mv.addObject("industryDataMaintenance",industryDataMaintenance);
        return  mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除行业数据维护信息
     * @Date 2018/9/10 11:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteIndustryDataMaintenance")
    public void deleteIndustryDataMaintenance(Integer[] chk_value, PrintWriter out){
        policyManagementService.deleteIndustryDataMaintenance(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加行业数据维护信息
     * @Date 2018/9/17 13:36
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertIndustryDataMaintenance")
    public ModelAndView insertIndustryDataMaintenance(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/industryDataMaintenance_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改行业数据维护信息
     * @Date 2018/9/17 13:36
     * @Param [id, industryDataMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateIndustryDataMaintenance")
    public ModelAndView updateIndustryDataMaintenance(Integer id,IndustryDataMaintenance industryDataMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/industryDataMaintenance_info");
        mv.addObject("industryDataMaintenance",policyManagementService.selectIndustryDataMaintenanceById(id));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存行业数据维护信息
     * @Date 2018/9/17 13:36
     * @Param [industryDataMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveIndustryDataMaintenance")
    public ModelAndView saveIndustryDataMaintenance(IndustryDataMaintenance industryDataMaintenance){
        List<IndustryDataMaintenance> list = policyManagementService.selectIndustryDataMaintenanceByName(industryDataMaintenance);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (industryDataMaintenance.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId()!=industryDataMaintenance.getId()){
                    mv.addObject("msg","failed");
                    return mv;
                }
            }
            policyManagementService.updateIndustryDataMaintenance(industryDataMaintenance);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg","failed");
                return mv;
            }
            policyManagementService.insertIndustryDataMaintenance(industryDataMaintenance);
        }
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历区域数据维护信息
     * @Date 2018/9/10 11:50
     * @Param [regionalDataMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageRegionalDataMaintenance")
    public ModelAndView listPageRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/regionalDataMaintenance");
        mv.addObject("listPageRegionalDataMaintenance",policyManagementService.listPageRegionalDataMaintenance(regionalDataMaintenance));
        mv.addObject("regionalDataMaintenance",regionalDataMaintenance);
        return  mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除区域维护信息
     * @Date 2018/9/10 11:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteRegionalDataMaintenance")
    public void deleteRegionalDataMaintenance(Integer[] chk_value, PrintWriter out){
        policyManagementService.deleteRegionalDataMaintenance(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   添加区域维护信息
     * @Date 2018/9/17 13:37
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertRegionalDataMaintenance")
    public ModelAndView insertRegionalDataMaintenance(){
        ModelAndView mv = new ModelAndView();
       mv.setViewName("policyManagement/regionalDataMaintenance_info");
       return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改区域维护信息
     * @Date 2018/9/17 13:37
     * @Param [id, regionalDataMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateRegionalDataMaintenance")
    public ModelAndView updateRegionalDataMaintenance(Integer id,RegionalDataMaintenance regionalDataMaintenance){
        List<Map<String,Object>> mapList = policyManagementService.selectRegionalDataMaintenanceById(id);
        regionalDataMaintenance.setId(id);
        regionalDataMaintenance.setName((String) mapList.get(0).get("name"));
        regionalDataMaintenance.setSorting((Integer) mapList.get(0).get("sorting"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/regionalDataMaintenance_info");
        mv.addObject("regionalDataMaintenance",regionalDataMaintenance);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   保存区域维护信息
     * @Date 2018/9/17 13:37
     * @Param [regionalDataMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveRegionalDataMaintenance")
    public ModelAndView saveRegionalDataMaintenance(RegionalDataMaintenance regionalDataMaintenance){
        List<RegionalDataMaintenance> list = policyManagementService.selectNameCheckInfo(regionalDataMaintenance);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (regionalDataMaintenance.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId()!=regionalDataMaintenance.getId()){
                    mv.addObject("msg","failed");
                    return mv;
                }
            }
            policyManagementService.updateRegionalDataMaintenance(regionalDataMaintenance);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg","failed");
                return mv;
            }
            policyManagementService.insertRegionalDataMaintenance(regionalDataMaintenance);
        }
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历主题分类维护信息
     * @Date 2018/9/10 11:50
     * @Param [subjectClassificationMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageSubjectClassificationMaintenance")
    public ModelAndView listPageSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/subjectClassificationMaintenance");
        mv.addObject("listPageSubjectClassificationMaintenance",policyManagementService.listPageSubjectClassificationMaintenance(subjectClassificationMaintenance));
        mv.addObject("subjectClassificationMaintenance",subjectClassificationMaintenance);
        return  mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除主题分类维护信息
     * @Date 2018/9/10 11:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteSubjectClassificationMaintenance")
    public void deleteSubjectClassificationMaintenance(Integer[] chk_value, PrintWriter out){
        policyManagementService.deleteSubjectClassificationMaintenance(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加主题分类维护信息
     * @Date 2018/9/17 13:36
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertSubjectClassificationMaintenance")
    public ModelAndView insertSubjectClassificationMaintenance(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/subjectClassificationMaintenance_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改主题分类维护信息
     * @Date 2018/9/17 13:36
     * @Param [id, subjectClassificationMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateSubjectClassificationMaintenance")
    public ModelAndView updateSubjectClassificationMaintenance(Integer id,SubjectClassificationMaintenance subjectClassificationMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/subjectClassificationMaintenance_info");
        mv.addObject("subjectClassificationMaintenance",policyManagementService.selectSubjectClassificationMaintenanceById(id));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存主题分类维护信息
     * @Date 2018/9/17 13:36
     * @Param [subjectClassificationMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveSubjectClassificationMaintenance")
    public ModelAndView saveSubjectClassificationMaintenance(SubjectClassificationMaintenance subjectClassificationMaintenance){
        List<SubjectClassificationMaintenance> list = policyManagementService.selectSubjectClassificationMaintenanceByName(subjectClassificationMaintenance);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (subjectClassificationMaintenance.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId()!=subjectClassificationMaintenance.getId()){
                    mv.addObject("msg","failed");
                    return mv;
                }
            }
            policyManagementService.updateSubjectClassificationMaintenance(subjectClassificationMaintenance);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg","failed");
                return mv;
            }
            policyManagementService.insertSubjectClassificationMaintenance(subjectClassificationMaintenance);
        }
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历政策分类维护信息
     * @Date 2018/9/10 11:50
     * @Param [policyClassificationMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPagePolicyClassificationMaintenance")
    public ModelAndView listPagePolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/policyClassificationMaintenance");
        mv.addObject("listPagePolicyClassificationMaintenance",policyManagementService.listPagePolicyClassificationMaintenance(policyClassificationMaintenance));
        mv.addObject("policyClassificationMaintenance", policyClassificationMaintenance);
        return  mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除政策分类维护信息
     * @Date 2018/9/10 11:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deletePolicyClassificationMaintenance")
    public void deletePolicyClassificationMaintenance(Integer[] chk_value, PrintWriter out){
        policyManagementService.deletePolicyClassificationMaintenance(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加政策分类维护信息
     * @Date 2018/9/17 13:36
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertPolicyClassificationMaintenance")
    public ModelAndView insertPolicyClassificationMaintenance(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/policyClassificationMaintenance_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改政策分类维护信息
     * @Date 2018/9/17 13:36
     * @Param [id, policyClassificationMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updatePolicyClassificationMaintenance")
    public ModelAndView updatePolicyClassificationMaintenance(Integer id,PolicyClassificationMaintenance policyClassificationMaintenance){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/policyClassificationMaintenance_info");
        mv.addObject("policyClassificationMaintenance",policyManagementService.selectPolicyClassificationMaintenanceById(id));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存政策分类维护信息
     * @Date 2018/9/17 13:36
     * @Param [policyClassificationMaintenance]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/savePolicyClassificationMaintenance")
    public ModelAndView savePolicyClassificationMaintenance(PolicyClassificationMaintenance policyClassificationMaintenance){
        List<PolicyClassificationMaintenance> list = policyManagementService.selectPolicyClassificationMaintenanceByName(policyClassificationMaintenance);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (policyClassificationMaintenance.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId()!= policyClassificationMaintenance.getId()){
                    mv.addObject("msg","failed");
                    return mv;
                }
            }
            policyManagementService.updatePolicyClassificationMaintenance(policyClassificationMaintenance);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg","failed");
                return mv;
            }
            policyManagementService.insertPolicyClassificationMaintenance(policyClassificationMaintenance);
        }
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历产业园推荐信息
     * @Date 2018/9/10 11:50
     * @Param [industrialParkRecommendation]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageIndustrialParkRecommendation")
    public ModelAndView listPageIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/industrialParkRecommendation");
        mv.addObject("listPageIndustrialParkRecommendation",policyManagementService.listPageIndustrialParkRecommendation(industrialParkRecommendation));
        mv.addObject("industrialParkRecommendation", industrialParkRecommendation);
        return  mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除产业园推荐信息
     * @Date 2018/9/10 11:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteIndustrialParkRecommendation")
    public void deleteIndustrialParkRecommendation(Integer[] chk_value, PrintWriter out){
        policyManagementService.deleteIndustrialParkRecommendation(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   产业园推荐信息置顶
     * @Date 2018/9/17 17:01
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateIndustrialParkRecommendationPlacedTop")
    public void updateIndustrialParkRecommendationPlacedTop(Integer[] chk_value, PrintWriter out){
        policyManagementService.updateIndustrialParkRecommendationPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   产业园推荐信息取消置顶
     * @Date 2018/9/17 17:01
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateIndustrialParkRecommendationCancelPlacedTop")
    public void updateIndustrialParkRecommendationCancelPlacedTop(Integer[] chk_value, PrintWriter out){
        policyManagementService.updateIndustrialParkRecommendationCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加产业园推荐信息
     * @Date 2018/9/17 13:36
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertIndustrialParkRecommendation")
    public ModelAndView insertIndustrialParkRecommendation(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/industrialParkRecommendation_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改产业园推荐信息
     * @Date 2018/9/17 13:36
     * @Param [id, industrialParkRecommendation]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateIndustrialParkRecommendation")
    public ModelAndView updateIndustrialParkRecommendation(Integer id,IndustrialParkRecommendation industrialParkRecommendation){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/industrialParkRecommendation_info");
        mv.addObject("industrialParkRecommendation",policyManagementService.selectIndustrialParkRecommendationById(id));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存产业园推荐信息
     * @Date 2018/9/17 13:36
     * @Param [industrialParkRecommendation]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveIndustrialParkRecommendation")
    public ModelAndView saveIndustrialParkRecommendation(IndustrialParkRecommendation industrialParkRecommendation, HttpServletRequest req, Map map, @RequestParam(value = "file", required = false) MultipartFile file){
        List<IndustrialParkRecommendation> list = policyManagementService.selectIndustrialParkRecommendationByName(industrialParkRecommendation);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (industrialParkRecommendation.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId()!= industrialParkRecommendation.getId()){
                    mv.addObject("msg","failed");
                    return mv;
                }
            }
            if (file == null || file.isEmpty()) {
                industrialParkRecommendation.setFileURL(list.get(0).getFileURL());
            } else {
                map = FileUtil.uploadImg(file, req);
                industrialParkRecommendation.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            policyManagementService.updateIndustrialParkRecommendation(industrialParkRecommendation);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg","failed");
                return mv;
            }
            map = FileUtil.uploadImg(file, req);
            industrialParkRecommendation.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            policyManagementService.insertIndustrialParkRecommendation(industrialParkRecommendation);
        }
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历政策发布信息
     * @Date 2018/9/26 21:43
     * @Param [policyIssued]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPagePolicyIssued")
    public ModelAndView listPagePolicyIssued(PolicyIssued policyIssued){
        if (policyIssued.getPlacedTop()!=null){
            if (policyIssued.getPlacedTop()==2){
                policyIssued.setPlacedTop(null);
            }
        }
        if (policyIssued.getReportMarks()!=null){
            if (policyIssued.getReportMarks()==2){
                policyIssued.setReportMarks(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("selectIndustry",policyManagementService.selectIndustry());
        mv.addObject("selectPolicyTheme",policyManagementService.selectPolicyTheme());
        mv.addObject("selectRegion",policyManagementService.selectRegion());
        mv.addObject("selectReportUnit",policyManagementService.selectReportUnit());
        mv.addObject("policyIssued",policyIssued);
        mv.addObject("listPagePolicyIssued",policyManagementService.listPagePolicyIssued(policyIssued));
        mv.setViewName("policyManagement/policyIssued");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   删除政策发布信息
     * @Date 2018/9/27 23:12
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deletePolicyIssued")
    public void deletePolicyIssued(Integer[] chk_value,PrintWriter out){
        policyManagementService.deletePolicyIssued(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  政策发布信息置顶
     * @Date 2018/9/27 23:12
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updatePolicyIssuedPlacedTop")
    public void updatePolicyIssuedPlacedTop(Integer[] chk_value,PrintWriter out){
        policyManagementService.updatePolicyIssuedPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  政策发布信息取消置顶
     * @Date 2018/9/27 23:12
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updatePolicyIssuedCancelPlacedTop")
    public void updatePolicyIssuedCancelPlacedTop(Integer[] chk_value,PrintWriter out){
        policyManagementService.updatePolicyIssuedCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  政策发布信息撤回发布
     * @Date 2018/9/27 23:12
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updatePolicyIssuedCancelReportMarks")
    public void updatePolicyIssuedCancelReportMarks(Integer[] chk_value,PrintWriter out){
        policyManagementService.updatePolicyIssuedCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加政策发布信息
     * @Date 2018/9/27 23:13
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertPolicyIssued")
    public ModelAndView insertPolicyIssued(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("policyManagement/policyIssued_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改政策发布信息
     * @Date 2018/9/27 23:13
     * @Param [id, policyIssued]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updatePolicyIssued")
    public ModelAndView updatePolicyIssued(Integer id,PolicyIssued policyIssued){
        policyIssued = policyManagementService.selectPolicyIssuedById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("policyIssued",policyIssued);
        mv.setViewName("policyManagement/policyIssued_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存政策发布信息
     * @Date 2018/9/27 23:13
     * @Param [policyIssued, session, req, map, file]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/savePolicyIssued")
    public ModelAndView savePolicyIssued(PolicyIssued policyIssued, HttpSession session,HttpServletRequest req, Map map, @RequestParam(value = "file", required = false) MultipartFile file){
        List<Integer> list = policyManagementService.selectPolicyIssuedIdByName(policyIssued.getName());
        User user = (User)session.getAttribute(Const.SESSION_USER);
        ModelAndView mv = new ModelAndView();
        if (policyIssued.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if (!list.get(0).equals(policyIssued.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            if (file == null || file.isEmpty()) {
                policyIssued.setFileURL(policyManagementService.selectPolicyIssuedById(policyIssued.getId()).getFileURL());
            } else {
                map = FileUtil.uploadImg(file, req);
                policyIssued.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            policyIssued.setModifyTime(new Date());
            policyManagementService.updatePolicyIssued(policyIssued);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            if (file == null || file.isEmpty()) {
                policyIssued.setFileURL(null);
            } else {
                map = FileUtil.uploadImg(file, req);
                policyIssued.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            policyIssued.setReportPeople(user.getUsername());
            policyIssued.setModifyTime(new Date());
            policyManagementService.insertPolicyIssued(policyIssued);
        }
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @Author Mr.Chan
     * @Description //TODO  combobox得到行业信息
     * @Date 2018/10/1 18:23
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getIndustry", method = RequestMethod.GET)
    @ResponseBody
    public void getIndustry(HttpServletResponse response) throws IOException {
            List<IndustryDataMaintenance> list = policyManagementService.selectIndustry();
            JSONArray jsonArray = JSONArray.fromObject(list);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(jsonArray);
        }
    /**
     * @Author Mr.Chan
     * @Description //TODO   combobox得到主题分类信息
     * @Date 2018/10/1 18:22
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getPolicyTheme", method = RequestMethod.GET)
    @ResponseBody
    public void getPolicyTheme(HttpServletResponse response) throws IOException {
        List<SubjectClassificationMaintenance> list = policyManagementService.selectPolicyTheme();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(jsonArray);
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  combobox得到所属区域信息
     * @Date 2018/10/1 18:22
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getRegion", method = RequestMethod.GET)
    @ResponseBody
    public void getRegion(HttpServletResponse response) throws IOException {
        List<RegionalDataMaintenance> list = policyManagementService.selectRegion();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(jsonArray);
    }

    /**
     * @Author Mr.Chan
     * @Description //TODO  combobox得到时间轴信息
     * @Date 2018/10/1 18:22
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getTimelinePhase", method = RequestMethod.GET)
    @ResponseBody
    public void getTimelinePhase(HttpServletResponse response) throws IOException {
        List<TimelineMaintenance> list = policyManagementService.selectTimelinePhase();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(jsonArray);
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  combobox得到政策分类信息
     * @Date 2018/10/1 18:19
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getPolicyClassification", method = RequestMethod.GET)
    @ResponseBody
    public void getPolicyClassification(HttpServletResponse response) throws IOException {
        List<PolicyClassificationMaintenance> list = policyManagementService.selectPolicyClassification();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(jsonArray);
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  combobox得到所属机构信息
     * @Date 2018/10/1 18:19
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getReportUnit", method = RequestMethod.GET)
    @ResponseBody
    public void getReportUnit(HttpServletResponse response) throws IOException {
        List<OrganizationManagement> list = policyManagementService.selectReportUnit();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(jsonArray);
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  combobox得到生态圈信息
     * @Date 2018/10/1 18:19
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getEcosphereKeyword", method = RequestMethod.GET)
    @ResponseBody
    public void getEcosphereKeyword(HttpServletResponse response) throws IOException {
        List<EcosystemMaintenance> list = policyManagementService.selectEcosphereKeyword();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(jsonArray);
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  combobox得到创业人群信息
     * @Date 2018/10/1 18:18
     * @Param [response]
     * @return void
     */
    @RequestMapping(value = "/getBusinessPeople", method = RequestMethod.GET)
    @ResponseBody
    public void getBusinessPeople(HttpServletResponse response) throws IOException {
        List<EntrepreneurshipGroupMaintenance> list = policyManagementService.selectBusinessPeople();
        JSONArray jsonArray = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(jsonArray);
    }

    /**
     * @Author Mr.Chan
     * @Description //TODO  时间插件
     * @Date 2018/9/6 16:36
     * @Param [binder]
     * @return void
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }
}

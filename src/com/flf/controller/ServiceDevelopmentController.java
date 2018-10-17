package com.flf.controller;

import com.flf.entity.FileUtil;
import com.flf.entity.User;
import com.flf.entity.serviceDevelopment.FundFeeEnquiry;
import com.flf.entity.serviceDevelopment.GuideManagement;
import com.flf.entity.serviceDevelopment.TaxPreferenceEnquiry;
import com.flf.service.ServiceDevelopmentService;
import com.flf.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ServiceDevelopmentController
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/25 9:27
 * @Version: 1.0
 */
@Controller
@RequestMapping("/serviceDevelopment")
public class ServiceDevelopmentController {
    @Autowired
    private ServiceDevelopmentService serviceDevelopmentService;


    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历办事指南管理
     * @Date 2018/9/25 9:31
     * @Param [guideManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageGuideManagement")
    public ModelAndView listPageGuideManagement(GuideManagement guideManagement){
        ModelAndView mv = new ModelAndView();
        mv.addObject("guideManagement",guideManagement);
        mv.addObject("listPageGuideManagement",serviceDevelopmentService.listPageGuideManagement(guideManagement));
        mv.setViewName("serviceDevelopment/guideManagement");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除办事指南管理
     * @Date 2018/9/25 9:36
     * @Param [out, chk_value]
     * @return void
     */
    @RequestMapping("/deleteGuideManagement")
    public void deleteGuideManagement(PrintWriter out,Integer[] chk_value){
        serviceDevelopmentService.deleteGuideManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  办事指南管理发布
     * @Date 2018/9/25 9:38
     * @Param [out, chk_value]
     * @return void
     */
    @RequestMapping("/updateGuideManagementReportMarks")
    public void updateGuideManagementReportMarks(PrintWriter out,Integer[] chk_value){
        serviceDevelopmentService.updateGuideManagementReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  办事指南管理撤销发布
     * @Date 2018/9/25 9:38
     * @Param [out, chk_value]
     * @return void
     */
    @RequestMapping("/updateGuideManagementCancelReportMarks")
    public void updateGuideManagementCancelReportMarks(PrintWriter out,Integer[] chk_value){
        serviceDevelopmentService.updateGuideManagementCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加办事指南管理信息
     * @Date 2018/9/25 9:41
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertGuideManagement")
    public ModelAndView insertGuideManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("serviceDevelopment/guideManagement_info");
        return mv;
    }
       /**
        * @Author Mr.Chan
        * @Description //TODO  修改办事指南管理信息
        * @Date 2018/9/25 9:44
        * @Param [id, guideManagement]
        * @return org.springframework.web.servlet.ModelAndView
        */
    @RequestMapping("/updateGuideManagement")
    public ModelAndView updateGuideManagement(Integer id,GuideManagement guideManagement){
        guideManagement = serviceDevelopmentService.selectGuideManagementById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("guideManagement",guideManagement);
        mv.setViewName("serviceDevelopment/guideManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存办事指南管理信息
     * @Date 2018/9/25 11:16
     * @Param [guideManagement, session]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveGuideManagement")
    public ModelAndView saveGuideManagement(GuideManagement guideManagement,HttpSession session){
        User user = (User) session.getAttribute(Const.SESSION_USER);
        List<Integer> list = serviceDevelopmentService.selectGuideManagementIdByName(guideManagement.getName());
        ModelAndView mv = new ModelAndView();
        if (guideManagement.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if (!list.get(0).equals(guideManagement.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            guideManagement.setModifier(user.getUsername());
            guideManagement.setModifyTime(new Date());
            serviceDevelopmentService.updateGuideManagement(guideManagement);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            guideManagement.setReleasePeople(user.getUsername());
            guideManagement.setModifier(user.getUsername());
            guideManagement.setModifyTime(new Date());
            guideManagement.setReleaseTime(new Date());
            serviceDevelopmentService.insertGuideManagement(guideManagement);
        }
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:19
     * @Param [fundFeeEnquiry]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageFundFeeEnquiry")
    public ModelAndView listPageFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry){
        if (fundFeeEnquiry.getType()!=null){
            if (fundFeeEnquiry.getType()==0){
                fundFeeEnquiry.setType(null);
            }
        }
        if (fundFeeEnquiry.getReportMarks()!=null){
            if (fundFeeEnquiry.getReportMarks()==2){
                fundFeeEnquiry.setReportMarks(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("listPageFundFeeEnquiry",serviceDevelopmentService.listPageFundFeeEnquiry(fundFeeEnquiry));
        mv.addObject("fundFeeEnquiry",fundFeeEnquiry);
        mv.setViewName("serviceDevelopment/fundFeeEnquiry");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:21
     * @Param [out, chk_value]
     * @return void
     */
    @RequestMapping("/deleteFundFeeEnquiry")
    public void deleteFundFeeEnquiry(PrintWriter out,Integer[] chk_value){
        serviceDevelopmentService.deleteFundFeeEnquiry(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  政府性基金和行政事业型收费查询信息撤回发布
     * @Date 2018/9/25 11:41
     * @Param [out, chk_value]
     * @return void
     */
    @RequestMapping("/updateFundFeeEnquiryCancelReportMarks")
    public void updateFundFeeEnquiryCancelReportMarks(PrintWriter out,Integer[] chk_value){
        serviceDevelopmentService.updateFundFeeEnquiryCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:41
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertFundFeeEnquiry")
    public ModelAndView insertFundFeeEnquiry(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("serviceDevelopment/fundFeeEnquiry_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:41
     * @Param [id, fundFeeEnquiry]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateFundFeeEnquiry")
    public ModelAndView updateFundFeeEnquiry(Integer id,FundFeeEnquiry fundFeeEnquiry){
        fundFeeEnquiry = serviceDevelopmentService.selectFundFeeEnquiryById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("serviceDevelopment/fundFeeEnquiry_info");
        mv.addObject("fundFeeEnquiry",fundFeeEnquiry);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存政府性基金和行政事业型收费查询信息
     * @Date 2018/9/25 11:41
     * @Param [fundFeeEnquiry, req, map, file, session]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveFundFeeEnquiry")
    public ModelAndView saveFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry, HttpServletRequest req, Map map, @RequestParam(value = "file", required = false) MultipartFile file,HttpSession session){
        User user = (User) session.getAttribute(Const.SESSION_USER);
       if (file == null || file.isEmpty()) {
            fundFeeEnquiry.setFileURL(serviceDevelopmentService.selectFundFeeEnquiryById(fundFeeEnquiry.getId()).getFileURL());
        } else {
            map = FileUtil.uploadImg(file, req);
            fundFeeEnquiry.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (fundFeeEnquiry.getId()!=null){
//            修改
            fundFeeEnquiry.setModifier(user.getUsername());
            fundFeeEnquiry.setModifyTime(new Date());
            serviceDevelopmentService.updateFundFeeEnquiry(fundFeeEnquiry);
        }else {
//        添加
            fundFeeEnquiry.setReportPeople(user.getUsername());
            fundFeeEnquiry.setModifier(user.getUsername());
            fundFeeEnquiry.setModifyTime(new Date());
            fundFeeEnquiry.setReportTime(new Date());
            serviceDevelopmentService.insertFundFeeEnquiry(fundFeeEnquiry);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }

    @RequestMapping("/listPageTaxPreferenceEnquiry")
    public ModelAndView listPageTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry){
        if (taxPreferenceEnquiry.getPhase()!=null){
            if (taxPreferenceEnquiry.getPhase()==0){
                taxPreferenceEnquiry.setPhase(null);
            }
        }
        if (taxPreferenceEnquiry.getReportMarks()!=null){
            if (taxPreferenceEnquiry.getReportMarks()==2){
                taxPreferenceEnquiry.setReportMarks(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("listPageTaxPreferenceEnquiry",serviceDevelopmentService.listPageTaxPreferenceEnquiry(taxPreferenceEnquiry));
        mv.addObject("taxPreferenceEnquiry",taxPreferenceEnquiry);
        mv.setViewName("serviceDevelopment/taxPreferenceEnquiry");
        return mv;
    }

    @RequestMapping("/deleteTaxPreferenceEnquiry")
    public void deleteTaxPreferenceEnquiry(Integer[] chk_value,PrintWriter out){
        serviceDevelopmentService.deleteTaxPreferenceEnquiry(chk_value);
        out.write("success");
        out.close();
    }

    @RequestMapping("/updateTaxPreferenceEnquiryCancelReportMarks")
    public void updateTaxPreferenceEnquiryCancelReportMarks(Integer[] chk_value,PrintWriter out){
        serviceDevelopmentService.updateTaxPreferenceEnquiryCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }

    @RequestMapping("/insertTaxPreferenceEnquiry")
    public ModelAndView insertTaxPreferenceEnquiry(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("serviceDevelopment/taxPreferenceEnquiry_info");
        return mv;
    }

    @RequestMapping("/updateTaxPreferenceEnquiry")
    public ModelAndView updateTaxPreferenceEnquiry(Integer id,TaxPreferenceEnquiry taxPreferenceEnquiry){
        taxPreferenceEnquiry = serviceDevelopmentService.selectTaxPreferenceEnquiryById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("taxPreferenceEnquiry",taxPreferenceEnquiry);
        mv.setViewName("serviceDevelopment/taxPreferenceEnquiry_info");
        return mv;
    }

    @RequestMapping("/saveTaxPreferenceEnquiry")
    public ModelAndView saveTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry,HttpSession session){
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (taxPreferenceEnquiry.getId()!=null){
//            修改
            taxPreferenceEnquiry.setModifier(user.getUsername());
            taxPreferenceEnquiry.setModifyTime(new Date());
            serviceDevelopmentService.updateTaxPreferenceEnquiry(taxPreferenceEnquiry);
        }else {
//            添加
            taxPreferenceEnquiry.setReportPeople(user.getUsername());
            taxPreferenceEnquiry.setReportTime(new Date());
            taxPreferenceEnquiry.setModifier(user.getUsername());
            taxPreferenceEnquiry.setModifyTime(new Date());
            serviceDevelopmentService.insertTaxPreferenceEnquiry(taxPreferenceEnquiry);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
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

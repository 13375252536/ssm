package com.flf.controller;

import com.flf.entity.importantEmergingIndustries.*;
import com.flf.service.ImportantEmergingIndustriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ImportantEmergingIndustriesController
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/14 16:14
 * @Version: 1.0
 */
@Controller
@RequestMapping("/importantEmergingIndustriesService")
public class ImportantEmergingIndustriesController {
    @Autowired
    private ImportantEmergingIndustriesService importantEmergingIndustriesService;

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历战略性新兴产业
     * @Date 2018/9/14 13:18
     * @Param [importantEmergingIndustries]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageImportantEmergingIndustries")
    public ModelAndView listPageImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries,Integer type){
        if (importantEmergingIndustries.getPlacedTop()!=null){
            if (importantEmergingIndustries.getPlacedTop()==2){
                importantEmergingIndustries.setPlacedTop(null);
            }
        }
        if (importantEmergingIndustries.getReportMarks()!=null){
            if (importantEmergingIndustries.getReportMarks()==2){
                importantEmergingIndustries.setReportMarks(null);
            }
        }
        if (type!=null){
            importantEmergingIndustries.setType(type);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("importantEmergingIndustries/importantEmergingIndustries");
        mv.addObject("importantEmergingIndustries",importantEmergingIndustries);
        mv.addObject("listPageImportantEmergingIndustries",importantEmergingIndustriesService.listPageImportantEmergingIndustries(importantEmergingIndustries));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除战略性新兴产业
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteImportantEmergingIndustries")
    public void deleteImportantEmergingIndustries(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.deleteImportantEmergingIndustries(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  战略性新兴产业置顶
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateImportantEmergingIndustriesPlacedTop")
    public void updateImportantEmergingIndustriesPlacedTop(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateImportantEmergingIndustriesPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  战略性新兴产业取消置顶
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateImportantEmergingIndustriesCancelPlacedTop")
    public void updateImportantEmergingIndustriesCancelPlacedTop(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateImportantEmergingIndustriesCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   发布战略性新兴产业
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateImportantEmergingIndustriesReportMarks")
    public void updateImportantEmergingIndustriesReportMarks(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateImportantEmergingIndustriesReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   撤销发布战略性新兴产业
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateImportantEmergingIndustriesCancelReportMarks")
    public void updateImportantEmergingIndustriesCancelReportMarks(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateImportantEmergingIndustriesCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加战略性新兴产业
     * @Date 2018/9/14 13:19
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertImportantEmergingIndustries")
    public ModelAndView insertImportantEmergingIndustries(Integer type,ImportantEmergingIndustries importantEmergingIndustries){
        ModelAndView mv = new ModelAndView();
        importantEmergingIndustries.setType(type);
        mv.addObject("importantEmergingIndustries",importantEmergingIndustries);
        mv.setViewName("importantEmergingIndustries/importantEmergingIndustries_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改战略性新兴产业
     * @Date 2018/9/14 13:20
     * @Param [id, importantEmergingIndustries]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateImportantEmergingIndustries")
    public ModelAndView updateImportantEmergingIndustries(Integer id,ImportantEmergingIndustries importantEmergingIndustries,Integer type){
        importantEmergingIndustries = importantEmergingIndustriesService.selectImportantEmergingIndustriesById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("importantEmergingIndustries",importantEmergingIndustries);
        mv.setViewName("importantEmergingIndustries/importantEmergingIndustries_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存战略性新兴产业
     * @Date 2018/9/14 13:20
     * @Param [importantEmergingIndustries]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveImportantEmergingIndustries")
    public ModelAndView saveImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries){
        List<ImportantEmergingIndustries> list = importantEmergingIndustriesService.selectImportantEmergingIndustriesByName(importantEmergingIndustries);
        ModelAndView mv = new ModelAndView();
        if (importantEmergingIndustries.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if (!list.get(0).getId().equals(importantEmergingIndustries.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            importantEmergingIndustries.setModifyTime(new Date());
            importantEmergingIndustriesService.updateImportantEmergingIndustries(importantEmergingIndustries);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            importantEmergingIndustries.setModifyTime(new Date());
            importantEmergingIndustries.setReleaseTime(new Date());
            importantEmergingIndustriesService.insertImportantEmergingIndustries(importantEmergingIndustries);
        }
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历新兴产业管理信息
     * @Date 2018/9/14 13:18
     * @Param [emergingIndustryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageEmergingIndustryManagement")
    public ModelAndView listPageEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement){
        if (emergingIndustryManagement.getPlacedTop()!=null){
            if (emergingIndustryManagement.getPlacedTop()==2){
                emergingIndustryManagement.setPlacedTop(null);
            }
        }
        if (emergingIndustryManagement.getReportMarks()!=null){
            if (emergingIndustryManagement.getReportMarks()==2){
                emergingIndustryManagement.setReportMarks(null);
            }
        }
        if (emergingIndustryManagement.getType()!=null){
            if (emergingIndustryManagement.getType().equals("0")){
                emergingIndustryManagement.setType(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("importantEmergingIndustries/emergingIndustryManagement");
        mv.addObject("emergingIndustryManagement",emergingIndustryManagement);
        mv.addObject("listPageEmergingIndustryManagement",importantEmergingIndustriesService.listPageEmergingIndustryManagement(emergingIndustryManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除新兴产业管理信息
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteEmergingIndustryManagement")
    public void deleteEmergingIndustryManagement(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.deleteEmergingIndustryManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  新兴产业管理信息置顶
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateEmergingIndustryManagementPlacedTop")
    public void updateEmergingIndustryManagementPlacedTop(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateEmergingIndustryManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  新兴产业管理信息取消置顶
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateEmergingIndustryManagementCancelPlacedTop")
    public void updateEmergingIndustryManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateEmergingIndustryManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   发布新兴产业管理信息
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateEmergingIndustryManagementReportMarks")
    public void updateEmergingIndustryManagementReportMarks(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateEmergingIndustryManagementReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   撤销发布新兴产业管理信息
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateEmergingIndustryManagementCancelReportMarks")
    public void updateEmergingIndustryManagementCancelReportMarks(Integer[] chk_value, PrintWriter out){
        importantEmergingIndustriesService.updateEmergingIndustryManagementCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加新兴产业管理信息
     * @Date 2018/9/14 13:19
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertEmergingIndustryManagement")
    public ModelAndView insertEmergingIndustryManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("importantEmergingIndustries/emergingIndustryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改新兴产业管理信息
     * @Date 2018/9/14 13:20
     * @Param [id, emergingIndustryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateEmergingIndustryManagement")
    public ModelAndView updateEmergingIndustryManagement(Integer id,EmergingIndustryManagement emergingIndustryManagement){
        emergingIndustryManagement = importantEmergingIndustriesService.selectEmergingIndustryManagementById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("emergingIndustryManagement",emergingIndustryManagement);
        mv.setViewName("importantEmergingIndustries/emergingIndustryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存新兴产业管理信息
     * @Date 2018/9/14 13:20
     * @Param [emergingIndustryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveEmergingIndustryManagement")
    public ModelAndView saveEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement){
        List<EmergingIndustryManagement> list = importantEmergingIndustriesService.selectEmergingIndustryManagementByName(emergingIndustryManagement.getName());
        ModelAndView mv = new ModelAndView();
        if (emergingIndustryManagement.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if (!list.get(0).getId().equals(emergingIndustryManagement.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            emergingIndustryManagement.setModifyTime(new Date());
            importantEmergingIndustriesService.updateEmergingIndustryManagement(emergingIndustryManagement);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            emergingIndustryManagement.setModifyTime(new Date());
            emergingIndustryManagement.setReleaseTime(new Date());
            importantEmergingIndustriesService.insertEmergingIndustryManagement(emergingIndustryManagement);
        }
        mv.setViewName("save_result");
        mv.addObject("msg","success");
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

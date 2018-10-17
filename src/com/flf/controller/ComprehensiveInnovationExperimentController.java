package com.flf.controller;

import com.flf.entity.comprehensiveInnovationExperiment.ComprehensiveInnovationExperiment;
import com.flf.service.ComprehensiveInnovationExperimentService;
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
 * @ClassName: ComprehensiveInnovationExperimentController
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/22 14:56
 * @Version: 1.0
 */
@Controller
@RequestMapping("/comprehensiveInnovationExperiment")
public class ComprehensiveInnovationExperimentController {
    @Autowired
    private ComprehensiveInnovationExperimentService comprehensiveInnovationExperimentService;

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历战略性新兴产业
     * @Date 2018/9/14 13:18
     * @Param [comprehensiveInnovationExperiment]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageComprehensiveInnovationExperiment")
    public ModelAndView listPageComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment, Integer type){
        if (comprehensiveInnovationExperiment.getPlacedTop()!=null){
            if (comprehensiveInnovationExperiment.getPlacedTop()==2){
                comprehensiveInnovationExperiment.setPlacedTop(null);
            }
        }
        if (comprehensiveInnovationExperiment.getReportMarks()!=null){
            if (comprehensiveInnovationExperiment.getReportMarks()==2){
                comprehensiveInnovationExperiment.setReportMarks(null);
            }
        }
        if (type!=null){
            comprehensiveInnovationExperiment.setType(type);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("comprehensiveInnovationExperiment/comprehensiveInnovationExperiment");
        mv.addObject("comprehensiveInnovationExperiment",comprehensiveInnovationExperiment);
        mv.addObject("listPageComprehensiveInnovationExperiment",comprehensiveInnovationExperimentService.listPageComprehensiveInnovationExperiment(comprehensiveInnovationExperiment));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除战略性新兴产业
     * @Date 2018/9/14 13:19
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteComprehensiveInnovationExperiment")
    public void deleteComprehensiveInnovationExperiment(Integer[] chk_value, PrintWriter out){
        comprehensiveInnovationExperimentService.deleteComprehensiveInnovationExperiment(chk_value);
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
    @RequestMapping("/updateComprehensiveInnovationExperimentPlacedTop")
    public void updateComprehensiveInnovationExperimentPlacedTop(Integer[] chk_value, PrintWriter out){
        comprehensiveInnovationExperimentService.updateComprehensiveInnovationExperimentPlacedTop(chk_value);
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
    @RequestMapping("/updateComprehensiveInnovationExperimentCancelPlacedTop")
    public void updateComprehensiveInnovationExperimentCancelPlacedTop(Integer[] chk_value, PrintWriter out){
        comprehensiveInnovationExperimentService.updateComprehensiveInnovationExperimentCancelPlacedTop(chk_value);
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
    @RequestMapping("/updateComprehensiveInnovationExperimentReportMarks")
    public void updateComprehensiveInnovationExperimentReportMarks(Integer[] chk_value, PrintWriter out){
        comprehensiveInnovationExperimentService.updateComprehensiveInnovationExperimentReportMarks(chk_value);
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
    @RequestMapping("/updateComprehensiveInnovationExperimentCancelReportMarks")
    public void updateComprehensiveInnovationExperimentCancelReportMarks(Integer[] chk_value, PrintWriter out){
        comprehensiveInnovationExperimentService.updateComprehensiveInnovationExperimentCancelReportMarks(chk_value);
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
    @RequestMapping("/insertComprehensiveInnovationExperiment")
    public ModelAndView insertComprehensiveInnovationExperiment(Integer type,ComprehensiveInnovationExperiment comprehensiveInnovationExperiment){
        ModelAndView mv = new ModelAndView();
        comprehensiveInnovationExperiment.setType(type);
        mv.addObject("comprehensiveInnovationExperiment",comprehensiveInnovationExperiment);
        mv.setViewName("comprehensiveInnovationExperiment/comprehensiveInnovationExperiment_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改战略性新兴产业
     * @Date 2018/9/14 13:20
     * @Param [id, comprehensiveInnovationExperiment]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateComprehensiveInnovationExperiment")
    public ModelAndView updateComprehensiveInnovationExperiment(Integer id,ComprehensiveInnovationExperiment comprehensiveInnovationExperiment,Integer type){
        comprehensiveInnovationExperiment = comprehensiveInnovationExperimentService.selectComprehensiveInnovationExperimentById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("comprehensiveInnovationExperiment",comprehensiveInnovationExperiment);
        mv.setViewName("comprehensiveInnovationExperiment/comprehensiveInnovationExperiment_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存战略性新兴产业
     * @Date 2018/9/14 13:20
     * @Param [comprehensiveInnovationExperiment]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveComprehensiveInnovationExperiment")
    public ModelAndView saveComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment){
        List<ComprehensiveInnovationExperiment> list = comprehensiveInnovationExperimentService.selectComprehensiveInnovationExperimentByName(comprehensiveInnovationExperiment);
        ModelAndView mv = new ModelAndView();
        if (comprehensiveInnovationExperiment.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if (!list.get(0).getId().equals(comprehensiveInnovationExperiment.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            comprehensiveInnovationExperiment.setModifyTime(new Date());
            comprehensiveInnovationExperimentService.updateComprehensiveInnovationExperiment(comprehensiveInnovationExperiment);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            comprehensiveInnovationExperiment.setModifyTime(new Date());
            comprehensiveInnovationExperiment.setReleaseTime(new Date());
            comprehensiveInnovationExperimentService.insertComprehensiveInnovationExperiment(comprehensiveInnovationExperiment);
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

package com.flf.controller;

import com.flf.entity.advisesManagement.MakeRecommendations;
import com.flf.entity.advisesManagement.SuggestionsAndGuidelines;
import com.flf.service.AdvisesManagementService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: AdvisesManagementController
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/22 18:15
 * @Version: 1.0
 */
@Controller
@RequestMapping("/advisesManagement")
public class AdvisesManagementController {

    @Autowired
    private AdvisesManagementService advisesManagementService;
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历建言献策信息
     * @Date 2018/9/22 18:22
     * @Param [makeRecommendations]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageMakeRecommendations")
    public ModelAndView listPageMakeRecommendations(MakeRecommendations makeRecommendations){
        if (makeRecommendations.getState()!=null){
            if (makeRecommendations.getState()==3){
                makeRecommendations.setState(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("advisesManagement/makeRecommendations");
        mv.addObject("makeRecommendations",makeRecommendations);
        mv.addObject("listPageMakeRecommendations",advisesManagementService.listPageMakeRecommendations(makeRecommendations));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除建言献策信息
     * @Date 2018/9/22 18:28
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteMakeRecommendations")
    public void deleteMakeRecommendations(Integer[] chk_value, PrintWriter out){
        advisesManagementService.deleteMakeRecommendations(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  审批建言献策
     * @Date 2018/9/22 18:30
     * @Param [id]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateMakeRecommendationsState")
    public ModelAndView updateMakeRecommendationsState(Integer id){
       MakeRecommendations makeRecommendations = advisesManagementService.selectMakeRecommendationsById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("advisesManagement/makeRecommendations_info");
        mv.addObject("makeRecommendations",makeRecommendations);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   保存建言献策信息
     * @Date 2018/9/22 18:33
     * @Param [makeRecommendations]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveMakeRecommendations")
    public ModelAndView saveMakeRecommendations(MakeRecommendations makeRecommendations){
        ModelAndView mv = new ModelAndView();
        advisesManagementService.updateMakeRecommendationsState(makeRecommendations);
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历建言须知信息
     * @Date 2018/9/22 20:30
     * @Param [suggestionsAndGuidelines]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageSuggestionsAndGuidelines")
    public ModelAndView listPageSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines){
        ModelAndView mv = new ModelAndView();
        mv.addObject("listPageSuggestionsAndGuidelines",advisesManagementService.listPageSuggestionsAndGuidelines(suggestionsAndGuidelines));
        mv.addObject("suggestionsAndGuidelines",suggestionsAndGuidelines);
        mv.setViewName("advisesManagement/suggestionsAndGuidelines");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改建言须知信息
     * @Date 2018/9/22 20:35
     * @Param [suggestionsAndGuidelines]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateSuggestionsAndGuidelines")
    public ModelAndView updateSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines){
        suggestionsAndGuidelines = advisesManagementService.selectSuggestionsAndGuidelinesById();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("advisesManagement/suggestionsAndGuidelines_info");
        mv.addObject("suggestionsAndGuidelines",suggestionsAndGuidelines);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存建言须知信息
     * @Date 2018/9/22 20:36
     * @Param [suggestionsAndGuidelines]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveSuggestionsAndGuidelines")
    public ModelAndView saveSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines){
        advisesManagementService.updateSuggestionsAndGuidelines(suggestionsAndGuidelines);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加建言献策信息
     * @Date 2018/9/27 12:02
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertMakeRecommendations")
    public ModelAndView insertMakeRecommendations(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/makeRecommendations");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询建言须知信息
     * @Date 2018/9/27 12:06
     * @Param [suggestionsAndGuidelines]
     * @return java.lang.String
     */
    @RequestMapping(value = "/selectSuggestionsAndGuidelines", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines){
        List<SuggestionsAndGuidelines> list = advisesManagementService.listPageSuggestionsAndGuidelines(suggestionsAndGuidelines);
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
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

package com.flf.controller;


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
import com.flf.service.impl.IndexServiceImpl;
import com.flf.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/front")
public class IndexController {
    @Autowired
    private IndexServiceImpl indexService;
    private Timer timer;

    /**
     * 请求新增用户页面
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/home")
    public ModelAndView home(Model model) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/home");
        return mv;
    }

    /**
     * @return
     * @Author Mr.Chan
     * @Description //TODO  查询动态管理信息limit=4,传object
     * @Date 2018/9/19 14:42
     * @Param
     */
    @RequestMapping(value = "/selectDynamicManagement", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectDynamicManagement(Integer limit) {
        List<DynamicManagement> list = indexService.selectDynamicManagement();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  二维码图片路径 json传值
     * @Date 2018/9/19 20:59
     * @Param []
     */
    @RequestMapping(value = "/selectQrCode", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectQrCode() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("weixin", indexService.selectQrCodeWeiXin());
        jsonObject.put("sina", indexService.selectQrCodeWeiBo());
        String qrCodeInfo = jsonObject.toString();
        return qrCodeInfo;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  刷部委信息
     * @Date 2018/9/20 16:03
     * @Param []
     */
    @RequestMapping(value = "/selectBuWei", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectBuWei(Integer limit) {
        List<DynamicManagement> list = indexService.selectBuWei();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setDate(sdf.format(list.get(i).getReportDate()));
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  热门信息
     * @Date 2018/9/20 19:46
     * @Param []
     */
    @RequestMapping(value = "/selectShouLu", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectShouLu() {
        List<ImageManagement> list = indexService.selectShouLu();
        JSONObject jsonObject = new JSONObject();
        if (list.size() > 1) {
            list = list.subList(0, 1);
        } else if (list.size() == 1) {
            jsonObject.put("link", list.get(0).getLink());
            jsonObject.put("fileURL", list.get(0).getFileURL());
        }
        String shouLuInfo = jsonObject.toString();
        return shouLuInfo;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  地方信息
     * @Date 2018/9/21 10:23
     * @Param []
     */
    @RequestMapping(value = "/selectDiFang", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectDiFang(Integer limit) {
        List<DynamicManagement> list = indexService.selectDiFang();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  社会团体信息
     * @Date 2018/9/21 16:58
     * @Param [limit]
     */
    @RequestMapping(value = "/selectTuanTi", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectTuanTi(Integer limit) {
        List<DynamicManagement> list = indexService.selectTuanTi();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  基地信息
     * @Date 2018/9/21 16:58
     * @Param [limit]
     */
    @RequestMapping(value = "/selectJiDi", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectJiDi(Integer limit) {
        List<DynamicManagement> list = indexService.selectJiDi();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  全面创新实验
     * @Date 2018/9/21 17:01
     * @Param [limit]
     */
    @RequestMapping(value = "/selectChuangXinShiYan", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectChuangXinShiYan(Integer limit) {
        List<ComprehensiveInnovationExperiment> list = indexService.selectChuangXinShiYan();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询战略性新兴产业信息
     * @Date 2018/9/25 16:05
     * @Param [limit]
     */
    @RequestMapping(value = "/selectXinXingChanYe", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectXinXingChanYe(Integer limit) {
        List<EmergingIndustryManagement> list = indexService.selectXinXingChanYe();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  活动跟踪信息
     * @Date 2018/9/25 16:56
     * @Param [limit, type]
     */
    @RequestMapping(value = "/selectHuoDongGengZong", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectHuoDongGengZong(Integer limit, Integer type) {
        String temp;
        if (type == 1) {
            temp = "双创活动周";
        } else {
            temp = "创响中国";
        }
        List<MediaManagement> list = indexService.selectHuoDongGengZong(temp);
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转示范基地页面
     * @Date 2018/9/26 11:25
     * @Param []
     */
    @RequestMapping("/demonstrationBase")
    public ModelAndView demonstrationBase() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/demonstrationBase");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  示范基地图片轮播图
     * @Date 2018/9/26 11:05
     * @Param [limit]
     */
    @RequestMapping(value = "/selectJiDiLunBoTu", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectJiDiLunBoTu(Integer limit) {
        List<DemonstrationBaseManagement> list = indexService.selectJiDiLunBoTu();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询基地动态信息
     * @Date 2018/9/26 18:54
     * @Param []
     */
    @RequestMapping(value = "/selectJiDiDongTaiXingXi", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectJiDiDongTaiXingXi(DynamicManagement dynamicManagement, String batch, String type, Integer pageSize, Integer pageNum) {
        if (batch.equals("1")) {
            dynamicManagement.setBaseBatch("首批");
        } else if (batch.equals("2")) {
            dynamicManagement.setBaseBatch("第二批");
        } else {
            dynamicManagement.setBaseBatch(null);
        }
        if (type.equals("00")) {
            dynamicManagement.setBaseType("区域示范基地");
        } else if (type.equals("02")) {
            dynamicManagement.setBaseType("企业示范基地");
        } else if (type.equals("01")) {
            dynamicManagement.setBaseType("高校和科研院所示范基地");
        } else {
            dynamicManagement.setBaseType(null);
        }
        Integer temp = (pageNum - 1) * pageSize;
        dynamicManagement.setStart(temp);
        dynamicManagement.setPageSize(pageSize);
        List<DynamicManagement> list = indexService.selectJiDiDongTaiXingXi(dynamicManagement);
        Integer allCounts = indexService.selectJiDiDongTaiXingXiCount(dynamicManagement);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allCounts", allCounts);
        jsonArray.add(jsonObject);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转基地库信息
     * @Date 2018/9/28 9:19
     * @Param []
     */
    @RequestMapping("/skipBaseLibrary")
    public ModelAndView skipBaseLibrary() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/baseLibrary");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  前台基地库动态信息
     * @Date 2018/9/28 11:21
     * @Param [demonstrationBaseManagement, batch, type, pageSize, pageNum]
     */
    @RequestMapping(value = "/selectJiDiKuDongTaiXingXi", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectJiDiKuDongTaiXingXi(DemonstrationBaseManagement demonstrationBaseManagement, String batch, String type, Integer pageSize, Integer pageNum, Integer areaId, @RequestParam(value = "baseName", required = false) String baseName) {
        if (batch.equals("1")) {
            demonstrationBaseManagement.setBatch("首批");
        } else if (batch.equals("2")) {
            demonstrationBaseManagement.setBatch("第二批");
        } else {
            demonstrationBaseManagement.setBatch(null);
        }
        if (areaId != null) {
            demonstrationBaseManagement.setArea(areaId);
        }
        if (StringUtils.isNotBlank(baseName)) {
            List<Integer> baseIds = indexService.selectDemonstrationBaseManagementByBaseName(baseName);
            demonstrationBaseManagement.setBaseIds(baseIds);
        }
        if (type.equals("00")) {
            demonstrationBaseManagement.setType("区域示范基地");
        } else if (type.equals("02")) {
            demonstrationBaseManagement.setType("企业示范基地");
        } else if (type.equals("01")) {
            demonstrationBaseManagement.setType("高校和科研院所示范基地");
        } else {
            demonstrationBaseManagement.setType(null);
        }
        Integer allCounts = indexService.selectJiDiKuDongTaiXingXiCount(demonstrationBaseManagement);
        Integer temp = (pageNum - 1) * pageSize;
        demonstrationBaseManagement.setStart(temp);
        demonstrationBaseManagement.setPageSize(pageSize);
        List<DemonstrationBaseManagement> list1 = indexService.selectJiDiKuXingXi(demonstrationBaseManagement);
        JSONArray jsonArray = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < list1.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            List<Object> list3 = new ArrayList<Object>();
            demonstrationBaseManagement = list1.get(i);
            List<DynamicManagement> list2 = indexService.selectDongTaiXingXiByBaseId(list1.get(i).getId());
            for (int j = 0; j < list2.size(); j++) {
                list2.get(j).setDate(sdf.format(list2.get(j).getReportDate()));
            }
            jsonObject.put("dynamicList", list2);
            list3.add(demonstrationBaseManagement);
            list3.add(jsonObject);
            jsonArray.add(list3);
        }
        jsonArray.add(allCounts);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转建言献策页面
     * @Date 2018/9/27 12:02
     * @Param []
     */
    @RequestMapping("/insertMakeRecommendations")
    public ModelAndView insertMakeRecommendations() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/makeRecommendations");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  保存前端建言献策信息
     * @Date 2018/9/27 14:15
     * @Param [arr]
     */
    @ResponseBody
    @RequestMapping("/saveMakeRecommendations")
    public String saveRecommendations(MakeRecommendations arr) {
        JSONObject jsonObject = new JSONObject();
        arr.setTime(new Date());
        indexService.insertMakeRecommendations(arr);
        jsonObject.put("code", "200");
        String jsonString = jsonObject.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询建言须知信息
     * @Date 2018/9/27 12:06
     * @Param [suggestionsAndGuidelines]
     */
    @RequestMapping(value = "/selectSuggestionsAndGuidelines", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines) {
        List<SuggestionsAndGuidelines> list = indexService.listPageSuggestionsAndGuidelines(suggestionsAndGuidelines);
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转服务拓展页面
     * @Date 2018/9/28 14:07
     * @Param []
     */
    @RequestMapping("/skipServiceDevelopment")
    public ModelAndView skipServiceDevelopment() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/serviceDevelopment");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询所有时间轴信息
     * @Date 2018/9/28 14:33
     * @Param []
     */
    @RequestMapping(value = "/selectTimeLineInfo", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectTimeLineInfo() {
        List<TimelineMaintenance> list = indexService.selectTimeLineInfo();
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询办事指南信息
     * @Date 2018/9/28 20:48
     * @Param [guideManagement, type, pageSize, pageNum]
     */
    @RequestMapping(value = "/selectGuideManagementInfo", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectGuideManagementInfo(String type1) {
        Integer typeId;
        if (type1.equals("2")) {
            typeId = 2;
        } else {
            typeId = 1;
        }
        List<GuideManagement> list = indexService.selectGuideManagementInfo(typeId);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return
     * @Author Mr.Chan
     * @Description //TODO  查询首页政策部委信息
     * @Date 2018/9/28 20:48
     * @Param
     */
    @RequestMapping(value = "/selectPolicyIssuedByReportUnit", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectPolicyIssuedByReportUnit(Integer limit) {
        List<PolicyIssued> list = indexService.selectPolicyIssuedByReportUnit();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO   查询首页政策地方信息
     * @Date 2018/9/28 20:57
     * @Param []
     */
    @RequestMapping(value = "/selectPolicyIssuedByRegion", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectPolicyIssuedByRegion(Integer limit) {
        List<PolicyIssued> list = indexService.selectPolicyIssuedByRegion();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  通过页面点击量降序查询政策发布信息
     * @Date 2018/9/28 21:15
     * @Param [limit]
     */
    @RequestMapping(value = "/selectPolicyIssuedByPageView", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectPolicyIssuedByPageView(Integer limit) {
        List<PolicyIssued> list = indexService.selectPolicyIssuedByPageView();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询活动跟踪创响中国信息
     * @Date 2018/9/29 11:10
     * @Param [limit]
     */
    @RequestMapping(value = "/selectHuoDongGengZongCXZG", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectHuoDongGengZongCXZG(Integer limit) {
        List<ActivityManagement> list = indexService.selectHuoDongGengZongCXZG();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询活动跟踪双创周信息
     * @Date 2018/9/29 11:10
     * @Param [limit]
     */
    @RequestMapping(value = "/selectHuoDongGengZongSCZ", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectHuoDongGengZongSCZ(Integer limit) {
        List<ActivityManagement> list = indexService.selectHuoDongGengZongSCZ();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询活动跟踪banner图片
     * @Date 2018/9/29 11:38
     * @Param [limit]
     */
    @RequestMapping(value = "/selectHuoDongGenZongBanner", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectHuoDongGenZongBanner(Integer limit) {
        List<ImageManagement> list = indexService.selectHuoDongGenZongBanner();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  通过type查询活动类别的信息
     * @Date 2018/9/29 12:45
     * @Param [activityCategoryManagement, category, pageSize, pageNum]
     */
    @RequestMapping(value = "/selectActivityCategoryManagementByType", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectActivityCategoryManagementByType(ActivityCategoryManagement activityCategoryManagement, Integer category, Integer pageSize, Integer pageNum) {
        if (category == 0) {
            activityCategoryManagement.setType("部委活动");
        } else if (category == 1) {
            activityCategoryManagement.setType("地方活动");
        } else if (category == 2) {
            activityCategoryManagement.setType("基地活动");
        } else {
            activityCategoryManagement.setType("团体活动");
        }
        Integer temp = (pageNum - 1) * pageSize;
        activityCategoryManagement.setStart(temp);
        activityCategoryManagement.setPageSize(pageSize);
        List<ActivityCategoryManagement> list = indexService.selectActivityCategoryManagementByType(activityCategoryManagement);
        Integer allCounts = indexService.selectActivityCategoryManagementByTypeCount(activityCategoryManagement);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", list);
        jsonObject.put("allCounts", allCounts);
        String jsonString = jsonObject.toString();
        return jsonString;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO   跳转活动跟踪
     * @Date 2018/9/29 12:59
     * @Param []
     */
    @RequestMapping("/skipActivityTracking")
    public ModelAndView skipActivityTracking() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/activityTrace");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  通过type查询动态管理中的动态政策信息
     * @Date 2018/10/2 10:50
     * @Param [limit]
     */
    @RequestMapping(value = "/selectDynamicManagementByTypeZCDT", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectDynamicManagementByTypeZCDT(Integer limit) {
        List<DynamicManagement> list = indexService.selectDynamicManagementByTypeZCDT();
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询所有地区信息
     * @Date 2018/10/2 11:20
     * @Param []
     */
    @RequestMapping(value = "/selectAllRegionList", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectAllRegionList() {
        List<RegionalDataMaintenance> list = indexService.selectAllRegionList();
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
        return jsonString;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询动态管理信息通过政策动态内的动态点击给政策动态页面
     * @Date 2018/10/2 13:01
     * @Param [dynamicManagement, pageSize, pageNum, areaId, pubDeptFlag, basesActivityFlag]
     */
    @RequestMapping(value = "/selectDynamicManagementByZCDTClick", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectDynamicManagementByZCDTClick(DynamicManagement dynamicManagement, Integer pageSize, Integer pageNum, Integer areaId, Integer pubDeptFlag, Integer basesActivityFlag) {
        if (basesActivityFlag != null) {
            dynamicManagement.setBase(0);
        } else {
            dynamicManagement.setBase(null);
        }
        if (pubDeptFlag != null) {
            dynamicManagement.setReleaseUnit(0);
        } else {
            dynamicManagement.setReleaseUnit(null);
        }
        if (areaId != null) {
            dynamicManagement.setRegion(areaId);
        } else {
            dynamicManagement.setRegion(null);
        }
        Integer temp = (pageNum - 1) * pageSize;
        dynamicManagement.setStart(temp);
        dynamicManagement.setPageSize(pageSize);
        List<DynamicManagement> list = indexService.selectDynamicManagementByZCDTClick(dynamicManagement);
        Integer allCounts = indexService.selectDynamicManagementByZCDTClickCounts(dynamicManagement);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allCounts", allCounts);
        map.put("data", jsonArray);
        jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转政策动态
     * @Date 2018/10/2 13:12
     * @Param []
     */
    @RequestMapping("/skipPolicyDynamic")
    public ModelAndView skipPolicyDynamic() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/policyDynamic");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  查询区域,行业,创业人群,政策分类全部信息
     * @Date 2018/10/2 22:02
     * @Param []
     */
    @RequestMapping(value = "/getFilterInfo", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getFilterInfo() {
        List<RegionalDataMaintenance> region = indexService.selectAllRegionList();
        List<IndustryDataMaintenance> industry = indexService.selectAllIndustryList();
        List<EntrepreneurshipGroupMaintenance> businessPeople = indexService.selectAllEntrepreneurshipGroupMaintenanceList();
        List<PolicyClassificationMaintenance> policyClassification = indexService.selectAllPolicyClassificationMaintenance();
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();
        JSONArray jsonArray1 = JSONArray.fromObject(region);
        JSONArray jsonArray2 = JSONArray.fromObject(industry);
        JSONArray jsonArray3 = JSONArray.fromObject(businessPeople);
        JSONArray jsonArray4 = JSONArray.fromObject(policyClassification);
        map.put("region", jsonArray1);
        map.put("industry", jsonArray2);
        map.put("businessPeople", jsonArray3);
        map.put("policyClassification", jsonArray4);
        jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转政策库页面
     * @Date 2018/10/3 17:48
     * @Param []
     */
    @RequestMapping("/skipPolicyLibrary")
    public ModelAndView skipPolicyLibrary() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/policyLibrary");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  政策查询页面信息
     * @Date 2018/10/5 14:12
     * @Param [policyIssued, issuedno, pageNum, pageSize, areaFlagId, areaId, zoneId, businessPeopleId, startDate, endDate, industryId, unitName, keyword]
     */
    @RequestMapping(value = "/selectPolicyIssuedByZCCXClick", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String selectPolicyIssuedByZCCXClick(PolicyIssued policyIssued, String issuedno, Integer pageNum, Integer pageSize, Integer areaFlagId, Integer areaId, Integer zoneId, Integer businessPeopleId, String startDate, String endDate, Integer industryId, String unitName, String keyword) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotBlank(startDate)) {
            Date reportDateStart = sdf.parse(startDate);
            policyIssued.setReportDateStart(reportDateStart);
        }
        if (StringUtils.isNotBlank(endDate)) {
            Date ReportDateEnd = sdf.parse(endDate);
            policyIssued.setReportDateEnd(ReportDateEnd);
        }
        Integer temp = (pageNum - 1) * pageSize;
        policyIssued.setStart(temp);
        policyIssued.setPageSize(pageSize);
        policyIssued.setPostShopName(issuedno);
        policyIssued.setReportUnit(unitName);
        policyIssued.setName(keyword);
        if (areaFlagId != null) {
            policyIssued.setReportUnit("0");
        }
        if (areaId != null) {
            String region = indexService.selectRegionNameById(areaId);
            policyIssued.setRegion(region);
        }
        if (zoneId != null) {
            String policyClassification = indexService.selectPolicyClassificationById(zoneId);
            policyIssued.setPolicyClassification(policyClassification);
        }
        if (businessPeopleId != null) {
            String businessPeople = indexService.selectBusinessPeopleById(businessPeopleId);
            policyIssued.setBusinessPeople(businessPeople);
        }
        if (industryId != null) {
            String industry = indexService.selectIndustryById(industryId);
            policyIssued.setIndustry(industry);
        }
        List<PolicyIssued> list = indexService.selectPolicyIssuedByZCCXClick(policyIssued);
        Integer allCounts = indexService.selectPolicyIssuedByZCCXClickCounts(policyIssued);
        JSONObject jsonObject = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allCounts", allCounts);
        map.put("data", jsonArray);
        jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO   跳转政策分析
     * @Date 2018/10/5 13:46
     * @Param []
     */
    @RequestMapping("/skipPolicyAnalysis")
    public ModelAndView skipPolicyAnalysis() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/policyAnalysis");
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  政策分析页面最火政策
     * @Date 2018/10/5 14:11
     * @Param [limit, type]
     */
    @RequestMapping(value = "/getPolicyAnalysisInfo", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getPolicyAnalysisInfo(Integer limit, Integer type) {
        List<PolicyIssued> list;
        if (type == 0) {
            list = indexService.selectPolicyIssuedByAnnualPageView();
        } else if (type == 1) {
            list = indexService.selectPolicyIssuedByQuarterPageView();
        } else if (type == 2) {
            list = indexService.selectPolicyIssuedByMonthlyPageView();
        } else {
            list = indexService.selectPolicyIssuedByWeeklyPageView();
        }
        if (list.size() > limit) {
            list = list.subList(0, limit);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        map.put("data", jsonArray);
        jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转动态详情页面
     * @Date 2018/10/6 11:40
     * @Param [id]
     */
    @RequestMapping("/skipDynamicDetails")
    public ModelAndView skipDynamicDetails(Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/dynamicDetails");
        mv.addObject("id", id);
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO  点击动态 得到该动态详情
     * @Date 2018/10/6 20:34
     * @Param [id]
     */
    @RequestMapping(value = "/getDynamicManagementInfoById", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getDynamicManagementInfoById(Integer id, DynamicManagement dynamicManagement) {
        Integer pageView = indexService.getDynamicManagementPageViewsById(id);
        pageView++;
        dynamicManagement.setPageViews(pageView);
        dynamicManagement.setId(id);
        indexService.updateDynamicManagementPageViewsById(dynamicManagement);
        List<DynamicManagement> list = indexService.getDynamicManagementInfoById(id);
        JSONObject jsonObject = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", jsonArray);
        map.put("pageView", pageView);
        jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  跳转政策详情页面
     * @Date 2018/10/6 11:40
     * @Param [id]
     */
    @RequestMapping("/skipPolicyDetails")
    public ModelAndView skipPolicyDetails(Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("front/policyDetails");
        mv.addObject("id", id);
        return mv;
    }

    /**
     * @return java.lang.String
     * @Author Mr.Chan
     * @Description //TODO   点击政策 得到该政策详情
     * @Date 2018/10/6 22:02
     * @Param [id, policyIssued]
     */
    @RequestMapping(value = "/getPolicyIssuedPageViewsById", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getPolicyIssuedPageViewsById(Integer id, PolicyIssued policyIssued) {
        Integer pageView = indexService.getPolicyIssuedPageViewsById(id);
        pageView++;
        policyIssued.setId(id);
        policyIssued.setPageView(pageView);
        indexService.updatePolicyIssuedPageViewsById(policyIssued);
        List<PolicyIssued> list = indexService.getPolicyIssuedInfoById(id);
        JSONObject jsonObject = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", jsonArray);
        map.put("pageView", pageView);
        jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  每周清零政策管理表的浏览量内容
     * @Date 2018/10/8 16:22
     * @Param []
     */
    public void weeklyCleaning() {
        List<PolicyIssued> list = indexService.getAllPolicyIssuedInfo();
        for (int i = 0; i < list.size(); i++) {
            indexService.updatePolicyIssuedWeeklyPageView(list.get(i).getId());
        }
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  每月清零政策管理表的浏览量内容
     * @Date 2018/10/8 16:22
     * @Param []
     */
    public void monthlyCleaning() {
        List<PolicyIssued> list = indexService.getAllPolicyIssuedInfo();
        for (int i = 0; i < list.size(); i++) {
            indexService.updatePolicyIssuedMonthlyPageView(list.get(i).getId());
        }
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  每季度清零政策管理表的浏览量内容
     * @Date 2018/10/8 16:22
     * @Param []
     */
    public void quarterCleaning() {
        List<PolicyIssued> list = indexService.getAllPolicyIssuedInfo();
        for (int i = 0; i < list.size(); i++) {
            indexService.updatePolicyIssuedQuarterPageView(list.get(i).getId());
        }
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  每年清零政策管理表的浏览量内容
     * @Date 2018/10/8 16:22
     * @Param []
     */
    public void annualCleaning() {
        List<PolicyIssued> list = indexService.getAllPolicyIssuedInfo();
        for (int i = 0; i < list.size(); i++) {
            indexService.updatePolicyIssuedAnnualPageView(list.get(i).getId());
        }
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  周度浏览量清理
     * @Date 2018/10/10 9:19
     * @Param []
     */
    @RequestMapping(value = "/weeklyCleaningAction", produces = "text/html;charset=utf-8")
    public void weeklyCleaningAction() throws ParseException {
        timer = new java.util.Timer(true);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.set(Calendar.DATE, calendar.get(calendar.DATE) + 6);
        String weeklast = df.format(calendar.getTime()+"23:59:59");
        Date dateWeek = df.parse(weeklast);
        timer.schedule(new MyTimerTaskWeeklyCleaning(), dateWeek, 604800000L);
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  月度浏览量清理
     * @Date 2018/10/10 9:19
     * @Param []
     */
    @RequestMapping(value = "/mouthlyCleaningAction", produces = "text/html;charset=utf-8")
    public void mouthlyCleaningAction() throws ParseException {
        int x;                  // 日期属性：年
        int y;                  // 日期属性：月
        Calendar localTime = null;     // 当前日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timer = new java.util.Timer(true);
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        String strY = null;
        String strZ = null;
        boolean leap = false;
        x = localTime.get(Calendar.YEAR);
        y = localTime.get(Calendar.MONTH) + 1;
        if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10 || y == 12) {
            strZ = "31";
        }
        if (y == 4 || y == 6 || y == 9 || y == 11) {
            strZ = "30";
        }
        if (y == 2) {
            leap = leapYear(x);
            if (leap) {
                strZ = "29";
            } else {
                strZ = "28";
            }
        }
        strY = y >= 10 ? String.valueOf(y) : ("0" + y);
        String mouthEnd = x + "-" + strY + "-" + strZ + "23:59:59";
        String nextMouth = "";
        if (strY.equals(12)) {
            nextMouth = x + 1 + "-" + "01-31 23:59:59";
        } else {
            Integer m = Integer.valueOf(strY) + 1;
            if (m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                strZ = "31";
            }
            if (m == 4 || m == 6 || m == 9 || m == 11) {
                strZ = "30";
            }
            if (m == 2) {
                leap = leapYear(x);
                if (leap) {
                    strZ = "29";
                } else {
                    strZ = "28";
                }
            }
            nextMouth = x + "-" + m + "-" + strZ + "23:59:59";
        }
        Date dateMouth = df.parse(mouthEnd);
        Date dateNext = df.parse(nextMouth);
        Long ts = dateNext.getTime() - dateMouth.getTime();
        timer.schedule(new MyTimerTaskMouthlyCleaning(), dateMouth, ts);
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  季度浏览量清理
     * @Date 2018/10/10 9:19
     * @Param []
     */
    @RequestMapping(value = "/quarterCleaningAction", produces = "text/html;charset=utf-8")
    public void quarterCleaningAction() throws ParseException {
        timer = new java.util.Timer(true);
        Calendar calendar = Calendar.getInstance();
        int x;                  // 日期属性：年
        int y;                  // 日期属性：月
        Calendar localTime = null;     // 当前日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateString = "";
        String nextDate = "";
        x = localTime.get(Calendar.YEAR);
        y = localTime.get(Calendar.MONTH) + 1;
        if (y >= 1 && y <= 3) {
            dateString = x + "-" + "03" + "-" + "31"+ "23:59:59";
        }
        if (y >= 4 && y <= 6) {
            dateString = x + "-" + "06" + "-" + "30"+ "23:59:59";
        }
        if (y >= 7 && y <= 9) {
            dateString = x + "-" + "09" + "-" + "30"+ "23:59:59";
        }
        if (y >= 10 && y <= 12) {
            dateString = x + "-" + "12" + "-" + "31"+ "23:59:59";
        }
        if (y >= 1 && y <= 3) {
            nextDate = x + "-" + "06" + "-" + "30"+ "23:59:59";
        }
        if (y >= 4 && y <= 6) {
            nextDate = x + "-" + "09" + "-" + "30"+ "23:59:59";
        }
        if (y >= 7 && y <= 9) {
            nextDate = x + "-" + "12" + "-" + "31"+ "23:59:59";
        }
        if (y >= 10 && y <= 12) {
            nextDate = x + "-" + "03" + "-" + "31"+ "23:59:59";
        }
        Date dateQuarter = df.parse(dateString);
        Date dateNext = df.parse(nextDate);
        Long ts = dateNext.getTime() - dateQuarter.getTime();
        timer.schedule(new MyTimerTaskQuarterCleaning(), dateQuarter, ts);
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  年度浏览量清理
     * @Date 2018/10/10 9:20
     * @Param []
     */
    @RequestMapping(value = "/annualCleaningAction", produces = "text/html;charset=utf-8")
    public void annualCleaningAction() throws ParseException {
        timer = new java.util.Timer(true);
        int x;                  // 日期属性：年
        Calendar localTime = null;     // 当前日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        x = localTime.get(Calendar.YEAR);
        String year = x + "-12" + "-31";
        String nextYear = x+1 + "-12" + "-31";
        Date dateAnnual = df.parse(year);
        Date yearNext = df.parse(nextYear);
        Long ts = yearNext.getTime() - dateAnnual.getTime();
        timer.schedule(new MyTimerTaskAnnualCleaning(), dateAnnual, ts);
    }

    /**
     * @return boolean
     * @Author Mr.Chan
     * @Description //TODO  判断是否是闰年
     * @Date 2018/10/15 10:46
     * @Param [year]
     */
    public boolean leapYear(int year) {
        boolean leap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) leap = true;
                else leap = false;
            } else leap = true;
        } else leap = false;
        return leap;
    }
}

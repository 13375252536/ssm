package com.flf.controller;

import com.flf.entity.*;
import com.flf.entity.demonstrationBase.DemonstrationBaseManagement;
import com.flf.entity.homePage.*;
import com.flf.entity.policyManagement.RegionalDataMaintenance;
import com.flf.service.ActivityManagementService;
import com.flf.service.HomePageService;
import com.flf.util.Const;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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
 * @ClassName: HomePageController
 * @Description: //TODO  首页的controller层
 * @Author: Mr.Chan
 * @Data: 2018/8/28 11:55
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/homePage", produces = "text/html;charset=utf-8")
public class HomePageController {
    @Autowired
    private HomePageService homePageService;
    @Autowired
    private ActivityManagementService activityManagementService;
    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO   查询微博与微信的url地址  传值到qrCodeManagement.jsp
     * @Date 2018/8/28 18:51
     * @Param []
     */
    @RequestMapping(value = "/updateQrCodeManagement")
    public ModelAndView updateQrCodeManagement() {
        ModelAndView mv = new ModelAndView();
        if (homePageService.selectURLByWeiBo().isEmpty() && homePageService.selectURLByWeiXin().isEmpty()) {

        } else {
            mv.addObject("selectURLByWeiBo", homePageService.selectURLByWeiBo());
            mv.addObject("selectURLByWeiXin", homePageService.selectURLByWeiXin());
        }
        mv.setViewName("homePage/qrCodeManagement");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO   前端上传的图片拼接成相对路径储存到数据库中
     * @Date 2018/8/28 18:53
     * @Param [file, map, req, qrCodeManagement]
     */
    @RequestMapping(value = "/saveQrCodeManagement", produces = "text/html;charset=utf-8")
    public ModelAndView saveQrCodeManagement(@RequestParam(value = "file", required = false) MultipartFile file, Map map, HttpServletRequest req, QrCodeManagement qrCodeManagement) {
        ModelAndView modelAndView = new ModelAndView();
        map = homePageService.uploadFile(file, req);
        if (file.isEmpty()) {

        } else {
            qrCodeManagement.setQrCodeURL("/uploadImgs/" + map.get("fileUrl"));
            homePageService.updateQrCodeManagement(qrCodeManagement);
        }
        modelAndView.addObject("selectURLByWeiBo", homePageService.selectURLByWeiBo());
        modelAndView.addObject("selectURLByWeiXin", homePageService.selectURLByWeiXin());
        modelAndView.setViewName("homePage/qrCodeManagement");
        updateQrCodeManagement();
        return modelAndView;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  图片管理的查询界面
     * @Date 2018/8/30 9:42
     * @Param [imageManagement]
     */
    @RequestMapping(value = "/listPageImageManagement")
    public ModelAndView listPageImageManagement(ImageManagement imageManagement) {
        List<ImageManagement> listPageImageManagement = homePageService.listPageImageManagement(imageManagement);
        ModelAndView mv = new ModelAndView();
        mv.addObject("ImageManagement", imageManagement);
        mv.addObject("listPageImageManagement", listPageImageManagement);
        mv.setViewName("homePage/imageManagement");
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  图片管理的批量删除
     * @Date 2018/8/30 9:42
     * @Param [chk_value, out]
     */
    @RequestMapping(value = "/deleteImageManagement")
    public void delImageManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteImageManagement(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  图片管理插入
     * @Date 2018/8/30 9:44
     * @Param [imageManagement]
     */
    @RequestMapping(value = "/insertImageManagement")
    public ModelAndView insertImageManagement(ImageManagement imageManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/imageManagement_info");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  图片管理保存
     * @Date 2018/8/30 9:45
     * @Param [imageManagement, file, map, req, user]
     */
    @RequestMapping(value = "/saveImageManagement")
    public ModelAndView saveImageManagement(ImageManagement imageManagement, @RequestParam(value = "file", required = false) MultipartFile file, Map map, HttpServletRequest req, HttpSession session) {
        User user = (User) session.getAttribute(Const.SESSION_USER);
        ModelAndView mv = new ModelAndView();
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectImageManagementById(imageManagement.getId());
            imageManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            imageManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (imageManagement.getId() != null) {
//            修改时id不为null
            imageManagement.setModifier(user.getUsername());
            imageManagement.setModifyTime(new Date());
            homePageService.updateImageManagement(imageManagement);
        } else {
//            添加时id为null
            imageManagement.setReleasePeople(user.getUsername());
            imageManagement.setModifyTime(new Date());
            imageManagement.setReleaseTime(new Date());
            imageManagement.setModifier(user.getUsername());
            System.out.println(imageManagement);
            homePageService.insertImageManagement(imageManagement);
        }
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  修改图片管理信息
     * @Date 2018/8/30 10:35
     * @Param [imageManagement]
     */
    @RequestMapping(value = "/updateImageManagement")
    public ModelAndView updateImageManagement(ImageManagement imageManagement, @RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/imageManagement_info");
        List<Map<String, Object>> mapList = homePageService.selectImageManagementById(id);
        imageManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        imageManagement.setLink((String) mapList.get(0).get("link"));
        imageManagement.setName((String) mapList.get(0).get("name"));
        imageManagement.setSorting(String.valueOf(mapList.get(0).get("sorting")));
        imageManagement.setType((String) mapList.get(0).get("type"));
        imageManagement.setId(id);
        mv.addObject("imageManagement", imageManagement);
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  图片管理信息置顶
     * @Date 2018/8/30 15:20
     * @Param [chk_value, out]
     */
    @RequestMapping(value = "/updateImageManagementPlacedTop")
    public void updateImageManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateImageManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  图片管理信息取消置顶
     * @Date 2018/8/30 15:21
     * @Param [chk_value, out]
     */
    @RequestMapping(value = "/updateImageManagementCancelPlacedTop")
    public void updateImageManagementcancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateImageManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  遍历创业群体维护信息
     * @Date 2018/9/4 9:28
     * @Param [entrepreneurshipGroupMaintenance]
     */
    @RequestMapping("/listPageEntrepreneurshipGroupMaintenance")
    public ModelAndView listPageEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance) {
        ModelAndView mv = new ModelAndView();
        List<EntrepreneurshipGroupMaintenance> listPageEntrepreneurshipGroupMaintenance = homePageService.listPageEntrepreneurshipGroupMaintenance(entrepreneurshipGroupMaintenance);
        mv.addObject("entrepreneurshipGroupMaintenance", entrepreneurshipGroupMaintenance);
        mv.addObject("listPageEntrepreneurshipGroupMaintenance", listPageEntrepreneurshipGroupMaintenance);
        mv.setViewName("homePage/entrepreneurshipGroupMaintenance");
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除创业群体维护信息
     * @Date 2018/9/4 9:28
     * @Param [chk_value, out]
     */
    @RequestMapping(value = "/deleteEntrepreneurshipGroupMaintenance")
    public void deleteEntrepreneurshipGroupMaintenance(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteEntrepreneurshipGroupMaintenance(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   创业群体维护信息置顶
     * @Date 2018/9/4 9:29
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateEntrepreneurshipGroupMaintenancePlacedTop")
    public void updateEntrepreneurshipGroupMaintenancePlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateEntrepreneurshipGroupMaintenancePlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   创业群体信息取消置顶
     * @Date 2018/9/4 9:29
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateEntrepreneurshipGroupMaintenanceCancelPlacedTop")
    public void updateEntrepreneurshipGroupMaintenanceCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateEntrepreneurshipGroupMaintenanceCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  添加创业群体信息
     * @Date 2018/9/4 9:30
     * @Param []
     */
    @RequestMapping("/insertEntrepreneurshipGroupMaintenance")
    public ModelAndView insertEntrepreneurshipGroupMaintenance() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/entrepreneurshipGroupMaintenance-info");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO   修改创业群体信息
     * @Date 2018/9/4 9:30
     * @Param [entrepreneurshipGroupMaintenance, id]
     */
    @RequestMapping("/updateEntrepreneurshipGroupMaintenance")
    public ModelAndView updateEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance, @RequestParam("id") Integer id) {
        List<Map<String, Object>> mapList = homePageService.selectEntrepreneurshipGroupMaintenanceById(id);
        entrepreneurshipGroupMaintenance.setFileURL((String) mapList.get(0).get("fileURL"));
        entrepreneurshipGroupMaintenance.setId(id);
        entrepreneurshipGroupMaintenance.setName((String) mapList.get(0).get("name"));
        entrepreneurshipGroupMaintenance.setSorting((Integer) mapList.get(0).get("sorting"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/entrepreneurshipGroupMaintenance-info");
        mv.addObject("entrepreneurshipGroupMaintenance", entrepreneurshipGroupMaintenance);
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  保存创业群体信息
     * @Date 2018/9/4 9:30
     * @Param [entrepreneurshipGroupMaintenance, session, file, map, req]
     */
    @RequestMapping("/saveEntrepreneurshipGroupMaintenance")
    public ModelAndView saveEntrepreneurshipGroupMaintenance(EntrepreneurshipGroupMaintenance entrepreneurshipGroupMaintenance, HttpSession session, @RequestParam(value = "file", required = false) MultipartFile file, Map map, HttpServletRequest req) {
        List<EntrepreneurshipGroupMaintenance> list = homePageService.selectEntrepreneurshipGroupMaintenanceByName(entrepreneurshipGroupMaintenance.getName());
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (entrepreneurshipGroupMaintenance.getId() != null) {
//            id不为null 修改
            if (!list.isEmpty()){
                if (!list.get(0).getId().equals(entrepreneurshipGroupMaintenance.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            if (file == null || file.isEmpty()) {
                List<Map<String, Object>> mapList = homePageService.selectEntrepreneurshipGroupMaintenanceById(entrepreneurshipGroupMaintenance.getId());
                entrepreneurshipGroupMaintenance.setFileURL((String) mapList.get(0).get("fileURL"));
            } else {
                map = homePageService.uploadFile(file, req);
                entrepreneurshipGroupMaintenance.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            entrepreneurshipGroupMaintenance.setModifier(user.getUsername());
            entrepreneurshipGroupMaintenance.setModifyTime(new Date());
            homePageService.updateEntrepreneurshipGroupMaintenance(entrepreneurshipGroupMaintenance);
        } else {
//            id为null 添加
            if (!list.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
                map = homePageService.uploadFile(file, req);
                entrepreneurshipGroupMaintenance.setFileURL("/uploadImgs/" + map.get("fileUrl"));
                entrepreneurshipGroupMaintenance.setReleasePeople(user.getUsername());
                entrepreneurshipGroupMaintenance.setReleaseTime(new Date());
                entrepreneurshipGroupMaintenance.setModifier(user.getUsername());
                entrepreneurshipGroupMaintenance.setModifyTime(new Date());
                homePageService.insertEntrepreneurshipGroupMaintenance(entrepreneurshipGroupMaintenance);
        }
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  遍历金融宣传位信息
     * @Date 2018/9/4 9:31
     * @Param [financialPositionManagementFinancial]
     */
    @RequestMapping("/listPageFinancialPositionManagement")
    public ModelAndView listPageFinancialPositionManagement(FinancialPositionManagement financialPositionManagementFinancial) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("financialPositionManagement", financialPositionManagementFinancial);
        mv.addObject("listPageFinancialPositionManagement", homePageService.listPageFinancialPositionManagement(financialPositionManagementFinancial));
        mv.setViewName("homePage/financialPositionManagement");
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   删除金融宣传位信息
     * @Date 2018/9/4 9:31
     * @Param [chk_value, out]
     */
    @RequestMapping("/deleteFinancialPositionManagement")
    public void deleteFinancialPositionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteFinancialPositionManagement(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO   金融宣传位信息置顶
     * @Date 2018/9/4 9:31
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateFinancialPositionManagementPlacedTop")
    public void updateFinancialPositionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateFinancialPositionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融宣传位信息取消置顶
     * @Date 2018/9/4 9:32
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateFinancialPositionManagementCancelPlacedTop")
    public void updateFinancialPositionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateFinancialPositionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  添加宣传金融位信息
     * @Date 2018/9/4 9:32
     * @Param []
     */
    @RequestMapping("/insertFinancialPositionManagement")
    public ModelAndView insertFinancialPositionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/financialPositionManagement_info");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  删除金融宣传位信息
     * @Date 2018/9/4 9:32
     * @Param [financialPositionManagement, id]
     */
    @RequestMapping("/updateFinancialPositionManagement")
    public ModelAndView updateFinancialPositionManagement(FinancialPositionManagement financialPositionManagement, @RequestParam("id") Integer id) {
        List<Map<String, Object>> mapList = homePageService.selectFinancialPositionManagementById(id);
        financialPositionManagement.setId(id);
        financialPositionManagement.setName((String) mapList.get(0).get("name"));
        financialPositionManagement.setLink((String) mapList.get(0).get("link"));
        financialPositionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        financialPositionManagement.setDescribe((String) mapList.get(0).get("describe"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/financialPositionManagement_info");
        mv.addObject("financialPositionManagement", financialPositionManagement);
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  保存金融宣传位信息
     * @Date 2018/9/4 9:33
     * @Param [financialPositionManagement]
     */
    @RequestMapping("/saveFinancialPositionManagement")
    public ModelAndView saveFinancialPositionManagement(FinancialPositionManagement financialPositionManagement) {
        if (financialPositionManagement.getId() == null) {
//            添加
            homePageService.insertFinancialPositionManagement(financialPositionManagement);
        } else {
//            修改
            homePageService.updateFinancialPositionManagement(financialPositionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  遍历金融咨询管理信息
     * @Date 2018/9/4 9:33
     * @Param [financialAdvisoryManagement]
     */
    @RequestMapping("/listPageFinancialAdvisoryManagement")
    public ModelAndView listPageFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement) {
        ModelAndView mv = new ModelAndView();
        List<FinancialAdvisoryManagement> listPageFinancialAdvisoryManagement = homePageService.listPageFinancialAdvisoryManagement(financialAdvisoryManagement);
        mv.addObject("financialAdvisoryManagement", financialAdvisoryManagement);
        mv.addObject("listPageFinancialAdvisoryManagement", listPageFinancialAdvisoryManagement);
        mv.setViewName("homePage/financialAdvisoryManagement");
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除金融咨询管理信息
     * @Date 2018/9/4 9:34
     * @Param [chk_value, out]
     */
    @RequestMapping("/deleteFinancialAdvisoryManagement")
    public void deleteFinancialAdvisoryManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteFinancialAdvisoryManagement(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融咨询管理信息置顶
     * @Date 2018/9/4 9:34
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateFinancialAdvisoryManagementPlacedTop")
    public void updateFinancialAdvisoryManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateFinancialAdvisoryManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融咨询管理信息取消置顶
     * @Date 2018/9/4 9:34
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateFinancialAdvisoryManagementCancelPlacedTop")
    public void updateFinancialAdvisoryManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateFinancialAdvisoryManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  添加金融咨询管理信息
     * @Date 2018/9/4 9:34
     * @Param []
     */
    @RequestMapping("/insertFinancialAdvisoryManagement")
    public ModelAndView insertFinancialAdvisoryManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/financialAdvisoryManagement_info");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  修改金融咨询管理信息
     * @Date 2018/9/4 9:34
     * @Param [id, financialAdvisoryManagement]
     */
    @RequestMapping("/updateFinancialAdvisoryManagement")
    public ModelAndView updateFinancialAdvisoryManagement(@RequestParam("id") Integer id, FinancialAdvisoryManagement financialAdvisoryManagement) {
        List<Map<String, Object>> mapList = homePageService.selectFinancialAdvisoryManagementById(id);
        financialAdvisoryManagement.setId(id);
        financialAdvisoryManagement.setName((String) mapList.get(0).get("name"));
        financialAdvisoryManagement.setLink((String) mapList.get(0).get("link"));
        financialAdvisoryManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("financialAdvisoryManagement", financialAdvisoryManagement);
        mv.setViewName("homePage/financialAdvisoryManagement_info");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  保存金融咨询管理信息
     * @Date 2018/9/4 9:35
     * @Param [financialAdvisoryManagement]
     */
    @RequestMapping("/saveFinancialAdvisoryManagement")
    public ModelAndView saveFinancialAdvisoryManagement(FinancialAdvisoryManagement financialAdvisoryManagement) {
        if (financialAdvisoryManagement.getId() != null) {
//            修改
            homePageService.updateFinancialAdvisoryManagement(financialAdvisoryManagement);
        } else {
//            添加
            homePageService.insertFinancialAdvisoryManagement(financialAdvisoryManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  遍历金融机构管理信息
     * @Date 2018/9/4 9:35
     * @Param [financialInstitutionManagement]
     */
    @RequestMapping("/listPageFinancialInstitutionManagement")
    public ModelAndView listPageFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/financialInstitutionManagement");
        mv.addObject("financialInstitutionManagement", financialInstitutionManagement);
        mv.addObject("listPageFinancialInstitutionManagement", homePageService.listPageFinancialInstitutionManagement(financialInstitutionManagement));
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除金融机构管理信息
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/deleteFinancialInstitutionManagement")
    public void deleteFinancialInstitutionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteFinancialInstitutionManagement(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融机构管理信息置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateFinancialInstitutionManagementPlacedTop")
    public void updateFinancialInstitutionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateFinancialInstitutionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  金融机构管理信息取消置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateFinancialInstitutionManagementCancelPlacedTop")
    public void updateFinancialInstitutionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateFinancialInstitutionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加金融机构管理信息
     * @Date 2018/9/6 15:44
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertFinancialInstitutionManagement")
    public ModelAndView insertFinancialInstitutionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/financialInstitutionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改金融机构管理信息
     * @Date 2018/9/6 15:45
     * @Param [id, financialInstitutionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateFinancialInstitutionManagement")
    public ModelAndView updateFinancialInstitutionManagement(@RequestParam("id") Integer id, FinancialInstitutionManagement financialInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> mapList = homePageService.selectFinancialInstitutionManagementById(id);
        financialInstitutionManagement.setId(id);
        financialInstitutionManagement.setName((String) mapList.get(0).get("name"));
        financialInstitutionManagement.setLink((String) mapList.get(0).get("link"));
        financialInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        financialInstitutionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mv.setViewName("homePage/financialInstitutionManagement_info");
        mv.addObject("financialInstitutionManagement", financialInstitutionManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存金融机构管理信息
     * @Date 2018/9/6 15:45
     * @Param [financialInstitutionManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/saveFinancialInstitutionManagement", method = RequestMethod.POST)
    public ModelAndView saveFinancialInstitutionManagement(FinancialInstitutionManagement financialInstitutionManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectFinancialInstitutionManagementById(financialInstitutionManagement.getId());
            System.out.println(mapList);
            financialInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            financialInstitutionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (financialInstitutionManagement.getId() != null) {
//            修改
            homePageService.updateFinancialInstitutionManagement(financialInstitutionManagement);
        } else {
//            添加
            homePageService.insertFinancialInstitutionManagement(financialInstitutionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历技术宣传位管理信息
     * @Date 2018/9/6 15:45
     * @Param [technicalPositionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageTechnicalPositionManagement")
    public ModelAndView listPageTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/technicalPositionManagement");
        mv.addObject("technicalPositionManagement", technicalPositionManagement);
        mv.addObject("listPageTechnicalPositionManagement", homePageService.listPageTechnicalPositionManagement(technicalPositionManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除技术宣传位管理信息
     * @Date 2018/9/6 15:46
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteTechnicalPositionManagement")
    public void deleteTechnicalPositionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteTechnicalPositionManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  技术宣传位管理信息置顶
     * @Date 2018/9/6 15:46
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTechnicalPositionManagementPlacedTop")
    public void updateTechnicalPositionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTechnicalPositionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  技术宣传位管理信息取消置顶
     * @Date 2018/9/6 15:46
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTechnicalPositionManagementCancelPlacedTop")
    public void updateTechnicalPositionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTechnicalPositionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加技术宣传位管理信息
     * @Date 2018/9/6 15:46
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertTechnicalPositionManagement")
    public ModelAndView insertTechnicalPositionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/technicalPositionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改技术宣传位管理信息
     * @Date 2018/9/6 15:47
     * @Param [id, technicalPositionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateTechnicalPositionManagement")
    public ModelAndView updateTechnicalPositionManagement(@RequestParam("id") Integer id, TechnicalPositionManagement technicalPositionManagement) {
        List<Map<String, Object>> mapList = homePageService.selectTechnicalPositionManagementById(id);
        technicalPositionManagement.setId(id);
        technicalPositionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        technicalPositionManagement.setLink((String) mapList.get(0).get("link"));
        technicalPositionManagement.setName((String) mapList.get(0).get("name"));
        technicalPositionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("technicalPositionManagement", technicalPositionManagement);
        mv.setViewName("homePage/technicalPositionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存技术宣传位管理信息
     * @Date 2018/9/6 15:47
     * @Param [technicalPositionManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveTechnicalPositionManagement")
    public ModelAndView saveTechnicalPositionManagement(TechnicalPositionManagement technicalPositionManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectTechnicalPositionManagementById(technicalPositionManagement.getId());
            System.out.println(mapList);
            technicalPositionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            technicalPositionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (technicalPositionManagement.getId() != null) {
//            修改
            homePageService.updateTechnicalPositionManagement(technicalPositionManagement);
        } else {
//            添加
            homePageService.insertTechnicalPositionManagement(technicalPositionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历技术咨询管理信息
     * @Date 2018/9/6 15:47
     * @Param [technicalAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageTechnicalAdvisoryManagement")
    public ModelAndView listPageTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("technicalAdvisoryManagement", technicalAdvisoryManagement);
        mv.addObject("listPageTechnicalAdvisoryManagement", homePageService.listPageTechnicalAdvisoryManagement(technicalAdvisoryManagement));
        mv.setViewName("homePage/technicalAdvisoryManagement");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除遍历技术咨询管理信息
     * @Date 2018/9/6 15:48
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteTechnicalAdvisoryManagement")
    public void deleteTechnicalAdvisoryManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteTechnicalAdvisoryManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  技术咨询管理信息置顶
     * @Date 2018/9/6 15:48
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTechnicalAdvisoryManagementPlacedTop")
    public void updateTechnicalAdvisoryManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTechnicalAdvisoryManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  技术咨询管理信息取消置顶
     * @Date 2018/9/6 15:50
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTechnicalAdvisoryManagementCancelPlacedTop")
    public void updateTechnicalAdvisoryManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTechnicalAdvisoryManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加技术咨询管理信息
     * @Date 2018/9/6 15:50
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertTechnicalAdvisoryManagement")
    public ModelAndView insertTechnicalAdvisoryManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/technicalAdvisoryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除技术咨询管理信息
     * @Date 2018/9/6 15:50
     * @Param [id, technicalAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateTechnicalAdvisoryManagement")
    public ModelAndView updateTechnicalAdvisoryManagement(Integer id, TechnicalAdvisoryManagement technicalAdvisoryManagement) {
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> mapList = homePageService.selectTechnicalAdvisoryManagementById(id);
        technicalAdvisoryManagement.setId(id);
        technicalAdvisoryManagement.setName((String) mapList.get(0).get("name"));
        technicalAdvisoryManagement.setLink((String) mapList.get(0).get("link"));
        technicalAdvisoryManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mv.addObject("technicalAdvisoryManagement", technicalAdvisoryManagement);
        mv.setViewName("homePage/technicalAdvisoryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存技术咨询管理信息
     * @Date 2018/9/6 15:51
     * @Param [technicalAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveTechnicalAdvisoryManagement")
    public ModelAndView saveTechnicalAdvisoryManagement(TechnicalAdvisoryManagement technicalAdvisoryManagement) {
        if (technicalAdvisoryManagement.getId() != null) {
//            修改
            homePageService.updateTechnicalAdvisoryManagement(technicalAdvisoryManagement);
        } else {
//            添加
            homePageService.insertTechnicalAdvisoryManagement(technicalAdvisoryManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  遍历技术机构管理信息
     * @Date 2018/9/4 9:35
     * @Param [technicalInstitutionManagement]
     */
    @RequestMapping("/listPageTechnicalInstitutionManagement")
    public ModelAndView listPageTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/technicalInstitutionManagement");
        mv.addObject("technicalInstitutionManagement", technicalInstitutionManagement);
        mv.addObject("listPageTechnicalInstitutionManagement", homePageService.listPageTechnicalInstitutionManagement(technicalInstitutionManagement));
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除技术机构管理信息
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/deleteTechnicalInstitutionManagement")
    public void deleteTechnicalInstitutionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteTechnicalInstitutionManagement(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  技术机构管理信息置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateTechnicalInstitutionManagementPlacedTop")
    public void updateTechnicalInstitutionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTechnicalInstitutionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  技术机构管理信息取消置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateTechnicalInstitutionManagementCancelPlacedTop")
    public void updateTechnicalInstitutionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTechnicalInstitutionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   添加技术机构管理信息
     * @Date 2018/9/6 16:21
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertTechnicalInstitutionManagement")
    public ModelAndView insertTechnicalInstitutionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/technicalInstitutionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改技术机构管理信息
     * @Date 2018/9/6 16:22
     * @Param [id, technicalInstitutionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateTechnicalInstitutionManagement")
    public ModelAndView updateTechnicalInstitutionManagement(@RequestParam("id") Integer id, TechnicalInstitutionManagement technicalInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> mapList = homePageService.selectTechnicalInstitutionManagementById(id);
        technicalInstitutionManagement.setId(id);
        technicalInstitutionManagement.setName((String) mapList.get(0).get("name"));
        technicalInstitutionManagement.setLink((String) mapList.get(0).get("link"));
        technicalInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        technicalInstitutionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mv.setViewName("homePage/technicalInstitutionManagement_info");
        mv.addObject("technicalInstitutionManagement", technicalInstitutionManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存技术机构管理信息
     * @Date 2018/9/6 16:22
     * @Param [technicalInstitutionManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/saveTechnicalInstitutionManagement", method = RequestMethod.POST)
    public ModelAndView saveTechnicalInstitutionManagement(TechnicalInstitutionManagement technicalInstitutionManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectTechnicalInstitutionManagementById(technicalInstitutionManagement.getId());
            System.out.println(mapList);
            technicalInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            technicalInstitutionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (technicalInstitutionManagement.getId() != null) {
//            修改
            homePageService.updateTechnicalInstitutionManagement(technicalInstitutionManagement);
        } else {
//            添加
            homePageService.insertTechnicalInstitutionManagement(technicalInstitutionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历人才宣传位管理信息
     * @Date 2018/9/6 16:22
     * @Param [talentPositionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageTalentPositionManagement")
    public ModelAndView listPageTalentPositionManagement(TalentPositionManagement talentPositionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/talentPositionManagement");
        mv.addObject("talentPositionManagement", talentPositionManagement);
        mv.addObject("listPageTalentPositionManagement", homePageService.listPageTalentPositionManagement(talentPositionManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除人才宣传位管理信息
     * @Date 2018/9/6 16:22
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteTalentPositionManagement")
    public void deleteTalentPositionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteTalentPositionManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   人才宣传位管理信息置顶
     * @Date 2018/9/6 16:23
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTalentPositionManagementPlacedTop")
    public void updateTalentPositionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTalentPositionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  人才宣传位管理信息取消置顶
     * @Date 2018/9/6 16:23
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTalentPositionManagementCancelPlacedTop")
    public void updateTalentPositionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTalentPositionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加人才宣传位管理信息
     * @Date 2018/9/6 16:23
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertTalentPositionManagement")
    public ModelAndView insertTalentPositionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/talentPositionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改人才宣传位管理信息
     * @Date 2018/9/6 16:23
     * @Param [id, talentPositionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateTalentPositionManagement")
    public ModelAndView updateTalentPositionManagement(@RequestParam("id") Integer id, TalentPositionManagement talentPositionManagement) {
        List<Map<String, Object>> mapList = homePageService.selectTalentPositionManagementById(id);
        talentPositionManagement.setId(id);
        talentPositionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        talentPositionManagement.setLink((String) mapList.get(0).get("link"));
        talentPositionManagement.setName((String) mapList.get(0).get("name"));
        talentPositionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("talentPositionManagement", talentPositionManagement);
        mv.setViewName("homePage/talentPositionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存人才宣传位管理信息
     * @Date 2018/9/6 16:23
     * @Param [talentPositionManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveTalentPositionManagement")
    public ModelAndView saveTalentPositionManagement(TalentPositionManagement talentPositionManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectTalentPositionManagementById(talentPositionManagement.getId());
            System.out.println(mapList);
            talentPositionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            talentPositionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }

        if (talentPositionManagement.getId() != null) {
//            修改
            homePageService.updateTalentPositionManagement(talentPositionManagement);
        } else {
//            添加
            homePageService.insertTalentPositionManagement(talentPositionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历人才咨询管理信息
     * @Date 2018/9/6 16:24
     * @Param [talentAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageTalentAdvisoryManagement")
    public ModelAndView listPageTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("talentAdvisoryManagement", talentAdvisoryManagement);
        mv.addObject("listPageTalentAdvisoryManagement", homePageService.listPageTalentAdvisoryManagement(talentAdvisoryManagement));
        mv.setViewName("homePage/talentAdvisoryManagement");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除人才咨询管理信息
     * @Date 2018/9/6 16:24
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteTalentAdvisoryManagement")
    public void deleteTalentAdvisoryManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteTalentAdvisoryManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  人才咨询管理信息置顶
     * @Date 2018/9/6 16:24
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTalentAdvisoryManagementPlacedTop")
    public void updateTalentAdvisoryManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTalentAdvisoryManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   人才咨询管理信息取消置顶
     * @Date 2018/9/6 16:24
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateTalentAdvisoryManagementCancelPlacedTop")
    public void updateTalentAdvisoryManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTalentAdvisoryManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加人才咨询管理信息
     * @Date 2018/9/6 16:24
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertTalentAdvisoryManagement")
    public ModelAndView insertTalentAdvisoryManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/talentAdvisoryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改人才咨询管理信息
     * @Date 2018/9/6 16:25
     * @Param [id, talentAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateTalentAdvisoryManagement")
    public ModelAndView updateTalentAdvisoryManagement(Integer id, TalentAdvisoryManagement talentAdvisoryManagement) {
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> mapList = homePageService.selectTalentAdvisoryManagementById(id);
        talentAdvisoryManagement.setId(id);
        talentAdvisoryManagement.setName((String) mapList.get(0).get("name"));
        talentAdvisoryManagement.setLink((String) mapList.get(0).get("link"));
        talentAdvisoryManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mv.addObject("talentAdvisoryManagement", talentAdvisoryManagement);
        mv.setViewName("homePage/talentAdvisoryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存人才咨询管理信息
     * @Date 2018/9/6 16:25
     * @Param [talentAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveTalentAdvisoryManagement")
    public ModelAndView saveTalentAdvisoryManagement(TalentAdvisoryManagement talentAdvisoryManagement) {
        if (talentAdvisoryManagement.getId() != null) {
//            修改
            homePageService.updateTalentAdvisoryManagement(talentAdvisoryManagement);
        } else {
//            添加
            homePageService.insertTalentAdvisoryManagement(talentAdvisoryManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  遍历人才机构管理信息
     * @Date 2018/9/4 9:35
     * @Param [talentInstitutionManagement]
     */
    @RequestMapping("/listPageTalentInstitutionManagement")
    public ModelAndView listPageTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/talentInstitutionManagement");
        mv.addObject("talentInstitutionManagement", talentInstitutionManagement);
        mv.addObject("listPageTalentInstitutionManagement", homePageService.listPageTalentInstitutionManagement(talentInstitutionManagement));
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除人才机构管理信息
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/deleteTalentInstitutionManagement")
    public void deleteTalentInstitutionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteTalentInstitutionManagement(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  人才机构管理信息置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateTalentInstitutionManagementPlacedTop")
    public void updateTalentInstitutionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTalentInstitutionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  人才机构管理信息取消置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateTalentInstitutionManagementCancelPlacedTop")
    public void updateTalentInstitutionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateTalentInstitutionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加人才机构管理信息
     * @Date 2018/9/6 16:28
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertTalentInstitutionManagement")
    public ModelAndView insertTalentInstitutionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/talentInstitutionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改人才机构管理信息
     * @Date 2018/9/6 16:28
     * @Param [id, talentInstitutionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateTalentInstitutionManagement")
    public ModelAndView updateTalentInstitutionManagement(@RequestParam("id") Integer id, TalentInstitutionManagement talentInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> mapList = homePageService.selectTalentInstitutionManagementById(id);
        talentInstitutionManagement.setId(id);
        talentInstitutionManagement.setName((String) mapList.get(0).get("name"));
        talentInstitutionManagement.setLink((String) mapList.get(0).get("link"));
        talentInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        talentInstitutionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mv.setViewName("homePage/talentInstitutionManagement_info");
        mv.addObject("talentInstitutionManagement", talentInstitutionManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存人才机构管理信息
     * @Date 2018/9/6 16:28
     * @Param [talentInstitutionManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/saveTalentInstitutionManagement", method = RequestMethod.POST)
    public ModelAndView saveTalentInstitutionManagement(TalentInstitutionManagement talentInstitutionManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectTalentInstitutionManagementById(talentInstitutionManagement.getId());
            System.out.println(mapList);
            talentInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            talentInstitutionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (talentInstitutionManagement.getId() != null) {
//            修改
            homePageService.updateTalentInstitutionManagement(talentInstitutionManagement);
        } else {
//            添加
            homePageService.insertTalentInstitutionManagement(talentInstitutionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历场地宣传位管理信息
     * @Date 2018/9/6 16:29
     * @Param [sitePositionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageSitePositionManagement")
    public ModelAndView listPageSitePositionManagement(SitePositionManagement sitePositionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/sitePositionManagement");
        mv.addObject("sitePositionManagement", sitePositionManagement);
        mv.addObject("listPageSitePositionManagement", homePageService.listPageSitePositionManagement(sitePositionManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除场地宣传位管理信息
     * @Date 2018/9/6 16:29
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteSitePositionManagement")
    public void deleteSitePositionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteSitePositionManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  场地宣传位管理信息置顶
     * @Date 2018/9/6 16:29
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateSitePositionManagementPlacedTop")
    public void updateSitePositionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateSitePositionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  场地宣传位管理信息取消置顶
     * @Date 2018/9/6 16:30
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateSitePositionManagementCancelPlacedTop")
    public void updateSitePositionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateSitePositionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加场地宣传位管理信息
     * @Date 2018/9/6 16:30
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertSitePositionManagement")
    public ModelAndView insertSitePositionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/sitePositionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改场地宣传位管理信息
     * @Date 2018/9/6 16:30
     * @Param [id, sitePositionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateSitePositionManagement")
    public ModelAndView updateSitePositionManagement(@RequestParam("id") Integer id, SitePositionManagement sitePositionManagement) {
        List<Map<String, Object>> mapList = homePageService.selectSitePositionManagementById(id);
        sitePositionManagement.setId(id);
        sitePositionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        sitePositionManagement.setLink((String) mapList.get(0).get("link"));
        sitePositionManagement.setName((String) mapList.get(0).get("name"));
        sitePositionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("sitePositionManagement", sitePositionManagement);
        mv.setViewName("homePage/sitePositionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存场地宣传位管理信息
     * @Date 2018/9/6 16:30
     * @Param [sitePositionManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveSitePositionManagement")
    public ModelAndView saveSitePositionManagement(SitePositionManagement sitePositionManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectSitePositionManagementById(sitePositionManagement.getId());
            System.out.println(mapList);
            sitePositionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            sitePositionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }

        if (sitePositionManagement.getId() != null) {
//            修改
            homePageService.updateSitePositionManagement(sitePositionManagement);
        } else {
//            添加
            homePageService.insertSitePositionManagement(sitePositionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历场地咨询管理信息
     * @Date 2018/9/6 16:30
     * @Param [siteAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageSiteAdvisoryManagement")
    public ModelAndView listPageSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("siteAdvisoryManagement", siteAdvisoryManagement);
        mv.addObject("listPageSiteAdvisoryManagement", homePageService.listPageSiteAdvisoryManagement(siteAdvisoryManagement));
        mv.setViewName("homePage/siteAdvisoryManagement");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除场地咨询管理信息
     * @Date 2018/9/6 16:31
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteSiteAdvisoryManagement")
    public void deleteSiteAdvisoryManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteSiteAdvisoryManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  场地咨询管理信息置顶
     * @Date 2018/9/6 16:31
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateSiteAdvisoryManagementPlacedTop")
    public void updateSiteAdvisoryManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateSiteAdvisoryManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  场地咨询管理信息取消置顶
     * @Date 2018/9/6 16:31
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateSiteAdvisoryManagementCancelPlacedTop")
    public void updateSiteAdvisoryManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateSiteAdvisoryManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   添加场地咨询管理信息
     * @Date 2018/9/6 16:31
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertSiteAdvisoryManagement")
    public ModelAndView insertSiteAdvisoryManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/siteAdvisoryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改场地咨询管理信息
     * @Date 2018/9/6 16:32
     * @Param [id, siteAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateSiteAdvisoryManagement")
    public ModelAndView updateSiteAdvisoryManagement(Integer id, SiteAdvisoryManagement siteAdvisoryManagement) {
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> mapList = homePageService.selectSiteAdvisoryManagementById(id);
        siteAdvisoryManagement.setId(id);
        siteAdvisoryManagement.setName((String) mapList.get(0).get("name"));
        siteAdvisoryManagement.setLink((String) mapList.get(0).get("link"));
        siteAdvisoryManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mv.addObject("siteAdvisoryManagement", siteAdvisoryManagement);
        mv.setViewName("homePage/siteAdvisoryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存场地咨询管理信息
     * @Date 2018/9/6 16:32
     * @Param [siteAdvisoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveSiteAdvisoryManagement")
    public ModelAndView saveSiteAdvisoryManagement(SiteAdvisoryManagement siteAdvisoryManagement) {
        if (siteAdvisoryManagement.getId() != null) {
//            修改
            homePageService.updateSiteAdvisoryManagement(siteAdvisoryManagement);
        } else {
//            添加
            homePageService.insertSiteAdvisoryManagement(siteAdvisoryManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.Chan
     * @Description //TODO  遍历场地机构管理信息
     * @Date 2018/9/4 9:35
     * @Param [siteInstitutionManagement]
     */
    @RequestMapping("/listPageSiteInstitutionManagement")
    public ModelAndView listPageSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/siteInstitutionManagement");
        mv.addObject("siteInstitutionManagement", siteInstitutionManagement);
        mv.addObject("listPageSiteInstitutionManagement", homePageService.listPageSiteInstitutionManagement(siteInstitutionManagement));
        return mv;
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  删除场地机构管理信息
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/deleteSiteInstitutionManagement")
    public void deleteSiteInstitutionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteSiteInstitutionManagement(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  场地机构管理信息置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateSiteInstitutionManagementPlacedTop")
    public void updateSiteInstitutionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateSiteInstitutionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }

    /**
     * @return void
     * @Author Mr.Chan
     * @Description //TODO  场地机构管理信息取消置顶
     * @Date 2018/9/4 10:06
     * @Param [chk_value, out]
     */
    @RequestMapping("/updateSiteInstitutionManagementCancelPlacedTop")
    public void updateSiteInstitutionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateSiteInstitutionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加场地机构管理信息
     * @Date 2018/9/6 16:32
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertSiteInstitutionManagement")
    public ModelAndView insertSiteInstitutionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/siteInstitutionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改场地机构管理信息
     * @Date 2018/9/6 16:32
     * @Param [id, siteInstitutionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateSiteInstitutionManagement")
    public ModelAndView updateSiteInstitutionManagement(@RequestParam("id") Integer id, SiteInstitutionManagement siteInstitutionManagement) {
        ModelAndView mv = new ModelAndView();
        List<Map<String, Object>> mapList = homePageService.selectSiteInstitutionManagementById(id);
        siteInstitutionManagement.setId(id);
        siteInstitutionManagement.setName((String) mapList.get(0).get("name"));
        siteInstitutionManagement.setLink((String) mapList.get(0).get("link"));
        siteInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        siteInstitutionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mv.setViewName("homePage/siteInstitutionManagement_info");
        mv.addObject("siteInstitutionManagement", siteInstitutionManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存场地机构管理信息
     * @Date 2018/9/6 16:32
     * @Param [siteInstitutionManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/saveSiteInstitutionManagement", method = RequestMethod.POST)
    public ModelAndView saveSiteInstitutionManagement(SiteInstitutionManagement siteInstitutionManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectSiteInstitutionManagementById(siteInstitutionManagement.getId());
            System.out.println(mapList);
            siteInstitutionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            siteInstitutionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (siteInstitutionManagement.getId() != null) {
//            修改
            homePageService.updateSiteInstitutionManagement(siteInstitutionManagement);
        } else {
//            添加
            homePageService.insertSiteInstitutionManagement(siteInstitutionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }

    /**
     * @Author Mr.Chan
     * @Description //TODO   遍历宣传位管理信息
     * @Date 2018/9/6 16:33
     * @Param [positionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPagePositionManagement")
    public ModelAndView listPagePositionManagement(PositionManagement positionManagement) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("listPagePositionManagement", homePageService.listPagePositionManagement(positionManagement));
        mv.addObject("positionManagement", positionManagement);
        mv.setViewName("homePage/positionManagement");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除宣传位管理信息
     * @Date 2018/9/6 16:33
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deletePositionManagement")
    public void deletePositionManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deletePositionManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  宣传位管理信息置顶
     * @Date 2018/9/6 16:33
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updatePositionManagementPlacedTop")
    public void updatePositionManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updatePositionManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  宣传位管理信息取消置顶
     * @Date 2018/9/6 16:33
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updatePositionManagementCancelPlacedTop")
    public void updatePositionManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updatePositionManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加宣传位管理信息
     * @Date 2018/9/6 16:33
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertPositionManagement")
    public ModelAndView insertPositionManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/positionManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改宣传位管理信息
     * @Date 2018/9/6 16:34
     * @Param [id, positionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updatePositionManagement")
    public ModelAndView updatePositionManagement(Integer id, PositionManagement positionManagement) {
        List<Map<String, Object>> mapList = homePageService.selectPositionManagementById(id);
        positionManagement.setId(id);
        positionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        positionManagement.setLink((String) mapList.get(0).get("link"));
        positionManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        positionManagement.setName((String) mapList.get(0).get("name"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/positionManagement_info");
        mv.addObject("positionManagement", positionManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存宣传位管理信息
     * @Date 2018/9/6 16:34
     * @Param [req, session, file, map, positionManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/savePositionManagement")
    public ModelAndView savePositionManagement(HttpServletRequest req, HttpSession session, @RequestParam(value = "file", required = false) MultipartFile file, Map map, PositionManagement positionManagement) {
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (file == null || file.isEmpty()) {
            List<Map<String, Object>> mapList = homePageService.selectPositionManagementById(positionManagement.getId());
            positionManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        } else {
            map = homePageService.uploadFile(file, req);
            positionManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (positionManagement.getId() != null) {
//            修改
            positionManagement.setModifyTime(new Date());
            positionManagement.setModifier(user.getUsername());
            homePageService.updatePositionManagement(positionManagement);
        } else {
//            添加
            positionManagement.setModifyTime(new Date());
            positionManagement.setModifier(user.getUsername());
            positionManagement.setReleasePeople(user.getUsername());
            positionManagement.setReleaseTime(new Date());
            homePageService.insertPositionManagement(positionManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历成果展示管理信息
     * @Date 2018/9/6 16:34
     * @Param [resultsShowManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageResultsShowManagement")
    public ModelAndView listPageResultsShowManagement(ResultsShowManagement resultsShowManagement) {
        if (resultsShowManagement.getPlacedTopId()!=null){
            if (resultsShowManagement.getPlacedTopId().equals("未置顶")){
                resultsShowManagement.setPlacedTop(0);
            }else if (resultsShowManagement.getPlacedTopId().equals("已置顶")){
                resultsShowManagement.setPlacedTop(1);
            }
        }
        if (resultsShowManagement.getReleaseMarksId()!=null){
            if (resultsShowManagement.getReleaseMarksId().equals("未发布")){
                resultsShowManagement.setReleaseMarks(0);
            }else if (resultsShowManagement.getReleaseMarksId().equals("已发布")){
                resultsShowManagement.setReleaseMarks(1);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/resultsShowManagement");
        mv.addObject("resultsShowManagement",resultsShowManagement);
        mv.addObject("listPageResultsShowManagement", homePageService.listPageResultsShowManagement(resultsShowManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除成果展示管理信息
     * @Date 2018/9/6 16:35
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteResultsShowManagement")
    public void deleteResultsShowManagement(Integer[] chk_value, PrintWriter out) {
        homePageService.deleteResultsShowManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息置顶
     * @Date 2018/9/6 16:35
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateResultsShowManagementPlacedTop")
    public void updateResultsShowManagementPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateResultsShowManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息取消置顶
     * @Date 2018/9/6 16:35
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateResultsShowManagementCancelPlacedTop")
    public void updateResultsShowManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out) {
        homePageService.updateResultsShowManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息发布
     * @Date 2018/9/6 16:35
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateResultsShowManagementReleaseMarks")
    public void updateResultsShowManagementReleaseMarks(Integer[] chk_value, PrintWriter out) {
        homePageService.updateResultsShowManagementReleaseMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  成果展示管理信息撤销发布
     * @Date 2018/9/6 16:35
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateResultsShowManagementCancelReleaseMarks")
    public void updateResultsShowManagementCancelReleaseMarks(Integer[] chk_value, PrintWriter out) {
        homePageService.updateResultsShowManagementCancelReleaseMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加成果展示管理信息
     * @Date 2018/9/6 16:35
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertResultsShowManagement")
    public ModelAndView insertResultsShowManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/resultsShowManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改成果展示管理信息
     * @Date 2018/9/6 16:36
     * @Param [id, resultsShowManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateResultsShowManagement")
    public ModelAndView updateResultsShowManagement(Integer id, ResultsShowManagement resultsShowManagement) {
        List<Map<String, Object>> mapList = homePageService.selectResultsShowManagementById(id);
        resultsShowManagement.setId(id);
        resultsShowManagement.setName((String) mapList.get(0).get("name"));
        resultsShowManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        resultsShowManagement.setContent((String) mapList.get(0).get("content"));
        resultsShowManagement.setReportTime((Date) mapList.get(0).get("reportTime"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/resultsShowManagement_info");
        mv.addObject("resultsShowManagement", resultsShowManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存成果展示管理信息
     * @Date 2018/9/6 16:36
     * @Param [resultsShowManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveResultsShowManagement")
    public ModelAndView saveResultsShowManagement(ResultsShowManagement resultsShowManagement) {
        if (resultsShowManagement.getId() != null) {
            homePageService.updateResultsShowManagement(resultsShowManagement);
        } else {
            resultsShowManagement.setReleaseTime(new Date());
            homePageService.insertResultsShowManagement(resultsShowManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "success");
        mv.setViewName("save_result");
        return mv;
    }


    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历动态管理信息
     * @Date 2018/9/7 11:01
     * @Param [dynamicManagement]
     * @return java.util.List<com.flf.entity.homePage.DynamicManagement>
     */
    @RequestMapping("/listPageDynamicManagement")
    public ModelAndView listPageDynamicManagement(DynamicManagement dynamicManagement){
        if (dynamicManagement.getReleaseMarks()!=null){
            if (dynamicManagement.getReleaseMarks()==2){
                dynamicManagement.setReleaseMarks(null);
            }
        }
        if (dynamicManagement.getPlacedTop()!=null){
            if (dynamicManagement.getPlacedTop()==2){
                dynamicManagement.setPlacedTop(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homePage/dynamicManagement");
        mv.addObject("dynamicManagement",dynamicManagement);
        mv.addObject("listPageDynamicManagement",homePageService.listPageDynamicManagement(dynamicManagement));
        return mv;
    }
   /**
    * @Author Mr.Chan
    * @Description //TODO  删除动态管理信息
    * @Date 2018/9/7 11:32
    * @Param [chk_value, out]
    * @return void
    */
   @RequestMapping("/deleteDynamicManagement")
    public void deleteDynamicManagement(Integer[] chk_value,PrintWriter out){
        homePageService.deleteDynamicManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息置顶
     * @Date 2018/9/7 11:07
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateDynamicManagementPlacedTop")
    public void updateDynamicManagementPlacedTop(Integer[] chk_value,PrintWriter out){
        homePageService.updateDynamicManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息取消置顶
     * @Date 2018/9/7 11:07
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/")
    public void updateDynamicManagementCancelPlacedTop(Integer[] chk_value,PrintWriter out){
        homePageService.updateDynamicManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息发布
     * @Date 2018/9/7 11:07
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateDynamicManagementReleaseMarks")
    public void updateDynamicManagementReleaseMarks(Integer[] chk_value,PrintWriter out){
        homePageService.updateDynamicManagementReleaseMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  动态管理信息取消发布
     * @Date 2018/9/7 11:08
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateDynamicManagementCancelReleaseMarks")
    public void updateDynamicManagementCancelReleaseMarks(Integer[] chk_value,PrintWriter out){
        homePageService.updateDynamicManagementCancelReleaseMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加动态管理信息
     * @Date 2018/9/7 11:08
     * @Param [dynamicManagement]
     * @return void
     */
    @RequestMapping("/insertDynamicManagement")
    public ModelAndView insertDynamicManagement(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("selectOrganizationInfo",homePageService.selectOrganizationInfo());
        mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
        mv.addObject("selectBaseInfo",homePageService.selectBaseInfo());
        mv.setViewName("homePage/dynamicManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改动态管理信息
     * @Date 2018/9/7 11:08
     * @Param [dynamicManagement]
     * @return void
     */
    @RequestMapping("/updateDynamicManagement")
    public ModelAndView updateDynamicManagement(DynamicManagement dynamicManagement,Integer id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("dynamicManagement",homePageService.selectDynamicManagementById(id));
        mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
        mv.addObject("selectOrganizationInfo",homePageService.selectOrganizationInfo());
        mv.addObject("selectBaseInfo",homePageService.selectBaseInfo());
        mv.setViewName("homePage/dynamicManagement_info");
        return mv;
    }

    /**
     * @Author Mr.Chan
     * @Description //TODO  保存动态管理信息
     * @Date 2018/9/7 13:15
     * @Param [req, file, map, dynamicManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("saveDynamicManagement")
    public ModelAndView saveDynamicManagement(HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map,DynamicManagement dynamicManagement){
        List<Integer> list = homePageService.selectDynamicManagementIdByName(dynamicManagement.getName());
        ModelAndView mv = new ModelAndView();
       if (dynamicManagement.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if (!list.get(0).equals(dynamicManagement.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            if (file == null || file.isEmpty()) {
                dynamicManagement.setFileURL(homePageService.selectDynamicManagementById(dynamicManagement.getId()).getFileURL());
            } else {
                map = homePageService.uploadFile(file, req);
                dynamicManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            homePageService.updateDynamicManagement(dynamicManagement);
        }else {
//            添加
           if (!list.isEmpty()){
               mv.addObject("msg", "nameExist");
               mv.setViewName("save_result");
               return mv;
           }
            if (file == null || file.isEmpty()) {
                dynamicManagement.setFileURL(null);
            } else {
                map = homePageService.uploadFile(file, req);
                dynamicManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            dynamicManagement.setReleaseTime(new Date());
            homePageService.insertDynamicManagement(dynamicManagement);
        }
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/selectBaseIdByRegionId", produces = "text/html;charset=utf-8")
    public String selectBaseIdByRegionId(Integer id){
        List<DemonstrationBaseManagement> list = homePageService.selectBaseIdByRegionId(id);
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonString = jsonArray.toString();
       return jsonString;
    }

    @ResponseBody
    @RequestMapping(value = "/selectRegionIdByBaseId", produces = "text/html;charset=utf-8")
    public String selectRegionIdByBaseId(Integer id){
        JSONObject jsonObject = new JSONObject();
        RegionalDataMaintenance regionalDataMaintenance = homePageService.selectRegionIdByBaseId(id);
        jsonObject.put("id",regionalDataMaintenance.getId());
        jsonObject.put("name",regionalDataMaintenance.getName());
        String RegionInfo = jsonObject.toString();
        return RegionInfo;
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
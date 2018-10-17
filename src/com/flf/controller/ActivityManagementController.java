package com.flf.controller;

import com.flf.entity.FileUtil;
import com.flf.entity.User;
import com.flf.entity.activityManagement.*;
import com.flf.service.ActivityManagementService;
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
 * @ClassName: ActivityManagementController
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/10 15:23
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/activityManagement", produces = "text/html;charset=utf-8")
public class ActivityManagementController {
    @Autowired
    private ActivityManagementService activityManagementService;
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历媒体管理信息
     * @Date 2018/9/21 9:04
     * @Param [mediaManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageMediaManagement")
    public ModelAndView listPageMediaManagement(MediaManagement mediaManagement){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/mediaManagement");
        mv.addObject("mediaManagement",mediaManagement);
        mv.addObject("listPageMediaManagement",activityManagementService.listPageMediaManagement(mediaManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除媒体管理信息
     * @Date 2018/9/21 9:04
     * @Param [chk_value, out]
     * @return void
     */
   @RequestMapping("/deleteMediaManagement")
    public void deleteMediaManagement(Integer[] chk_value, PrintWriter out){
        activityManagementService.deleteMediaManagement(chk_value);
        out.write("success");
        out.close();
   }
   /**
    * @Author Mr.Chan
    * @Description //TODO  媒体管理信息置顶
    * @Date 2018/9/21 9:04
    * @Param [chk_value, out]
    * @return void
    */
    @RequestMapping("/updateMediaManagementPlacedTop")
    public void updateMediaManagementPlacedTop(Integer[] chk_value, PrintWriter out){
        System.err.println("true");
        activityManagementService.updateMediaManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  媒体管理信息取消置顶
     * @Date 2018/9/21 9:04
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateMediaManagementCancelPlacedTop")
    public void updateMediaManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out){
        activityManagementService.updateMediaManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加媒体管理信息
     * @Date 2018/9/21 9:05
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertMediaManagement")
    public ModelAndView insertMediaManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/mediaManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改媒体管理信息
     * @Date 2018/9/21 9:06
     * @Param [id, mediaManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateMediaManagement")
    public ModelAndView updateMediaManagement(Integer id,MediaManagement mediaManagement){
        List<Map<String,Object>> mapList = activityManagementService.selectMediaManagementById(id);
        mediaManagement.setId(id);
        mediaManagement.setBusinessTypes((String) mapList.get(0).get("businessTypes"));
       mediaManagement.setLink((String) mapList.get(0).get("link"));
       mediaManagement.setMediaType((String) mapList.get(0).get("mediaType"));
       mediaManagement.setName((String) mapList.get(0).get("name"));
       mediaManagement.setSorting((Integer) mapList.get(0).get("sorting"));
        mediaManagement.setFileURL((String) mapList.get(0).get("fileURL"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/mediaManagement_info");
        mv.addObject("mediaManagement",mediaManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存媒体管理信息
     * @Date 2018/9/21 9:06
     * @Param [mediaManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveMediaManagement")
    public ModelAndView saveMediaManagement(MediaManagement mediaManagement, HttpServletRequest req,@RequestParam(value = "file", required = false) MultipartFile file, Map map){
        List<Integer> list = activityManagementService.selectMediaManagementIdByName(mediaManagement.getName());
        ModelAndView mv = new ModelAndView();
        if (mediaManagement.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if (!list.get(0).equals(mediaManagement.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            if (file == null || file.isEmpty()) {
                List<Map<String, Object>> mapList = activityManagementService.selectMediaManagementById(mediaManagement.getId());
                mediaManagement.setFileURL((String) mapList.get(0).get("fileURL"));
            } else {
                map = FileUtil.uploadImg(file, req);
                mediaManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            activityManagementService.updateMediaManagement(mediaManagement);
        }else {
//            添加
            if (!list.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            map = FileUtil.uploadImg(file, req);
            mediaManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            activityManagementService.insertMediaManagement(mediaManagement);
        }
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历活动管理信息
     * @Date 2018/9/21 9:06
     * @Param [activityManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageActivityManagement")
    public ModelAndView listPageActivityManagement(ActivityManagement activityManagement){
        System.out.println("hhhhhh");
        System.out.println(activityManagement);
        if (activityManagement.getPlacedTop()!=null){
            if (activityManagement.getPlacedTop()==2){
                activityManagement.setPlacedTop(null);
            }
        }
        if (activityManagement.getReportMarks()!=null){
            if (activityManagement.getReportMarks()==2){
                activityManagement.setReportMarks(null);
            }
        }
        if (activityManagement.getType()!=null){
            if (activityManagement.getType().equals("0")){
                activityManagement.setType(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/activityManagement");
        if (activityManagement.getArea()!=null){
            if (activityManagement.getArea()==0){
                activityManagement.setArea(null);
            }
        }
        System.out.println(activityManagement);
        mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
        mv.addObject("listPageActivityManagement",activityManagementService.listPageActivityManagement(activityManagement));
        mv.addObject("activityManagement",activityManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除活动管理信息
     * @Date 2018/9/21 9:07
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteActivityManagement")
    public void deleteActivityManagement(Integer[] chk_value,PrintWriter out){
        activityManagementService.deleteActivityManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动管理信息置顶
     * @Date 2018/9/21 9:07
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateActivityManagementPlacedTop")
    public void updateActivityManagementPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateActivityManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动管理信息取消置顶
     * @Date 2018/9/21 9:07
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateActivityManagementCancelPlacedTop")
    public void updateActivityManagementCancelPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateActivityManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动管理信息撤销发布
     * @Date 2018/9/21 9:07
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateActivityManagementCancelReportMarks")
    public void updateActivityManagementCancelReportMarks(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateActivityManagementCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加活动管理信息
     * @Date 2018/9/21 9:08
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertActivityManagement")
    public ModelAndView insertActivityManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/activityManagement_info");
        mv.addObject("selectAreaInfo", activityManagementService.selectAreaInfo());
        mv.addObject("selectOrganizationInfo",activityManagementService.selectOrganizationInfo());
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改活动管理信息
     * @Date 2018/9/21 9:08
     * @Param [activityManagement, id]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateActivityManagement")
    public ModelAndView updateActivityManagement(ActivityManagement activityManagement,Integer id){
        ModelAndView mv = new ModelAndView();
        List<ActivityManagement> list = activityManagementService.selectActivityManagementById(id);
        activityManagement.setId(id);
        activityManagement.setName(list.get(0).getName());
        activityManagement.setIntroduction(list.get(0).getIntroduction());
        activityManagement.setModifier(list.get(0).getModifier());
        activityManagement.setReportDate(list.get(0).getReportDate());
        activityManagement.setSorting(list.get(0).getSorting());
        activityManagement.setType(list.get(0).getType());
        activityManagement.setSource(list.get(0).getSource());
        activityManagement.setContent(list.get(0).getContent());
        activityManagement.setFileURL(list.get(0).getFileURL());
        activityManagement.setArea(list.get(0).getArea());
        activityManagement.setReportUnit(list.get(0).getReportUnit());
        mv.setViewName("activityManagement/activityManagement_info");
        mv.addObject("selectAreaInfo", activityManagementService.selectAreaInfo());
        mv.addObject("selectOrganizationInfo",activityManagementService.selectOrganizationInfo());
        mv.addObject("activityManagement",activityManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存活动管理信息
     * @Date 2018/9/21 9:08
     * @Param [session, activityManagement, req, file, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveActivityManagement")
    public ModelAndView saveMediaManagement(HttpSession session,ActivityManagement activityManagement, HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map) {
        List<ActivityManagement> list = activityManagementService.selectActivityManagementById(activityManagement.getId());
        User user = (User) session.getAttribute(Const.SESSION_USER);
        List<Integer> integerList = activityManagementService.selectActivityManagementIdByName(activityManagement.getName());
        ModelAndView mv = new ModelAndView();
        if (activityManagement.getId()!=null){
//            修改
            if (!integerList.isEmpty()){
                if (!integerList.get(0).equals(activityManagement.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            if (file == null || file.isEmpty()) {
                activityManagement.setFileURL(list.get(0).getFileURL());
            } else {
                map = FileUtil.uploadImg(file, req);
                activityManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            }
            if (activityManagement.getArea()==0){
                activityManagement.setArea(list.get(0).getArea());
            }
            if (activityManagement.getReportUnit()==0){
                activityManagement.setReportUnit(list.get(0).getReportUnit());
            }
            activityManagement.setModifier(user.getUsername());
            activityManagement.setModifyTime(new Date());
            activityManagementService.updateActivityManagement(activityManagement);
        }else {
//            添加
            if (!integerList.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            map = FileUtil.uploadImg(file, req);
            activityManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
            activityManagement.setModifier(user.getUsername());
            activityManagement.setModifyTime(new Date());
            activityManagement.setReleaseTime(new Date());
            activityManagement.setReportPeople(user.getUsername());
            activityManagementService.insertActivityManagement(activityManagement);
        }
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历吉祥物管理信息
     * @Date 2018/9/21 9:08
     * @Param [mascotManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageMascotManagement")
    public ModelAndView listPageMascotManagement(MascotManagement mascotManagement){
        if (mascotManagement.getPlacedTop()!=null){
            if (mascotManagement.getPlacedTop()==2){
                mascotManagement.setPlacedTop(null);
            }
        }
        if (mascotManagement.getReportMarks()!=null){
            if (mascotManagement.getReportMarks()==2){
                mascotManagement.setReportMarks(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/mascotManagement");
        mv.addObject("mascotManagement",mascotManagement);
        mv.addObject("listPageMascotManagement",activityManagementService.listPageMascotManagement(mascotManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除吉祥物管理信息
     * @Date 2018/9/21 9:09
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteMascotManagement")
    public void deleteMascotManagement(Integer[] chk_value,PrintWriter out){
        activityManagementService.deleteMascotManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   吉祥物管理信息置顶
     * @Date 2018/9/21 9:09
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateMascotManagementPlacedTop")
    public void updateMascotManagementPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateMascotManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  吉祥物管理信息取消置顶
     * @Date 2018/9/21 9:09
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateMascotManagementCancelPlacedTop")
    public void updateMascotManagementCancelPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateMascotManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  吉祥物管理信息撤销发布
     * @Date 2018/9/21 9:09
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateMascotManagementCancelReportMarks")
    public void updateMascotManagementCancelReportMarks(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateMascotManagementCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加吉祥物管理信息
     * @Date 2018/9/21 9:09
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertMascotManagement")
    public ModelAndView insertMascotManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/mascotManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改吉祥物管理信息
     * @Date 2018/9/21 9:09
     * @Param [id, mascotManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateMascotManagement")
    public ModelAndView updateMascotManagement(Integer id,MascotManagement mascotManagement){
        List<MascotManagement> list = activityManagementService.selectMascotManagementById(id);
        mascotManagement.setId(list.get(0).getId());
        mascotManagement.setContent(list.get(0).getContent());
        mascotManagement.setFileURL(list.get(0).getFileURL());
        mascotManagement.setIntroduction(list.get(0).getIntroduction());
        mascotManagement.setName(list.get(0).getName());
        mascotManagement.setReportDate(list.get(0).getReportDate());
        mascotManagement.setSorting(list.get(0).getSorting());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/mascotManagement_info");
        mv.addObject("mascotManagement",mascotManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   保存吉祥物管理信息
     * @Date 2018/9/21 9:10
     * @Param [mascotManagement, req, file, map, session]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveMascotManagement")
    public ModelAndView saveMascotManagement(MascotManagement mascotManagement,HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map,HttpSession session){
        List<MascotManagement> list = activityManagementService.selectMascotManagementById(mascotManagement.getId());
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (file == null || file.isEmpty()) {
            mascotManagement.setFileURL(list.get(0).getFileURL());
        } else {
            map = FileUtil.uploadImg(file, req);
            mascotManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (mascotManagement.getId()!=null){
//            修改
            mascotManagement.setModifier(user.getUsername());
            mascotManagement.setModifyTime(new Date());
            activityManagementService.updateMascotManagement(mascotManagement);
        }else {
//            添加
            mascotManagement.setModifier(user.getUsername());
            mascotManagement.setModifyTime(new Date());
            mascotManagement.setReportPeople(user.getUsername());
            mascotManagement.setReleaseTime(new Date());
            activityManagementService.insertMascotManagement(mascotManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   遍历展厅管理信息
     * @Date 2018/9/21 9:10
     * @Param [exhibitionHallManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageExhibitionHallManagement")
    public ModelAndView listPageExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement){
        if (exhibitionHallManagement.getPlacedTop()!=null){
            if (exhibitionHallManagement.getPlacedTop()==2){
                exhibitionHallManagement.setPlacedTop(null);
            }
        }
        if (exhibitionHallManagement.getReportMarks()!=null){
            if (exhibitionHallManagement.getReportMarks()==2){
                exhibitionHallManagement.setReportMarks(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/exhibitionHallManagement");
        mv.addObject("exhibitionHallManagement",exhibitionHallManagement);
        mv.addObject("listPageExhibitionHallManagement",activityManagementService.listPageExhibitionHallManagement(exhibitionHallManagement));
        return mv;
    }

    @RequestMapping("/deleteExhibitionHallManagement")
    public void deleteExhibitionHallManagement(Integer[] chk_value,PrintWriter out){
        activityManagementService.deleteExhibitionHallManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  展厅管理信息置顶
     * @Date 2018/9/21 9:10
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateExhibitionHallManagementPlacedTop")
    public void updateExhibitionHallManagementPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateExhibitionHallManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  展厅管理信息取消置顶
     * @Date 2018/9/21 9:10
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateExhibitionHallManagementCancelPlacedTop")
    public void updateExhibitionHallManagementCancelPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateExhibitionHallManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  展厅管理信息撤销发布
     * @Date 2018/9/21 9:11
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateExhibitionHallManagementCancelReportMarks")
    public void updateExhibitionHallManagementCancelReportMarks(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateExhibitionHallManagementCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加展厅管理信息
     * @Date 2018/9/21 9:11
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertExhibitionHallManagement")
    public ModelAndView insertExhibitionHallManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/exhibitionHallManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改展厅管理信息
     * @Date 2018/9/21 9:11
     * @Param [exhibitionHallManagement, id]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateExhibitionHallManagement")
    public ModelAndView updateExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement,Integer id){
        List<ExhibitionHallManagement> list = activityManagementService.selectExhibitionHallManagementById(id);
        exhibitionHallManagement.setId(id);
        exhibitionHallManagement.setContent(list.get(0).getContent());
        exhibitionHallManagement.setFileURL(list.get(0).getFileURL());
        exhibitionHallManagement.setIntroduction(list.get(0).getIntroduction());
        exhibitionHallManagement.setName(list.get(0).getName());
        exhibitionHallManagement.setReportDate(list.get(0).getReportDate());
        exhibitionHallManagement.setSorting(list.get(0).getSorting());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/exhibitionHallManagement_info");
        mv.addObject("exhibitionHallManagement",exhibitionHallManagement);
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存展厅管理信息
     * @Date 2018/9/21 9:11
     * @Param [exhibitionHallManagement, req, file, map, session]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveExhibitionHallManagement")
    public ModelAndView saveExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement,HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file, Map map,HttpSession session){
        List<ExhibitionHallManagement> list = activityManagementService.selectExhibitionHallManagementById(exhibitionHallManagement.getId());
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (file == null || file.isEmpty()) {
            exhibitionHallManagement.setFileURL(list.get(0).getFileURL());
        } else {
            map = FileUtil.uploadImg(file, req);
            exhibitionHallManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }
        if (exhibitionHallManagement.getId()!=null){
//            修改
            exhibitionHallManagement.setModifier(user.getUsername());
            exhibitionHallManagement.setModifyTime(new Date());
            activityManagementService.updateExhibitionHallManagement(exhibitionHallManagement);
        }else {
//            添加
            exhibitionHallManagement.setModifier(user.getUsername());
            exhibitionHallManagement.setModifyTime(new Date());
            exhibitionHallManagement.setReportPeople(user.getUsername());
            exhibitionHallManagement.setReleaseTime(new Date());
            activityManagementService.insertExhibitionHallManagement(exhibitionHallManagement);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历活动类别管理信息
     * @Date 2018/9/21 9:11
     * @Param [activityCategoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageActivityCategoryManagement")
    public ModelAndView listPageActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement){
        if (activityCategoryManagement.getType()!=null){
            if (activityCategoryManagement.getType().equals("0")){
                activityCategoryManagement.setType(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
        mv.addObject("listPageActivityCategoryManagement",activityManagementService.listPageActivityCategoryManagement(activityCategoryManagement));
        mv.addObject("activityCategoryManagement",activityCategoryManagement);
        mv.setViewName("activityManagement/activityCategoryManagement");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除活动类别管理信息
     * @Date 2018/9/21 9:12
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteActivityCategoryManagement")
    public void deleteActivityCategoryManagement(Integer[] chk_value,PrintWriter out){
        activityManagementService.deleteActivityCategoryManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  启用活动类别管理信息
     * @Date 2018/9/21 9:12
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateActivityCategoryManagementInitiateMode")
    public void updateActivityCategoryManagementInitiateMode(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateActivityCategoryManagementInitiateMode(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO   停用活动类别管理信息
     * @Date 2018/9/21 9:13
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateActivityCategoryManagementCancelInitiateMode")
    public void updateActivityCategoryManagementCancelInitiateMode(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateActivityCategoryManagementCancelInitiateMode(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加活动类别管理信息
     * @Date 2018/9/21 9:13
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertActivityCategoryManagement")
    public ModelAndView insertActivityCategoryManagement(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
        mv.setViewName("activityManagement/activityCategoryManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改活动类别管理信息
     * @Date 2018/9/21 9:14
     * @Param [id, activityCategoryManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateActivityCategoryManagement")
    public ModelAndView updateActivityCategoryManagement(Integer id,ActivityCategoryManagement activityCategoryManagement){
         List<ActivityCategoryManagement> list = activityManagementService.selectActivityCategoryManagementById(id);
         activityCategoryManagement.setId(id);
         activityCategoryManagement.setName(list.get(0).getName());
         activityCategoryManagement.setType(list.get(0).getType());
         activityCategoryManagement.setIntroduction(list.get(0).getIntroduction());
         activityCategoryManagement.setLink(list.get(0).getLink());
         activityCategoryManagement.setActivityPhotosURL(list.get(0).getActivityPhotosURL());
         activityCategoryManagement.setBannerPhotosURL(list.get(0).getBannerPhotosURL());
         activityCategoryManagement.setSource(list.get(0).getSource());
         activityCategoryManagement.setArea(list.get(0).getArea());
         ModelAndView mv = new ModelAndView();
         mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
         mv.addObject("activityCategoryManagement",activityCategoryManagement);
         mv.setViewName("activityManagement/activityCategoryManagement_info");
         return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存活动类别管理信息
     * @Date 2018/9/21 9:14
     * @Param [activityCategoryManagement, req, map, activityPhotosURL, bannerPhotosURL, session]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveActivityCategoryManagement")
    public ModelAndView saveActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement, HttpServletRequest req, Map map, @RequestParam(value = "activityPhotos", required = false) MultipartFile activityPhotosURL, @RequestParam(value = "bannerPhotos", required = false) MultipartFile bannerPhotosURL, HttpSession session
    ){
        ModelAndView mv = new ModelAndView();
        List<ActivityCategoryManagement> list = activityManagementService.selectActivityCategoryManagementById(activityCategoryManagement.getId());
        User user = (User) session.getAttribute(Const.SESSION_USER);
        List<ActivityCategoryManagement> activityCategoryManagementList = activityManagementService.selectActivityCategoryManagementByName(activityCategoryManagement.getName());
        if (activityCategoryManagement.getId()!=null){
//            修改
            if (!activityCategoryManagementList.isEmpty()){
                if (!activityCategoryManagementList.get(0).getId().equals(activityCategoryManagement.getId())){
                    mv.addObject("msg", "nameExist");
                    mv.setViewName("save_result");
                    return mv;
                }
            }
            if (activityPhotosURL == null || activityPhotosURL.isEmpty()) {
                activityCategoryManagement.setActivityPhotosURL(list.get(0).getActivityPhotosURL());
            } else {
                map = FileUtil.uploadImg(activityPhotosURL, req);
                activityCategoryManagement.setActivityPhotosURL("/uploadImgs/" + map.get("fileUrl"));
            }
            if (bannerPhotosURL == null || bannerPhotosURL.isEmpty()) {
                activityCategoryManagement.setBannerPhotosURL(list.get(0).getBannerPhotosURL());
            } else {
                map = FileUtil.uploadImg(bannerPhotosURL, req);
                activityCategoryManagement.setBannerPhotosURL("/uploadImgs/" + map.get("fileUrl"));
            }
            activityCategoryManagement.setModifier(user.getUsername());
            activityCategoryManagement.setModifyTime(new Date());
            activityManagementService.updateActivityCategoryManagement(activityCategoryManagement);
        }else {
//            添加
            if (!activityCategoryManagementList.isEmpty()){
                mv.addObject("msg", "nameExist");
                mv.setViewName("save_result");
                return mv;
            }
            map = FileUtil.uploadImg(activityPhotosURL, req);
            activityCategoryManagement.setActivityPhotosURL("/uploadImgs/" + map.get("fileUrl"));
            map = FileUtil.uploadImg(bannerPhotosURL, req);
            activityCategoryManagement.setBannerPhotosURL("/uploadImgs/" + map.get("fileUrl"));
            activityCategoryManagement.setReportPeople(user.getUsername());
            activityCategoryManagement.setReportTime(new Date());
            activityCategoryManagement.setModifier(user.getUsername());
            activityCategoryManagement.setModifyTime(new Date());
            activityManagementService.insertActivityCategoryManagement(activityCategoryManagement);
        }
        mv.setViewName("save_result");
        mv.addObject("msg","success");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历嘉宾管理信息
     * @Date 2018/9/21 9:14
     * @Param [guestManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageGuestManagement")
    public ModelAndView listPageGuestManagement(GuestManagement guestManagement){
        if (guestManagement.getPlacedTop()!=null){
            if (guestManagement.getPlacedTop()==2){
                guestManagement.setPlacedTop(null);
            }
        }
        if (guestManagement.getReportMarks()!=null){
            if (guestManagement.getReportMarks()==2){
                guestManagement.setReportMarks(null);
            }
        }
       ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/guestManagement");
        mv.addObject("guestManagement",guestManagement);
        mv.addObject("listPageGuestManagement",activityManagementService.listPageGuestManagement(guestManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除嘉宾管理信息
     * @Date 2018/9/21 9:14
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteGuestManagement")
    public void deleteGuestManagement(Integer[] chk_value,PrintWriter out){
        activityManagementService.deleteGuestManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  嘉宾管理信息置顶
     * @Date 2018/9/21 9:15
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateGuestManagementPlacedTop")
    public void updateGuestManagementPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateGuestManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  嘉宾管理信息取消置顶
     * @Date 2018/9/21 9:15
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateGuestManagementCancelPlacedTop")
    public void updateGuestManagementCancelPlacedTop(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateGuestManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  嘉宾管理信息撤销发布
     * @Date 2018/9/21 9:15
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateGuestManagementCancelReportMarks")
    public void updateGuestManagementCancelReportMarks(Integer[] chk_value,PrintWriter out){
        activityManagementService.updateGuestManagementCancelReportMarks(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加嘉宾管理信息
     * @Date 2018/9/21 9:15
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertGuestManagement")
    public ModelAndView insertGuestManagement(){
        System.err.println("true");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/guestManagement_info");
        mv.addObject("selectActivityCategoryInfo", activityManagementService.selectActivityCategoryInfo());
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改嘉宾管理信息
     * @Date 2018/9/21 9:15
     * @Param [id, guestManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateGuestManagement")
    public ModelAndView updateGuestManagement(Integer id,GuestManagement guestManagement){
        List<GuestManagement> list = activityManagementService.selectGuestManagementById(id);
        guestManagement.setId(id);
        guestManagement.setName(list.get(0).getName());
        guestManagement.setActivityCategory(list.get(0).getActivityCategory());
        guestManagement.setSorting(list.get(0).getSorting());
        guestManagement.setFileURL(list.get(0).getFileURL());
        guestManagement.setReportDate(list.get(0).getReportDate());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("activityManagement/guestManagement_info");
        mv.addObject("guestManagement", guestManagement);
        mv.addObject("selectActivityCategoryInfo", activityManagementService.selectActivityCategoryInfo());
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存嘉宾管理信息
     * @Date 2018/9/21 9:15
     * @Param [guestManagement, req, map, file, session]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveGuestManagement")
    public ModelAndView saveGuestManagement(GuestManagement guestManagement,HttpServletRequest req, Map map, @RequestParam(value = "file", required = false) MultipartFile file, HttpSession session){
        List<GuestManagement> list = activityManagementService.selectGuestManagementById(guestManagement.getId());
        User user = (User) session.getAttribute(Const.SESSION_USER);
        if (file == null || file.isEmpty()) {
            guestManagement.setFileURL(list.get(0).getFileURL());
        } else {
            map = FileUtil.uploadImg(file, req);
            guestManagement.setFileURL("/uploadImgs/" + map.get("fileUrl"));
        }

        if (guestManagement.getId()!=null){
//            修改
            guestManagement.setModifier(user.getUsername());
            guestManagement.setModifyTime(new Date());
            activityManagementService.updateGuestManagement(guestManagement);
        }else {
//            添加
            guestManagement.setReportPeople(user.getUsername());
            guestManagement.setModifier(user.getUsername());
            guestManagement.setModifyTime(new Date());
            guestManagement.setReleaseTime(new Date());
            activityManagementService.insertGuestManagement(guestManagement);
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

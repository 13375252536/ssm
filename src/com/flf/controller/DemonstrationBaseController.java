package com.flf.controller;

import com.flf.entity.FileUtil;
import com.flf.entity.User;
import com.flf.entity.demonstrationBase.DemonstrationBaseManagement;
import com.flf.entity.policyManagement.RegionalDataMaintenance;
import com.flf.service.ActivityManagementService;
import com.flf.service.DemonstrationBaseService;
import com.flf.service.impl.ActivityManagementServiceImpl;
import com.flf.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DemonstrationBaseManagementController
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/18 10:49
 * @Version: 1.0
 */
@Controller
@RequestMapping("/demonstrationBase")
public class DemonstrationBaseController {

    @Autowired
    private DemonstrationBaseService demonstrationBaseService;
    @Autowired
    private ActivityManagementService activityManagementService;
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历示范基地管理信息
     * @Date 2018/9/18 13:10
     * @Param [demonstrationBaseManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/listPageDemonstrationBaseManagement")
    public ModelAndView listPageDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement){
        if (demonstrationBaseManagement.getType()!=null){
            if (demonstrationBaseManagement.getType().equals("0")){
                demonstrationBaseManagement.setType(null);
            }
        }
        if (demonstrationBaseManagement.getBatch()!=null){
            if (demonstrationBaseManagement.getBatch().equals("0")){
                demonstrationBaseManagement.setBatch(null);
            }
        }
        if (demonstrationBaseManagement.getPlacedTop()!=null){
            if (demonstrationBaseManagement.getPlacedTop()==2){
                demonstrationBaseManagement.setPlacedTop(null);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demonstrationBase/demonstrationBaseManagement");
        mv.addObject("demonstrationBaseManagement",demonstrationBaseManagement);
        mv.addObject("listPageDemonstrationBaseManagement",demonstrationBaseService.listPageDemonstrationBaseManagement(demonstrationBaseManagement));
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除示范基地管理信息
     * @Date 2018/9/21 9:16
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/deleteDemonstrationBaseManagement")
    public void deleteDemonstrationBaseManagement(Integer[] chk_value, PrintWriter out){
        demonstrationBaseService.deleteDemonstrationBaseManagement(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  示范基地管理信息置顶
     * @Date 2018/9/21 9:16
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateDemonstrationBaseManagementPlacedTop")
    public void updateDemonstrationBaseManagementPlacedTop(Integer[] chk_value, PrintWriter out){
        demonstrationBaseService.updateDemonstrationBaseManagementPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  示范基地管理信息取消置顶
     * @Date 2018/9/21 9:17
     * @Param [chk_value, out]
     * @return void
     */
    @RequestMapping("/updateDemonstrationBaseManagementCancelPlacedTop")
    public void updateDemonstrationBaseManagementCancelPlacedTop(Integer[] chk_value, PrintWriter out){
        demonstrationBaseService.updateDemonstrationBaseManagementCancelPlacedTop(chk_value);
        out.write("success");
        out.close();
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加示范基地管理信息
     * @Date 2018/9/21 9:17
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/insertDemonstrationBaseManagement")
    public ModelAndView insertDemonstrationBaseManagement(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demonstrationBase/demonstrationBaseManagement_info");
        mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
        mv.addObject("selectOrganizationInfo",activityManagementService.selectOrganizationInfo());
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改示范基地管理信息
     * @Date 2018/9/21 9:17
     * @Param [id, demonstrationBaseManagement]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/updateDemonstrationBaseManagement")
    public ModelAndView updateDemonstrationBaseManagement(Integer id,DemonstrationBaseManagement demonstrationBaseManagement){
        ModelAndView mv = new ModelAndView();
        demonstrationBaseManagement = demonstrationBaseService.selectDemonstrationBaseManagementById(id);
        mv.addObject("demonstrationBaseManagement",demonstrationBaseManagement);
        mv.addObject("selectAreaInfo",activityManagementService.selectAreaInfo());
        mv.addObject("selectOrganizationInfo",activityManagementService.selectOrganizationInfo());
        mv.setViewName("demonstrationBase/demonstrationBaseManagement_info");
        return mv;
    }
    /**
     * @Author Mr.Chan
     * @Description //TODO  保存示范基地管理信息
     * @Date 2018/9/21 9:19
     * @Param [demonstrationBaseManagement, req, map, file, session]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/saveDemonstrationBaseManagement")
    public ModelAndView saveDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement, HttpServletRequest req, Map map, @RequestParam(value = "file", required = false) MultipartFile file, HttpSession session){
        List<DemonstrationBaseManagement> list = demonstrationBaseService.selectDemonstrationBaseManagementByName(demonstrationBaseManagement.getName());
        User user = (User) session.getAttribute(Const.SESSION_USER);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("save_result");
        if (demonstrationBaseManagement.getId()!=null){
//            修改
            if (!list.isEmpty()){
                if(list.get(0).getId().equals(demonstrationBaseManagement.getId())){
                    mv.addObject("msg","nameExist");
                    return mv;
                }
            }
            if (file == null || file.isEmpty()) {
                demonstrationBaseManagement.setFileURL(list.get(0).getFileURL());
            } else {
                map = FileUtil.uploadFile(file, req);
                demonstrationBaseManagement.setFileURL("/uploadFile/" + map.get("fileUrl"));
            }
            demonstrationBaseManagement.setModifier(user.getUsername());
            demonstrationBaseManagement.setModifyTime(new Date());
            demonstrationBaseService.updateDemonstrationBaseManagement(demonstrationBaseManagement);
        }else {
//          添加
            if (!list.isEmpty()){
                mv.addObject("msg","nameExist");
                return mv;
            }
            map = FileUtil.uploadFile(file, req);
            demonstrationBaseManagement.setFileURL("/uploadFile/" + map.get("fileUrl"));
            demonstrationBaseManagement.setModifier(user.getUsername());
            demonstrationBaseManagement.setModifyTime(new Date());
            demonstrationBaseManagement.setReleasePeople(user.getUsername());
            demonstrationBaseManagement.setReleaseTime(new Date());
            demonstrationBaseService.insertDemonstrationBaseManagement(demonstrationBaseManagement);
        }
        mv.addObject("msg","success");
        return mv;
    }

}

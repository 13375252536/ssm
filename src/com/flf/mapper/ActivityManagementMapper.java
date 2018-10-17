package com.flf.mapper;

import com.flf.entity.OrganizationManagement;
import com.flf.entity.activityManagement.*;
import com.flf.entity.policyManagement.RegionalDataMaintenance;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ActivityManagementMapper
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/10 14:54
 * @Version: 1.0
 */
public interface ActivityManagementMapper {
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历媒体管理信息
     * @Date 2018/9/10 15:17
     * @Param [mediaManagement]
     * @return java.util.List<com.flf.entity.activityManagement.MediaManagement>
     */
    List<MediaManagement> listPageMediaManagement(MediaManagement mediaManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除媒体管理信息
     * @Date 2018/9/10 15:17
     * @Param [chk_value]
     * @return void
     */
    void deleteMediaManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  媒体管理信息置顶
     * @Date 2018/9/10 15:17
     * @Param [chk_value]
     * @return void
     */
    void updateMediaManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO   媒体管理信息取消置顶
     * @Date 2018/9/10 15:17
     * @Param [chk_value]
     * @return void
     */
    void updateMediaManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加媒体管理信息
     * @Date 2018/9/10 15:17
     * @Param [mediaManagement]
     * @return void
     */
    void insertMediaManagement(MediaManagement mediaManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改媒体管理信息
     * @Date 2018/9/10 15:18
     * @Param [mediaManagement]
     * @return void
     */
    void updateMediaManagement(MediaManagement mediaManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询媒体管理信息
     * @Date 2018/9/10 15:18
     * @Param [id]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> selectMediaManagementById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历活动管理信息
     * @Date 2018/9/11 13:44
     * @Param [activityManagement]
     * @return java.util.List<com.flf.entity.activityManagement.ActivityManagement>
     */
    List<ActivityManagement> listPageActivityManagement(ActivityManagement activityManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除活动管理信息
     * @Date 2018/9/11 16:12
     * @Param [chk_value]
     * @return void
     */
    void deleteActivityManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动管理信息置顶
     * @Date 2018/9/11 16:12
     * @Param [chk_value]
     * @return void
     */
    void updateActivityManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动管理信息取消置顶
     * @Date 2018/9/11 16:12
     * @Param [chk_value]
     * @return void
     */
    void updateActivityManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动管理信息撤销发布
     * @Date 2018/9/11 16:13
     * @Param [chk_value]
     * @return void
     */
    void updateActivityManagementCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加活动管理信息
     * @Date 2018/9/11 16:17
     * @Param [activityManagement]
     * @return void
     */
    void insertActivityManagement(ActivityManagement activityManagement);
     /**
      * @Author Mr.Chan
      * @Description //TODO  修改活动管理信息
      * @Date 2018/9/11 16:16
      * @Param [activityManagement]
      * @return void
      */
    void updateActivityManagement(ActivityManagement activityManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询所有活动管理信息
     * @Date 2018/9/11 16:16
     * @Param [id]
     * @return java.util.List<com.flf.entity.activityManagement.ActivityManagement>
     */
    List<ActivityManagement> selectActivityManagementById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有机构的信息
     * @Date 2018/9/11 16:16
     * @Param
     * @return
     */
    List<OrganizationManagement> selectOrganizationInfo();

    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有区域信息
     * @Date 2018/9/11 15:04
     * @Param [regionalDataMaintenance]
     * @return java.util.List<com.flf.entity.policyManagement.RegionalDataMaintenance>
     */
    List<RegionalDataMaintenance> selectAreaInfo();

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历吉祥物管理信息
     * @Date 2018/9/12 14:16
     * @Param [mascotManagement]
     * @return java.util.List<com.flf.entity.activityManagement.MascotManagement>
     */
    List<MascotManagement> listPageMascotManagement(MascotManagement mascotManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除吉祥物管理信息
     * @Date 2018/9/12 14:23
     * @Param [chk_value]
     * @return void
     */
    void deleteMascotManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  吉祥物管理信息置顶
     * @Date 2018/9/12 14:23
     * @Param [chk_value]
     * @return void
     */
    void updateMascotManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  吉祥物管理信息取消置顶
     * @Date 2018/9/12 14:23
     * @Param [chk_value]
     * @return void
     */
    void updateMascotManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  吉祥物管理信息撤销发布
     * @Date 2018/9/12 14:24
     * @Param [chk_value]
     * @return void
     */
    void updateMascotManagementCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加吉祥物管理信息
     * @Date 2018/9/12 14:24
     * @Param [mascotManagement]
     * @return void
     */
    void insertMascotManagement(MascotManagement mascotManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改吉祥物管理信息
     * @Date 2018/9/12 14:24
     * @Param [mascotManagement]
     * @return void
     */
    void updateMascotManagement(MascotManagement mascotManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询吉祥物管理信息
     * @Date 2018/9/12 14:24
     * @Param [id]
     * @return java.util.List<com.flf.entity.activityManagement.MascotManagement>
     */
    List<MascotManagement> selectMascotManagementById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历展厅管理信息
     * @Date 2018/9/13 11:10
     * @Param [exhibitionHallManagement]
     * @return java.util.List<com.flf.entity.activityManagement.ExhibitionHallManagement>
     */
    List<ExhibitionHallManagement> listPageExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除展厅管理信息
     * @Date 2018/9/13 11:11
     * @Param [chk_value]
     * @return void
     */
     void deleteExhibitionHallManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  展厅管理信息置顶
     * @Date 2018/9/13 11:11
     * @Param [chk_value]
     * @return void
     */
    void updateExhibitionHallManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  展厅管理信息取消置顶
     * @Date 2018/9/13 11:11
     * @Param [chk_value]
     * @return void
     */
    void updateExhibitionHallManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  展厅管理信息撤销发布
     * @Date 2018/9/13 11:11
     * @Param [chk_value]
     * @return void
     */
    void updateExhibitionHallManagementCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加展厅管理信息
     * @Date 2018/9/13 11:11
     * @Param [exhibitionHallManagement]
     * @return void
     */
    void insertExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改展厅管理信息
     * @Date 2018/9/13 11:12
     * @Param [exhibitionHallManagement]
     * @return void
     */
    void updateExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO   通过id查询展厅管理信息
     * @Date 2018/9/13 11:12
     * @Param [id]
     * @return java.util.List<com.flf.entity.activityManagement.ExhibitionHallManagement>
     */
    List<ExhibitionHallManagement> selectExhibitionHallManagementById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历活动类别管理信息
     * @Date 2018/9/13 13:43
     * @Param [activityCategoryManagement]
     * @return java.util.List<com.flf.entity.activityManagement.ActivityCategoryManagement>
     */
    List<ActivityCategoryManagement> listPageActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除活动类别管理信息
     * @Date 2018/9/13 13:44
     * @Param [chk_value]
     * @return void
     */
    void deleteActivityCategoryManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动类别管理信息启用
     * @Date 2018/9/13 13:44
     * @Param [chk_value]
     * @return void
     */
    void updateActivityCategoryManagementInitiateMode(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  活动类别管理信息停用
     * @Date 2018/9/13 13:45
     * @Param [chk_value]
     * @return void
     */
    void updateActivityCategoryManagementCancelInitiateMode(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改活动类别管理信息
     * @Date 2018/9/13 13:45
     * @Param [activityCategoryManagement]
     * @return void
     */
    void updateActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加活动类别管理信息
     * @Date 2018/9/13 13:45
     * @Param [activityCategoryManagement]
     * @return void
     */
    void insertActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询活动类别管理信息
     * @Date 2018/9/13 13:45
     * @Param [id]
     * @return java.util.List<com.flf.entity.activityManagement.ActivityCategoryManagement>
     */
    List<ActivityCategoryManagement> selectActivityCategoryManagementById(Integer id);

    /**
     * @Author Mr.Chan
     * @Description //TODO   通过name查询活动类别管理信息
     * @Date 2018/9/14 9:59
     * @Param [name]
     * @return java.util.List<com.flf.entity.activityManagement.ActivityCategoryManagement>
     */
    List<ActivityCategoryManagement> selectActivityCategoryManagementByName(String name);

    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历嘉宾管理信息
     * @Date 2018/9/13 22:02
     * @Param [guestManagement]
     * @return java.util.List<com.flf.entity.activityManagement.GuestManagement>
     */
    List<GuestManagement> listPageGuestManagement(GuestManagement guestManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除嘉宾管理信息
     * @Date 2018/9/13 22:03
     * @Param [chk_value]
     * @return void
     */
    void deleteGuestManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  嘉宾管理信息置顶
     * @Date 2018/9/13 22:03
     * @Param [chk_value]
     * @return void
     */
    void updateGuestManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  嘉宾管理信息取消置顶
     * @Date 2018/9/13 22:03
     * @Param [chk_value]
     * @return void
     */
    void updateGuestManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  嘉宾管理信息撤销发布
     * @Date 2018/9/13 22:03
     * @Param [chk_value]
     * @return void
     */
    void updateGuestManagementCancelReportMarks(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加嘉宾管理信息
     * @Date 2018/9/13 22:03
     * @Param [guestManagement]
     * @return void
     */
    void insertGuestManagement(GuestManagement guestManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改嘉宾管理信息
     * @Date 2018/9/13 22:03
     * @Param [guestManagement]
     * @return void
     */
    void updateGuestManagement(GuestManagement guestManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询嘉宾管理信息
     * @Date 2018/9/13 22:03
     * @Param [id]
     * @return java.util.List<com.flf.entity.activityManagement.GuestManagement>
     */
     List<GuestManagement> selectGuestManagementById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  查询所有活动分类信息
     * @Date 2018/9/13 22:04
     * @Param []
     * @return java.util.List<com.flf.entity.activityManagement.ActivityCategoryManagement>
     */
    List<ActivityCategoryManagement> selectActivityCategoryInfo();
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过活动管理name查询活动管理id
     * @Date 2018/10/10 10:23
     * @Param [name]
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> selectActivityManagementIdByName(String name);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过媒体管理name查询媒体管理id
     * @Date 2018/10/10 10:23
     * @Param [name]
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> selectMediaManagementIdByName(String name);

   }

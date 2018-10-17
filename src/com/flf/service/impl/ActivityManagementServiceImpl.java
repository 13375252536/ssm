package com.flf.service.impl;

import com.flf.entity.OrganizationManagement;
import com.flf.entity.activityManagement.*;
import com.flf.entity.policyManagement.RegionalDataMaintenance;
import com.flf.mapper.ActivityManagementMapper;
import com.flf.service.ActivityManagementService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ActivityManagementServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/10 15:12
 * @Version: 1.0
 */
public class ActivityManagementServiceImpl implements ActivityManagementService {
    private ActivityManagementMapper activityManagementMapper;

    public ActivityManagementMapper getActivityManagementMapper() {
        return activityManagementMapper;
    }

    public void setActivityManagementMapper(ActivityManagementMapper activityManagementMapper) {
        this.activityManagementMapper = activityManagementMapper;
    }


    @Override
    public List<MediaManagement> listPageMediaManagement(MediaManagement mediaManagement) {
        return activityManagementMapper.listPageMediaManagement(mediaManagement);
    }

    @Override
    public void deleteMediaManagement(Integer[] chk_value) {
        activityManagementMapper.deleteMediaManagement(chk_value);
    }

    @Override
    public void updateMediaManagementPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateMediaManagementPlacedTop(chk_value);
    }

    @Override
    public void updateMediaManagementCancelPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateMediaManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertMediaManagement(MediaManagement mediaManagement) {
        activityManagementMapper.insertMediaManagement(mediaManagement);
    }

    @Override
    public void updateMediaManagement(MediaManagement mediaManagement) {
        activityManagementMapper.updateMediaManagement(mediaManagement);
    }

    @Override
    public List<Map<String, Object>> selectMediaManagementById(Integer id) {
        return activityManagementMapper.selectMediaManagementById(id);
    }

    @Override
    public List<ActivityManagement> listPageActivityManagement(ActivityManagement activityManagement) {

        return activityManagementMapper.listPageActivityManagement(activityManagement);
    }

    @Override
    public List<RegionalDataMaintenance> selectAreaInfo() {
        return activityManagementMapper.selectAreaInfo();
    }

    @Override
    public void deleteActivityManagement(Integer[] chk_value) {
        activityManagementMapper.deleteActivityManagement(chk_value);
    }

    @Override
    public void updateActivityManagementPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateActivityManagementPlacedTop(chk_value);
    }

    @Override
    public void updateActivityManagementCancelPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateActivityManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void updateActivityManagementCancelReportMarks(Integer[] chk_value) {
        activityManagementMapper.updateActivityManagementCancelReportMarks(chk_value);
    }

    @Override
    public void insertActivityManagement(ActivityManagement activityManagement) {
        activityManagementMapper.insertActivityManagement(activityManagement);
    }

    @Override
    public void updateActivityManagement(ActivityManagement activityManagement) {
        activityManagementMapper.updateActivityManagement(activityManagement);
    }

    @Override
    public List<ActivityManagement> selectActivityManagementById(Integer id) {
        return activityManagementMapper.selectActivityManagementById(id);
    }

    @Override
    public List<OrganizationManagement> selectOrganizationInfo() {
        return activityManagementMapper.selectOrganizationInfo();
    }

    @Override
    public List<MascotManagement> listPageMascotManagement(MascotManagement mascotManagement) {
        return activityManagementMapper.listPageMascotManagement(mascotManagement);
    }

    @Override
    public void deleteMascotManagement(Integer[] chk_value) {
        activityManagementMapper.deleteMascotManagement(chk_value);
    }

    @Override
    public void updateMascotManagementPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateMascotManagementPlacedTop(chk_value);
    }

    @Override
    public void updateMascotManagementCancelPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateMascotManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void updateMascotManagementCancelReportMarks(Integer[] chk_value) {
        activityManagementMapper.updateMascotManagementCancelReportMarks(chk_value);
    }

    @Override
    public void insertMascotManagement(MascotManagement mascotManagement) {
        activityManagementMapper.insertMascotManagement(mascotManagement);
    }

    @Override
    public void updateMascotManagement(MascotManagement mascotManagement) {
        activityManagementMapper.updateMascotManagement(mascotManagement);
    }

    @Override
    public List<MascotManagement> selectMascotManagementById(Integer id) {
        return activityManagementMapper.selectMascotManagementById(id);
    }

    @Override
    public List<ExhibitionHallManagement> listPageExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement) {
        return activityManagementMapper.listPageExhibitionHallManagement(exhibitionHallManagement);
    }

    @Override
    public void deleteExhibitionHallManagement(Integer[] chk_value) {
        activityManagementMapper.deleteExhibitionHallManagement(chk_value);
    }

    @Override
    public void updateExhibitionHallManagementPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateExhibitionHallManagementPlacedTop(chk_value);
    }

    @Override
    public void updateExhibitionHallManagementCancelPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateExhibitionHallManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void updateExhibitionHallManagementCancelReportMarks(Integer[] chk_value) {
        activityManagementMapper.updateExhibitionHallManagementCancelReportMarks(chk_value);
    }

    @Override
    public void insertExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement) {
        activityManagementMapper.insertExhibitionHallManagement(exhibitionHallManagement);
    }

    @Override
    public void updateExhibitionHallManagement(ExhibitionHallManagement exhibitionHallManagement) {
        activityManagementMapper.updateExhibitionHallManagement(exhibitionHallManagement);
    }

    @Override
    public List<ExhibitionHallManagement> selectExhibitionHallManagementById(Integer id) {
        return activityManagementMapper.selectExhibitionHallManagementById(id);
    }

    @Override
    public List<ActivityCategoryManagement> listPageActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement) {
        return activityManagementMapper.listPageActivityCategoryManagement(activityCategoryManagement);
    }

    @Override
    public void deleteActivityCategoryManagement(Integer[] chk_value) {
        activityManagementMapper.deleteActivityCategoryManagement(chk_value);
    }

    @Override
    public void updateActivityCategoryManagementInitiateMode(Integer[] chk_value) {
        activityManagementMapper.updateActivityCategoryManagementInitiateMode(chk_value);
    }

    @Override
    public void updateActivityCategoryManagementCancelInitiateMode(Integer[] chk_value) {
        activityManagementMapper.updateActivityCategoryManagementCancelInitiateMode(chk_value);
    }

    @Override
    public void updateActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement) {
        activityManagementMapper.updateActivityCategoryManagement(activityCategoryManagement);
    }

    @Override
    public void insertActivityCategoryManagement(ActivityCategoryManagement activityCategoryManagement) {
        activityManagementMapper.insertActivityCategoryManagement(activityCategoryManagement);
    }

    @Override
    public List<ActivityCategoryManagement> selectActivityCategoryManagementById(Integer id) {
        return activityManagementMapper.selectActivityCategoryManagementById(id);
    }

    @Override
    public List<ActivityCategoryManagement> selectActivityCategoryManagementByName(String name) {
        return activityManagementMapper.selectActivityCategoryManagementByName(name);
    }

    @Override
    public List<GuestManagement> listPageGuestManagement(GuestManagement guestManagement) {
        return activityManagementMapper.listPageGuestManagement(guestManagement);
    }

    @Override
    public void deleteGuestManagement(Integer[] chk_value) {
        activityManagementMapper.deleteGuestManagement(chk_value);
    }

    @Override
    public void updateGuestManagementPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateGuestManagementPlacedTop(chk_value);
    }

    @Override
    public void updateGuestManagementCancelPlacedTop(Integer[] chk_value) {
        activityManagementMapper.updateGuestManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void updateGuestManagementCancelReportMarks(Integer[] chk_value) {
        activityManagementMapper.updateGuestManagementCancelReportMarks(chk_value);
    }

    @Override
    public void insertGuestManagement(GuestManagement guestManagement) {
        activityManagementMapper.insertGuestManagement(guestManagement);
    }

    @Override
    public void updateGuestManagement(GuestManagement guestManagement) {
        activityManagementMapper.updateGuestManagement(guestManagement);
    }

    @Override
    public List<GuestManagement> selectGuestManagementById(Integer id) {
        return activityManagementMapper.selectGuestManagementById(id);
    }

    @Override
    public List<ActivityCategoryManagement> selectActivityCategoryInfo() {
        return activityManagementMapper.selectActivityCategoryInfo();
    }

    @Override
    public List<Integer> selectActivityManagementIdByName(String name) {
        return activityManagementMapper.selectActivityManagementIdByName(name);
    }

    @Override
    public List<Integer> selectMediaManagementIdByName(String name) {
        return activityManagementMapper.selectMediaManagementIdByName(name);
    }
}

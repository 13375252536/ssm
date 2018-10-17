package com.flf.service.impl;

import com.flf.entity.importantEmergingIndustries.*;
import com.flf.mapper.ImportantEmergingIndustriesMapper;
import com.flf.service.ImportantEmergingIndustriesService;

import java.util.List;

/**
 * @ClassName: ImportantEmergingIndustriesServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/14 16:33
 * @Version: 1.0
 */
public class ImportantEmergingIndustriesServiceImpl implements ImportantEmergingIndustriesService {
    
    private ImportantEmergingIndustriesMapper importantEmergingIndustriesMapper;

    public ImportantEmergingIndustriesMapper getImportantEmergingIndustriesMapper() {
        return importantEmergingIndustriesMapper;
    }

    public void setImportantEmergingIndustriesMapper(ImportantEmergingIndustriesMapper importantEmergingIndustriesMapper) {
        this.importantEmergingIndustriesMapper = importantEmergingIndustriesMapper;
    }
    @Override
    public List<ImportantEmergingIndustries> listPageImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries) {
        return importantEmergingIndustriesMapper.listPageImportantEmergingIndustries(importantEmergingIndustries);
    }

    @Override
    public void deleteImportantEmergingIndustries(Integer[] chk_value) {
        importantEmergingIndustriesMapper.deleteImportantEmergingIndustries(chk_value);
    }

    @Override
    public void updateImportantEmergingIndustriesPlacedTop(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateImportantEmergingIndustriesPlacedTop(chk_value);
    }

    @Override
    public void updateImportantEmergingIndustriesCancelPlacedTop(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateImportantEmergingIndustriesCancelPlacedTop(chk_value);
    }

    @Override
    public void updateImportantEmergingIndustriesReportMarks(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateImportantEmergingIndustriesReportMarks(chk_value);
    }

    @Override
    public void updateImportantEmergingIndustriesCancelReportMarks(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateImportantEmergingIndustriesCancelReportMarks(chk_value);
    }

    @Override
    public void insertImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries) {
        importantEmergingIndustriesMapper.insertImportantEmergingIndustries(importantEmergingIndustries);
    }

    @Override
    public void updateImportantEmergingIndustries(ImportantEmergingIndustries importantEmergingIndustries) {
        importantEmergingIndustriesMapper.updateImportantEmergingIndustries(importantEmergingIndustries);
    }

    @Override
    public ImportantEmergingIndustries selectImportantEmergingIndustriesById(Integer id) {
        return importantEmergingIndustriesMapper.selectImportantEmergingIndustriesById(id);
    }

    @Override
    public List<ImportantEmergingIndustries> selectImportantEmergingIndustriesByName(ImportantEmergingIndustries importantEmergingIndustries) {
        return importantEmergingIndustriesMapper.selectImportantEmergingIndustriesByName(importantEmergingIndustries);
    }
    @Override
    public List<EmergingIndustryManagement> listPageEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement) {
        return importantEmergingIndustriesMapper.listPageEmergingIndustryManagement(emergingIndustryManagement);
    }

    @Override
    public void deleteEmergingIndustryManagement(Integer[] chk_value) {
        importantEmergingIndustriesMapper.deleteEmergingIndustryManagement(chk_value);
    }

    @Override
    public void updateEmergingIndustryManagementPlacedTop(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateEmergingIndustryManagementPlacedTop(chk_value);
    }

    @Override
    public void updateEmergingIndustryManagementCancelPlacedTop(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateEmergingIndustryManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void updateEmergingIndustryManagementReportMarks(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateEmergingIndustryManagementReportMarks(chk_value);
    }

    @Override
    public void updateEmergingIndustryManagementCancelReportMarks(Integer[] chk_value) {
        importantEmergingIndustriesMapper.updateEmergingIndustryManagementCancelReportMarks(chk_value);
    }

    @Override
    public void insertEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement) {
        importantEmergingIndustriesMapper.insertEmergingIndustryManagement(emergingIndustryManagement);
    }

    @Override
    public void updateEmergingIndustryManagement(EmergingIndustryManagement emergingIndustryManagement) {
        importantEmergingIndustriesMapper.updateEmergingIndustryManagement(emergingIndustryManagement);
    }

    @Override
    public EmergingIndustryManagement selectEmergingIndustryManagementById(Integer id) {
        return importantEmergingIndustriesMapper.selectEmergingIndustryManagementById(id);
    }

    @Override
    public List<EmergingIndustryManagement> selectEmergingIndustryManagementByName(String name) {
        return importantEmergingIndustriesMapper.selectEmergingIndustryManagementByName(name);
    }

}

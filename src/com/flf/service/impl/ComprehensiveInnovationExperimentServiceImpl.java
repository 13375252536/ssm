package com.flf.service.impl;

import com.flf.entity.comprehensiveInnovationExperiment.*;
import com.flf.mapper.ComprehensiveInnovationExperimentMapper;
import com.flf.service.ComprehensiveInnovationExperimentService;

import java.util.List;

/**
 * @ClassName: ComprehensiveInnovationExperimentServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/14 11:11
 * @Version: 1.0
 */
public class ComprehensiveInnovationExperimentServiceImpl implements ComprehensiveInnovationExperimentService {
    private ComprehensiveInnovationExperimentMapper comprehensiveInnovationExperimentMapper;

    public ComprehensiveInnovationExperimentMapper getComprehensiveInnovationExperimentMapper() {
        return comprehensiveInnovationExperimentMapper;
    }

    public void setComprehensiveInnovationExperimentMapper(ComprehensiveInnovationExperimentMapper comprehensiveInnovationExperimentMapper) {
        this.comprehensiveInnovationExperimentMapper = comprehensiveInnovationExperimentMapper;
    }

    @Override
    public List<ComprehensiveInnovationExperiment> listPageComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment) {
        return comprehensiveInnovationExperimentMapper.listPageComprehensiveInnovationExperiment(comprehensiveInnovationExperiment);
    }

    @Override
    public void deleteComprehensiveInnovationExperiment(Integer[] chk_value) {
        comprehensiveInnovationExperimentMapper.deleteComprehensiveInnovationExperiment(chk_value);
    }

    @Override
    public void updateComprehensiveInnovationExperimentPlacedTop(Integer[] chk_value) {
        comprehensiveInnovationExperimentMapper.updateComprehensiveInnovationExperimentPlacedTop(chk_value);
    }

    @Override
    public void updateComprehensiveInnovationExperimentCancelPlacedTop(Integer[] chk_value) {
        comprehensiveInnovationExperimentMapper.updateComprehensiveInnovationExperimentCancelPlacedTop(chk_value);
    }

    @Override
    public void updateComprehensiveInnovationExperimentReportMarks(Integer[] chk_value) {
        comprehensiveInnovationExperimentMapper.updateComprehensiveInnovationExperimentReportMarks(chk_value);
    }

    @Override
    public void updateComprehensiveInnovationExperimentCancelReportMarks(Integer[] chk_value) {
        comprehensiveInnovationExperimentMapper.updateComprehensiveInnovationExperimentCancelReportMarks(chk_value);
    }

    @Override
    public void insertComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment) {
        comprehensiveInnovationExperimentMapper.insertComprehensiveInnovationExperiment(comprehensiveInnovationExperiment);
    }

    @Override
    public void updateComprehensiveInnovationExperiment(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment) {
        comprehensiveInnovationExperimentMapper.updateComprehensiveInnovationExperiment(comprehensiveInnovationExperiment);
    }

    @Override
    public ComprehensiveInnovationExperiment selectComprehensiveInnovationExperimentById(Integer id) {
        return comprehensiveInnovationExperimentMapper.selectComprehensiveInnovationExperimentById(id);
    }

    @Override
    public List<ComprehensiveInnovationExperiment> selectComprehensiveInnovationExperimentByName(ComprehensiveInnovationExperiment comprehensiveInnovationExperiment) {
        return comprehensiveInnovationExperimentMapper.selectComprehensiveInnovationExperimentByName(comprehensiveInnovationExperiment);
    }
}

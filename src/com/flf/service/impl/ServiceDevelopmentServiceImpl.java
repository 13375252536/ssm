package com.flf.service.impl;

import com.flf.entity.serviceDevelopment.FundFeeEnquiry;
import com.flf.entity.serviceDevelopment.GuideManagement;
import com.flf.entity.serviceDevelopment.TaxPreferenceEnquiry;
import com.flf.mapper.ServiceDevelopmentMapper;
import com.flf.service.ServiceDevelopmentService;

import java.util.List;

/**
 * @ClassName: ServiceDevelopmentServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/23 19:38
 * @Version: 1.0
 */
public class ServiceDevelopmentServiceImpl implements ServiceDevelopmentService {

    private ServiceDevelopmentMapper serviceDevelopmentMapper;

    public ServiceDevelopmentMapper getServiceDevelopmentMapper() {
        return serviceDevelopmentMapper;
    }

    public void setServiceDevelopmentMapper(ServiceDevelopmentMapper serviceDevelopmentMapper) {
        this.serviceDevelopmentMapper = serviceDevelopmentMapper;
    }

    @Override
    public List<GuideManagement> listPageGuideManagement(GuideManagement guideManagement) {
        return serviceDevelopmentMapper.listPageGuideManagement(guideManagement);
    }

    @Override
    public void deleteGuideManagement(Integer[] chk_value) {
        serviceDevelopmentMapper.deleteGuideManagement(chk_value);
    }

    @Override
    public void updateGuideManagementReportMarks(Integer[] chk_value) {
        serviceDevelopmentMapper.updateGuideManagementReportMarks(chk_value);
    }

    @Override
    public void updateGuideManagementCancelReportMarks(Integer[] chk_value) {
        serviceDevelopmentMapper.updateGuideManagementCancelReportMarks(chk_value);
    }

    @Override
    public void insertGuideManagement(GuideManagement guideManagement) {
        serviceDevelopmentMapper.insertGuideManagement(guideManagement);
    }

    @Override
    public void updateGuideManagement(GuideManagement guideManagement) {
        serviceDevelopmentMapper.updateGuideManagement(guideManagement);
    }

    @Override
    public GuideManagement selectGuideManagementById(int id) {
        return serviceDevelopmentMapper.selectGuideManagementById(id);
    }

    @Override
    public List<Integer> selectGuideManagementIdByName(String name) {
        return serviceDevelopmentMapper.selectGuideManagementIdByName(name);
    }

    @Override
    public List<FundFeeEnquiry> listPageFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry) {
        return serviceDevelopmentMapper.listPageFundFeeEnquiry(fundFeeEnquiry);
    }

    @Override
    public void deleteFundFeeEnquiry(Integer[] chk_value) {
        serviceDevelopmentMapper.deleteFundFeeEnquiry(chk_value);
    }

    @Override
    public void updateFundFeeEnquiryCancelReportMarks(Integer[] chk_value) {
        serviceDevelopmentMapper.updateFundFeeEnquiryCancelReportMarks(chk_value);
    }

    @Override
    public void updateFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry) {
        serviceDevelopmentMapper.updateFundFeeEnquiry(fundFeeEnquiry);
    }

    @Override
    public void insertFundFeeEnquiry(FundFeeEnquiry fundFeeEnquiry) {
        serviceDevelopmentMapper.insertFundFeeEnquiry(fundFeeEnquiry);
    }

    @Override
    public FundFeeEnquiry selectFundFeeEnquiryById(Integer id) {
        return serviceDevelopmentMapper.selectFundFeeEnquiryById(id);
    }

    @Override
    public List<TaxPreferenceEnquiry> listPageTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry) {
        return serviceDevelopmentMapper.listPageTaxPreferenceEnquiry(taxPreferenceEnquiry);
    }

    @Override
    public void deleteTaxPreferenceEnquiry(Integer[] chk_value) {
        serviceDevelopmentMapper.deleteTaxPreferenceEnquiry(chk_value);
    }

    @Override
    public void updateTaxPreferenceEnquiryCancelReportMarks(Integer[] chk_value) {
        serviceDevelopmentMapper.updateTaxPreferenceEnquiryCancelReportMarks(chk_value);
    }

    @Override
    public void insertTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry) {
        serviceDevelopmentMapper.insertTaxPreferenceEnquiry(taxPreferenceEnquiry);
    }

    @Override
    public void updateTaxPreferenceEnquiry(TaxPreferenceEnquiry taxPreferenceEnquiry) {
        serviceDevelopmentMapper.updateTaxPreferenceEnquiry(taxPreferenceEnquiry);
    }

    @Override
    public TaxPreferenceEnquiry selectTaxPreferenceEnquiryById(Integer id) {
        return serviceDevelopmentMapper.selectTaxPreferenceEnquiryById(id);
    }
}

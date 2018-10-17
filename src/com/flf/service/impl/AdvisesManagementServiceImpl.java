package com.flf.service.impl;

import com.flf.entity.advisesManagement.MakeRecommendations;
import com.flf.entity.advisesManagement.SuggestionsAndGuidelines;
import com.flf.mapper.AdvisesManagementMapper;
import com.flf.service.AdvisesManagementService;

import java.util.List;

/**
 * @ClassName: AdvisesManagementServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/22 18:04
 * @Version: 1.0
 */
public class AdvisesManagementServiceImpl implements AdvisesManagementService {
    private AdvisesManagementMapper advisesManagementMapper;

    public AdvisesManagementMapper getAdvisesManagementMapper() {
        return advisesManagementMapper;
    }

    public void setAdvisesManagementMapper(AdvisesManagementMapper advisesManagementMapper) {
        this.advisesManagementMapper = advisesManagementMapper;
    }

    @Override
    public List<MakeRecommendations> listPageMakeRecommendations(MakeRecommendations makeRecommendations) {
        return advisesManagementMapper.listPageMakeRecommendations(makeRecommendations);
    }

    @Override
    public void deleteMakeRecommendations(Integer[] chk_value) {
        advisesManagementMapper.deleteMakeRecommendations(chk_value);
    }

    @Override
    public void updateMakeRecommendationsState(MakeRecommendations makeRecommendations) {
        advisesManagementMapper.updateMakeRecommendationsState(makeRecommendations);
    }

    @Override
    public MakeRecommendations selectMakeRecommendationsById(Integer id) {
        return advisesManagementMapper.selectMakeRecommendationsById(id);
    }

    @Override
    public List<SuggestionsAndGuidelines> listPageSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines) {
        return advisesManagementMapper.listPageSuggestionsAndGuidelines(suggestionsAndGuidelines);
    }

    @Override
    public void updateSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines) {
        advisesManagementMapper.updateSuggestionsAndGuidelines(suggestionsAndGuidelines);
    }

    @Override
    public SuggestionsAndGuidelines selectSuggestionsAndGuidelinesById() {
        return advisesManagementMapper.selectSuggestionsAndGuidelinesById();
    }

}

package com.flf.service;

import com.flf.entity.advisesManagement.MakeRecommendations;
import com.flf.entity.advisesManagement.SuggestionsAndGuidelines;

import java.util.List;

/**
 * @ClassName: AdvisesManagementService
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/22 18:04
 * @Version: 1.0
 */
public interface AdvisesManagementService {
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历所有建言献策的信息
     * @Date 2018/9/22 18:03
     * @Param [makeRecommendations]
     * @return java.util.List<com.flf.entity.advisesManagement.MakeRecommendations>
     */
    List<MakeRecommendations> listPageMakeRecommendations(MakeRecommendations makeRecommendations);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除建言献策信息
     * @Date 2018/9/22 18:03
     * @Param [id]
     * @return void
     */
    void deleteMakeRecommendations(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO   审核建言献策
     * @Date 2018/9/22 18:02
     * @Param [makeRecommendations]
     * @return void
     */
    void updateMakeRecommendationsState(MakeRecommendations makeRecommendations);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询建言献策的信息
     * @Date 2018/9/22 18:00
     * @Param [id]
     * @return com.flf.entity.advisesManagement.MakeRecommendations
     */
    MakeRecommendations selectMakeRecommendationsById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历建言须知信息
     * @Date 2018/9/22 20:25
     * @Param [suggestionsAndGuidelines]
     * @return java.util.List<com.flf.entity.advisesManagement.SuggestionsAndGuidelines>
     */
    List<SuggestionsAndGuidelines> listPageSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改建言须知信息
     * @Date 2018/9/22 20:25
     * @Param [suggestionsAndGuidelines]
     * @return void
     */
    void updateSuggestionsAndGuidelines(SuggestionsAndGuidelines suggestionsAndGuidelines);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id 查询建言须知信息
     * @Date 2018/9/22 20:25
     * @Param []
     * @return com.flf.entity.advisesManagement.SuggestionsAndGuidelines
     */
    SuggestionsAndGuidelines selectSuggestionsAndGuidelinesById();

}

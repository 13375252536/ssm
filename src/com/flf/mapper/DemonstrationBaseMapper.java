package com.flf.mapper;

import com.flf.entity.demonstrationBase.DemonstrationBaseManagement;

import java.util.List;

/**
 * @ClassName: DemonstrationBaseMapper
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/18 10:24
 * @Version: 1.0
 */
public interface DemonstrationBaseMapper {
    /**
     * @Author Mr.Chan
     * @Description //TODO  遍历示范基地管理信息
     * @Date 2018/9/18 10:47
     * @Param [demonstrationBaseManagement]
     * @return java.util.List<com.flf.entity.demonstrationBase.DemonstrationBaseManagement>
     */
    List<DemonstrationBaseManagement> listPageDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  删除示范基地管理信息
     * @Date 2018/9/18 13:05
     * @Param [chk_value]
     * @return void
     */
    void deleteDemonstrationBaseManagement(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO   示范基地管理信息置顶
     * @Date 2018/9/18 13:05
     * @Param [chk_value]
     * @return void
     */
    void updateDemonstrationBaseManagementPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  示范基地管理信息取消置顶
     * @Date 2018/9/18 13:05
     * @Param [chk_value]
     * @return void
     */
    void updateDemonstrationBaseManagementCancelPlacedTop(Integer[] chk_value);
    /**
     * @Author Mr.Chan
     * @Description //TODO  添加示范基地管理信息
     * @Date 2018/9/18 13:05
     * @Param [demonstrationBaseManagement]
     * @return void
     */
    void insertDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  修改示范基地管理信息
     * @Date 2018/9/18 13:06
     * @Param [demonstrationBaseManagement]
     * @return void
     */
    void updateDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过id查询示范基地管理信息
     * @Date 2018/9/18 13:06
     * @Param [id]
     * @return com.flf.entity.demonstrationBase.DemonstrationBaseManagement
     */
    DemonstrationBaseManagement selectDemonstrationBaseManagementById(Integer id);
    /**
     * @Author Mr.Chan
     * @Description //TODO  通过name查询示范基地管理信息
     * @Date 2018/9/18 13:06
     * @Param [name]
     * @return java.util.List<com.flf.entity.demonstrationBase.DemonstrationBaseManagement>
     */
    List<DemonstrationBaseManagement> selectDemonstrationBaseManagementByName(String name);

}

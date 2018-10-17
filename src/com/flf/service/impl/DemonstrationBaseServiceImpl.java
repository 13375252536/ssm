package com.flf.service.impl;

import com.flf.entity.demonstrationBase.DemonstrationBaseManagement;
import com.flf.mapper.DemonstrationBaseMapper;
import com.flf.service.DemonstrationBaseService;

import java.util.List;

/**
 * @ClassName: DemonstrationBaseManagementServiceImpl
 * @Description: //TODO
 * @Author: Mr.Chan
 * @Data: 2018/9/18 10:46
 * @Version: 1.0
 */
public class DemonstrationBaseServiceImpl implements DemonstrationBaseService {
    private DemonstrationBaseMapper demonstrationBaseMapper;

    public DemonstrationBaseMapper getDemonstrationBaseMapper() {
        return demonstrationBaseMapper;
    }

    public void setDemonstrationBaseMapper(DemonstrationBaseMapper demonstrationBaseMapper) {
        this.demonstrationBaseMapper = demonstrationBaseMapper;
    }

    @Override
    public List<DemonstrationBaseManagement> listPageDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement) {
        return demonstrationBaseMapper.listPageDemonstrationBaseManagement(demonstrationBaseManagement);
    }

    @Override
    public void deleteDemonstrationBaseManagement(Integer[] chk_value) {
        demonstrationBaseMapper.deleteDemonstrationBaseManagement(chk_value);
    }

    @Override
    public void updateDemonstrationBaseManagementPlacedTop(Integer[] chk_value) {
        demonstrationBaseMapper.updateDemonstrationBaseManagementPlacedTop(chk_value);
    }

    @Override
    public void updateDemonstrationBaseManagementCancelPlacedTop(Integer[] chk_value) {
        demonstrationBaseMapper.updateDemonstrationBaseManagementCancelPlacedTop(chk_value);
    }

    @Override
    public void insertDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement) {
        demonstrationBaseMapper.insertDemonstrationBaseManagement(demonstrationBaseManagement);
    }

    @Override
    public void updateDemonstrationBaseManagement(DemonstrationBaseManagement demonstrationBaseManagement) {
        demonstrationBaseMapper.updateDemonstrationBaseManagement(demonstrationBaseManagement);
    }

    @Override
    public DemonstrationBaseManagement selectDemonstrationBaseManagementById(Integer id) {
        return demonstrationBaseMapper.selectDemonstrationBaseManagementById(id);
    }

    @Override
    public List<DemonstrationBaseManagement> selectDemonstrationBaseManagementByName(String name) {
        return demonstrationBaseMapper.selectDemonstrationBaseManagementByName(name);
    }
}

package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.core.AbstractService;
import com.gahon.leftchild.core.ServiceException;
import com.gahon.leftchild.dao.DemandMapper;
import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.service.DemandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Gahon
 * @date 2018/12/28.
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class DemandServiceImpl extends AbstractService<Demand> implements DemandService {
    @Resource
    private DemandMapper demandMapper;

    @Override
    public List<Demand> findByHid(Integer hid) {
        Example example = new Example(Demand.class);
        example.createCriteria().andLike("hid", hid.toString());
        return demandMapper.selectByExample(example);
    }

    @Override
    public List<Demand> findDemandsByPid(Integer pid) {
        Example example = new Example(Demand.class);
        example.createCriteria().andLike("pid", pid.toString());
        return demandMapper.selectByExample(example);
    }

    @Override
    public List<Demand> findByStatus(Integer status) {
        Example example = new Example(Demand.class);
        example.createCriteria().andLike("status", status.toString());
        return demandMapper.selectByExample(example);
    }
}

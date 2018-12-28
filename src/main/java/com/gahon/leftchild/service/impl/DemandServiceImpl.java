package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.dao.DemandMapper;
import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.service.DemandService;
import com.gahon.leftchild.core.AbstractService;
import com.gahon.leftchild.core.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author Gahon
 * @date 2018/12/28.
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class DemandServiceImpl extends AbstractService<Demand> implements DemandService {
    @Resource
    private DemandMapper demandMapper;

}

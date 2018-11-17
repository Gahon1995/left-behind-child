package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.dao.DemandMapper;
import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.service.DemandService;
import com.gahon.leftchild.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author Gahon
 * @date 2018/11/17.
 */
@Service
@Transactional
public class DemandServiceImpl extends AbstractService<Demand> implements DemandService {
    @Resource
    private DemandMapper demandMapper;

}

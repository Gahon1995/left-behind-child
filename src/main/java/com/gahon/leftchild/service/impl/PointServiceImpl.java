package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.core.AbstractService;
import com.gahon.leftchild.core.ServiceException;
import com.gahon.leftchild.dao.PointMapper;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.service.PointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author Gahon
 * @date 2018/11/17.
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class PointServiceImpl extends AbstractService<Point> implements PointService {
    @Resource
    private PointMapper pointMapper;

}

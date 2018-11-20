package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.core.AbstractService;
import com.gahon.leftchild.core.ServiceException;
import com.gahon.leftchild.dao.PointMapper;
import com.gahon.leftchild.service.PointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Gahon
 * @date 2018/11/17.
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class PointServiceImpl extends AbstractService<Point> implements PointService {
    @Resource
    private PointMapper pointMapper;

    @Override
    public List<Point> findPointsByCity(String city) {
        Example example = new Example(Point.class);
        example.createCriteria().andLike("city", city.toLowerCase() + "%");
        return pointMapper.selectByExample(example);
    }
}

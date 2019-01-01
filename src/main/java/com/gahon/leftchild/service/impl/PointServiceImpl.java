package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.core.AbstractService;
import com.gahon.leftchild.core.ServiceException;
import com.gahon.leftchild.dao.PointMapper;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.bean.FeaturesBean;
import com.gahon.leftchild.model.bean.GsonPoint;
import com.gahon.leftchild.service.PointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Point> findByProvince(String province) {
        Example example = new Example(Point.class);
        example.createCriteria().andLike("province", province.toLowerCase() + "%");
        return pointMapper.selectByExample(example);
    }

    @Override
    public List<Point> findPointsByUid(Integer uid) {
        Example example = new Example(Point.class);
        example.createCriteria().andLike("uid", uid.toString());
        return pointMapper.selectByExample(example);
    }

    @Override
    public GsonPoint getGsonPoint(List<Point> points) {
        GsonPoint gsonPoint = new GsonPoint();
        gsonPoint.setType("FeatureCollection");
        List<FeaturesBean> featuresBeans = new ArrayList<>();
        for (Point point : points) {
            featuresBeans.add(genFeature(point));
        }
        gsonPoint.setFeatures(featuresBeans);
        return gsonPoint;
    }

    public FeaturesBean genFeature(Point point) {
        FeaturesBean feature = new FeaturesBean();
        feature.setType("Point");
        feature.setGeometry(new FeaturesBean.GeometryBean("Point", Arrays.asList(point.getLat(), point.getLng())));
        feature.setProperties(point);
        return feature;
    }
}

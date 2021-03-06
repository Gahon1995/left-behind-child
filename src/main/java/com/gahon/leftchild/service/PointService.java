package com.gahon.leftchild.service;

import com.gahon.leftchild.core.Service;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.bean.GsonPoint;

import java.util.List;


/**
 * @author Gahon
 * @date 2018/11/17.
 */
public interface PointService extends Service<Point> {

    List<Point> findByProvince(String province);

    List<Point> findPointsByUid(Integer uid);

    GsonPoint getGsonPoint(List<Point> points);
}

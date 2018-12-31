package com.gahon.leftchild.service;

import com.gahon.leftchild.core.Service;
import com.gahon.leftchild.model.Demand;

import java.util.List;


/**
 * @author Gahon
 * @date 2018/12/28.
 */
public interface DemandService extends Service<Demand> {
    List<Demand> findDemandsByPid(Integer uid);
}

package com.gahon.leftchild.model.index;

import com.gahon.leftchild.model.Demand;
import com.gahon.leftchild.model.Point;
import com.gahon.leftchild.model.admin.AdminPoint;

import java.util.List;

public class PointDemands extends AdminPoint {
    public List<Demand> getDemands() {
        return demands;
    }

    @Override
    public String toString() {
        return "PointDemands{" +
                "demands=" + demands +
                '}';
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    private List<Demand> demands;

    public PointDemands() {
    }

    public PointDemands(String username, Point point, List<Demand> demands) {
        super(username, point);
        this.demands = demands;
    }

}

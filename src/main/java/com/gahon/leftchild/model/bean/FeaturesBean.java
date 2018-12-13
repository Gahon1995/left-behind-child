package com.gahon.leftchild.model.bean;

import com.gahon.leftchild.model.Point;

import java.util.List;

public class FeaturesBean {

    /**
     * type : Feature
     * geometry : {"type":"Point","coordinates":["105.924767","26.251054"]}
     * properties : {"id":"1","name":"小米","province":"贵州省","city":"安顺市","district":"西秀区","address":"中华北路与西水路交叉口路西","phone":"","google_map_id":"ChIJd57sOyAtxzYRrivDzjfGwxM","gaode_map_id":"B03550I6R8"}
     */

    private String type;
    private GeometryBean geometry;
    private Point properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeometryBean getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryBean geometry) {
        this.geometry = geometry;
    }

    public Point getProperties() {
        return properties;
    }

    public void setProperties(Point properties) {
        this.properties = properties;
    }

    public static class GeometryBean {
        /**
         * type : Point
         * coordinates : ["105.924767","26.251054"]
         */

        private String type;
        private List<String> coordinates;

        public GeometryBean(String type, List<String> coordinates) {
            this.type = type;
            this.coordinates = coordinates;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<String> coordinates) {
            this.coordinates = coordinates;
        }
    }

}

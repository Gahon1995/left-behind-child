package com.gahon.leftchild.model;

public class LatLng {

    /**
     * status : 0
     * result : {"location":{"lng":116.3084202915042,"lat":40.05703033345938},"precise":1,"confidence":80,"comprehension":100,"level":"道路"}
     */

    private int status;

    @Override
    public String toString() {
        return "LatLng{" +
                "status=" + status +
                ", result=" + result +
                '}';
    }

    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * location : {"lng":116.3084202915042,"lat":40.05703033345938}
         * precise : 1
         * confidence : 80
         * comprehension : 100
         * level : 道路
         */

        private LocationBean location;
        private int precise;
        private int confidence;
        private int comprehension;
        private String level;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public int getPrecise() {
            return precise;
        }

        public void setPrecise(int precise) {
            this.precise = precise;
        }

        public int getConfidence() {
            return confidence;
        }

        public void setConfidence(int confidence) {
            this.confidence = confidence;
        }

        public int getComprehension() {
            return comprehension;
        }

        public void setComprehension(int comprehension) {
            this.comprehension = comprehension;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "location=" + location +
                    ", precise=" + precise +
                    ", confidence=" + confidence +
                    ", comprehension=" + comprehension +
                    ", level='" + level + '\'' +
                    '}';
        }

        public static class LocationBean {
            @Override
            public String toString() {
                return "LocationBean{" +
                        "lng=" + lng +
                        ", lat=" + lat +
                        '}';
            }

            /**
             * lng : 116.3084202915042
             * lat : 40.05703033345938
             */

            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }
    }
}

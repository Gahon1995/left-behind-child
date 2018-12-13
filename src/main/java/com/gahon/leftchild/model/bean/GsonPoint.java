package com.gahon.leftchild.model.bean;

import java.util.List;

public class GsonPoint {
    /**
     * type : FeatureCollection
     * features : [{"type":"Feature","geometry":{"type":"Point","coordinates":["105.924767","26.251054"]},"properties":{"id":"1","name":"小米","province":"贵州省","city":"安顺市","district":"西秀区","address":"中华北路与西水路交叉口路西","phone":"","google_map_id":"ChIJd57sOyAtxzYRrivDzjfGwxM","gaode_map_id":"B03550I6R8"}},{"type":"Feature","geometry":{"type":"Point","coordinates":["114.334916","36.090769"]},"properties":{"id":"2","name":"小猫","province":"河南省","city":"安阳市","district":"龙安区","address":"文明大道西段85号","phone":"0372-3661777","google_map_id":"ChIJ_7MijgcI3DUR6nw4IdmvNyo","gaode_map_id":"B0174021QW"}},{"type":"Feature","geometry":{"type":"Point","coordinates":["117.377263","32.950353"]},"properties":{"id":"3","name":"小满","province":"安徽省","city":"蚌埠市","district":"龙子湖区","address":"蚌埠市龙子湖区交通路143号","phone":"+86 552 315 1111","google_map_id":"ChIJ89b5MHFFyTURZ2gzoGoCqyE","gaode_map_id":""}},{"type":"Feature","geometry":{"type":"Point","coordinates":["109.838867","40.653687"]},"properties":{"id":"4","name":"小美","province":"内蒙古自治区","city":"包头市","district":"昆都仑区","address":"阿尔丁大街神华蓝天商厦对面(市政府阿尔丁广场西南道6号)","phone":"0472-5988666;0472-5143311","google_map_id":"ChIJkX5vgR3uDzYRYre4gEBCpTE","gaode_map_id":"B01D8028NG"}},{"type":"Feature","geometry":{"type":"Point","coordinates":["109.838068","40.659398"]},"properties":{"id":"5","name":"小南","province":"内蒙古自治区","city":"包头市","district":"昆都仑区","address":"乌兰道7号小肥羊大厦往东50米","phone":"0472-5914999;4000120982","google_map_id":"ChIJvUJ-_ePxDzYRhqr7ZuU5zJg","gaode_map_id":"B01D801UP4"}},{"type":"Feature","geometry":{"type":"Point","coordinates":["109.855748","40.655514"]},"properties":{"id":"6","name":"小波","province":"内蒙古自治区","city":"包头市","district":"青山区","address":"钢铁大街36号(万达广场斜对面)","phone":"0472-6969098;0472-6969120","google_map_id":"ChIJNXPt1vjxDzYRAlpTE_yxaWg","gaode_map_id":"B01D801W6W"}},{"type":"Feature","geometry":{"type":"Point","coordinates":["109.870359","40.651305"]},"properties":{"id":"7","name":"小白","province":"内蒙古自治区","city":"包头市","district":"青山区","address":"少先路21号","phone":"0472-5999999;0472-5109199","google_map_id":"ChIJgf5pCQnyDzYRXOm_5przyNI","gaode_map_id":"B01D80P1XQ"}},{"type":"Feature","geometry":{"type":"Point","coordinates":["107.210141","34.367326"]},"properties":{"id":"8","name":"小鱼","province":"陕西省","city":"宝鸡市","district":"金台区","address":"宏文路48号","phone":"0917-3412538;0917-3131325;13571162120","google_map_id":"ChIJD9Xkr2XeYDYR4UwDazyjVEQ","gaode_map_id":"B03950PBWS"}}]
     */

    private String type;
    private List<FeaturesBean> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FeaturesBean> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeaturesBean> features) {
        this.features = features;
    }
}

package com.baidu.geolocation;

import com.baidu.location.BDLocation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultBuilder {

  BDLocation location;

  ResultBuilder(BDLocation location) {
    this.location = location;
  }

  public JSONArray build() {
    JSONObject result = new JSONObject();
    try {
      // 纬度
      result.put("latitude", location.getLatitude());
      // 精度
      result.put("longitude", location.getLongitude());
      // 方向
      result.put("direction", location.getDirection());
      // 速度
      result.put("speed", location.getSpeed());
      // 海拔高度
      result.put("altitude", location.getAltitude());
      // 定位类型
      result.put("locType", location.getLocType());
      // 对应的定位类型说明
      result.put("locTypeDesc", location.getLocTypeDescription());
      // 半径
      result.put("radius", location.getRadius());
      // 国家码
      result.put("countryCode", location.getCountryCode());
      // 国家名称
      result.put("country", location.getCountry());
      // 省份
      result.put("province", location.getProvince());
      // 城市编码
      result.put("cityCode", location.getCityCode());
      // 城市
      result.put("city", location.getCity());
      // 区
      result.put("district", location.getDistrict());
      // 街道
      result.put("street", location.getStreet());
      // 街道号码
      result.put("streetNumber", location.getStreetNumber());
      // 地址信息
      result.put("addr", location.getAddrStr());
      // 返回用户室内外判断结果
      result.put("userIndoorState", location.getUserIndoorState());
      // 获取位置语义化信息
      result.put("locationDescribe", location.getLocationDescribe());
      // 在网络定位结果的情况下，获取网络定位结果是通过基站定位得到的还是通过wifi定位得到的还是GPS得结果
      result.put("networkLocationType", location.getNetworkLocationType());
      // 运营商
      result.put("operators", location.getOperators());
      // gps定位结果时，获取gps锁定用的卫星数
      result.put("satelliteNumber", location.getSatelliteNumber());
      // server返回的当前定位时间
      result.put("timestamp", location.getTime());
    } catch (JSONException e) {
      e.printStackTrace();
    }
    JSONArray message = new JSONArray();
    message.put(result);
    return message;
  }

}

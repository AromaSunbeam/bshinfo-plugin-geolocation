package com.bshinfo.plugins.geolocation;

import android.util.Log;

import com.baidu.location.LocationClientOption;

import org.json.JSONException;
import org.json.JSONObject;

public class OptionBuilder {
  private static final String TAG = "PositionOptions";
  JSONObject options;

  OptionBuilder(JSONObject options) {
    this.options = options;
  }

  public LocationClientOption build() {
    LocationClientOption option = new LocationClientOption();
    try {
        Log.v(TAG, "-----locationMode----->:"+options.getString("locationMode"));
      // 设置定位模式
      switch(options.getInt("locationMode")){
        case 1:option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);break;
        case 2:option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);break;
        case 3:option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);break;
        default:option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
      }
        Log.v(TAG, "-----locationMode2----->:"+option.getLocationMode());
    } catch (JSONException e) {
      option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
      Log.v(TAG, "LocationMode-HighAccuracy 设置异常:"+e);
    }

    try {
      // 设置坐标类型
      option.setCoorType(options.getString("coorType"));
    } catch (JSONException e) {
      option.setCoorType(LocationService.COORD_BD09LL);
      Log.v(TAG, "坐标类型=CoorType 设置异常:"+e);
    }

    try {
     // 设置扫描间隔，单位是毫秒 当<1000(1s)时，定时定位无效
      option.setScanSpan(options.getInt("scanSpan"));
    } catch (JSONException e) {
      option.setScanSpan(3000);
      Log.v(TAG, "扫描间隔-ScanSpan 设置异常:"+e);
    }
    try {
      // 设置是否需要地址信息，默认为无地址
      option.setIsNeedAddress(options.getBoolean("isNeedAddress"));
    } catch (JSONException e) {
        option.setIsNeedAddress(true);
      Log.v(TAG, "地址信息-IsNeedAddress 设置异常:"+e);
    }
    try {
      // 设置是否需要返回位置语义化信息，可以在BDLocation.getLocationDescribe()中得到数据，ex:"在天安门附近"， 可以用作地址信息的补充
      option.setIsNeedLocationDescribe(options.getBoolean("isNeedLocationDescribe"));
    } catch (JSONException e) {
      option.setIsNeedLocationDescribe(true);
      Log.v(TAG, "位置语义化信息-IsNeedLocationDescribe 设置异常:"+e);
    }
    try {
      // 在网络定位时，是否需要设备方向 true:需要 ; false:不需要。
      option.setNeedDeviceDirect(options.getBoolean("needDeviceDirect"));
    } catch (JSONException e) {
      option.setNeedDeviceDirect(true);
      Log.v(TAG, "设备方向-NeedDeviceDirect 设置异常:"+e);
    }

    try {
      // 默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
      option.setLocationNotify(options.getBoolean("notify"));
    } catch (JSONException e) {
      Log.v(TAG, "设备方向-LocationNotify 设置异常:"+e);
    }

    try {
      // 设置是否退出定位进程 true:不退出进程； false:退出进程，默认为true
      option.setIgnoreKillProcess(options.getBoolean("ignoreKillProcess"));
    } catch (JSONException e) {
      option.setIgnoreKillProcess(true);
      Log.v(TAG, "是否退出定位进程-IgnoreKillProcess 设置异常:"+e);
    }

    try {
      // 设置是否需要返回位置POI信息，可以在BDLocation.getPoiList()中得到数据
      option.setIsNeedLocationPoiList(options.getBoolean("isNeedLocationPoiList"));
    } catch (JSONException e) {
      option.setIsNeedLocationPoiList(true);
      Log.v(TAG, "是否需要返回位置POI信息-IsNeedLocationPoiList 设置异常:"+e);
    }

    try {
      // 设置是否进行异常捕捉 true:不捕捉异常；false:捕捉异常，默认为false
      option.SetIgnoreCacheException(options.getBoolean("ignoreCacheException"));
    } catch (JSONException e) {
      option.SetIgnoreCacheException(true);
      Log.v(TAG, "是否进行异常捕捉-IgnoreCacheException 设置异常:"+e);
    }

    try {
      // 设置是否需要返回海拔高度信息，可以在BDLocation.getAltitude()中得到数据，GPS定位结果中默认返回，默认值Double.MIN_VALUE
      option.setIsNeedAltitude(options.getBoolean("isNeedAltitude"));
    } catch (JSONException e) {
      option.setIsNeedAltitude(true);
      Log.v(TAG, "是否需要返回海拔高度信息-IsNeedAltitude 设置异常:"+e);
    }

    try {
      // 设置超时时间
      option.setTimeOut(options.getInt("timeOut"));
    } catch (JSONException e) {
      option.setTimeOut(27000);
      Log.v(TAG, "超时时间-TimeOut 设置异常:"+e);
    }
    return option;
  }

}

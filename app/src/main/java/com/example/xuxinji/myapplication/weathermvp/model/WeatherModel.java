package com.example.xuxinji.myapplication.weathermvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class WeatherModel {
    @SerializedName("errNum")
    private int errNum;

    @SerializedName("errMsg")
    private String errMsg;

    @SerializedName("retData")
    private RetDataBean retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public RetDataBean getRetData() {
        return retData;
    }

    public void setRetData(RetDataBean retData) {
        this.retData = retData;
    }

    public static class RetDataBean {
        /**
         * city : 北京
         * pinyin : beijing
         * citycode : 101010100
         * date : 15-02-11
         * time : 11:00
         * postCode : 100000
         * longitude : 116.391
         * latitude : 39.904
         * altitude : 33
         * weather : 晴
         * temp : 10
         * l_tmp : -4
         * h_tmp : 10
         * WD : 无持续风向
         * WS : 微风(<10m/h)
         * sunrise : 07:12
         * sunset : 17:44
         */
        @SerializedName("city")
        private String city;

        @SerializedName("pinyin")
        private String pinyin;

        @SerializedName("citycode")
        private String citycode;

        @SerializedName("date")
        private String date;

        @SerializedName("time")
        private String time;

        @SerializedName("postCode")
        private String postCode;

        @SerializedName("longitude")
        private double longitude;

        @SerializedName("latitude")
        private double latitude;

        @SerializedName("altitude")
        private String altitude;

        @SerializedName("weather")
        private String weather;

        @SerializedName("temp")
        private String temp;

        @SerializedName("l_tmp")
        private String l_tmp;

        @SerializedName("h_tmp")
        private String h_tmp;

        @SerializedName("WD")
        private String WD;

        @SerializedName("WS")
        private String WS;

        @SerializedName("sunrise")
        private String sunrise;

        @SerializedName("sunset")
        private String sunset;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getCitycode() {
            return citycode;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getAltitude() {
            return altitude;
        }

        public void setAltitude(String altitude) {
            this.altitude = altitude;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getL_tmp() {
            return l_tmp;
        }

        public void setL_tmp(String l_tmp) {
            this.l_tmp = l_tmp;
        }

        public String getH_tmp() {
            return h_tmp;
        }

        public void setH_tmp(String h_tmp) {
            this.h_tmp = h_tmp;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }
    }
}

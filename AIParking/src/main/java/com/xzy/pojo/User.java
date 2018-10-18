package com.xzy.pojo;



/**
 * Created by ♕ Prince on 2018/8/17.
 */
public class User
{
    String openId;
    String carId;
    String userNamee;
    String sex;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserNamee() {
        return userNamee;
    }

    public void setUserNamee(String userNamee) {
        this.userNamee = userNamee;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "openId='" + openId + '\'' +
                ", carId='" + carId + '\'' +
                ", userNamee='" + userNamee + '\'' +
                ", sex=" + sex +
                '}';
    }
}

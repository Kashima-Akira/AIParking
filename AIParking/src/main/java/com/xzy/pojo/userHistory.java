package com.xzy.pojo;

import java.util.Date;

/**
 * Created by ♕ Prince on 2018/8/17.
 */
public class userHistory
{
    Integer id;
    String userId;
    Date startTime;
    String endTime;
    String  totalTime;
    String price;
    Integer mapId;
    int payStatus;
    mapping mapName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public mapping getMapName() {
        return mapName;
    }

    public void setMapName(mapping mapName) {
        this.mapName = mapName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String toString() {
        return "userHistory{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", startTime=" + startTime +
                ", endTime='" + endTime + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", price='" + price + '\'' +
                ", mapId=" + mapId +
                ", payStatus=" + payStatus +
                ", mapName=" + mapName +
                '}';
    }
}

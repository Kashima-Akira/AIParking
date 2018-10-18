package com.xzy.pojo;

/**
 * Created by ♕ Prince on 2018/8/5.
 */
public class mapping
{
    private int id;
    private String longitude;
    private String latitude;
    private String name;
    private int status;
    private String descript;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public String toString() {
        return "mapping{" +
                "id=" + id +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", descript='" + descript + '\'' +
                '}';
    }
}

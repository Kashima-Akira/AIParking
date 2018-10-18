package com.xzy.pojo;

/**
 * Created by ♕ Prince on 2018/8/5.
 */
public class parking
{
    private int id;
    private String name;
    private String carNumber;
    private String carID;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "parking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carID='" + carID + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

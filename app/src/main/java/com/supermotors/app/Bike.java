package com.supermotors.app;

import java.io.Serializable;

public class Bike implements Serializable {
    private String name;
    private String type;
    private String year;
    private String displacement;
    private String power;
    private String topSpeed;
    private String weight;
    private String description;
    private int imageResId;
    private String mainImageUrl;
    private String webUrl;
    private int[] photos;
    private String[] photoUrls;
    private String torque;
    private String engine;
    private String tankCapacity;
    private String seatHeight;
    private String brakes;

    public Bike(String name, String type, String year, String displacement, String power, String topSpeed, String weight, String description, int imageResId, String mainImageUrl, String webUrl, int[] photos, String[] photoUrls, String torque, String engine, String tankCapacity, String seatHeight, String brakes) {
        this.name = name;
        this.type = type;
        this.year = year;
        this.displacement = displacement;
        this.power = power;
        this.topSpeed = topSpeed;
        this.weight = weight;
        this.description = description;
        this.imageResId = imageResId;
        this.mainImageUrl = mainImageUrl;
        this.webUrl = webUrl;
        this.photos = photos;
        this.photoUrls = photoUrls;
        this.torque = torque;
        this.engine = engine;
        this.tankCapacity = tankCapacity;
        this.seatHeight = seatHeight;
        this.brakes = brakes;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getYear() { return year; }
    public String getDisplacement() { return displacement; }
    public String getPower() { return power; }
    public String getTopSpeed() { return topSpeed; }
    public String getWeight() { return weight; }
    public String getDescription() { return description; }
    public int getImageResId() { return imageResId; }
    public String getMainImageUrl() { return mainImageUrl; }
    public String getWebUrl() { return webUrl; }
    public int[] getPhotos() { return photos; }
    public String[] getPhotoUrls() { return photoUrls; }
    public String getTorque() { return torque; }
    public String getEngine() { return engine; }
    public String getTankCapacity() { return tankCapacity; }
    public String getSeatHeight() { return seatHeight; }
    public String getBrakes() { return brakes; }
}

package Bean_class;

import java.util.Date;

import static bean_utils.Date.StrTransSqlDate;

public class Dog {
    private String dogName;
    private String picture;
    private String user_Name;
    private String dogcategory;
    private String dogbirthday;
    private String dogweight;
    private String dogsex;

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getDogcategory() {
        return dogcategory;
    }

    public void setDogcategory(String dogcategory) {
        this.dogcategory = dogcategory;
    }

    public Date getDogbirthday() {
        return StrTransSqlDate(dogbirthday);
    }

    public void setDogbirthday(String dogbirthday) {
        this.dogbirthday = dogbirthday;
    }

    public String getDogweight() {
        return dogweight;
    }

    public void setDogweight(String dogweight) {
        this.dogweight = dogweight;
    }

    public String getDogsex() {
        return dogsex;
    }

    public void setDogsex(String dogsex) {
        this.dogsex = dogsex;
    }

}

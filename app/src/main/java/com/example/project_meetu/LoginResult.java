package com.example.project_meetu;

import com.google.gson.annotations.SerializedName;

public class LoginResult {

    /**
     *             fb1:result.fb1,
     *             fb2:result.fb2,
     *             food:result.food,
     *             lang:result.lang,
     *             hobby:result.hobby,
     *             intro:result.intro,
     *             contact:result.contact,
     *             student_id:result.student_id
     */
    private String name;
    private String age;
    private String major;
    private String place;
    private String fb1;
    private String fb2;
    private String food;
    private String lang;
    private String hobby;
    private String intro;
    private String contact;
    private String student_id;

    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }
    public String getPlace() {
        return age;
    }
    public String getMajor() {
        return major;
    }
    public String getFb1() {
        return fb1;
    }
    public String getFb2() {
        return fb2;
    }
    public String getFood() {
        return food;
    }
    public String getLang() {
        return lang;
    }
    public String getHobby() {
        return hobby;
    }
    public String getIntro() {
        return intro;
    }
    public String getContact() {
        return contact;
    }
    public String getID() {
        return intro;
    }
}
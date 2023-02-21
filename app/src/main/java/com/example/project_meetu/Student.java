package com.example.project_meetu;

import android.app.Application;

public class Student extends Application {

    String student_name; //Student name
    String[] profile_info;
    /**
     * Profile information have following 8 informations:
     * College Years
     * Majors
     * Favorite Space(1)
     * Favorite Space(2)
     * Where You lives Near From
     * Language Preference
     * Favorite Food
     * Hobby
     */
    String contact_info; //Contact information
    String introduction; //introduction information
    String student_id; //Wisconsin ID for students
    public static Student instance = new Student(); //instance for user

    private int priority;

    /**
     * Instance method used for making user owned instance for app user
     * @return student instance storing user information
     */
    public static Student getInstance(){
        return instance;
    }

    /**
     * OnCreate method helps for making instance for user
     *
     */
    public void onCreate(){
        super.onCreate();
        instance = this;
    }

    /**
     * Following information is default options for testing, or user annonymous debug
     * Error check with default option
     */
    public Student() {
        student_name = "Anonymous";
        profile_info = new String[8];
        contact_info = "No information provided";
        introduction = "No information provided";
        student_id = "None";
        priority = 0;

    }

    /**
     * used for user using application
     *
     * @param student_name // user name
     * @param profile_info // profile information
     * @param contact_info // contact information
     * @param introduction // introduction information
     * @param student_id // Wisconsin Student ID
     */
    public Student(String student_name, String[] profile_info, String contact_info, String introduction,
                   String student_id) {
        this.student_name = student_name;
        this.profile_info = profile_info;
        this.contact_info = contact_info;
        this.introduction = introduction;
        this.student_id = student_id;
        priority = 0;

    }

    /**
     * Following is get set method for each following
     * user profile information
     * @param name
     */
    public void setName(String name) {
        this.student_name = name;
    }

    public void setProfile(String[] profile) {
        this.profile_info = profile;
    }

    public void setContact(String contact) {
        this.contact_info = contact;
    }

    public void setIntro(String intro) {
        this.introduction = intro;
    }

    public void setId(String id) {
        this.student_id = id;
    }

    public String getName() {
        return this.student_name;
    }

    public String[] getProfile() {
        return this.profile_info;
    }

    public String getContact() {
        return this.contact_info;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public String getId() {
        return this.student_id;
    }

    /**
     * Use for pending algorithm *it will be
     * fixed for updated alogrithm
     * @return
     */
    public int getPriority() {
        return priority;
    }

    public void setPriority(int newPriority) {
        priority = newPriority;
    }

    public int compare(Student s) {
        if (this.priority == s.priority) {
            return 0;
        } else if (s.priority > s.priority) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass())
            return false;

        Student other_Student = (Student) other;
        return this.student_id == other_Student.getId();
    }

    @Override
    public String toString() {
        return student_name + profile_info[0];
    }

}
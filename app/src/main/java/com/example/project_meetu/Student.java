package com.example.project_meetu;

import android.app.Application;

public class Student extends Application {
    String student_name;
    String[] profile_info;
    String contact_info;
    String introduction;
    String student_id;
    public static Student instance = new Student();

    private int priority;

    public static Student getInstance(){
        return instance;
    }


    public void onCreate(){
        super.onCreate();
        instance = this;
    }

    public Student() {
        student_name = "Anonymous";
        profile_info = new String[8];
        contact_info = "No information provided";
        introduction = "No information provided";
        student_id = "None";
        priority = 0;

    }

    public Student(String student_name, String[] profile_info, String contact_info, String introduction,
                   String student_id) {
        this.student_name = student_name;
        this.profile_info = profile_info;
        this.contact_info = contact_info;
        this.introduction = introduction;
        this.student_id = student_id;
        priority = 0;

    }

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
package com.example.recovis.model;

import java.sql.Date;

public class Patient {
    private String patient_id;
    private String first_name;
    private String second_name;
    private String tel;
    private String email;
    private Date last_transplant_date;
    private String transplant_type;
    private int transplants_num;
    private String kidney_failure_cause;
    private String username;
    private String userpassword;

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Date getLast_transplant_date() {
        return last_transplant_date;
    }

    public void setLast_transplant_date(Date last_transplant_date) {
        this.last_transplant_date = last_transplant_date;
    }

    public String getTransplant_type() {
        return transplant_type;
    }

    public void setTransplant_type(String transplant_type) {
        this.transplant_type = transplant_type;
    }

    public int getTransplants_num() {
        return transplants_num;
    }

    public void setTransplants_num(int transplants_num) {
        this.transplants_num = transplants_num;
    }

    public String getKidney_failure_cause() {
        return kidney_failure_cause;
    }

    public void setKidney_failure_cause(String kidney_failure_cause) {
        this.kidney_failure_cause = kidney_failure_cause;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id='" + patient_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", last_transplant_date=" + last_transplant_date +
                ", transplant_type='" + transplant_type + '\'' +
                ", transplants_num=" + transplants_num +
                ", kidney_failure_cause='" + kidney_failure_cause + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}

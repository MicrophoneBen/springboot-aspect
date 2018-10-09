package com.ghostben.entity;

import com.ghostben.view.viewutil.RatingStars;
import com.vaadin.server.ThemeResource;

public class Company {
    private int serialNo;
    private String name;
    private RatingStars rtstars;
    private ThemeResource rsrc;

    public Company() {
    }

    public Company(int serialNo, String name, RatingStars rtstars) {
        this.serialNo = serialNo;
        this.name = name;
        this.rtstars = rtstars;
    }

    public Company(int serialNo, String name, RatingStars rtstars, ThemeResource rsrc) {
        this.serialNo = serialNo;
        this.name = name;
        this.rtstars = rtstars;
        this.rsrc = rsrc;
    }

    public Company(int serialNo, String name) {
        this.serialNo = serialNo;
        this.name = name;
    }

    public ThemeResource getRsrc() {
        return rsrc;
    }

    public void setRsrc(ThemeResource rsrc) {
        this.rsrc = rsrc;
    }

    public RatingStars getRtstars() {
        return rtstars;
    }

    public void setRtstars(RatingStars rtstars) {
        this.rtstars = rtstars;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

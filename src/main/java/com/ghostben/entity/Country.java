package com.ghostben.entity;

/**
 * author    : ben.zhang.b.q
 * date      : 2018/9/18 16:51
 * package   : com.ghostben.entity
 * description : 国家实体类
 **/
public class Country {

    private String name;
    private String country;
    private String network;

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", network='" + network + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Country(String name, String country, String network) {
        this.name = name;
        this.country = country;
        this.network = network;
    }
}

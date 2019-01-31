package com.tiza.plugin.model;

import lombok.Data;

/**
 * Description: Position
 * Author: DIYILIU
 * Update: 2018-12-19 10:45
 */

@Data
public class Position {
    private String id;
    private long time;

    private String gpsDate;

    private double lng;
    private double lat;

    private double enLng;
    private double enLat;

    private String address;
    private String province;
    private String city;
    private String area;

    private String proCode;
    private String cityCode;
    private String areaCode;
}

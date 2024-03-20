package com.study.redistest;

import lombok.Builder;
import lombok.Getter;

import java.awt.*;

@Getter
public class GeoDTO {
    private String key;
    private String member1;
    private double m1_x;
    private double m1_y;
//    private Point m1_point1;

    private String member2;
    private double m2_x;
    private double m2_y;
//    private Point m2_point1;


    @Builder

    public GeoDTO(String key, String member1, double m1_x, double m1_y, String member2, double m2_x, double m2_y) {
        this.key = key;
        this.member1 = member1;
        this.m1_x = m1_x;
        this.m1_y = m1_y;
        this.member2 = member2;
        this.m2_x = m2_x;
        this.m2_y = m2_y;
    }
}

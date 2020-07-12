package com.igeekhome.ccsv2.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.SplittableRandom;
@Setter
@Getter
public class Notice {
    private String title;
    private String content;
    private int creatorId;
    private Date createTime;

}

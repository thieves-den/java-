package com.igeekhome.ccsv2.entity;

import lombok.Data;

@Data
public class CommonWord {
    private String content;
    private boolean isPersonal;
    private String type;
    private int creatorId;
}

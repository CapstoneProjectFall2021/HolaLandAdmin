package com.holaland.holalandadmin.entity.food;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class FoodReport {

    private int foodReportId;
    private int userId;
    private int foodStoreOnlineId;
    private int foodOrderId;
    private String foodReportContent;
    private Timestamp foodReportCreateDate;
    private Timestamp foodReportUpdateDate;
    private boolean foodReportDeleted;
}

package com.holaland.holalandadmin.entity.food;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FoodStoreOnline {

    private int foodStoreOnlineId;
    private int userId;
    private int sttFoodCode;
    private String foodStoreOnlineImage;
    private String foodStoreOnlineName;
    private double foodStoreOnlineRate;
    private int foodStoreOnlineMinPrice;
    private int foodStoreOnlineMaxPrice;
    private String foodStoreOnlineDescription;
    private int foodStoreOnlineCountFoodItem;
    private int foodStoreOnlineCountRate;
    private int foodStoreOnlineCountReport;
    private boolean foodStoreOnlinePauseSellingFlag;
    private boolean foodStoreOnlineStopSellingFlag;
    private boolean foodStoreOnlineDeleted;
}

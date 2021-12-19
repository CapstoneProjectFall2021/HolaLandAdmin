package com.holaland.holalandadmin.view;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class CountAllDashboard {
    private int countUserAcc;
    private int countStudentAcc;
    private int countRecruitmentAcc;
    private int countSellerAcc;
    private int countPostRecruitment;
    private int countPostFindJob;
    private int countStore;
    private int countOrder;
    private int totalPrice;
    private int sumSoldItems;

}

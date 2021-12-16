package com.holaland.holalandadmin.entity.work;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkRequestFindJob {

    private int workRequestFindJobId;
    private int userId;
    private int workRequestTypeId;
    private int workTimeId;
    private int sttWorkCode;
    private int workPaymentMethodId;
    private int workSalaryUnitId;
    private String workRequestFindJobTitle;
    private Date workRequestFindJobStartDateTime;
    private Date workRequestFindJobEndDateTime;
    private Date workRequestFindJobLastUpdateDateTime;
    private String workRequestFindJobDescription;
    private String workRequestFindJobPersonalExperience;
    private String workRequestFindJobExpectedLocation;
    private int workRequestFindJobExpectedSalary;
    private String workRequestFindJobNote;
    private boolean workRequestFindJobDeleted;
}

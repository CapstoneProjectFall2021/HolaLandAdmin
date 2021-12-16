package com.holaland.holalandadmin.entity.work;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkRequestType {

    private int workRequestTypeId;
    private String workRequestTypeIcon;
    private String workRequestTypeName;
    private int workRequestTypeCountRequestRecruitment;
    private int workRequestTypeCountRequestFindJob;
    private boolean workRequestTypeDeleted;
}

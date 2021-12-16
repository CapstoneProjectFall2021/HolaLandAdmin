package com.holaland.holalandadmin.entity.work;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkTime {

    private int workTimeId;
    private String workTimeName;
    private boolean workTimeDeleted;
}

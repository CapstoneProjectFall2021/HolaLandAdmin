package com.holaland.holalandadmin.entity.fptu;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClubType {

    private int fptuClubTypeId;
    private String fptuClubTypeIcon;
    private String fptuClubTypeName;
    private int fptuClubTypeCount;
    private boolean fptuClubTypeDeleted;
}

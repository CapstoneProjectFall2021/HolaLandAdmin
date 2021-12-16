package com.holaland.holalandadmin.entity.work;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SttWork {

    private int sttWorkId;
    private String sttWorkName;
    private int sttWorkCode;
    private String sttWorkValue;
    private String sttWorkIcon;
}

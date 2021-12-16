package com.holaland.holalandadmin.entity.work;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkPaymentMethod {

    private int workPaymentMethodId;
    private String workPaymentMethodName;
    private boolean workPaymentMethodDeleted;
}

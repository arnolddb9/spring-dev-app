package com.pfcti.spring.dev.app.dto;

import lombok.Data;

@Data
public class NotificationDto {
    private String phoneNumber;
    private String mailBody;
}

package com.demo.dataexchangeapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationDto {
    private ResultDto resultDto;
    private String email;
}

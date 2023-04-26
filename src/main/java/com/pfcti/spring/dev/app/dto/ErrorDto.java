package com.pfcti.spring.dev.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private Integer status;
    private int codigo;
    private String message;
    public ErrorDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}

package com.gear.proex.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}

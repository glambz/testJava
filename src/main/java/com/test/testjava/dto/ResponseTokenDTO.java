package com.test.testjava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseTokenDTO {
    private boolean status;
    private String message;
    private String access_Token;

    public ResponseTokenDTO(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}

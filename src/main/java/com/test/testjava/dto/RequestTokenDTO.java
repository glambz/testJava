package com.test.testjava.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RequestTokenDTO {
    private String username;

    private String password;

    private String subject;

    private String secretKey;

    private String audience;
}

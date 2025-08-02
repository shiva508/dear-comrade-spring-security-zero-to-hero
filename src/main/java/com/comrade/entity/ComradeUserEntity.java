package com.comrade.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ComradeUserEntity implements Serializable {
    private Long userId;
    private String username;
    private String password;
    private String authority;
}

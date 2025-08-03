package com.comrade.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
//@Entity
//@Table(name = "DC_USER")
@AllArgsConstructor
@NoArgsConstructor
public class ComradeUserEntity implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "USER_ID")
    private Long userId;

//    @Column(name = "USER_NAME")
    private String username;

//    @Column(name = "PASSWORD")
    private String password;

//    @Column(name = "ENABLED")
    private boolean enabled;
}

package com.comrade.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "DC_AUTHORITY")
public class ComradeAuthority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorityId;
    private String authorityName;
    private String authorityDescription;
}

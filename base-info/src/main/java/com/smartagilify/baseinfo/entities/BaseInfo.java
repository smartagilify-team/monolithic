package com.smartagilify.baseinfo.entities;

import com.smartagilify.core.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BI$T_BASE_INFO", schema = "PUBLIC")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class BaseInfo extends BaseEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "code")
    private String code;
    @Column(name = "icon")
    private String icon;
}

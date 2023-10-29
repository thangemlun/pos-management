package com.thienday.posmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manufacture",schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manufacture extends BaseEntity {
    private String name;

}
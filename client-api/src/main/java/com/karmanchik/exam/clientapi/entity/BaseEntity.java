package com.karmanchik.exam.clientapi.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "next_val")
    private Integer id;
}

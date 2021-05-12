package com.karmanchik.exam.clientapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT")
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ISACTIVE")
    private Boolean isActive;

    @Column(name = "COST")
    private Double cost;

    @Column(name = "MAINIMAGEPATH")
    private String mainImagePath;

    @ManyToOne
    @JoinColumn(name = "MANUFACTURERID")
    private Manufacturer manufacturer;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", cost=" + cost +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

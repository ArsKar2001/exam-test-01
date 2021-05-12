package com.karmanchik.exam.clientapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "MANUFACTURER")
@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Manufacturer extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @Column(name = "STARTDATE")
    private LocalDate startDate;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;

    public Manufacturer() {
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}

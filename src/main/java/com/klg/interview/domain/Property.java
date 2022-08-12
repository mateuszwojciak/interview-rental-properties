package com.klg.interview.domain;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PROPERTIES")
@NoArgsConstructor
@Setter
public class Property {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer rentArea;
    private String description;

    public Property(Long id, String name, BigDecimal price, Integer rentArea, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rentArea = rentArea;
        this.description = description;
    }

    @Id
    @NotNull
    @Column(name = "ID_PROPERTY", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "RENT_AREA")
    public Integer getRentArea() {
        return rentArea;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
}

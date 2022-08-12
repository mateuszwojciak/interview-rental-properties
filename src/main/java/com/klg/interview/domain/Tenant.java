package com.klg.interview.domain;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TENANTS")
@NoArgsConstructor
@Setter
public class Tenant {
    private Long id;
    private String name;

    public Tenant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @NotNull
    @Column(name = "ID_TENANT", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "NAME", unique = true)
    public String getName() {
        return name;
    }
}

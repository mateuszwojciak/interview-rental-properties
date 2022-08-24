package com.klg.interview.domain;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVATIONS")
@NoArgsConstructor
@Setter
public class Reservation {
    private Long id;
    private Tenant tenant;
    private Long id_tenant;
    private Landlord landlord;
    private Long id_landlord;
    private Property property;
    private Long id_property;
    private LocalDate rentalPeriodStart;
    private LocalDate rentalPeriodEnd;
    private BigDecimal price;

    public Reservation(Long id, Long id_tenant, Long id_landlord, Long id_property, LocalDate rentalPeriodStart, LocalDate rentalPeriodEnd, BigDecimal price) {
        this.id = id;
        this.id_tenant = id_tenant;
        this.id_landlord = id_landlord;
        this.id_property = id_property;
        this.rentalPeriodStart = rentalPeriodStart;
        this.rentalPeriodEnd = rentalPeriodEnd;
        this.price = price;
    }

    @Id
    @NotNull
    @Column(name = "ID_RESERVATION", unique= true)
    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TENANT")
    public Tenant getTenant() {
        return tenant;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_LANDLORD")
    public Landlord getLandlord() {
        return landlord;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PROPERTY")
    public Property getProperty() {
        return property;
    }

    @Transient
    public Long getId_tenant() {
        return id_tenant;
    }

    @Transient
    public Long getId_landlord() {
        return id_landlord;
    }

    @Transient
    public Long getId_property() {
        return id_property;
    }

    @NotNull
    @Column(name = "RENTAL_PERIOD_START")
    public LocalDate getRentalPeriodStart() {
        return rentalPeriodStart;
    }

    @NotNull
    @Column(name = "RENTAL_PERIOD_END")
    public LocalDate getRentalPeriodEnd() {
        return rentalPeriodEnd;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }
}

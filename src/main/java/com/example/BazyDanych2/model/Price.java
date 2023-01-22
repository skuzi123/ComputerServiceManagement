package com.example.BazyDanych2.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Price")
public class Price extends IdEntity{
    @ManyToOne
    @JoinColumn(name = "fault_id",
                referencedColumnName = "id")
    private Fault fault;

    @ManyToOne
    @JoinColumn(name = "tax_id",
                referencedColumnName = "id")
    private Tax tax;
    @Column(name = "price",
            nullable = false,
            precision = 2,
            scale = 6)
    private double price;

}

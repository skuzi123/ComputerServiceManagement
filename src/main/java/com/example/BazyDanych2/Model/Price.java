package com.example.BazyDanych2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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




//    @Column(name = "fault_id",
//            nullable = false)
//    private int faultId;
//    @Column(name = "tax_id",
//            nullable = false)
//    private int taxId;
}

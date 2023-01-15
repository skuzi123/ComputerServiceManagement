package com.example.BazyDanych2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Tax")
public class Tax extends IdEntity{
    @Column(name = "shop_tax",
            nullable = false,
            length = 3,
            precision = 2,
            scale = 3)
    private double shopTax;
    @Column(name = "Country_tax",
            nullable = false,
            length = 3,
            precision = 2,
            scale = 3)
    private double countryTax;
    @JsonIgnore
    @OneToMany(mappedBy = "tax",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Price> prices = new ArrayList<>();
}

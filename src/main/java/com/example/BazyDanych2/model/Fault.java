package com.example.BazyDanych2.model;

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
@Table(name = "Fault")
public class Fault extends IdEntity{
    @Column(name = "cause",
            nullable = false,
            length = 50)
    private String cause;
    @JsonIgnore
    @OneToMany(mappedBy = "fault",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Repair> repairs = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "fault",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Price> prices = new ArrayList<>();
}

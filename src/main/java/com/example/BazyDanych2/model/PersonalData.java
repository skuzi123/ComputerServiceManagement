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
@Table(name = "Personal_data")
public class PersonalData extends IdEntity {

    @Column(name = "name",
            nullable = false,
            length = 30)
    private String name;
    @Column(name = "surname",
            nullable = false,
            length = 30)
    private String surname;
    @Column(name = "telephone_number",
            nullable = false,
            columnDefinition = "VARCHAR(9)"
            )
    private String telephoneNumber;
    @Column(name = "adres",
            nullable = false,
            length = 60)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "personalData",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();



}

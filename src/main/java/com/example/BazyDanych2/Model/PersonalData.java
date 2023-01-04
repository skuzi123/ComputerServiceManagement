package com.example.BazyDanych2.Model;

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
            nullable = false
            )
    private int telephoneNumber;
    @Column(name = "adres",
            nullable = false,
            length = 60)
    private String address;

    @OneToMany(mappedBy = "personalData",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "personalData",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Worker> workers = new ArrayList<>();


}

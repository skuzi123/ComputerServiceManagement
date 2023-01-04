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
@Table(name = "Client")
public class Client extends IdEntity{
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "personal_id",
                referencedColumnName = "id")
    private PersonalData personalData;

    @Column(name = "email",
            nullable = false,
            length = 30)
    private String email;

    @OneToMany(mappedBy = "client",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Computer> computers = new ArrayList<>();

    @OneToMany(mappedBy = "client",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Log> logs = new ArrayList<>();

    //    @Column(name = "personal_id",
//            nullable = false)
//    private int personalId;

}

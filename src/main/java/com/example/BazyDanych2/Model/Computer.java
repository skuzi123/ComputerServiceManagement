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
@Table(name = "Computer")
public class Computer extends IdEntity{
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id",
                referencedColumnName = "id")
    private User user;


    @OneToMany(mappedBy = "computer",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<ComputerParts> computerParts = new ArrayList<>();
    @OneToMany(mappedBy = "computer",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Repair> repairs = new ArrayList<>();

    //  @Column(name = "client_id",
//            nullable = false)
//    private int clientId;



}

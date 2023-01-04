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
@Table(name = "Worker")
public class Worker extends IdEntity{

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "personal_id",
                referencedColumnName = "id")
    private PersonalData personalData;
    @Column(name = "workname",
            nullable = false,
            length = 20)
    private String workName;



    @OneToMany(mappedBy = "worker",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Repair> repairs = new ArrayList<>();


//    @Column(name = "personal_id",
//            nullable = false)
//    private int personalId;


}

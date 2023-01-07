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
@Table(name = "User")
public class User extends IdEntity{
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "personal_id",
            referencedColumnName = "id")
    private PersonalData personalData;
    @Column(name = "workname",
            nullable = false,
            length = 20)
    private String workName;

    @Column(name = "password",
            nullable = false,
            length = 20)
    private String password;

    @Column(name = "role",
            nullable = false)
    private Role role;
    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Repair> repairs = new ArrayList<>();
}

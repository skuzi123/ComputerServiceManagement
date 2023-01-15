package com.example.BazyDanych2.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


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
    @ManyToOne
    @JoinColumn(name = "user_id",
                referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "computer",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ComputerParts> computerParts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "computer",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Repair> repairs = new ArrayList<>();

}

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
@Table(name = "Part")
public class Part extends IdEntity{
    @Column(name = "part_name",
            nullable = false,
            length = 60)
    private String partName;

    @JsonIgnore
    @OneToMany(mappedBy = "part",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<ComputerParts> computerParts = new ArrayList<>();

}

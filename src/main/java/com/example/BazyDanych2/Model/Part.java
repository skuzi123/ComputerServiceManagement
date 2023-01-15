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
@Table(name = "Part")
public class Part extends IdEntity{
    @Column(name = "part_name",
            nullable = false,
            length = 60)
    private String partName;

    @OneToMany(mappedBy = "part",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ComputerParts> computerParts = new ArrayList<>();

}

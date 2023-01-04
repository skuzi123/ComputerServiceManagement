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
@Table(name = "Repair_location")
public class RepairLocation extends IdEntity{
    @Column(name = "location_name",
            nullable = false,
            length = 30)
    private String locationName;

    @OneToMany(mappedBy = "repairLocation",
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Repair> repairs = new ArrayList<>();


}

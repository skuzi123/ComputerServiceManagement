package com.example.BazyDanych2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Repair")
public class Repair extends IdEntity{

    @ManyToOne
    @JoinColumn(name = "computer_id",
                referencedColumnName = "id" )
    @JsonIgnore
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "location_id",
                referencedColumnName = "id" )
    @JsonIgnore
    private RepairLocation repairLocation;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id",
                referencedColumnName = "id" )
    private User user;

    @ManyToOne
    @JoinColumn(name = "fault_id",
                referencedColumnName = "id" )
    @JsonIgnore
    private Fault fault;

    @Column(name = "back_up",
            nullable = false,
            length = 3)
    private String backup;





}

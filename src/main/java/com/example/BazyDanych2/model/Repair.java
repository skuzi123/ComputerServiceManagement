package com.example.BazyDanych2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "location_id",
                referencedColumnName = "id" )
    private RepairLocation repairLocation;

    @ManyToOne
    @JoinColumn(name = "user_id",
                referencedColumnName = "id" )
    private User user;

    @ManyToOne
    @JoinColumn(name = "fault_id",
                referencedColumnName = "id" )
    private Fault fault;
    @Column(name = "repair_start",
            nullable = false)
    private LocalDate repairStart;
    @Column(name = "repair_end")
    private LocalDate repairEnd;

    @Column(name = "repair_state",
              nullable = false)
    @Enumerated(EnumType.STRING)
    private RepairState repairState;
    @Column(name = "back_up",
            nullable = false,
            length = 3)
    private String backup;





}

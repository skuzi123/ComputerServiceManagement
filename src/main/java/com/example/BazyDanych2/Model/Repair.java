package com.example.BazyDanych2.Model;

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
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "location_id",
                referencedColumnName = "id" )
    private RepairLocation repairLocation;

    @ManyToOne
    @JoinColumn(name = "worker_id",
                referencedColumnName = "id" )
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "fault_id",
                referencedColumnName = "id" )
    private Fault fault;
    @Column(name = "back-up",
            nullable = false,
            length = 3)
    private char backup;

    //    @Column(name = "computer_id",
//            nullable = false)
//    private int computerId;
//    @Column(name = "location_id",
//            nullable = false)
//    private int locationId;
//    @Column(name = "worker_id",
//            nullable = false)
//    private int workerId;
//    @Column(name = "fault_id",
//            nullable = false)
//    private int faultId;
    //add repart_start and repair_end



}

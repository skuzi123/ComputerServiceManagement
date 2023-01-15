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
@Table(name = "Computer_parts")
public class ComputerParts extends IdEntity{

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "computer_id",
                referencedColumnName = "id")
    private Computer computer;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "part_type",
                referencedColumnName = "id")
//    @JsonIgnore
    private Part part;



//    @Column(name = "computer_id",
//            nullable = false)
//    private int computerId;
    //    @Column(name = "part_type",
//            nullable = false)
//    private String partType;
}

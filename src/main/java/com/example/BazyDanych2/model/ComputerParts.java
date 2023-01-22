package com.example.BazyDanych2.model;

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

    @ManyToOne
    @JoinColumn(name = "computer_id",
                referencedColumnName = "id")
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "part_type",
                referencedColumnName = "id")
    private Part part;

}

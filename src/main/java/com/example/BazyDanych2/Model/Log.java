package com.example.BazyDanych2.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Log")
public class Log extends IdEntity{
    @Column(name = "operacja",
            nullable = false,
            length = 20)
    private String operation;

//    @ManyToOne
//    @JoinColumn(name = "client_id",
//                referencedColumnName = "id")
//    private Client client;
//    @Column(name = "client_id",
//            nullable = false)
//    private int clientId;




}

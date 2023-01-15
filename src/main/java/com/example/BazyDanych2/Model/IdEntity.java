package com.example.BazyDanych2.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@MappedSuperclass
public abstract class IdEntity {

    @Id
    @Column(updatable = false,
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "native")
    @GenericGenerator(name = "native",
            strategy = "native")
    private Long id;
}

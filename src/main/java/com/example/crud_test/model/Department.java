package com.example.crud_test.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.dialect.function.LpadRpadPadEmulation;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String manager;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
    //private List<Employee> employees = new ArrayList<>();

}

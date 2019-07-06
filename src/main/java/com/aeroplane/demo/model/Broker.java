package com.aeroplane.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Broker {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    private Contract contract;
}
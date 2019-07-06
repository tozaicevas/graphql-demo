package com.aeroplane.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Contract {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private float interest;
}

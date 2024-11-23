package com.taxi.taxibooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "service")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String image;
    private String title;
    private String description;
}

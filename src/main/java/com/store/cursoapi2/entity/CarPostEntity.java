package com.store.cursoapi2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="car_post")
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "car_model")
    private String model;
    @Column(name="car_brand")
    private String brand;
    @Column(name="car_price")
    private Double price;
    @Column(name="car_description")
    private String description;
    @Column(name="car_engineVersion")
    private String engineVersion;
    @Column(name="car_city")
    private String city;
    @Column(name="car_createdDate")
    private String createdDate;
    @Column(name="car_ownerId")
    private Long ownerId;
    @Column(name="car_ownerName")
    private String ownerName;
    @Column(name="car_ownerType")
    private String ownerType;
    @Column(name="car_post_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;



}

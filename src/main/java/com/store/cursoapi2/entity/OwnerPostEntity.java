package com.store.cursoapi2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Table(name = "owner_post")
@Data
@NoArgsConstructor
public class OwnerPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "owner_name")
    private String name;
    @Column(name= "owner_type")
    private String type;
    @Column(name = "owner_contractNumber")
    private String contactNumber;
}

package com.zanabazar.JarSoftTestTask.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CATEGORY_TBL")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String reqName;

    private boolean deleted;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Banner> banners;
}

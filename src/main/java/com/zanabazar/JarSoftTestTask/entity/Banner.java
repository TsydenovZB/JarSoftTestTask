package com.zanabazar.JarSoftTestTask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BANNER_TBL")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String name;

    @Column(columnDefinition = "DECIMAL(8,2)", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private boolean deleted;

    @JsonIgnore
    @OneToMany(mappedBy = "banner")
    private List<Request> requests;
}

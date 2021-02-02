package com.example.demo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne   //let recipe own the cascade style by not
                // writing anything
    private Recipe recipe;

    @Lob//bigg data <255
    // hibernate (JPA) is expecting CLOB field in the database
    private String recipeNotes;

    public Notes() {
    }

}

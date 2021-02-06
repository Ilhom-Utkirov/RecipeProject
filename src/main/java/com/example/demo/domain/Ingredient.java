package com.example.demo.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    //(cascade = CascadeType.ALL, mappedBy = "ingredient")
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description=description;
        this.amount=amount;
        this.uom=uom;

    }
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description=description;
        this.amount=amount;
        this.uom=uom;
        this.recipe=recipe;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", uom=" + uom +
                ", recipe=" + recipe +
                '}';
    }
}

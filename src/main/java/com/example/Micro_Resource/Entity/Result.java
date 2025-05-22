package com.example.Micro_Resource.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "result", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Result_ID")
})
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Result_ID", nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer resultId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Student_ID", nullable = false)
    private Student student;

    @Column(name = "Class")
    private Integer studentClass;

    @Column(name = "Science", precision = 4, scale = 2)
    private BigDecimal  science;

    @Column(name = "Maths", precision = 4, scale = 2)
    private BigDecimal  maths;

    @Column(name = "History_Sub", precision = 4, scale = 2)
    private BigDecimal  historySub;

    @Column(name = "English", precision = 4, scale = 2)
    private BigDecimal english;

    @Column(name = "Mother_Lan", precision = 4, scale = 2)
    private BigDecimal  motherLan;

    @Column(name = "Second_Lan", precision = 4, scale = 2)
    private BigDecimal  secondLan;

    @Column(name = "Percent", precision = 4, scale = 2)
    private BigDecimal  percent;

    // --- Getters and Setters (you can generate via IDE or use Lombok @Getter/@Setter)


}


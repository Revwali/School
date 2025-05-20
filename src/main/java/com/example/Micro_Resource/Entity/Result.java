package com.example.Micro_Resource.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

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
    private Double science;

    @Column(name = "Maths", precision = 4, scale = 2)
    private Double maths;

    @Column(name = "History_Sub", precision = 4, scale = 2)
    private Double historySub;

    @Column(name = "English", precision = 4, scale = 2)
    private Double english;

    @Column(name = "Mother_Lan", precision = 4, scale = 2)
    private Double motherLan;

    @Column(name = "Second_Lan", precision = 4, scale = 2)
    private Double secondLan;

    @Column(name = "Percent", precision = 4, scale = 2)
    private Double percent;

    // --- Getters and Setters (you can generate via IDE or use Lombok @Getter/@Setter)


}


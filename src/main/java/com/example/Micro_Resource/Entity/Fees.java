package com.example.Micro_Resource.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fees", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Fees_ID")
})
@Getter
@Setter
public class Fees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fees_ID", nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer feesId;

    // Foreign key to Student table
    @ManyToOne(optional = false)
    @JoinColumn(name = "Student_ID", nullable = false)
    private Student student;

    @Column(name = "Class")
    private Integer studentClass;

    @Column(name = "BaseFee", precision = 7, scale = 2)
    private Double baseFee;

    @Column(name = "Bus_Taken")
    private Boolean busTaken;

    @Column(name = "BusFee", precision = 6, scale = 2)
    private Double busFee;

    @Column(name = "Building_Fund", precision = 6, scale = 2)
    private Double buildingFund;

    @Column(name = "Total_Fee", precision = 7, scale = 2)
    private Double totalFee;

    @Enumerated(EnumType.STRING)
    @Column(name = "Paid", nullable = false)
    private PaymentStatus paid = PaymentStatus.PENDING;

    // Foreign key to Invoice table
    @OneToMany
    @JoinColumn(name = "Invoice")
    private Invoice invoice;

    // Enum for PAID status
    public enum PaymentStatus {
        PAID,
        PENDING
    }

    // Getters and setters or use Lombok (@Getter/@Setter)

}


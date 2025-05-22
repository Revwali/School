package com.example.Micro_Resource.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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
    private Integer studentclass;

    @Column(name = "BaseFee", precision = 7, scale = 2)
    private BigDecimal  baseFee;

    @Column(name = "Bus_Taken")
    private Boolean bustaken;

    @Column(name = "BusFee", precision = 6, scale = 2)
    private BigDecimal  busfee;

    @Column(name = "building_fund", precision = 6, scale = 2)
    private BigDecimal  buildingfund;

    @Column(name = "total_fee", precision = 7, scale = 2)
    private BigDecimal totalfee;

    @Enumerated(EnumType.STRING)
    @Column(name = "Paid", nullable = false)
    private PaymentStatus paid = PaymentStatus.PENDING;

    // Foreign key to Invoice table
    @OneToOne
    @JoinColumn(name = "Invoice")
    private Invoice invoice;

    // Enum for PAID status
    public enum PaymentStatus {
        PAID,
        PENDING
    }

    // Getters and setters or use Lombok (@Getter/@Setter)

}


package com.example.Micro_Resource.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Base_Invoice", uniqueConstraints = {
        @UniqueConstraint(columnNames = "BaseInvoice_ID")
})
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BaseInvoice_ID", nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer baseInvoiceId;

    // Foreign key to Fees table
    @ManyToOne(optional = false)
    @JoinColumn(name = "Fees_ID", nullable = false)
    private Fees fees;

    @Column(name = "Bank_Name", length = 100)
    private String bankName;

    @Column(name = "BaseAccountNo")
    private Long baseAccountNo;

    @Column(name = "BusAccountNo")
    private Long busAccountNo;

    @Column(name = "BuildingFundNo")
    private Long buildingFundNo;

    @Column(name = "Student_accountNo")
    private Long studentAccountNo;

    @Column(name = "Student_BankName", length = 100)
    private String studentBankName;

    @Column(name = "Receipt_ID", length = 50)
    private String receiptId;

    @Column(name = "Transaction_ID", length = 50)
    private String transactionId;

    // Getters and Setters (or use Lombok @Getter/@Setter)

}


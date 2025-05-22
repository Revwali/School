package com.example.Micro_Resource.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Invoice", uniqueConstraints = {
        @UniqueConstraint(columnNames = "BaseInvoice_ID")
})
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Invoice_ID", nullable = false)
    @Setter(AccessLevel.NONE)
    private Integer baseInvoiceId;

    // Foreign key to Fees table
    @ManyToOne(optional = false)
    @JoinColumn(name = "Fees_ID", nullable = false)
    private Fees fees;

    @Column(name = "Bank_Name", length = 100)
    private String bankname;

    @Column(name = "BaseAccountNo")
    private Long baseaccountno;

    @Column(name = "BusAccountNo")
    private Long busaccountno;

    @Column(name = "BuildingFundNo")
    private Long buildingfundno;

    @Column(name = "Student_accountNo")
    private Long studentaccountno;

    @Column(name = "Student_BankName", length = 100)
    private String studentbankname;

    @Column(name = "Receipt_ID", length = 50)
    private String receiptdd;

    @Column(name = "Transaction_ID", length = 50)
    private String transactionid;

    // Getters and Setters (or use Lombok @Getter/@Setter)

}


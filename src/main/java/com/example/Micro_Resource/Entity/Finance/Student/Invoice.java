package com.example.Micro_Resource.Entity.Finance.Student;

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

    @Column(name = "bank_name", length = 100)
    private String bankname;

    @Column(name = "base_account_no")
    private String baseaccountno;

    @Column(name = "bus_account_no")
    private String busaccountno;

    @Column(name = "building_fund_no")
    private String buildingfundno;

    @Column(name = "student_account_no")
    private String studentaccountno;

    @Column(name = "student_bank_name", length = 100)
    private String studentbankname;

    @Column(name = "Receipt_ID", length = 50)
    private String receiptdd;

    @Column(name = "Transaction_ID", length = 50)
    private String transactionid;

    // Getters and Setters (or use Lombok @Getter/@Setter)

}


package com.thi_m4.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "transaction")
public class Transaction {
    @Id
    private String id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date transaction_day;
    private String type;
    private BigDecimal price;
    private double area;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}

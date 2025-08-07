package com.thi_m4.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    @NotBlank(message = "Mã giao dịch không được để trống")
    private String id;


    @NotNull(message = "Ngày giao dịch không được để trống")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date transaction_day;


    @NotBlank(message = "Loại giao dịch không được để trống")
    private String type;

    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá phải lớn hơn 0")
    private BigDecimal price;

    @NotNull(message = "Diện tích không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Diện tích phải lớn hơn 0")
    private double area;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}

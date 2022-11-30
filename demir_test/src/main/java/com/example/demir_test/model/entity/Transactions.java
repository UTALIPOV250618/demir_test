package com.example.demir_test.model.entity;

import com.example.demir_test.model.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transactions {

    @Id
    @GeneratedValue(generator = "transaction_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "transaction_gen", sequenceName = "transaction_seq", allocationSize = 1)
    private Long id;
    @Column(name = "sum_in")
    private Double sumIn;
    @Column(name = "sum_out")
    private Double sumOut;
    @Column(name = "last_updated_amount")
    private Double amount;
    @Column(name = "transaction_date")
    private LocalDateTime date;
    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;


}

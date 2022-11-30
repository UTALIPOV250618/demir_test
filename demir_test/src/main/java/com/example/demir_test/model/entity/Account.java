package com.example.demir_test.model.entity;


import com.example.demir_test.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(generator = "account_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "account_gen", sequenceName = "account_seq", allocationSize = 1)
    private Long id;
    @Column(name = "balance")
    private double balance;
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany()
    private List<Transactions> transactions = new ArrayList<>();

}

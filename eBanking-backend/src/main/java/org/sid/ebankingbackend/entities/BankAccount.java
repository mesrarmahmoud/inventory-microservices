package org.sid.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
public class BankAccount {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private Customer customer;
    private List<AccountOperation> accountOperations;
}

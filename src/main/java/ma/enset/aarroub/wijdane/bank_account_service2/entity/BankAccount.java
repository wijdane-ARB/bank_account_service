package ma.enset.aarroub.wijdane.bank_account_service2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.aarroub.wijdane.bank_account_service2.enums.AccountType;
import ma.enset.aarroub.wijdane.bank_account_service2.enums.AccountType;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    private Long id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType type;

    public void setType(ma.enset.aarroub.wijdane.bank_account_service2.enums.AccountType accountType) {
    }
}
